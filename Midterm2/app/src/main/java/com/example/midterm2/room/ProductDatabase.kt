package com.example.midterm2.room

import android.content.Context

//@Database(entities = [UserProduct::class],version = 1)
abstract class ProductDatabase {
    abstract fun productUserDao(): UserProductDao
}