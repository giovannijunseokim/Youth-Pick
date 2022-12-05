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
import androidx.fragment.app.DialogFragment
import com.example.youthpick.R
import com.example.youthpick.data.local.NoteDatabase
import com.example.youthpick.data.local.NoteEntity
import com.example.youthpick.databinding.FragmentNoteDeleteDialogBinding
import com.example.youthpick.presentation.main.view.MainActivity.Companion.position
import kotlin.concurrent.thread


class NoteDeleteDialogFragment : DialogFragment() {

    private var _binding: FragmentNoteDeleteDialogBinding? = null
    private val binding: FragmentNoteDeleteDialogBinding
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

    fun getInstance(): NoteDeleteDialogFragment {
        return NoteDeleteDialogFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentNoteDeleteDialogBinding.inflate(inflater, container, false)
        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog?.window?.requestFeature(Window.FEATURE_NO_TITLE)
        binding.btnDeleteDialog.setOnClickListener {

            val deleteTask = thread(true) {
                db.noteDAO().delete(noteList[bundle!!.getInt(position)])
            }
            deleteTask.join()
            junseoListener.notifyToAdapter()
            dismiss()
        }
        binding.btnMaintainDialog.setOnClickListener {
            dismiss()
        }
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}