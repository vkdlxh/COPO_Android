package jp.co.archive.copo.data.model

import java.lang.Exception

interface Result<T> {
    fun onSuccess(response: T)

    fun onFailure(e: Exception)
}