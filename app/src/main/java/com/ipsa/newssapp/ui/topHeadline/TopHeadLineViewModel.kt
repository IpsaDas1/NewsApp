package com.ipsa.newssapp.ui.topHeadline

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ipsa.newssapp.data.model.Article
import com.ipsa.newssapp.data.repository.TopHeadLineRepository
import com.ipsa.newssapp.data.util.ConnectivityManager
import com.ipsa.newssapp.data.util.ConnectivityManagerImpl
import com.ipsa.newssapp.data.util.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TopHeadLineViewModel @Inject constructor
    (private val topHeadLineRepository: TopHeadLineRepository, private val connectivityManager: ConnectivityManagerImpl) :
    ViewModel() {
    private val _articleList = MutableStateFlow<UiState<List<Article>>>(UiState.Loading)
    val articleList: StateFlow<UiState<List<Article>>> = _articleList
     fun fetchArticles(){
        if(connectivityManager.isNetworkConnected()){
            viewModelScope.launch {
                topHeadLineRepository.getTopHeadLine("us")
                    .catch { e ->
                        _articleList.value = UiState.Error(e.toString())
                }.collect {
                        _articleList.value = UiState.Success(it)
                }
            }
        } else {

        }
    }
}