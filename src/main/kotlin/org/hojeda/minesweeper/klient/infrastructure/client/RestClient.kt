package org.hojeda.minesweeper.klient.infrastructure.client

import kong.unirest.HttpResponse
import kong.unirest.UnirestInstance
import org.apache.http.HttpHeaders.CONTENT_TYPE
import org.hojeda.minesweeper.klient.infrastructure.client.error.ExceptionResolver
import org.hojeda.minesweeper.klient.infrastructure.client.error.InternalServerErrorException
import org.hojeda.minesweeper.klient.infrastructure.logger.LoggerDelegate
import org.hojeda.minesweeper.klient.infrastructure.mapper.JsonMapper

class RestClient constructor(
    private val restClientConfig: RestClientConfig,
    private val client: UnirestInstance
) {

    private val logger by LoggerDelegate()

    private val defaultResponseHandler: (HttpResponse<String>, String) -> HttpResponse<String> =
        { res: HttpResponse<String>, path: String ->
            handle4xx(res, path)
            handle5xx(res, path)
            handle2xx(res)
        }

    private fun handle2xx(res: HttpResponse<String>) = res

    private fun handle4xx(res: HttpResponse<String>, path: String) {
        if (res.status in 400..499) {
            logger.error("ERROR_4XX: ${res.status} [path: $path, body: ${res.body}]")
            throw ExceptionResolver.resolve4xx(res.status, res.body ?: "RESPONSE_ERROR_WITHOUT_BODY")
        }
    }

    private fun handle5xx(res: HttpResponse<String>, path: String) {
        if (res.status in 500..599) {
            logger.error("ERROR_5XX ${res.status} [path: $path, body: ${res.body}]")
            throw InternalServerErrorException(res.body)
        }
    }

    fun get(
        path: String,
        queryParams: Map<String, String> = mapOf(),
        headers: Map<String, String> = mapOf(),
        connectionTimeout: Int? = null,
        socketTimeout: Int? = null,
        responseHandler: ((HttpResponse<String>, String) -> HttpResponse<String>) = defaultResponseHandler
    ): HttpResponse<String> {
        val url = restClientConfig.host + path

        val req = client
            .get(url)
            .headers(headers)
            .queryString(queryParams)
            .socketTimeout(socketTimeout ?: this.restClientConfig.defaultSocketTimeout)
            .connectTimeout(connectionTimeout ?: this.restClientConfig.defaultConnectionTimeout)

        return req.asString()
            .runCatching { responseHandler(this, url) }
            .onFailure { error ->
                logger.error("ERROR_GET_REQUEST_EXCEPTION - Error getting from $path [path: $path, headers: $headers, query_params: $queryParams]", error)
                throw error
            }
            .getOrThrow()
    }

    fun <T> post(
        path: String,
        body: T? = null,
        queryParams: Map<String, String> = mapOf(),
        headers: Map<String, String> = mapOf(),
        connectionTimeout: Int? = null,
        socketTimeout: Int? = null,
        responseHandler: ((HttpResponse<String>, String) -> HttpResponse<String>) = defaultResponseHandler
    ): HttpResponse<String> {
        val url = restClientConfig.host + path

        val req = client
            .post(url)
            .headers(headers)
            .queryString(queryParams)
            .socketTimeout(socketTimeout ?: this.restClientConfig.defaultSocketTimeout)
            .connectTimeout(connectionTimeout ?: this.restClientConfig.defaultConnectionTimeout)
        val reqWithBody = body?.let {
            req
                .header(CONTENT_TYPE, "application/json")
                .body(JsonMapper.get().writeValueAsString(body))
        } ?: req

        return reqWithBody.asString()
            .runCatching { responseHandler(this, url) }
            .onFailure { error ->
                logger.error("ERROR_GET_REQUEST_EXCEPTION - Error getting from $path [path: $path, headers: $headers, query_params: $queryParams]", error)
                throw error
            }
            .getOrThrow()
    }

    fun <T> patch(
        path: String,
        body: T? = null,
        queryParams: Map<String, String> = mapOf(),
        headers: Map<String, String> = mapOf(),
        connectionTimeout: Int? = null,
        socketTimeout: Int? = null,
        responseHandler: ((HttpResponse<String>, String) -> HttpResponse<String>) = defaultResponseHandler
    ): HttpResponse<String> {
        val url = restClientConfig.host + path

        val req = client
            .patch(url)
            .headers(headers)
            .queryString(queryParams)
            .socketTimeout(socketTimeout ?: this.restClientConfig.defaultSocketTimeout)
            .connectTimeout(connectionTimeout ?: this.restClientConfig.defaultConnectionTimeout)
        val reqWithBody = body?.let {
            req
                .header(CONTENT_TYPE, "application/json")
                .body(JsonMapper.get().writeValueAsString(body))
        } ?: req

        return reqWithBody.asString()
            .runCatching { responseHandler(this, url) }
            .onFailure { error ->
                logger.error("ERROR_GET_REQUEST_EXCEPTION - Error getting from $path [path: $path, headers: $headers, query_params: $queryParams]", error)
                throw error
            }
            .getOrThrow()
    }

}