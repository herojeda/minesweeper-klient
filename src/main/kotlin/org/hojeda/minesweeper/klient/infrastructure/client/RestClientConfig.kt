package org.hojeda.minesweeper.klient.infrastructure.client

data class RestClientConfig(
    val host: String,
    val defaultConnectionTimeout: Int,
    val defaultSocketTimeout: Int
)