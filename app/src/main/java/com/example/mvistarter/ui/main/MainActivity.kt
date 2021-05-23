package com.example.mvistarter.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.mvistarter.R
import com.example.mvistarter.ui.base.BaseActivity
import com.example.mvistarter.ui.login.LoginFragment
import com.example.mvistarter.ui.main.di.injectViewModel
import com.example.mvistarter.ui.media.MediaFragment

class MainActivity : BaseActivity<MainContract.State, MainContract.Event>(R.layout.activity_main), MainCallback {

    override val viewModel by injectViewModel()

    override fun observeState(state: MainContract.State?) {
        when (state) {
            is MainContract.State.NotLoggedIn -> navigateTo(LoginFragment())
            MainContract.State.LoggedIn -> openMedia()
            is MainContract.State.Initial -> Unit
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        navigateTo(LoginFragment())
    }

    override fun openMedia() {
        navigateTo(MediaFragment())
    }

    private fun navigateTo(fragment: Fragment, container: Int = R.id.flContainer, addToBackStack: Boolean = false) {
        supportFragmentManager.beginTransaction().replace(container, fragment).apply {
            if (addToBackStack) addToBackStack(fragment::class.simpleName)
        }.commit()
    }
}