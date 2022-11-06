package com.example.youthpick.models

import androidx.lifecycle.ViewModel
import com.example.youthpick.R

class NoteViewModel :ViewModel() {
    val itemList = listOf<NoteItem>(
        NoteItem(
            title = "김민종",
            desc = "Cash in, cash out, cash in, cash out\n" +
                    "Cash in, cash out, cash in, cash out\n" +
                    "Cash out, cash out, cash out, cash out\n" +
                    "Cash out, cash out, cash out, cash out\n" +
                    "Cash in, cash out, cash in, cash out\n" +
                    "Cash in, cash out, cash in, cash out\n" +
                    "Cash out, cash out, cash out, cash out (21)"
        ),
        NoteItem(
            title = "김준서",
            desc = "Riding in the car with no keys (straight up)\n" +
                    "Louis V shirt with no sleeves (on God)\n" +
                    "Slaughter gang, nigga, I'm rep'ing (21)\n" +
                    "Chopper get to preaching, I'm the reverend (21)"
        ),
        NoteItem(
            title = "김준섭",
            desc = "Call him New Era, he capping (yeah)\n" +
                    "Them the type of niggas I ain't dapping (on God)\n" +
                    "When I book a show, make my backend cashing\n" +
                    "21, Uncle Sam, dawg, I'm taxing"
        ),
        NoteItem(
            title = "김재원",
            desc = "Riding in the coupe and it's a sport (yeah)\n" +
                    "My bodyguard look like a horse (straight up)\n" +
                    "She gon' suck me up like it's a chore (on God)\n" +
                    "Took the La Ferrari on a tour (21)"
        ),
        NoteItem(
            title = "테스트용 쥰내 긴 제목",
            desc = "설명 1"
        ),
        NoteItem(
            title = "제목 2",
            desc = "설명 2"
        ),
        NoteItem(
            title = "제목 3",
            desc = "설명 3"
        ),
        NoteItem(
            title = "제목 4",
            desc = "설명 4"
        )
    )
}