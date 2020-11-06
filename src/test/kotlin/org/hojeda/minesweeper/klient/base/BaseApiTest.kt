package org.hojeda.minesweeper.klient.base

import kong.unirest.Config
import kong.unirest.UnirestInstance
import org.hojeda.minesweeper.klient.infrastructure.client.RestClient
import org.hojeda.minesweeper.klient.infrastructure.client.RestClientConfig

open class BaseApiTest {

    val restClient = RestClient(
        restClientConfig = RestClientConfig(
            host = "https://hojeda-minesweeper-api.herokuapp.com",
            defaultConnectionTimeout = 10000,
            defaultSocketTimeout = 30000
        ),
        client = UnirestInstance(Config())
    )

}
