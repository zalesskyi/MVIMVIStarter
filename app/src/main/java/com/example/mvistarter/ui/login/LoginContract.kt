package com.example.mvistarter.ui.login

import com.example.mvistarter.ui.base.UiEvent
import com.example.mvistarter.ui.base.UiState

class LoginContract {

    sealed class Event : UiEvent {

        data class Login(val email: String, val password: String) : Event()
    }

    sealed class State : UiState {

        object AuthSuccess : State()
        object AuthFailed : State()
        object AuthIdle : State()
    }
}