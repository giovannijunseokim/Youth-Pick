package com.example.youthpick.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.example.youthpick.MainActivity
import com.example.youthpick.R
import com.example.youthpick.adapter.NoteRecyclerViewAdapter
import com.example.youthpick.databinding.FragmentCalendarBinding
import com.example.youthpick.databinding.FragmentNoteBinding

class NoteFragment : Fragment() {
    private var _binding: FragmentNoteBinding? = null
    private val binding: FragmentNoteBinding
        get() = requireNotNull(_binding){"binding이 널임"}
    private val adapter by lazy { NoteRecyclerViewAdapter(requireContext()) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentNoteBinding.inflate(inflater, container, false)

        binding.btnDrawerOpener.setOnClickListener {
            (activity as MainActivity).drawerOpen()
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapter()
    }

    private fun initAdapter() {
        binding.rvMemo.adapter = adapter
        val manager = GridLayoutManager(activity,2)
        binding.rvMemo.layoutManager = manager
        adapter.setMemoList()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}