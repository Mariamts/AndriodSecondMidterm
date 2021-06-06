package com.example.midterm2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.midterm2.adapter.ProductAdapter
import com.example.midterm2.api.Api
import com.example.midterm2.api.MyData
import com.example.midterm2.room.ProductDatabase
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val BASEURL = "https://gorest.co.in/public-api/"

class MainActivity : AppCompatActivity() {
    lateinit var db: ProductDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getMyproduct()
    }

    private fun getMyproduct() {
//       App.instance.db.productUserDao().delete()
        val retrofitBuilder = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASEURL).build().create(Api::class.java)
        val retrofitData = retrofitBuilder.getProduct()
        retrofitData.enqueue(object : Callback<MyData> {
            override fun onResponse(call: Call<MyData>?, response: Response<MyData>?) {
                val responseBody = response!!.body().data
                Log.d("Mariami", responseBody.toString())
                recyclerVIew.layoutManager = LinearLayoutManager(this@MainActivity)
                recyclerVIew.adapter = responseBody?.let { ProductAdapter(it) }
                count.text = responseBody!!.size.toString()
//                for(i in 0 until responseBody.size) {
//                    val product = UserProduct(
//                        responseBody[i].categories,
//                        responseBody[i].description.toString(),
//                        responseBody[i].discount_amount.toString(),
//                        responseBody[i].id,
//                        responseBody[i].image.toString(),
//                        responseBody[i].name.toString(),
//                        responseBody[i].price.toString(),
//                        responseBody[i].status
//                    )
//                    App.instance.db.productUserDao().addUserProduct(product)
//
//                }
            }


            override fun onFailure(call: Call<MyData>?, t: Throwable?) {
                count.text = t!!.message.toString()
            }

        })
    }

}