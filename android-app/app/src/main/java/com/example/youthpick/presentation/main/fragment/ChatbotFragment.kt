package com.example.youthpick.presentation.main.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import com.example.youthpick.databinding.FragmentChatbotBinding

class ChatbotFragment : Fragment() {
    private var _binding: FragmentChatbotBinding? = null
    private val binding: FragmentChatbotBinding
        get() = requireNotNull(_binding) { "binding이 널임" }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentChatbotBinding.inflate(inflater, container, false)

        setWebView()
        return binding.root
    }

    private fun setWebView() {
        binding.wvChatbot.apply {
            webViewClient = WebViewClient()
            settings.javaScriptEnabled = true
        }
        binding.wvChatbot.loadUrl("https://console.dialogflow.com/api-client/demo/embedded/1304f852-8a98-48ae-b005-d916fd500733") /*준섭 추가*/


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}