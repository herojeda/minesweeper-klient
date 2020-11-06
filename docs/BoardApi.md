# BoardApi

All URIs are relative to *https://hojeda-minesweeper-api.herokuapp.com/*

Method | HTTP request | Description
------------- | ------------- | -------------
[**boardBoardIdGet**](BoardApi.md#boardBoardIdGet) | **GET** /board/{boardId} | Find board by id
[**boardBoardIdPatch**](BoardApi.md#boardBoardIdPatch) | **PATCH** /board/{boardId} | Make a movement in a board
[**boardPost**](BoardApi.md#boardPost) | **POST** /board | Create a new board

<a name="boardBoardIdGet"></a>
# **boardBoardIdGet**
> BoardResponse boardBoardIdGet(boardId)

Find board by id

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **boardId** | **kotlin.Int**| ID of the board |

### Return type

[**BoardResponse**](BoardResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="boardBoardIdPatch"></a>
# **boardBoardIdPatch**
> BoardResponse boardBoardIdPatch(boardId, body)

Make a movement in a board

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **boardId** | **kotlin.Int**| ID of the board to make movement |
 **body** | [**BoardRequestMovement**](BoardRequestMovement.md)|  | [optional]

### Return type

[**BoardResponse**](BoardResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="boardPost"></a>
# **boardPost**
> BoardResponse boardPost(body)

Create a new board

Returns a created board - Limits: row_min_limit&#x3D;10  - row_max_limit&#x3D;500 - column_min_limit&#x3D;10 - column_max_limit&#x3D;500

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**BoardRequestCreate**](BoardRequestCreate.md)|  | [optional]

### Return type

[**BoardResponse**](BoardResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

