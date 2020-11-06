package org.hojeda.minesweeper.klient.infrastructure.client.error

import kong.unirest.HttpStatus.NOT_FOUND


open class NotFoundException(
    message: String,
    errorCode: String = "NOT_FOUND",
    cause: Throwable? = null
) : ErrorRequestException(
    status = NOT_FOUND,
    message = message,
    errorCode = errorCode,
    cause = cause
)