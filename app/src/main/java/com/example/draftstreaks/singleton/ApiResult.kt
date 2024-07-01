package com.example.draftstreaks.singleton

enum class ApiStatus{
    SUCCESS,
    EXCEPTION,
    ERROR,
    LOADING
}

data class ViewState<out T>(val status: ApiStatus, val data: T?, val message: String?, val responseCode: Int? = null) {

    companion object {

        fun <T> success(data: T?): ViewState<T> {
            return ViewState(ApiStatus.SUCCESS, data, null, null)
        }

        fun <T> exception(responseCode: Int, e: String): ViewState<T> {
            return ViewState(ApiStatus.EXCEPTION, null,e,  responseCode)
        }

        fun <T> error(msg: String): ViewState<T> {
            return ViewState(ApiStatus.ERROR, null, msg, null)
        }

        fun <T> loading(): ViewState<T> {
            return ViewState(ApiStatus.LOADING, null, null, null)
        }
    }
}