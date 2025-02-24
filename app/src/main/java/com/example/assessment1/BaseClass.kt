package com.example.assessment1

import android.app.Application
import android.util.Log

// Static object to execute code before anything else
object EarlyInit {
    init {
        Log.d("AppExecutionOrder", "1⃣ EarlyInit block executed")
        earlyFunction()
    }

    fun earlyFunction() {
        Log.d("AppExecutionOrder", "2⃣ Custom function executed before Application constructor")
    }
}
class BaseClass:Application() {
    companion object {
        val init = EarlyInit
    }
    init {
        Log.d("AppExecutionOrder", "3⃣ Application constructor executed")
    }

    override fun onCreate() {
        super.onCreate()
        Log.d("AppExecutionOrder", "4⃣ onCreate executed")
    }
}