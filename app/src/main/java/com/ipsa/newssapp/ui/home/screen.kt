package com.ipsa.newssapp.ui.home

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class screen {
}

fun main() = runBlocking {
    runBlocking {
        print("Completed_1 ")
    }
    launch(Dispatchers .IO) {
        delay(1000L)
        print("IO Dispatcher ")
    }
    launch(Dispatchers .IO) {
        delay(1000L)
        print("IO Dispatcher2 ")
    }
    //job.join()
    print("Completed_2")
    runBlocking {
        print("Completed_3 ")
    }
}