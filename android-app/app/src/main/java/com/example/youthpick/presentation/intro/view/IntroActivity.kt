package com.example.youthpick.presentation.intro.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.youthpick.R
import com.example.youthpick.databinding.ActivityIntroBinding
import com.example.youthpick.presentation.main.view.MainActivity
import java.util.*
import kotlin.concurrent.schedule

class IntroActivity : AppCompatActivity() {
    lateinit var binding: ActivityIntroBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityIntroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Timer().schedule(2200) {
            changeActivity()
        }
    }

    private fun changeActivity() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out)
        finish()
    }
}