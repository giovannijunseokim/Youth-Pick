package com.example.youthpick.presentation.main.fragment

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.example.youthpick.R
import com.example.youthpick.data.local.NoteDatabase
import com.example.youthpick.data.local.NoteEntity
import com.example.youthpick.databinding.FragmentNoteDialogBinding
import com.example.youthpick.presentation.main.view.MainActivity.Companion.desc
import com.example.youthpick.presentation.main.view.MainActivity.Companion.position
import com.example.youthpick.presentation.main.view.MainActivity.Companion.title
import kotlin.concurrent.thread


class NoteDialogFragment : DialogFragment() {

    private var _binding: FragmentNoteDialogBinding? = null
    private val binding: FragmentNoteDialogBinding
        get() = requireNotNull(_binding) { "아 왜~~~~~" }
    val bundle by lazy { arguments }
    lateinit var db: NoteDatabase
    var noteList: List<NoteEntity> = listOf()

    private lateinit var junseoListener: JunseoListener

    override fun onAttach(context: Context) {
        super.onAttach(context)
        try {
            junseoListener = parentFragmentManager.findFragmentById(R.id.fragment_container_view)
                    as NoteFragment
        } catch (e: java.lang.ClassCastException) {
            Log.e("Gio", e.toString())
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        db = NoteDatabase.getInstance(requireContext())!!
        val getTask = thread(true) {
            noteList = db.noteDAO().getAllNote()
        }
        getTask.join()
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentNoteDialogBinding.inflate(inflater, container, false)
        binding.etMemoTitle.setText(bundle?.getString(title))
        binding.etMemoDesc.setText(bundle?.getString(desc))
        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog?.window?.requestFeature(Window.FEATURE_NO_TITLE)
        binding.ivBack.setOnClickListener {
            Toast.makeText(requireContext(), "저장되었습니다", Toast.LENGTH_SHORT)
                .show()
            dismiss()
        }
        return binding.root
    }

    fun getInstance(): NoteDialogFragment {
        return NoteDialogFragment()
    }

    override fun onPause() {
        super.onPause()
        val note = noteList[bundle!!.getInt(position)]
        note.noteTitle = binding.etMemoTitle.text.toString()
        note.noteDesc = binding.etMemoDesc.text.toString()
        val changeTask = thread(true) {
            db.noteDAO().insert(note)
        }
        changeTask.join()
        junseoListener.notifyToAdapter()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}