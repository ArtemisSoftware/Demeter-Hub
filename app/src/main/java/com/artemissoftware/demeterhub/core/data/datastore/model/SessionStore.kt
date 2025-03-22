package com.artemissoftware.demeterhub.core.data.datastore.model

import kotlinx.serialization.Serializable

@Serializable
data class SessionStore(
    val token: String? = null
)
