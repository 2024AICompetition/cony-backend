package com.conymind.backend.controller

import com.conymind.backend.model.Card
import com.conymind.backend.model.Link
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/cards")
class CardController {
    @GetMapping
    fun getCards(): List<Card> {
        return listOf(
            Card(
                iconImage = null,
                title = "CONY의 오늘 한마디",
                headline = "직장 상사와 갈등이 있어도 너무 걱정하지 마세요!",
                links = listOf(),
                contents = null
            ),
            Card(
                iconImage = null,
                title = "한주의 시작은 힘들어요",
                headline = null,
                links = listOf(
                    Link(
                        "https://conymind.com", "관련 기사에 대한 제목입니다.",
                        "관련 기사에 대한 내용입니다. 조금 요약되서 나올 듯한 그런 내용들.",
                        "https://picsum.photos/200/300"
                    ),
                    Link(
                        "https://conymind.com", "관련 기사에 대한 제목입니다.",
                        "관련 기사에 대한 내용입니다. 조금 요약되서 나올 듯한 그런 내용들.",
                        "https://picsum.photos/200/300"
                    )
                ),
                contents = null
            ),
            Card(
                iconImage = null,
                title = "과거의 오늘 보기",
                headline = null,
                links = listOf(
                    Link(
                        "https://conymind.com", "2019년 6월 27일",
                        "오늘도 열심히 공부하고 디자인에 노력해봐야겠어요.",
                        "https://picsum.photos/200/300"
                    )
                ),
                contents = "여행에서 뜻밖의 경험을 하고 새로운 사람을 알게 되었던 날이에요."
            )
        )
    }
}