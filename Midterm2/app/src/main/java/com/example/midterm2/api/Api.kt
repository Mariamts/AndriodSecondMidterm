package com.example.midterm2.api

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface Api {
    @GET("products")
    fun getProduct(): Call<MyData>
    @GET("products/{id}")
    fun getProductInfo(@Path("id") id: String): Call<ProductInfo>
}