package com.example.midterm2.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.midterm2.R
import com.example.midterm2.activity.Info
import com.example.midterm2.api.Data
import com.example.midterm2.model.ProductItems
import kotlinx.android.synthetic.main.product_list.view.*

class ProductAdapter(private val data: List<Data>): RecyclerView.Adapter<ProductAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductAdapter.ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.product_list, parent, false))
    }

    override fun onBindViewHolder(holder: ProductAdapter.ViewHolder, position: Int) {
        holder.name.text=data[position].name.toString()
        holder.price.text=data[position].price
        holder.discount.text=data[position].discount_amount
        holder.status.text=data[position].status.toString()
        Glide.with(holder.itemView.context).load(data[position].image).into(holder.image)
        holder.itemView.setOnClickListener{
            val intent = Intent(holder.itemView.context, Info::class.java)
            intent.putExtra("id", data[position].id.toString())
            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        val name = itemView.name
        val price = itemView.price
        val discount = itemView.discount
        val image= itemView.imageView
        val status = itemView.status
    }

}