package org.hojeda.minesweeper.klient.api

import com.fasterxml.jackson.core.type.TypeReference
import org.hojeda.minesweeper.klient.infrastructure.client.RestClient
import org.hojeda.minesweeper.klient.infrastructure.mapper.JsonMapper
import org.hojeda.minesweeper.klient.model.board.response.BoardResponse
import org.hojeda.minesweeper.klient.model.user.request.UserRequest
import org.hojeda.minesweeper.klient.model.user.response.UserResponse

class UserApi(
    private val restClient: RestClient
) {

    /**
     * Get a list of users
     *
     * @return List<UserResponse>
     */
    fun getUsers(): List<UserResponse> =
        restClient.get("/user")
            .body
            .let {
                JsonMapper.get().readValue(it, object : TypeReference<List<UserResponse>>() {})
            }

    /**
     * Create a new user
     *
     * @param body User data
     * @return UserResponse
     */
    fun userPost(body: UserRequest): UserResponse =
        restClient.post(
            path = "/user",
            body = body
        )
            .body
            .let {
                JsonMapper.get().readValue(it, UserResponse::class.java)
            }

    /**
     * Get a list of boards related to the user
     *
     * @param userId ID of the user
     * @return List<BoardResponse>
     */
    fun getBoardsByUserId(userId: Long):List<BoardResponse> =
        restClient.get("/user/$userId/board")
            .body
            .let {
                JsonMapper.get().readValue(it, object : TypeReference<List<BoardResponse>>() {})
            }

    /**
     * Get a user by id
     *
     * @param userId ID of the user
     * @return UserResponse
     */
    fun userUserIdGet(userId: Long): UserResponse =
        restClient.get("/user/$userId")
            .body
            .let {
                JsonMapper.get().readValue(it, UserResponse::class.java)
            }
}