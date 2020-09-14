package com.idealista.android.challenge.core

interface PreferencesProvider {

    fun string(key: String, defaultValue: String): String

}