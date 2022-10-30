package com.example.youthpick.models

import androidx.lifecycle.ViewModel
import com.example.youthpick.R

class PagerViewModel :ViewModel() {
    val itemList = listOf<PageItem>(
        PageItem(
            image = R.drawable.calendar_pager,
            title = "유스픽 캘린더 바로가기",
            description = "서울시 청년 정책 정보를 한눈에"
        ),
        PageItem(
            image = R.drawable.chatbot_pager,
            title = "유스픽 챗봇 바로가기",
            description = "모르는건 챗봇에게 물어봐~"
        ),
        PageItem(
            image = R.drawable.memo_pager,
            title = "메모 바로가기",
            description = "중요한 일정은 메모해두자!"
        )
    )
}