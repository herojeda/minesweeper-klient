package org.hojeda.minesweeper.klient.infrastructure.client.error

import kong.unirest.HttpStatus.UNAUTHORIZED

open class UnauthorizedException(
    message: String,
    errorCode: String = "UNAUTHORIZED",
    cause: Throwable? = null
) : ErrorRequestException(
    status = UNAUTHORIZED,
    message = message,
    errorCode = errorCode,
    cause = cause
)