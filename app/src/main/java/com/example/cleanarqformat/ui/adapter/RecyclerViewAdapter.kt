package com.example.moviesdb2022newapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.cleanarqformat.R
import com.example.cleanarqformat.databinding.SearchProductItemBinding
import com.example.cleanarqformat.domain.model.ModelProduct


class SearchViewAdapter(
    private var list: List<ModelProduct> = emptyList()): RecyclerView.Adapter<SearchViewAdapter.Holder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.search_product_item, parent, false)
        return Holder(view)
    }

    fun updateList(newList: List<ModelProduct>){
        list = newList
        notifyDataSetChanged()

    }

    override fun onBindViewHolder(holder:Holder, position: Int) {
        holder.bind(list, position)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class Holder(itemView: View) : RecyclerView.ViewHolder(itemView){

        private var binding = SearchProductItemBinding.bind(itemView)

        fun bind(searchProduct: List<ModelProduct>, position:Int){
            if (searchProduct.isNotEmpty()) {
                val url = searchProduct.get(position).thumbnail

                with(binding){
                    Glide.with(productImage.context).load(url).into(binding.productImage)
                    price.text = searchProduct.get(position).price
                    productName.text = searchProduct.get(position).title
                    if (searchProduct.size >= 1) {
                        itemView.setOnClickListener {
                            Navigation.findNavController(it)
                        }
                    }
                }
            }
        }

    }
}