package com.conymind.backend.model

data class Card(
    val iconImage: String?,
    val title: String,
    val contents: String?,
    val links: List<Link>,
    val cardColor: String,
    val cardColorAccent: String
)

data class Link(
    val url: String,
    val title: String,
    val description: String,
    val image: String
)