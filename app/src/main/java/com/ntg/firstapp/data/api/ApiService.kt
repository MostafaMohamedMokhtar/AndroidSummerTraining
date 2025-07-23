package com.ntg.firstapp.data.api

import com.ntg.firstapp.data.model.Post
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {
    @GET("posts/1")
    fun getPost(): Call<Post>

    @POST("posts")
    fun savePost(@Body post: Post): Call<Post>
}