package org.hojeda.minesweeper.klient.api

import org.hojeda.minesweeper.klient.infrastructure.client.RestClient
import org.hojeda.minesweeper.klient.infrastructure.mapper.JsonMapper
import org.hojeda.minesweeper.klient.model.board.request.BoardMovementRequest
import org.hojeda.minesweeper.klient.model.board.response.BoardResponse
import org.hojeda.minesweeper.klient.model.board.request.CreateBoardRequest

class BoardApi(
    private val restClient: RestClient
) {

    /**
     * Find board by id
     *
     * @param boardId ID of the board
     * @return BoardResponse
     */
    fun getBoardById(boardId: Int): BoardResponse =
        restClient.get("/board/$boardId")
            .body
            .let {
                JsonMapper.get().readValue(it, BoardResponse::class.java)
            }

    /**
     * Create a new board
     * Returns a created board - Limits: row_min_limit&#x3D;10  - row_max_limit&#x3D;500 - column_min_limit&#x3D;10 - column_max_limit&#x3D;500
     * @param body
     * @return BoardResponse
     */
    fun postBoard(body: CreateBoardRequest): BoardResponse =
        restClient.post(
            path = "/board",
            body = body
        )
            .body
            .let {
                JsonMapper.get().readValue(it, BoardResponse::class.java)
            }

    /**
     * Make a movement in a board
     *
     * @param boardId ID of the board to make movement
     * @param body
     * @return BoardResponse
     */
    fun patchBoardMovement(boardId: Int, body: BoardMovementRequest): BoardResponse =
        restClient.patch(
            path = "/board/$boardId",
            body = body
        )
            .body
            .let {
                JsonMapper.get().readValue(it, BoardResponse::class.java)
            }

}