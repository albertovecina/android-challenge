package com.idealista.android.challenge

import android.content.Context
import com.idealista.android.challenge.core.PreferencesProvider

const val PREFERENCES_NAME = "application_preferences"

class PreferencesProvider(context: Context) : PreferencesProvider {

    private val sharedPreferences =
        context.getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE)

    override fun string(key: String, defaultValue: String): String =
        sharedPreferences.getString(key, defaultValue) ?: defaultValue

}