package com.example.mvistarter.data.di

import com.example.mvistarter.data.prefs.AppPreferences
import com.example.mvistarter.data.prefs.AppPreferencesImpl
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val prefsModule = module {
    single<AppPreferences> { AppPreferencesImpl(androidApplication()) }
}