package com.example.youthpick.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.example.youthpick.MainActivity
import com.example.youthpick.adapter.NoteRecyclerViewAdapter
import com.example.youthpick.data.local.NoteDatabase
import com.example.youthpick.data.local.NoteEntity
import com.example.youthpick.databinding.FragmentNoteBinding
import kotlin.concurrent.thread

class NoteFragment : Fragment() {
    private var _binding: FragmentNoteBinding? = null
    private val binding: FragmentNoteBinding
        get() = requireNotNull(_binding){"binding이 널임"}
    private val adapter by lazy { NoteRecyclerViewAdapter(requireContext()) }

    lateinit var db: NoteDatabase
    var noteList: List<NoteEntity> = listOf<NoteEntity>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        db = NoteDatabase.getInstance(requireActivity())!!
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentNoteBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapter()

        binding.btnDrawerOpener.setOnClickListener {
            (activity as MainActivity).drawerOpen()
        }

        binding.btnAddMemo.setOnClickListener {
            addMemo()
        }
    }

    private fun initAdapter() {
        getAllNotes()
        adapter.setMemoList(noteList)
        binding.rvMemo.adapter = adapter
        val manager = GridLayoutManager(activity,2)
        binding.rvMemo.layoutManager = manager
    }

    private fun addMemo() {
        val note = NoteEntity(null,"Test","description")
        insertNote(note)
        Log.d("GIO", "insertNote")
    }

    fun insertNote(note : NoteEntity){
        val addTask = thread(true){
            db.noteDAO().insert(note)
        }
        addTask.join()
        getAllNotes()
        adapter.setMemoList(noteList)
        adapter.notifyDataSetChanged()
    }

    private fun getAllNotes(){
        val getTask = thread(true){
            noteList = db.noteDAO().getAllNote()
        }
        getTask.join()
    }

    fun deleteNote(){

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}