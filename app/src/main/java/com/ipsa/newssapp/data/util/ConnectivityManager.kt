package com.ipsa.newssapp.data.util

import android.content.Context
import android.net.ConnectivityManager
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

interface ConnectivityManager {
    fun isNetworkConnected(): Boolean
}

class ConnectivityManagerImpl @Inject constructor(@ApplicationContext private val context: Context) :
    com.ipsa.newssapp.data.util.ConnectivityManager {
    override fun isNetworkConnected(): Boolean {
        val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork = cm.activeNetworkInfo
        return activeNetwork?.isConnected ?: false
    }
}
