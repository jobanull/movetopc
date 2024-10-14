package com.example.myapplication.ldp.repository.data.remote.retrofit

import com.example.myapplication.ldp.repository.data.remote.response.RepoNewsResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RepoApiService {
    @GET("top-headlines?country=id&category=science")
    fun getNews(@Query("apiKey") apiKey: String): Call<RepoNewsResponse>
}