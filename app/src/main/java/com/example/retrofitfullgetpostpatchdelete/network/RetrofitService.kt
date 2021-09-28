package com.example.retrofitfullgetpostpatchdelete.network

import com.example.retrofitfullgetpostpatchdelete.model.User
import com.example.retrofitfullgetpostpatchdelete.model.UserList
import com.example.retrofitfullgetpostpatchdelete.model.UserResponse
import retrofit2.Call
import retrofit2.http.*

interface RetrofitService {
    //https://gorest.co.in/public/v1/users
    //token: 8f431ec42a08128ccc89285671bf8c9dfd8b070e7881ea2b852d54d035b8405e


    //https://gorest.co.in/public/v1/users
    //curl -i -H "Accept:application/json" -H "Content-Type:application/json" -XGET "https://gorest.co.in/public/v1/users"
    /*@GET("users")
    @Headers("Accept:application/json", "Content-Type:application/json")
    fun getUserList(): Call<UserList>

    //https://gorest.co.in/public/v1/users/5
    @GET("users/{user_id}")
    @Headers("Accept:application/json", "Content-Type:application/json")
    fun getUser(@Path("user_id") id: String): Call<UserResponse>

    //https://gorest.co.in/public/v1/users?name=abc
    @GET("users")
    @Headers("Accept:application/json", "Content-Type:application/json")
    fun searchUser(@Query("name") searchText: String): Call<UserList>

    //curl -i -H "Accept:application/json"-H "Content-Type:application/json"-H "Authorization: Bearer ACCESS-TOKEN"-XPOST "https://gorest.co.in/public/v1/users" -d '{"name":"Tenali Ramakrishna", "gender":"male", "email":"tenali.ramakrishna@15ce.com", "status":"active"}'
    @POST("users")
    @Headers("Accept:application/json", "Content-Type:application/json",
        "Authorization: Bearer 8f431ec42a08128ccc89285671bf8c9dfd8b070e7881ea2b852d54d035b8405e")
    fun createUser(@Body user: User): Call<UserResponse>

    @PATCH("users/{user_id}")
    @Headers(
        "Accept:application/json",
        "Content-Type:application/json",
        "Authorization: Bearer 8f431ec42a08128ccc89285671bf8c9dfd8b070e7881ea2b852d54d035b8405e"
    )
    fun updateUser(
        @Path("user_id") id: String,
        @Body user: User
    ): Call<UserResponse>

    @DELETE("users/{user_id}")
    @Headers(
        "Accept:application/json",
        "Content-Type:application/json",
        "Authorization: Bearer 8f431ec42a08128ccc89285671bf8c9dfd8b070e7881ea2b852d54d035b8405e"
    )
    fun deleteUser(
        @Path("user_id") id: String
    ): Call<UserResponse>*/


    @GET("users")
    @Headers("Accept:application/json","Content-Type:application/json")
    fun getUsersList(): Call<UserList>

    //https://gorest.co.in/public-api/users?name=a
    @GET("users")
    @Headers("Accept:application/json","Content-Type:application/json")
    fun searchUsers(@Query("name") searchText: String): Call<UserList>


    //https://gorest.co.in/public-api/users/121
    @GET("users/{user_id}")
    @Headers("Accept:application/json","Content-Type:application/json")
    fun getUser(@Path("user_id") user_id: String): Call<UserResponse>


    @POST("users")
    @Headers("Accept:application/json", "Content-Type:application/json",
        "Authorization: Bearer 73668350bdf06c66f3388408c1a712b378c3e25da599753b21b664a6261e246c")
    fun createUser(@Body params: User): Call<UserResponse>

    @PATCH("users/{user_id}")
    @Headers("Accept:application/json", "Content-Type:application/json",
        "Authorization: Bearer 73668350bdf06c66f3388408c1a712b378c3e25da599753b21b664a6261e246c")
    fun updateUser(@Path("user_id") user_id: String, @Body params: User): Call<UserResponse>

    @DELETE("users/{user_id}")
    @Headers("Accept:application/json", "Content-Type:application/json",
        "Authorization: Bearer 73668350bdf06c66f3388408c1a712b378c3e25da599753b21b664a6261e246c")
    fun deleteUser(@Path("user_id") user_id: String): Call<UserResponse>


}