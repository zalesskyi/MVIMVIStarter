package com.example.mvistarter.ui.login

import androidx.lifecycle.viewModelScope
import com.example.mvistarter.data.api.AuthApi
import com.example.mvistarter.ui.base.BaseViewModel
import com.example.mvistarter.ui.base.BaseViewModelImpl
import kotlinx.coroutines.launch

interface LoginViewModel : BaseViewModel<LoginContract.State, LoginContract.Event>

class LoginViewModelImpl(private val authApi: AuthApi) : BaseViewModelImpl<LoginContract.State, LoginContract.Event>(), LoginViewModel {

    override suspend fun initialState(): LoginContract.State = LoginContract.State.AuthIdle

    override fun onEventArrived(event: LoginContract.Event?) {
        when (event) {
            is LoginContract.Event.Login -> login(event.email, event.password)
        }
    }

    private fun login(email: String, password: String) {
        viewModelScope.launch {
            val result = authApi.signIn(email, password)
            uiState.value = if (result) LoginContract.State.AuthSuccess else LoginContract.State.AuthFailed
        }
    }
}