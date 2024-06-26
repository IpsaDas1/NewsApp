package com.ipsa.newssapp.data.model

data class TopHeadlineResponse(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)