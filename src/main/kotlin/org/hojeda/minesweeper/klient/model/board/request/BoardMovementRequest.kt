package org.hojeda.minesweeper.klient.model.board.request

data class BoardMovementRequest (
    val row: Int,
    val column: Int,
    val movementType: MovementType
) {
    /**
     *
     * Values: `open`,flag,question
     */
    enum class MovementType(val value: String){
        `open`("open"),
        flag("flag"),
        question("question");
    }
}