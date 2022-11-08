package com.example.youthpick.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.youthpick.databinding.FragmentNoteBinding
import com.example.youthpick.databinding.ItemMemosBinding
import com.example.youthpick.fragments.NoteFragment
import com.example.youthpick.models.NoteItem
import com.example.youthpick.models.NoteViewModel

class NoteRecyclerViewAdapter(context: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val inflater by lazy { LayoutInflater.from(context) }
    private var userList: List<NoteItem> = emptyList()
    private val context by lazy { context }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding = ItemMemosBinding.inflate(inflater, parent, false)
        return NoteViewHolder(binding, context)
    }

    class NoteViewHolder(private val binding: ItemMemosBinding, private val context: Context): RecyclerView.ViewHolder(binding.root){
        fun onBind(data : NoteItem){
            binding.tvMemoTitle.text = data.title
            binding.tvMemoDesc.text = data.desc
        }
        fun onNoteClickEventListener(position: Int){
            binding.memosItem.setOnClickListener {
                Toast.makeText(context, (position+1).toString()+ "번째 메모 클릭", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        holder as NoteViewHolder
        holder.onBind(userList[position])
        holder.onNoteClickEventListener(position)
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    fun setMemoList(){
        userList = NoteViewModel().itemList
    }

    fun addMemoList(){
        val newNoteItem = NoteItem(
            title = "새 메모",
            desc = "")
        userList = userList + newNoteItem
        notifyItemInserted(itemCount - 1)
    }
}