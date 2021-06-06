package com.example.midterm2.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.midterm2.R
import com.example.midterm2.api.CategoryX
import kotlinx.android.synthetic.main.category.view.*

class CategoryAdapter(private val category: List<CategoryX>): RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryAdapter.ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.category, parent, false))
    }

    override fun onBindViewHolder(holder: CategoryAdapter.ViewHolder, position: Int) {
        holder.caterory1.text = category[position].id.toString()
        holder.category2.text = category[position].name
    }

    override fun getItemCount(): Int {
        return category.size
    }

    inner class ViewHolder(itemView:View): RecyclerView.ViewHolder(itemView) {
        val caterory1 = itemView.cat1
        val category2 = itemView.cat2
    }

}