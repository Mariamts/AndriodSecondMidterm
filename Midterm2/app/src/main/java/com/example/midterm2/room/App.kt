package com.example.midterm2.room

import android.app.Application
//import androidx.room.Room

class App:Application() {
    lateinit var db: ProductDatabase

    companion object {
        lateinit var instance: App
            private set
    }

    override fun onCreate() {
        super.onCreate()

        instance = this

//        db = Room.databaseBuilder(
//            applicationContext,
//            ProductDatabase::class.java,
//            "APP_DATABASE_1"
//        ).allowMainThreadQueries().build()

    }
}