package org.hojeda.minesweeper.klient.infrastructure.client.error

class ExceptionResolver {

    companion object {
        fun resolve4xx(statusCode: Int, message: String): ErrorRequestException {
            return when (statusCode) {
                400 -> BadRequestException(message)
                401 -> UnauthorizedException(message)
                403 -> ForbiddenException(message)
                404 -> NotFoundException(message)
                429 -> TooManyRequestsException(message)
                else -> BadRequestException(message)
            }
        }
    }
}