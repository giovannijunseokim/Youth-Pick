package com.example.youthpick.presentation.search.view

import android.os.Bundle
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import com.example.youthpick.databinding.ActivitySearchBinding

class SearchActivity : AppCompatActivity() {
    lateinit var binding: ActivitySearchBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySearchBinding.inflate(layoutInflater)
        binding.wvSearch.apply {
            webViewClient = WebViewClient()
            settings.javaScriptEnabled = true;
            settings.useWideViewPort = true;       // wide viewport를 사용하도록 설정
            settings.loadWithOverviewMode = true;  // 컨텐츠가 웹뷰보다 클 경우 스크린 크기에 맞게 조정
        }
        binding.wvSearch.loadUrl("https://youth.seoul.go.kr/search/")

        setContentView(binding.root)
    }
}