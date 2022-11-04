package com.example.youthpick.fragments

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
    var mBackWait:Long = 0

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCalendarBinding.inflate(inflater, container, false)
        binding.wvCalendar.apply {
            webViewClient = WebViewClient()
            settings.javaScriptEnabled = true
        }
        binding.wvCalendar.loadUrl("file:///android_asset/www/calendar.html")

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun goBackEnable(){
        if (binding.wvCalendar.canGoBack())
            binding.wvCalendar.goBack()
        else{
            if(System.currentTimeMillis() - mBackWait >=2000 ) {
                mBackWait = System.currentTimeMillis()
                Toast.makeText(activity, "한번 더 누르면 종료합니다.", Toast.LENGTH_SHORT).show() }
            else {
                activity?.finish()
            }
        }
    }
}