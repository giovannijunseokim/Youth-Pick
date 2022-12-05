package com.example.youthpick.presentation.license.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.youthpick.databinding.ActivityLicenseBinding

class LicenseActivity : AppCompatActivity() {

    lateinit var binding: ActivityLicenseBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLicenseBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }

}