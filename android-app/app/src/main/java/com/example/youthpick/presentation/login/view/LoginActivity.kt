package com.example.youthpick.presentation.login.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.youthpick.databinding.ActivityLoginBinding


class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityLoginBinding.inflate(layoutInflater)

        setContentView(binding.root)
    }
}