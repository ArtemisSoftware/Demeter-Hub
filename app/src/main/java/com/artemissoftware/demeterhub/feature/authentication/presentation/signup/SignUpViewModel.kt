package com.artemissoftware.demeterhub.feature.authentication.presentation.signup

import androidx.lifecycle.viewModelScope
import com.artemissoftware.demeterhub.core.presentation.event.UiEvent
import com.artemissoftware.demeterhub.core.presentation.event.UiEventViewModel
import com.artemissoftware.demeterhub.core.presentation.models.ErrorInfo
import com.artemissoftware.demeterhub.core.presentation.util.extensions.toUiText
import com.artemissoftware.demeterhub.feature.authentication.domain.usecase.SignUpUseCase
import com.artemissoftware.demeterhub.feature.authentication.presentation.navigation.AuthenticationRoute
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.time.Duration.Companion.seconds

@HiltViewModel
class SignUpViewModel @Inject constructor(
    private val signUpUseCase: SignUpUseCase
): UiEventViewModel() {

    private val _state = MutableStateFlow(SignUpState())
    val state = _state.asStateFlow()

    fun onTriggerEvent(event: SignUpEvent){
        when(event){
            is SignUpEvent.UpdateEmail -> updateEmail(event.email)
            is SignUpEvent.UpdateName -> updateName(event.name)
            is SignUpEvent.UpdatePassword -> updatePassword(event.password)
            SignUpEvent.SignUp -> signUp()
        }
    }

    private fun updateEmail(email: String) = with(_state) {
        update {
            it.copy(email = email)
        }
    }

    private fun updateName(name: String) = with(_state) {
        update {
            it.copy(name = name)
        }
    }

    private fun updatePassword(password: String) = with(_state) {
        update {
            it.copy(email = password)
        }
    }

    private fun updateLoading(isLoading: Boolean) = with(_state) {
        update {
            it.copy(isLoading = isLoading, errorInfo = null)
        }
    }

    private fun updateError(error: ErrorInfo) = with(_state) {
        update {
            it.copy(errorInfo = error)
        }
    }


    private fun signUp() = with(_state.value) {
        viewModelScope.launch {
            updateLoading(true)

            signUpUseCase(name = name, password = password, email = email)
                .onSuccess {
                    updateLoading(false)
                    sendEvent()
                }
                .onFailure { error ->
                    updateLoading(false)
                    updateError(ErrorInfo(
                        title = "Authentication",
                        message = error.toUiText()
                    ))
                }

//            try {
//                val response = safeApiCall {
//                    foodApi.signUp(
//                        SignUpRequest(
//                            name = name.value,
//                            email = email.value,
//                            password = password.value
//                        )
//                    )
//                }
//                when (response) {
//                    is ApiResponse.Success -> {
//                        _uiState.value = SignupEvent.Success
//                        session.storeToken(response.data.token)
//                        _navigationEvent.emit(SigupNavigationEvent.NavigateToHome)
//                    }
//
//                    else -> {
//                        val errr = (response as? ApiResponse.Error)?.code ?: 0
//                        error = "Sign In Failed"
//                        errorDescription = "Failed to sign up"
//                        when (errr) {
//                            400 -> {
//                                error = "Invalid Credintials"
//                                errorDescription = "Please enter correct details."
//                            }
//                        }
//                        _uiState.value = SignupEvent.Error
//                    }
//                }
//
//
//            } catch (e: Exception) {
//                e.printStackTrace()
//                _uiState.value = SignupEvent.Error
//            }
//
        }
    }

    private fun sendEvent(){
        viewModelScope.launch {
            sendUiEvent(
                UiEvent.NavigateWithRoute(AuthenticationRoute.Home)
            )
        }
    }

//
//    fun onLoginClicked() {
//        viewModelScope.launch {
//            _navigationEvent.emit(SigupNavigationEvent.NavigateToLogin)
//        }
//    }

//    override fun onGoogleError(msg: String) {
//        viewModelScope.launch {
//            errorDescription = msg
//            error = "Google Sign In Failed"
//            _uiState.value = SignupEvent.Error
//        }
//    }
//
//    override fun onFacebookError(msg: String) {
//        viewModelScope.launch {
//            errorDescription = msg
//            error = "Facebook Sign In Failed"
//            _uiState.value = SignupEvent.Error
//        }
//    }
//
//    override fun onSocialLoginSuccess(token: String) {
//        viewModelScope.launch {
//            session.storeToken(token)
//            _uiState.value = SignupEvent.Success
//            _navigationEvent.emit(SigupNavigationEvent.NavigateToHome)
//        }
//    }
}