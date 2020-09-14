package com.idealista.android.challenge

import android.content.Context
import com.idealista.android.challenge.core.PreferencesProvider

const val PREFERENCES_NAME = "application_preferences"

class PreferencesProvider(context: Context) : PreferencesProvider {

    private val sharedPreferences =
        context.getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE)

    override fun putBoolean(key: String, value: Boolean) {
        sharedPreferences.edit()
            .putBoolean(key, value)
            .apply()
    }

    override fun getBoolean(key: String, defaultValue: Boolean): Boolean =
        sharedPreferences.getBoolean(key, defaultValue)

}