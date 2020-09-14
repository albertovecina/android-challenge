package com.idealista.android.challenge.core

interface PreferencesProvider {

    fun putBoolean(key: String, value: Boolean)

    fun getBoolean(key: String, defaultValue: Boolean): Boolean

}