package com.example.midterm2.api

data class Data(
    var categories: List<Category>?,
    var description: String?,
    var discount_amount: String?,
    var id: Int?,
    var image: String?,
    var name: String?,
    var price: String?,
    var status: Boolean?
)