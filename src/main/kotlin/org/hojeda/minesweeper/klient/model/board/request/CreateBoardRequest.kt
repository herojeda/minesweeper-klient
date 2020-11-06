package org.hojeda.minesweeper.klient.model.board.request

/**
 *
 * @param userId ID of the user (optional)
 * @param rowSize Number of rows on the board
 * @param columnSize Number of columns on the board
 * @param mines Number of mines on the board
 */
data class CreateBoardRequest(
    val userId: Long? = null,
    val rowSize: Int,
    val columnSize: Int,
    val mines: Int
)