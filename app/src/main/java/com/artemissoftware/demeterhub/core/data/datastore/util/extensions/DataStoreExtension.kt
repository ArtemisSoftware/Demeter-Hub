package com.artemissoftware.demeterhub.core.data.datastore.util.extensions

import android.content.Context
import androidx.datastore.dataStore
import com.artemissoftware.demeterhub.core.data.datastore.serializer.SessionStoreSerializer

val Context.sessionStore by dataStore(
    fileName = "session-store.json",
    serializer = SessionStoreSerializer(),
)