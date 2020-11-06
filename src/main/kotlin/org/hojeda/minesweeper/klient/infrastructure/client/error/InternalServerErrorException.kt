package org.hojeda.minesweeper.klient.infrastructure.client.error

import kong.unirest.HttpStatus


class InternalServerErrorException(
    message: String,
    errorCode: String = "INTERNAL_SERVER_ERROR",
    cause: Throwable? = null
) : ErrorRequestException(
    status = HttpStatus.INTERNAL_SERVER_ERROR,
    message = message,
    errorCode = errorCode,
    cause = cause
)