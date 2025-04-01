package com.artemissoftware.demeterhub.feature.authentication.presentation.login

import androidx.lifecycle.viewModelScope
import com.artemissoftware.demeterhub.core.presentation.event.UiEvent
import com.artemissoftware.demeterhub.core.presentation.event.UiEventViewModel
import com.artemissoftware.demeterhub.core.presentation.models.ErrorInfo
import com.artemissoftware.demeterhub.core.presentation.util.extensions.toUiText
import com.artemissoftware.demeterhub.feature.authentication.domain.usecase.LoginUseCase
import com.artemissoftware.demeterhub.feature.authentication.presentation.navigation.AuthenticationRoute
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase
): UiEventViewModel() {

    private val _state = MutableStateFlow(LoginState())
    val state = _state.asStateFlow()

    fun onTriggerEvent(event: LoginEvent){
        when(event){
            is LoginEvent.UpdateEmail -> updateEmail(event.email)
            is LoginEvent.UpdatePassword -> updatePassword(event.password)
            LoginEvent.Login -> login()
        }
    }

    private fun updateEmail(email: String) = with(_state) {
        update {
            it.copy(email = email)
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

    private fun login() = with(_state.value) {
        viewModelScope.launch {
            updateLoading(true)

            loginUseCase(email = email, password = password)
                .onSuccess {
                    updateLoading(false)
                    sendEvent()
                }
                .onFailure { error ->
                    updateLoading(false)
                    updateError(
                        ErrorInfo(
                        title = "Authentication",
                        message = error.toUiText()
                    )
                    )
                }
        }
    }

    private fun sendEvent(){
        viewModelScope.launch {
            sendUiEvent(
                UiEvent.NavigateWithRoute(AuthenticationRoute.Home)
            )
        }
    }

//    fun onSignInClick() {
//        viewModelScope.launch {
//            _uiState.value = SignInEvent.Loading
//            val response = safeApiCall {
//                foodApi.signIn(
//                    SignInRequest(
//                        email = email.value, password = password.value
//                    )
//                )
//            }
//            when (response) {
//                is ApiResponse.Success -> {
//                    _uiState.value = SignInEvent.Success
//                    session.storeToken(response.data.token)
//                    _navigationEvent.emit(SigInNavigationEvent.NavigateToHome)
//                }
//
//                else -> {
//                    val errr = (response as? ApiResponse.Error)?.code ?: 0
//                    error = "Sign In Failed"
//                    errorDescription = "Failed to sign up"
//                    when (errr) {
//                        400 -> {
//                            error = "Invalid Credintials"
//                            errorDescription = "Please enter correct details."
//                        }
//                    }
//                    _uiState.value = SignInEvent.Error
//                }
//            }
//        }
//    }
//
//    fun onSignUpClicked() {
//        viewModelScope.launch {
//            _navigationEvent.emit(SigInNavigationEvent.NavigateToSignUp)
//        }
//    }
//
//    sealed class SigInNavigationEvent {
//        object NavigateToSignUp : SigInNavigationEvent()
//        object NavigateToHome : SigInNavigationEvent()
//    }
//
//    sealed class SignInEvent {
//        object Nothing : SignInEvent()
//        object Success : SignInEvent()
//        object Error : SignInEvent()
//        object Loading : SignInEvent()
//    }
//
//    override fun loading() {
//        viewModelScope.launch {
//            _uiState.value = SignInEvent.Loading
//        }
//    }
//
//    override fun onGoogleError(msg: String) {
//        viewModelScope.launch {
//            errorDescription = msg
//            error = "Google Sign In Failed"
//            _uiState.value = SignInEvent.Error
//        }
//    }
//
//    override fun onFacebookError(msg: String) {
//        viewModelScope.launch {
//            errorDescription = msg
//            error = "Facebook Sign In Failed"
//            _uiState.value = SignInEvent.Error
//        }
//    }
//
//    override fun onSocialLoginSuccess(token: String) {
//        viewModelScope.launch {
//            session.storeToken(token)
//            _uiState.value = SignInEvent.Success
//            _navigationEvent.emit(SigInNavigationEvent.NavigateToHome)
//        }
//    }
}