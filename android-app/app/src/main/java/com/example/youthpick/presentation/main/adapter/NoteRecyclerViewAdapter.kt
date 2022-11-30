package com.example.youthpick.presentation.main.adapter

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.youthpick.data.local.NoteEntity
import com.example.youthpick.databinding.ItemMemosBinding
import com.example.youthpick.presentation.main.fragment.NoteDeleteDialogFragment
import com.example.youthpick.presentation.main.fragment.NoteDialogFragment
import com.example.youthpick.presentation.main.item.NoteItem
import com.example.youthpick.presentation.main.view.MainActivity
import com.example.youthpick.presentation.main.view.MainActivity.Companion.desc
import com.example.youthpick.presentation.main.view.MainActivity.Companion.title

class NoteRecyclerViewAdapter(
    context: Context,
    _deleteNote: (Int) -> Unit,
    _activity: FragmentActivity
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val inflater by lazy { LayoutInflater.from(context) }
    private var noteList: List<NoteEntity> = emptyList()
    private val deleteNote by lazy { _deleteNote }
    private val activity by lazy { _activity }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding = ItemMemosBinding.inflate(inflater, parent, false)
        return NoteViewHolder(binding, deleteNote, activity)
    }

    class NoteViewHolder(
        private val binding: ItemMemosBinding,
        private val deleteNote: (Int) -> Unit, private val activity: FragmentActivity
    ) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(data: NoteEntity) {
            val note = NoteItem(data.noteTitle, data.noteDesc)
            binding.tvMemoTitle.text = note.title
            binding.tvMemoDesc.text = note.desc
        }

        fun onNoteClick(data: NoteEntity, position: Int) {
            binding.ivDelete.setOnClickListener {
                val bundle = Bundle()
                bundle.putInt(MainActivity.position, position)
                val dialog = NoteDeleteDialogFragment().getInstance()
                dialog.arguments = bundle
                activity.supportFragmentManager.let { fragmentManager ->
                    dialog.getInstance()
                    dialog.show(fragmentManager, null)
                }
            }
            binding.memosItem.setOnClickListener {
                val bundle = Bundle()
                bundle.putString(title, data.noteTitle)
                bundle.putString(desc, data.noteDesc)
                bundle.putInt(MainActivity.position, position)
                val dialog = NoteDialogFragment().getInstance()
                dialog.arguments = bundle
                activity.supportFragmentManager.let { fragmentManager ->
                    dialog.getInstance()
                    dialog.show(fragmentManager, null)
                }
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        holder as NoteViewHolder
        holder.onBind(noteList[position])
        holder.onNoteClick(noteList[position], position)
    }

    override fun getItemCount(): Int {
        return noteList.size
    }

    fun setMemoList(_noteList: List<NoteEntity>) {
        noteList = _noteList
        notifyDataSetChanged()
    }
}