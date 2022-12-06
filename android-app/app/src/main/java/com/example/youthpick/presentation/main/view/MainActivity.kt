package com.example.youthpick.presentation.main.view


import android.content.Intent
import android.os.Bundle
import android.view.Gravity
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.youthpick.R
import com.example.youthpick.databinding.ActivityMainBinding
import com.example.youthpick.presentation.license.view.LicenseActivity
import com.example.youthpick.presentation.main.fragment.CalendarFragment
import com.example.youthpick.presentation.main.fragment.ChatbotFragment
import com.example.youthpick.presentation.main.fragment.MainFragment
import com.example.youthpick.presentation.main.fragment.NoteFragment

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    var mBackWait: Long = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        firstFragment()
        binding.bnvMain.setOnItemSelectedListener { item ->
            changeFragment(item.itemId)
        }
        selectNavigationListener()
    }

    override fun onBackPressed() {
        if (System.currentTimeMillis() - mBackWait >= 2000) {
            mBackWait = System.currentTimeMillis()
            Toast.makeText(this, "한번 더 누르면 종료합니다.", Toast.LENGTH_SHORT).show()
        } else {
            finish()
        }
    }

    private fun selectNavigationListener() {
        binding.ivDrawerLogo.setOnClickListener {
            changeFragment(R.id.item_main)
            binding.bnvMain.selectedItemId = R.id.item_main
            drawerClose()
        }
        binding.tvDrawerCalendar.setOnClickListener {
            changeFragment(R.id.item_calendar)
            binding.bnvMain.selectedItemId = R.id.item_calendar
            drawerClose()
        }
        binding.tvDrawerChatbot.setOnClickListener {
            changeFragment(R.id.item_chatbot)
            binding.bnvMain.selectedItemId = R.id.item_chatbot
            drawerClose()
        }
        binding.tvDrawerNote.setOnClickListener {
            changeFragment(R.id.item_note)
            binding.bnvMain.selectedItemId = R.id.item_note
            drawerClose()
        }
        binding.tvDrawerLicense.setOnClickListener {
            startActivity(Intent(this@MainActivity, LicenseActivity::class.java))
        }
    }

    private fun firstFragment() {
        val currentFragment = supportFragmentManager.findFragmentById(R.id.fragment_container_view)
        if (currentFragment == null) {
            supportFragmentManager.beginTransaction()
                .setCustomAnimations(
                    R.anim.fade_in, R.anim.fade_out,
                    R.anim.fade_in, R.anim.fade_out
                )
                .add(R.id.fragment_container_view, MainFragment())
                .commit()
        }
    }

    fun changeFragment(itemId: Int): Boolean {
        when (itemId) {
            R.id.item_main -> {
                supportFragmentManager.beginTransaction()
                    .setCustomAnimations(
                        R.anim.fade_in, R.anim.fade_out,
                        R.anim.fade_in, R.anim.fade_out
                    )
                    .replace(R.id.fragment_container_view, MainFragment())
                    .commit()
                return true
            }
            R.id.item_calendar -> {
                supportFragmentManager.beginTransaction()
                    .setCustomAnimations(
                        R.anim.fade_in, R.anim.fade_out,
                        R.anim.fade_in, R.anim.fade_out
                    )
                    .replace(R.id.fragment_container_view, CalendarFragment())
                    .commit()
                return true
            }
            R.id.item_chatbot -> {
                supportFragmentManager.beginTransaction()
                    .setCustomAnimations(
                        R.anim.fade_in, R.anim.fade_out,
                        R.anim.fade_in, R.anim.fade_out
                    )
                    .replace(R.id.fragment_container_view, ChatbotFragment())
                    .commit()
                return true
            }
            R.id.item_note -> {
                supportFragmentManager.beginTransaction()
                    .setCustomAnimations(
                        R.anim.fade_in, R.anim.fade_out,
                        R.anim.fade_in, R.anim.fade_out
                    )
                    .replace(R.id.fragment_container_view, NoteFragment())
                    .commit()
                return true
            }
            else -> return false
        }
    }

    fun drawerOpen() {
        binding.drawer.openDrawer(Gravity.LEFT)
    }

    private fun drawerClose() {
        binding.drawer.closeDrawer(Gravity.LEFT)
    }

    companion object {
        val title = "title"
        val desc = "desc"
        val position = "position"
    }

}