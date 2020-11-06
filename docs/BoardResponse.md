# BoardResponse

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | [**kotlin.Int**](.md) |  |  
**userId** | [**kotlin.Int**](.md) |  |  
**rowSize** | [**kotlin.Int**](.md) |  |  
**columnSize** | [**kotlin.Int**](.md) |  |  
**mines** | [**kotlin.Int**](.md) |  |  
**status** | [**inline**](#StatusEnum) |  |  
**createdAt** | [**java.time.LocalDateTime**](java.time.LocalDateTime.md) |  |  
**startedAt** | [**java.time.LocalDateTime**](java.time.LocalDateTime.md) |  |  [optional]
**finishedAt** | [**java.time.LocalDateTime**](java.time.LocalDateTime.md) |  |  [optional]
**fields** | [**kotlin.Array&lt;BoardFieldResponse&gt;**](BoardFieldResponse.md) |  |  

<a name="StatusEnum"></a>
## Enum: status
Name | Value
---- | -----
status | created, playing, won, lost
