package com.ipsa.newssapp.ui.topHeadline

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.ipsa.newssapp.data.model.Article
import com.ipsa.newssapp.data.util.UiState

@Composable
fun TopHeadlineScreen(viewModel: TopHeadLineViewModel = hiltViewModel(), navController: NavController){
    val topHeadlineUiState: UiState<List<Article>> by viewModel.articleList.collectAsStateWithLifecycle()
    LaunchedEffect(key1 = Unit, block = {
        viewModel.fetchArticles()
    })

    Column(modifier = Modifier.padding(5.dp)) {
        TopHeadlineState(topHeadlineUiState)
    }
}
@Composable
fun ArticleDataList(article: List<Article>) {
    LazyColumn {
        items(article, key = { article -> article.url }) { article ->
            ArticleData(article)
        }
    }
}

@Composable
fun ArticleData(data: Article) {
    Card(
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier
            .shadow(4.dp)
            .padding(6.dp)
            .fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFF5F5F5))

    ) {
        Column(modifier = Modifier.fillMaxWidth()) {
            BannerImage(imageUrl = data.urlToImage, title = data.title)
            TitleText(title = data.title)
            DescriptionText(description = data.description)
            AuthorText(name = data.author)
        }
    }
}


@Composable
fun BannerImage(imageUrl: String?, title: String) {
    AsyncImage(
        model = imageUrl,
        contentDescription = title,
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
    )
}

@Composable
fun TitleText(title: String?) {
    title?.let {
        Text(
            text = title,
            color = Color.Black,
            style = MaterialTheme.typography.titleMedium,
            maxLines = 2,
            modifier = Modifier.padding(4.dp)
        )
    }
}

@Composable
fun AuthorText(name: String?) {
    name?.let {
        Text(
            text = name,
            color = Color.LightGray,
            style = MaterialTheme.typography.titleSmall,
            maxLines = 2,
            modifier = Modifier.padding(4.dp)
        )
    }
}

@Composable
fun DescriptionText(description: String?) {
    description?.let {
        Text(
            text = description,
            color = Color.LightGray,
            style = MaterialTheme.typography.titleSmall,
            maxLines = 2,
            modifier = Modifier.padding(4.dp)
        )
    }
}

@Composable
fun TopHeadlineState(
    uiState: UiState<List<Article>>,
) {
    when (uiState) {
        is UiState.Success -> {
            ArticleDataList(uiState.data)
        }

        is UiState.Loading -> {
            //ShowLoading()
        }

        is UiState.Error -> {
            ///ShowError(text = uiState.message)
        }
    }

}

