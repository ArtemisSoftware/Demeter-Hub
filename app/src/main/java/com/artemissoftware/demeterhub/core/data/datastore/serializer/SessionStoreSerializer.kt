package com.artemissoftware.demeterhub.core.data.datastore.serializer

import androidx.datastore.core.Serializer
import com.artemissoftware.demeterhub.core.data.datastore.model.SessionStore
import kotlinx.serialization.SerializationException
import kotlinx.serialization.json.Json
import java.io.InputStream
import java.io.OutputStream

class SessionStoreSerializer : Serializer<SessionStore> {

    override val defaultValue: SessionStore
        get() = SessionStore()

    override suspend fun readFrom(input: InputStream): SessionStore {
        return try {
            Json.decodeFromString(
                deserializer = SessionStore.serializer(),
                string = input.readBytes().decodeToString(),
            )
        } catch (e: SerializationException) {
            defaultValue
        }
    }

    override suspend fun writeTo(t: SessionStore, output: OutputStream) {
        val bytes = Json.encodeToString(
            serializer = SessionStore.serializer(),
            value = t,
        )

        output.write(bytes.encodeToByteArray())
    }
}