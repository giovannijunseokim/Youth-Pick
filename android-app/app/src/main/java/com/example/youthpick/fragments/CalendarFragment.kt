package com.example.youthpick.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebViewClient
import android.widget.Toast
import com.example.youthpick.MainActivity
import com.example.youthpick.R
import com.example.youthpick.databinding.FragmentCalendarBinding

class CalendarFragment :Fragment(){
    private var _binding: FragmentCalendarBinding? = null
    private val binding: FragmentCalendarBinding
        get() = requireNotNull(_binding){"binding이 널임"}

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCalendarBinding.inflate(inflater, container, false)

        setWebView()
        return binding.root
    }

    private fun setWebView() {
        binding.wvCalendar.apply{
            webViewClient = WebViewClient()
            settings.javaScriptEnabled = true
        }
        binding.wvCalendar.loadUrl("https://naver.com")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}