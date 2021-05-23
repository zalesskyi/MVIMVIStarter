package com.example.mvistarter.data.di

import com.example.mvistarter.data.api.AuthApi
import com.example.mvistarter.data.api.AuthApiImpl
import org.koin.dsl.module

val apiModule = module {

    single<AuthApi> {
        AuthApiImpl()
    }
}