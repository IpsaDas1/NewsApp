package com.ipsa.newssapp.data.repository

import com.ipsa.newssapp.data.api.NetworkService
import com.ipsa.newssapp.data.model.Article
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TopHeadLineRepository @Inject constructor(private val networkService: NetworkService) {
    suspend fun getTopHeadLine(country: String): Flow<List<Article>> {
        val response = networkService.getTopHeadLine(country)
        return flow {
            emit(response)
        }.map {
            it.articles
        }
    }
}