package com.artemissoftware.demeterhub.core.presentation.util.extensions


import com.artemissoftware.demeterhub.core.domain.error.DataError
import com.artemissoftware.demeterhub.core.domain.error.Error


fun Error.toUiText(): String {
    return when (this) {
        is DataError.NetworkError -> {
            this.asUiText()
        }
        else -> "Error 2"//UiText.StringResource(R.string.error_not_mapped)
    }
}

private fun DataError.NetworkError.asUiText(): String {
    return "Error 1"
}


//private fun DataError.NetworkError.asUiText(): UiText {
//    return when (this) {
//        DataError.NetworkError.Connect -> UiText.StringResource(
//            R.string.connection_error,
//        )
//        is DataError.NetworkError.Error -> UiText.DynamicString(this.message)
//        DataError.NetworkError.SocketTimeout -> UiText.StringResource(
//            R.string.connection_socket_time_out,
//        )
//        DataError.NetworkError.Unknown -> UiText.StringResource(
//            R.string.unknown_error,
//        )
//        DataError.NetworkError.UnknownHost -> UiText.StringResource(
//            R.string.unknown_host_error,
//        )
//    }
//}