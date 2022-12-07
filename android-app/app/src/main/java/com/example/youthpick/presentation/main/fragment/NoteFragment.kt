package com.example.youthpick.presentation.main.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.youthpick.data.local.NoteDatabase
import com.example.youthpick.data.local.NoteEntity
import com.example.youthpick.databinding.FragmentNoteBinding
import com.example.youthpick.presentation.main.adapter.NoteRecyclerViewAdapter
import com.example.youthpick.presentation.main.view.MainActivity
import kotlin.concurrent.thread

class NoteFragment : Fragment(), JunseoListener {
    private var _binding: FragmentNoteBinding? = null
    private val binding: FragmentNoteBinding
        get() = requireNotNull(_binding) { "binding이 널임" }
    private val adapter by lazy {
        NoteRecyclerViewAdapter(
            requireContext(),
            deleteNote, requireActivity()
        )
    }

    lateinit var db: NoteDatabase
    var noteList: List<NoteEntity> = listOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        db = NoteDatabase.getInstance(requireContext())!!
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
        val manager = GridLayoutManager(activity, 2)
        binding.rvMemo.layoutManager = manager
    }

    private fun addMemo() {
        val note = NoteEntity(null, "제목", "내용")
        insertNote(note)
    }

    fun insertNote(note: NoteEntity) {
        val addTask = thread(true) {
            db.noteDAO().insert(note)
        }
        addTask.join()
        getAllNotes()
        adapter.setMemoList(noteList)
    }

    private val deleteNote: (Int) -> Unit = { position ->
        val deleteTask = thread(true) {
            db.noteDAO().delete(noteList[position])
        }
        deleteTask.join()
        getAllNotes()
        adapter.setMemoList(noteList)
    }

    fun getAllNotes() {
        val getTask = thread(true) {
            noteList = db.noteDAO().getAllNote()
        }
        getTask.join()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun notifyToAdapter() {
        getAllNotes()
        adapter.setMemoList(noteList)
    }
}

interface JunseoListener {
    fun notifyToAdapter()
}