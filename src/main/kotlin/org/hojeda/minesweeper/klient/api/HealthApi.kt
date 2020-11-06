package org.hojeda.minesweeper.klient.api

import org.hojeda.minesweeper.klient.infrastructure.client.RestClient


class HealthApi(
    private val restClient: RestClient
) {

    /**
     * Health check
     * 
     * @return void
     */
    fun ping(): String = restClient.get("/ping").body

}
