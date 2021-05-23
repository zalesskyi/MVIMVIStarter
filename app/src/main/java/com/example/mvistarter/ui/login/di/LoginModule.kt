package com.example.mvistarter.ui.login.di

import com.example.mvistarter.ui.login.LoginFragment
import com.example.mvistarter.ui.login.LoginViewModel
import com.example.mvistarter.ui.login.LoginViewModelImpl
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.androidx.viewmodel.ext.android.getViewModel
import org.koin.dsl.module

val loginModule = module {
    viewModel { LoginViewModelImpl(get()) }
}

fun LoginFragment.injectViewModel(): Lazy<LoginViewModel> =
    lazy { getViewModel<LoginViewModelImpl>(null) }