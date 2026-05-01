package com.example.letssopt.common.util

import android.content.Context
import android.content.SharedPreferences

class AuthPreference(context: Context) {

    private val prefs: SharedPreferences =
        context.getSharedPreferences("auth_pref", Context.MODE_PRIVATE)

    fun setLoggedIn(isLoggedIn: Boolean) {
        prefs.edit().putBoolean("is_logged_in", isLoggedIn).apply()
    }

    fun isLoggedIn(): Boolean {
        return prefs.getBoolean("is_logged_in", false)
    }
}