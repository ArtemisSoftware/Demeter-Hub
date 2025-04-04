package com.artemissoftware.demeterhub.feature.shop.presentation.dashboard
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.artemissoftware.demeterhub.core.presentation.models.ErrorInfo
import com.artemissoftware.demeterhub.core.presentation.util.extensions.toUiText
import com.artemissoftware.demeterhub.feature.shop.domain.usecase.GetDashboardUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class DashboardViewModel @Inject constructor(
    private val getDashboardUseCase: GetDashboardUseCase
): ViewModel() {

    private var hasLoadedInitialData = false

    private val _state = MutableStateFlow(DashboardState())
    val state = _state
        .onStart {
            if(!hasLoadedInitialData) {
                /** Load initial data here **/
                getDashboard()
                hasLoadedInitialData = true
            }
        }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000L),
            initialValue = DashboardState()
        )
        
    fun onTriggerEvent(event: DashboardEvent) {
        when(event) {
            else -> TODO("Handle actions")
        }
    }

    private suspend fun getDashboard() = with(_state){
        getDashboardUseCase(latitude = 40.7128, longitude = -74.0060)
            .onSuccess {
                update { it.copy(categories = it.categories, shops = it.shops) }
            }
            .onFailure { error ->
                update {
                    it.copy(
                        errorInfo = ErrorInfo(
                            title = "Shop",
                            message = error.toUiText()
                        )
                    )
                }
            }
    }
}