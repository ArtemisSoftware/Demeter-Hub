package com.artemissoftware.demeterhub.feature.authentication.domain.usecase

import com.artemissoftware.demeterhub.core.domain.repository.AuthenticationRepository
import javax.inject.Inject

class SignUpUseCase @Inject constructor(
    private val repository: AuthenticationRepository
) {
    suspend operator fun invoke(name: String, password: String, email: String) = repository.signUp(password = password, name = name, email = email)
}