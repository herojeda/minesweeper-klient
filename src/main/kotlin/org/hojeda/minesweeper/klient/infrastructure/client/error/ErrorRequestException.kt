package org.hojeda.minesweeper.klient.infrastructure.client.error


abstract class ErrorRequestException(
    open val status: Int,
    override val message: String,
    errorCode: String,
    cause: Throwable? = null
) : RuntimeException("$errorCode - $message", cause)