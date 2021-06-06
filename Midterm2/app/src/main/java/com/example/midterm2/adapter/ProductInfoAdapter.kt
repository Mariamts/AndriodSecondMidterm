package com.example.midterm2.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.midterm2.R
import com.example.midterm2.api.DataX
import kotlinx.android.synthetic.main.product_info.view.*

class ProductInfoAdapter(private val productInfo: List<DataX>): RecyclerView.Adapter<ProductInfoAdapter.ViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ProductInfoAdapter.ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.product_info, parent, false))
    }

    override fun onBindViewHolder(holder: ProductInfoAdapter.ViewHolder, position: Int) {
        holder.name.text=productInfo[position].name.toString()
        holder.price.text=productInfo[position].price
        holder.description.text=productInfo[position].description
        holder.discount.text=productInfo[position].discount_amount
        holder.status.text=productInfo[position].status.toString()
        Glide.with(holder.itemView.context).load(productInfo[position].image).into(holder.image)
        holder.rec.layoutManager = LinearLayoutManager(holder.itemView.context)
        holder.rec.adapter = CategoryAdapter(productInfo[position].categories)
    }

    override fun getItemCount(): Int {
        return productInfo.size
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val name = itemView.nameinfo
        val description = itemView.descriptioninfo
        val price = itemView.priceinfo
        val discount = itemView.discountinfo
        val image = itemView.imginfo
        val status = itemView.statusinfo
        val rec = itemView.recyclerCat
    }

}