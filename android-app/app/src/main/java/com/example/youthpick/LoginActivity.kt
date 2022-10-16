package com.example.youthpick

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.youthpick.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        val binding = ActivityLoginBinding.inflate(layoutInflater)
    }
}