package org.hojeda.minesweeper.klient.api

import org.hamcrest.MatcherAssert.*
import org.hamcrest.Matchers.*
import org.hojeda.minesweeper.klient.base.BaseApiTest
import org.hojeda.minesweeper.klient.model.board.request.CreateBoardRequest
import org.hojeda.minesweeper.klient.model.user.request.UserRequest
import org.junit.jupiter.api.Test

class UserApiTest: BaseApiTest() {

    @Test
    fun `Test user api`() {
        val target = UserApi(restClient)

        val charPool : List<Char> = ('a'..'z') + ('A'..'Z') + ('0'..'9')
        val userName = (1..20)
            .map { i -> kotlin.random.Random.nextInt(0, charPool.size) }
            .map(charPool::get)
            .joinToString("")

        val createdUser = target.userPost(UserRequest(userName))
        assertThat(createdUser.name, `is`(userName))

        val returnedUser = target.userUserIdGet(createdUser.id)
        assertThat(returnedUser.name, `is`(userName))

        val allUsers = target.getUsers()
        assertThat(allUsers, hasItem(createdUser))

        println(allUsers)

        val createdBoardToUser = BoardApi(restClient)
            .postBoard(
                CreateBoardRequest(
                    rowSize = 10,
                    columnSize = 10,
                    mines = 10,
                    userId = createdUser.id
                )
            )

        val boardsFromUser = target.getBoardsByUserId(createdUser.id)
        assertThat(boardsFromUser, hasItem(createdBoardToUser))
    }
}