package org.hojeda.minesweeper.klient.api

import org.hamcrest.MatcherAssert.*
import org.hamcrest.Matchers.`is`
import org.hojeda.minesweeper.klient.base.BaseApiTest
import org.junit.jupiter.api.Test

class HealthApiTest: BaseApiTest() {

    @Test
    fun `When execute ping should return pong`() {

        val target = HealthApi(restClient)

        val response = target.ping()

        assertThat(response, `is`("pong"))
    }

}