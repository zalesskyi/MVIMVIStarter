package com.example.mvistarter.ui.main

import android.content.Context
import com.example.mvistarter.data.prefs.AppPreferences
import com.example.mvistarter.ui.base.BaseViewModel
import com.example.mvistarter.ui.base.BaseViewModelImpl

interface MainViewModel : BaseViewModel<MainContract.State, MainContract.Event>

class MainViewModelImpl(private val appPrefs: AppPreferences)
    : BaseViewModelImpl<MainContract.State, MainContract.Event>(),
    MainViewModel {


    override suspend fun initialState(): MainContract.State = MainContract.State.Initial

    override fun onEventArrived(event: MainContract.Event?) {
        when (event) {
            MainContract.Event.CheckAuth -> checkAuth()
            is MainContract.Event.Logout -> {
                uiState.value = MainContract.State.NotLoggedIn
            }
        }
    }

    private fun checkAuth() {
        launch {
            uiState.value = appPrefs.getUserEmail()?.let {
                MainContract.State.LoggedIn
            } ?: MainContract.State.NotLoggedIn
        }
    }
}