package com.example.youthpick.presentation.main.viewmodel

import androidx.lifecycle.ViewModel
import com.example.youthpick.R
import com.example.youthpick.presentation.main.item.MainPageItem

class MainPagerViewModel : ViewModel() {
    val itemList = listOf<MainPageItem>(
        MainPageItem(
            image = R.drawable.calendar_pager,
            title = "유스픽 캘린더 바로가기",
            description = "서울시 청년 정책 정보를 한눈에"
        ),
        MainPageItem(
            image = R.drawable.chatbot_pager,
            title = "유스픽 챗봇 바로가기",
            description = "모르는건 챗봇에게 물어봐~"
        ),
        MainPageItem(
            image = R.drawable.memo_pager,
            title = "메모 바로가기",
            description = "중요한 일정은 메모해두자!"
        )
    )
}