package com.ipsa.newssapp.ui.home

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.ipsa.newssapp.R
import com.ipsa.newssapp.ui.base.Nav
import com.ipsa.newssapp.ui.theme.NewssAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NewssAppTheme {
                Nav()
            }
        }
    }
}