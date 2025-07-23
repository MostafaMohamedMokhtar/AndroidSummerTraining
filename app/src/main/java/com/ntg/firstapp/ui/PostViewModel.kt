package com.ntg.firstapp.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ntg.firstapp.data.model.Post
import com.ntg.firstapp.data.repo.PostRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PostViewModel : ViewModel() {
    private val repo: PostRepository = PostRepository()

    private val _post = MutableLiveData<Post>()
    val post: LiveData<Post> = _post

    private val _error = MutableLiveData<String>()
    val error: LiveData<String> = _error

    fun getPost() {
        repo.getPost().enqueue(object : Callback<Post> {
            override fun onResponse(call: Call<Post>, response: Response<Post>) {
                if (response.isSuccessful)
                    _post.value = response.body()
            }

            override fun onFailure(call: Call<Post>, t: Throwable) {
                _error.value = t.message
            }
        })
    }
}