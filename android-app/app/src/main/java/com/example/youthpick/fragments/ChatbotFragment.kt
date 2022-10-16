package com.example.youthpick.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.youthpick.R
import com.example.youthpick.databinding.FragmentCalendarBinding
import com.example.youthpick.databinding.FragmentChatbotBinding

class ChatbotFragment :Fragment(){
    private var _binding: FragmentChatbotBinding? = null
    private val binding: FragmentChatbotBinding
        get() = requireNotNull(_binding){"binding이 널임"}

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentChatbotBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}