package com.example.mvistarter.ui.login

import android.os.Bundle
import android.view.View
import com.example.mvistarter.R
import com.example.mvistarter.databinding.FragmentLoginBinding
import com.example.mvistarter.ui.base.BaseFragment
import com.example.mvistarter.ui.login.di.injectViewModel
import com.example.mvistarter.utils.extensions.gone
import com.example.mvistarter.utils.extensions.show
import com.example.mvistarter.utils.viewBinding.viewBinding

class LoginFragment : BaseFragment<LoginContract.State, LoginContract.Event>(R.layout.fragment_login) {

    override val viewModel by injectViewModel()

    private val binding by viewBinding(FragmentLoginBinding::bind)

    override fun observeState(state: LoginContract.State?) {
        when (state) {
            LoginContract.State.AuthFailed -> {
                binding.tvAuthError.show()
            }
            LoginContract.State.AuthSuccess -> {
                binding.tvAuthError.gone()
                callback?.openMedia()
            }
            LoginContract.State.AuthIdle -> Unit
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.run {
            btnSignIn.setOnClickListener {
                viewModel.sendEvent(LoginContract.Event.Login(
                    edtLogin.text.toString(), edtPassword.text.toString()))
            }
        }
    }
}