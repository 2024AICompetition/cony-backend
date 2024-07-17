package com.conymind.backend.model

data class Card(
    val iconImage: String?,
    val headline: String?,
    val title: String,
    val contents: String?,
    val links: List<Link>
)

data class Link(
    val url: String,
    val title: String,
    val description: String,
    val image: String
)