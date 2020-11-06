package org.hojeda.minesweeper.klient.model.board.response

/**
 *
 * @param id
 * @param row
 * @param column
 * @param value
 * @param status
 */
data class BoardFieldResponse (
    val id: Int,
    val row: Int,
    val column: Int,
    val value: Int,
    val status: Status
) {
    /**
     *
     * Values: closed,flagged,questioned,opened
     */
    enum class Status(val value: String){
        closed("closed"),
        flagged("flagged"),
        questioned("questioned"),
        opened("opened");
    }
}