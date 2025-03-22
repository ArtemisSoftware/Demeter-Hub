package com.artemissoftware.demeterhub.core.data.datastore.source

import android.content.Context
import com.artemissoftware.demeterhub.core.data.datastore.model.SessionStore
import com.artemissoftware.demeterhub.core.data.datastore.util.extensions.sessionStore
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SessionDataStore @Inject constructor(
    @ApplicationContext private val context: Context
) {
    fun getSession(): Flow<SessionStore> {
        return context.sessionStore.data
    }

    suspend fun setToken(token: String) {
        context.sessionStore.updateData {
            it.copy(token = token)
        }
    }
}