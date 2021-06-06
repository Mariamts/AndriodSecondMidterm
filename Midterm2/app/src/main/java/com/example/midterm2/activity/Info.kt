package com.example.midterm2.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.midterm2.BASEURL
import com.example.midterm2.R
import com.example.midterm2.adapter.ProductAdapter
import com.example.midterm2.adapter.ProductInfoAdapter
import com.example.midterm2.api.Api
import com.example.midterm2.api.ProductInfo
import kotlinx.android.synthetic.main.activity_info.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Info : AppCompatActivity() {
    private var id = "1"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info)
         id = intent.getStringExtra("id").toString()
        Log.d("Mariam", id)
        getProductInfo()
    }

    private fun getProductInfo() {
        val retrofitBuilder = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASEURL).build().create(Api::class.java)
        val retrofitData = retrofitBuilder.getProductInfo(id)
        retrofitData.enqueue(object : Callback<ProductInfo> {
            override fun onResponse(call: Call<ProductInfo>?, response: Response<ProductInfo>?) {
                val responseBody = response!!.body().data
                recyclerinfo.layoutManager=LinearLayoutManager(this@Info)
                recyclerinfo.adapter=responseBody?.let { ProductInfoAdapter(listOf(it)) }
            }

            override fun onFailure(call: Call<ProductInfo>?, t: Throwable?) {
                Log.d("mariam", t!!.message.toString())
            }

        })
    }

}