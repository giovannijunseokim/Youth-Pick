package com.example.youthpick


import android.os.Bundle
import android.view.Gravity
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.youthpick.databinding.ActivityMainBinding
import com.example.youthpick.databinding.FragmentCalendarBinding
import com.example.youthpick.databinding.FragmentMainBinding
import com.example.youthpick.fragments.CalendarFragment
import com.example.youthpick.fragments.ChatbotFragment
import com.example.youthpick.fragments.MainFragment
import com.example.youthpick.fragments.NoteFragment
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    var mBackWait:Long = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        firstFragment()
        binding.bnvMain.setOnItemSelectedListener { item ->
            changeFragment(item.itemId)
        }

        navigationClickEvent(binding)
    }

    override fun onBackPressed() {
        if(System.currentTimeMillis() - mBackWait >=2000 ) {
            mBackWait = System.currentTimeMillis()
            Toast.makeText(this, "한번 더 누르면 종료합니다.", Toast.LENGTH_SHORT).show() }
        else {
            finish()
        }
    }

    private fun navigationClickEvent(binding: ActivityMainBinding) {
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
    }

    private fun firstFragment(){
        val currentFragment = supportFragmentManager.findFragmentById(R.id.fragment_container_view)
        if(currentFragment == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.fragment_container_view, MainFragment())
                .commit()
        }
    }
    fun changeFragment(itemId : Int) : Boolean{
        when(itemId) {
            R.id.item_main -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container_view, MainFragment())
                    .commit()
                return true
            }
            R.id.item_calendar -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container_view, CalendarFragment())
                    .commit()
                return true
            }
            R.id.item_chatbot -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container_view, ChatbotFragment())
                    .commit()
                return true
            }
            R.id.item_note -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container_view, NoteFragment())
                    .commit()
                return true
            }
            else -> return false
        }
    }

    fun drawerOpen(){
        binding.drawer.openDrawer(Gravity.LEFT)
    }
    private fun drawerClose(){
        binding.drawer.closeDrawer(Gravity.LEFT)
    }
}