package com.example.midterm2.api

data class DataX(
    val categories: List<CategoryX>,
    val description: String,
    val discount_amount: String,
    val id: Int,
    val image: String,
    val name: String,
    val price: String,
    val status: Boolean
)