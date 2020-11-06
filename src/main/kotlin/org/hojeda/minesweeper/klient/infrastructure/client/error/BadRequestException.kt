package org.hojeda.minesweeper.klient.infrastructure.client.error

import kong.unirest.HttpStatus

open class BadRequestException(
    message: String,
    errorCode: String = "BAD_REQUEST",
    cause: Throwable? = null
) : ErrorRequestException(
    status = HttpStatus.BAD_REQUEST,
    message = message,
    errorCode = errorCode,
    cause = cause
)