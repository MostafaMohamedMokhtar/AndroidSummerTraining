package com.ntg.firstapp.data.repo

import com.ntg.firstapp.data.api.RetrofitInstance
import com.ntg.firstapp.data.model.Post
import retrofit2.Call

class PostRepository {
    fun getPost(): Call<Post>{
        return RetrofitInstance.apiService.getPost()
    }
}