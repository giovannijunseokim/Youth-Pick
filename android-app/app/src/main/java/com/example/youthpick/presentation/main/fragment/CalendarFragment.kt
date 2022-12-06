package com.example.youthpick.presentation.main.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import com.example.youthpick.databinding.FragmentCalendarBinding

class CalendarFragment : Fragment() {
    private var _binding: FragmentCalendarBinding? = null
    private val binding: FragmentCalendarBinding
        get() = requireNotNull(_binding) { "binding이 널임" }

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
        binding.wvCalendar.apply {
            webViewClient = WebViewClient()
            settings.javaScriptEnabled = true;
            settings.useWideViewPort = true;       // wide viewport를 사용하도록 설정
            settings.loadWithOverviewMode = true;  // 컨텐츠가 웹뷰보다 클 경우 스크린 크기에 맞게 조정
        }
        binding.wvCalendar.loadUrl("http://localhost:3000/")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}