package org.hojeda.minesweeper.klient.infrastructure.client.error

import kong.unirest.HttpStatus.FORBIDDEN

open class ForbiddenException(
    message: String,
    errorCode: String = "FORBIDDEN",
    cause: Throwable? = null
) : ErrorRequestException(
    status = FORBIDDEN,
    message = message,
    errorCode = errorCode,
    cause = cause
)