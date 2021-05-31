package com.example.mvistarter.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.CallSuper
import androidx.annotation.LayoutRes
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.lifecycleScope
import com.example.mvistarter.R
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

abstract class BaseBottomSheetDialogFragment<STATE : UiState, EVENT : UiEvent>(@LayoutRes private val layoutRes: Int) : BottomSheetDialogFragment() {

    abstract fun observeState(state: STATE?)

    abstract val viewModel : BaseViewModel<STATE, EVENT>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(DialogFragment.STYLE_NORMAL, R.style.DialogStyle)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        inflater.takeUnless { layoutRes == View.NO_ID }?.inflate(layoutRes, container, false)

    @CallSuper
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        lifecycleScope.launch {
            viewModel.init()
            viewModel.uiState.collect(::observeState)
        }
    }

    override fun onPause() {
        resetFlows()
        super.onPause()
    }

    private fun resetFlows() {
        viewModel.reset()
    }
}