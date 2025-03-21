package com.example.testmercadolibre.common

sealed class ViewState<T>(val data: T?, val message: String? = null) {
    class Success<T>(data: T?) : ViewState<T>(data)
    class Loading<T>(data: T? = null) : ViewState<T>(data)
    class Error<T>(data: T? = null, message: String?) : ViewState<T>(data, message)
}