package com.example.mvistarter.ui.main

import com.example.mvistarter.ui.base.UiEvent
import com.example.mvistarter.ui.base.UiState

class MainContract {

    sealed class Event : UiEvent {

        object CheckAuth : Event()
        object Logout : Event()
    }

    sealed class State : UiState {
        object Initial : State()
        object LoggedIn : State()
        object NotLoggedIn : State()
    }
}