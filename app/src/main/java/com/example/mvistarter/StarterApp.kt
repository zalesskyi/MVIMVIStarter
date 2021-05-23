package com.example.mvistarter

import android.app.Application
import com.google.firebase.FirebaseApp
import com.example.mvistarter.di.DependencyInjection

class StarterApp : Application() {

    override fun onCreate() {
        super.onCreate()
        DependencyInjection.init(this)
        FirebaseApp.initializeApp(this)
    }
}