package org.hojeda.minesweeper.klient.api

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.`is`
import org.hamcrest.Matchers.equalTo
import org.hamcrest.Matchers.not
import org.hojeda.minesweeper.klient.base.BaseApiTest
import org.hojeda.minesweeper.klient.model.board.request.BoardMovementRequest
import org.hojeda.minesweeper.klient.model.board.request.CreateBoardRequest
import org.hojeda.minesweeper.klient.model.board.response.BoardFieldResponse
import org.junit.jupiter.api.Test

class BoardApiTest: BaseApiTest() {

    @Test
    fun `Test board api`() {
        val target = BoardApi(restClient)

        val createdBoard = target.postBoard(
            CreateBoardRequest(
                columnSize = 10,
                rowSize = 10,
                mines = 10
            )
        )

        assertThat(createdBoard.fields.size, `is`(100))
        assertThat(createdBoard.userId, `is`(1))

        val returnedBoard = target.getBoardById(createdBoard.id)

        assertThat(returnedBoard, equalTo(createdBoard))

        val fieldToMakeMovement = createdBoard.fields
            .find { it.value == 0 }

        if (fieldToMakeMovement != null) {
            val modifiedBoard = target.patchBoardMovement(
                createdBoard.id,
                BoardMovementRequest(
                    row = fieldToMakeMovement.row,
                    column = fieldToMakeMovement.column,
                    movementType = BoardMovementRequest.MovementType.open
                )
            )

            assertThat(modifiedBoard, not(equalTo(createdBoard)))

            val openedField = modifiedBoard.fields
                .find { it.column == fieldToMakeMovement.column && it.row == fieldToMakeMovement.row }

            assertThat(openedField?.status, `is`(BoardFieldResponse.Status.opened))
        } else throw AssertionError("Can't find field with value 0")
    }

}