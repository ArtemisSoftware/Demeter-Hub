package com.artemissoftware.demeterhub.feature.authentication.domain.usecase

import com.artemissoftware.demeterhub.feature.authentication.domain.repository.AuthenticationRepository
import javax.inject.Inject

class LoginUseCase @Inject constructor(
    private val repository: AuthenticationRepository
) {
    suspend operator fun invoke(password: String, email: String) = repository.login(password = password, email = email)
}