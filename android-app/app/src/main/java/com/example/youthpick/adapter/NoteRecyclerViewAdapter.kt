package com.example.youthpick.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.youthpick.databinding.ItemMemosBinding
import com.example.youthpick.models.NoteItem
import com.example.youthpick.models.NoteViewModel

class NoteRecyclerViewAdapter(context: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val inflater by lazy { LayoutInflater.from(context) }
    private var userList: List<NoteItem> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding = ItemMemosBinding.inflate(inflater, parent, false)
        return NoteViewHolder(binding)
    }

    class NoteViewHolder(private val binding: ItemMemosBinding): RecyclerView.ViewHolder(binding.root){
        fun onBind(data : NoteItem){
            binding.tvMemoTitle.text = data.title
            binding.tvMemoDesc.text = data.desc
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        holder as NoteViewHolder
        holder.onBind(userList[position])
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    fun setMemoList(){
        userList = NoteViewModel().itemList
    }

}