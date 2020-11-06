package org.hojeda.minesweeper.klient.model.board.response

import java.time.LocalDateTime

/**
 *
 * @param id
 * @param userId
 * @param rowSize
 * @param columnSize
 * @param mines
 * @param status
 * @param createdAt
 * @param startedAt
 * @param finishedAt
 * @param fields
 */
data class BoardResponse (
    val id: Int,
    val userId: Int,
    val rowSize: Int,
    val columnSize: Int,
    val mines: Int,
    val status: Status,
    val createdAt: LocalDateTime,
    val startedAt: LocalDateTime? = null,
    val finishedAt: LocalDateTime? = null,
    val fields: List<BoardFieldResponse>
) {
    /**
     *
     * Values: created,playing,won,lost
     */
    enum class Status(val value: String){
        created("created"),
        playing("playing"),
        won("won"),
        lost("lost");
    }
}