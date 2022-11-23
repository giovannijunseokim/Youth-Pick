package com.example.youthpick.adapter

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.youthpick.MainActivity
import com.example.youthpick.MainActivity.Companion.desc
import com.example.youthpick.MainActivity.Companion.title
import com.example.youthpick.data.local.NoteEntity
import com.example.youthpick.databinding.ItemMemosBinding
import com.example.youthpick.fragments.NoteDialogFragment
import com.example.youthpick.fragments.NoteFragment
import com.example.youthpick.models.NoteItem
import kotlin.concurrent.thread

class NoteRecyclerViewAdapter(context: Context,
                              _deleteNote: (Int) -> Unit,
                              _changeNote: (Int) -> Unit,
                              _activity: FragmentActivity) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val inflater by lazy { LayoutInflater.from(context) }
    private var noteList: List<NoteEntity> = emptyList()
    private val context by lazy { context }
    private val deleteNote by lazy { _deleteNote }
    private val changeNote by lazy { _changeNote }
    private val activity by lazy { _activity }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding = ItemMemosBinding.inflate(inflater, parent, false)
        return NoteViewHolder(binding, context, deleteNote, changeNote, activity)
    }

    class NoteViewHolder(private val binding: ItemMemosBinding, private val context: Context,
                         private val deleteNote : (Int)->Unit, private val changeNote : (Int)-> Unit,
                         private val activity: FragmentActivity): RecyclerView.ViewHolder(binding.root){
        fun onBind(data : NoteEntity){
            val note = NoteItem(data.noteTitle, data.noteDesc)
            binding.tvMemoTitle.text = note.title
            binding.tvMemoDesc.text = note.desc
        }
        fun onNoteClick(data: NoteEntity, position: Int){
            binding.ivDelete.setOnClickListener {
                deleteNote(position)
            }
            binding.memosItem.setOnClickListener {
                Toast.makeText(context, (position + 1).toString() + "번째 메모 클릭", Toast.LENGTH_SHORT)
                    .show()
                val bundle = Bundle()
                bundle.putString(title, data.noteTitle)
                bundle.putString(desc, data.noteDesc)
                val dialog = NoteDialogFragment().getInstance()
                dialog.arguments = bundle
                val showTask = thread(true) {
                activity.supportFragmentManager.let { fragmentManager ->
                    dialog.getInstance()
                    dialog.show(fragmentManager, null)
                    }
                }
                showTask.join()
                changeNote(position)
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        holder as NoteRecyclerViewAdapter.NoteViewHolder
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