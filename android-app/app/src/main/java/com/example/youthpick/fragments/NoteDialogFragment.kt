package com.example.youthpick.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.youthpick.R
import com.example.youthpick.databinding.FragmentNoteBinding
import com.example.youthpick.databinding.FragmentNoteDialogBinding

class NoteDialogFragment : Fragment() {
    private var _binding: FragmentNoteDialogBinding? = null
    private val binding: FragmentNoteDialogBinding
        get() = requireNotNull(_binding){"_binding이 널임"}

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentNoteDialogBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}