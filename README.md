## Requires

* Kotlin 1.3.72
* Gradle 6.5

## Build
Run: 
```
./gradlew check assemble
```

This runs all tests and packages the library.

## Features/Implementation Notes

* Supports JSON inputs/outputs
* Supports collection formats for query parameters: csv, tsv, ssv, pipes.
* Some Kotlin and Java types are fully qualified to avoid conflicts.
* Implementation of RestClient is intended to reduce method counts, specifically to benefit Android targets.

<a name="documentation-for-api-endpoints"></a>
## Documentation for API Endpoints

All URIs are relative to *https://hojeda-minesweeper-api.herokuapp.com/*

Class | Method | HTTP request | Description
------------ | ------------- | ------------- | -------------
*HealthApi* | [**pingGet**](docs/HealthApi.md#pingget) | **GET** /ping | Health check
*BoardApi* | [**boardBoardIdGet**](docs/BoardApi.md#boardboardidget) | **GET** /board/{boardId} | Find board by id
*BoardApi* | [**boardBoardIdPatch**](docs/BoardApi.md#boardboardidpatch) | **PATCH** /board/{boardId} | Make a movement in a board
*BoardApi* | [**boardPost**](docs/BoardApi.md#boardpost) | **POST** /board | Create a new board
*UserApi* | [**userGet**](docs/UserApi.md#userget) | **GET** /user | Get a list of users
*UserApi* | [**userPost**](docs/UserApi.md#userpost) | **POST** /user | Create a new user
*UserApi* | [**userUserIdBoardGet**](docs/UserApi.md#useruseridboardget) | **GET** /user/{userId}/board | Get a list of boards related to the user id
*UserApi* | [**userUserIdGet**](docs/UserApi.md#useruseridget) | **GET** /user/{userId} | Get a user by id

<a name="documentation-for-models"></a>
## Documentation for Models

 - [org.hojeda.minesweeper.klient.model.board.response.BoardFieldResponse](docs/BoardFieldResponse.md)
 - [org.hojeda.minesweeper.klient.model.board.response.BoardResponse](docs/BoardResponse.md)
 - [org.hojeda.minesweeper.klient.model.board.request.CreateBoardRequest](docs/CreateBoardrequest.md)
 - [org.hojeda.minesweeper.klient.model.board.request.MoardMovementRequest](docs/BoardMovementRequest.md)
 - [org.hojeda.minesweeper.klient.model.user.request.UserRequest](docs/UserRequest.md)
 - [org.hojeda.minesweeper.klient.model.user.response.UserResponse](docs/UserResponse.md)

<a name="documentation-for-authorization"></a>
## Documentation for Authorization

All endpoints do not require authorization.