package uz.drop.sharedelementtransition

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import uz.drop.sharedelementtransition.databinding.ItemImageBinding

/**
 * Created by Abdulaziz Rasulbek on 13/08/21.
 * Copyright (c) 2021  All rights reserved.
 **/
class ImageAdapter : ListAdapter<Image, ImageVH>(COMPARATOR) {
    private var clickListener: ImageClickListener? = null

    fun setOnClickListener(l: ImageClickListener) {
        clickListener = l
    }

    companion object {
        private val COMPARATOR = object : DiffUtil.ItemCallback<Image>() {
            override fun areItemsTheSame(oldItem: Image, newItem: Image): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: Image, newItem: Image): Boolean {
                return oldItem == newItem
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageVH {
        val binding = ItemImageBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ImageVH(binding, clickListener)
    }

    override fun onBindViewHolder(holder: ImageVH, position: Int) {
        holder.bind(getItem(position))
    }
}

class ImageVH(
    private val binding: ItemImageBinding,
    private val clickListener: ImageClickListener?
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: Image) {
        binding.image.transitionName = "image$adapterPosition"
        binding.image.setImageResource(item.image)

        binding.root.setOnClickListener {
            clickListener?.invoke(item, binding.image)
        }
    }
}

typealias ImageClickListener = (item: Image, view: View) -> Unit