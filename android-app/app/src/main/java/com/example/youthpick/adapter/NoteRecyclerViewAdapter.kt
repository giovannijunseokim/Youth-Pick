package com.example.youthpick.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.youthpick.data.local.NoteEntity
import com.example.youthpick.databinding.ItemMemosBinding
import com.example.youthpick.models.NoteItem
import com.example.youthpick.models.NoteViewModel

class NoteRecyclerViewAdapter(context: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val inflater by lazy { LayoutInflater.from(context) }
    private var noteList: List<NoteEntity> = emptyList()
    private val context by lazy { context }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding = ItemMemosBinding.inflate(inflater, parent, false)
        return NoteViewHolder(binding, context)
    }

    class NoteViewHolder(private val binding: ItemMemosBinding, private val context: Context): RecyclerView.ViewHolder(binding.root){
        fun onBind(data : NoteEntity){
            val note = NoteItem(data.noteTitle, data.noteDesc)
            binding.tvMemoTitle.text = note.title
            binding.tvMemoDesc.text = note.desc
        }
        fun onNoteClick(position: Int){
            binding.memosItem.setOnClickListener {
                Toast.makeText(context, (position+1).toString()+ "번째 메모 클릭", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        holder as NoteViewHolder
        holder.onBind(noteList[position])
        holder.onNoteClick(position)
    }

    override fun getItemCount(): Int {
        return noteList.size
    }

    fun setMemoList(_noteList: List<NoteEntity>) {
        noteList = _noteList
        notifyDataSetChanged()
    }
}