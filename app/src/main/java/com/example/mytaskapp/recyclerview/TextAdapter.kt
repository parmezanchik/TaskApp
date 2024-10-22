package com.example.mytaskapp.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.mytaskapp.R
import com.example.mytaskapp.data.dp.entity.TextEntity
import com.example.mytaskapp.databinding.ItemTextBinding

class TextAdapter : ListAdapter<TextEntity, TextAdapter.TextViewHolder>(TextDiffCallback()) {

    class TextViewHolder(private val binding: ItemTextBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(textEntity: TextEntity?) {
            binding.textView.text = textEntity?.text
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TextViewHolder {
        val binding = ItemTextBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TextViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TextViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

class TextDiffCallback : DiffUtil.ItemCallback<TextEntity>() {
    override fun areItemsTheSame(oldItem: TextEntity, newItem: TextEntity): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: TextEntity, newItem: TextEntity): Boolean {
        return oldItem == newItem
    }
}