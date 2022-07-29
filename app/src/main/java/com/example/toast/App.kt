package com.example.toast

import android.app.Application
import android.content.Context
import android.widget.Toast

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        val prefs = getSharedPreferences("COUNT", Context.MODE_PRIVATE)
        val count = prefs.getInt("COUNT", 0)
        if (count == 2) {
            Toast.makeText(applicationContext, "This is Toast", Toast.LENGTH_LONG).show()
            prefs.edit().putInt("COUNT", 0).apply()
        }
        prefs.edit().putInt("COUNT", count + 1).apply()
    }
}