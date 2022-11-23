package com.example.youthpick.fragments

import android.os.Bundle
import android.text.Editable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.example.youthpick.MainActivity.Companion.desc
import com.example.youthpick.MainActivity.Companion.title
import com.example.youthpick.databinding.FragmentNoteDialogBinding

class NoteDialogFragment: DialogFragment() {

    private var _binding: FragmentNoteDialogBinding? = null
    private val binding: FragmentNoteDialogBinding
        get() = requireNotNull(_binding){"아 왜~~~~~"}
    val bundle by lazy { arguments }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentNoteDialogBinding.inflate(inflater, container, false)
        binding.etMemoTitle.setText(bundle?.getString(title))
        binding.etMemoDesc.setText(bundle?.getString(desc))
        binding.ivBack.setOnClickListener {
            dismiss()
        }
        return binding.root
    }

    fun getInstance(): NoteDialogFragment {
        return NoteDialogFragment()
    }

    override fun onDestroy() {
        super.onDestroy()

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}