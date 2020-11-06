package org.hojeda.minesweeper.klient.infrastructure.client.error

import kong.unirest.HttpStatus.TOO_MANY_REQUESTS


open class TooManyRequestsException(
    message: String,
    errorCode: String = "TOO_MANY_REQUESTS",
    cause: Throwable? = null
) : ErrorRequestException(
    status = TOO_MANY_REQUESTS,
    message = message,
    errorCode = errorCode,
    cause = cause
)