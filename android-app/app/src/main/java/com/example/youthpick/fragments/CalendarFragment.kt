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
            settings.javaScriptEnabled = true;
            settings.setUseWideViewPort(true);       // wide viewport를 사용하도록 설정
            settings.setLoadWithOverviewMode(true);  // 컨텐츠가 웹뷰보다 클 경우 스크린 크기에 맞게 조정
        }
        binding.wvCalendar.loadUrl("https://kim-junseop.github.io/")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}