package com.cse.ibisfsq.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.cse.ibisfsq.databinding.PlaceItemBinding
import com.cse.ibisfsq.retrofit.api.Result
import kotlin.random.Random

class ResultAdapter : RecyclerView.Adapter<ResultAdapter.ResultViewHolder>() {

    inner class ResultViewHolder(val binding: PlaceItemBinding) : RecyclerView.ViewHolder(binding.root)

    private val diffCallBack = object : DiffUtil.ItemCallback<Result>() {
        override fun areItemsTheSame(oldItem: Result, newItem: Result): Boolean {
            return oldItem.fsqId == newItem.fsqId
        }

        override fun areContentsTheSame(oldItem: Result, newItem: Result): Boolean {
            return oldItem == newItem
        }
    }
    private val differ = AsyncListDiffer(this, diffCallBack)
    var results : List<Result>
        get() = differ.currentList
        set(value) { differ.submitList(value)}


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ResultViewHolder {
        return ResultViewHolder(PlaceItemBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
     false))
    }

    override fun onBindViewHolder(holder: ResultViewHolder, position: Int) {
        holder.binding.apply {
            val result = results[position]

            locationName.text = result.name
            locationCategory.text = result.categories?.firstOrNull()?.name

            Glide.with(holder.itemView).load(buildIconPath(result)).into(locationImage)

            locationDistance.text = result.distance?.toString()

            locationFavorite.isChecked = Random.nextBoolean()
        }
    }

    override fun getItemCount() = results.size

    private fun buildIconPath(result: Result): String {
        result.categories?.firstOrNull()?.icon?.let{
            if (!it.prefix.isNullOrBlank() && !it.suffix.isNullOrBlank()) {
                return it.prefix + "88" + it.suffix
            }
        }
        return ""
    }
}