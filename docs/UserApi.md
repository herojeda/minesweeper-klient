# UserApi

All URIs are relative to *https://hojeda-minesweeper-api.herokuapp.com/*

Method | HTTP request | Description
------------- | ------------- | -------------
[**userGet**](UserApi.md#userGet) | **GET** /user | Get a list of users
[**userPost**](UserApi.md#userPost) | **POST** /user | Create a new user
[**userUserIdBoardGet**](UserApi.md#userUserIdBoardGet) | **GET** /user/{userId}/board | Get a list of boards related to the user id
[**userUserIdGet**](UserApi.md#userUserIdGet) | **GET** /user/{userId} | Get a user by id

<a name="userGet"></a>
# **userGet**
> kotlin.Array&lt;UserResponse&gt; userGet()

Get a list of users

### Parameters
This endpoint does not need any parameter.

### Return type

[**kotlin.Array&lt;UserResponse&gt;**](UserResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="userPost"></a>
# **userPost**
> UserResponse userPost(body)

Create a new user

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**UserRequest**](UserRequest.md)|  | [optional]

### Return type

[**UserResponse**](UserResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="userUserIdBoardGet"></a>
# **userUserIdBoardGet**
> kotlin.Array&lt;BoardResponse&gt; userUserIdBoardGet(userId)

Get a list of boards related to the user id

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **userId** | **kotlin.Int**| ID of the user |

### Return type

[**kotlin.Array&lt;BoardResponse&gt;**](BoardResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="userUserIdGet"></a>
# **userUserIdGet**
> UserResponse userUserIdGet(userId)

Get a user by id

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **userId** | **kotlin.Int**| ID of the user |

### Return type

[**UserResponse**](UserResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

