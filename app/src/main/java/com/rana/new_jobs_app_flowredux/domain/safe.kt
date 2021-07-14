package com.rana.new_jobs_app_flowredux.domain

import arrow.core.Either
import arrow.core.left
import com.squareup.moshi.JsonDataException
import retrofit2.HttpException
import java.io.IOException

suspend fun <T> safe(call: suspend () -> Either<String, T>): Either<String, T> {
    return try {
        return call()
    } catch (e: Throwable) {
        e.printStackTrace()
        //  FirebaseCrashlytics.getInstance().recordException(e)
        e.toFailure().left()
    }
}
fun Throwable.toFailure(): String {
    return when (this) {
        is HttpException -> {
            when (code()) {
                in 300 until 400 -> " custom error - Not Authorized"
                in 400 until 500 -> " custom error - Data not Valid"
                in 500 until 600 -> " custom error - Server is Busy"
                else -> " custom error - unknown error"
            }
        }
        is IOException ->  " custom error - Network Error"
        is JsonDataException ->  " custom error - data does not match"
        else ->  " custom error - unknown general error"
    }
}