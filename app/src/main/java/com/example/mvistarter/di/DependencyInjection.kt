package com.example.mvistarter.di

import android.app.Application
import com.example.mvistarter.data.di.apiModule
import com.example.mvistarter.data.di.prefsModule
import com.example.mvistarter.ui.login.di.loginModule
import com.example.mvistarter.ui.main.di.mainModule
import com.example.mvistarter.ui.media.di.mediaModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

object DependencyInjection {

    fun init(application: Application) {
        startKoin {
            androidContext(application)
            modules(prefsModule, apiModule, mainModule, loginModule, mediaModule)
        }
    }
}