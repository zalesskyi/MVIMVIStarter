package com.example.mvistarter.ui.media

import com.example.mvistarter.R
import com.example.mvistarter.ui.base.BaseFragment
import com.example.mvistarter.ui.media.di.injectViewModel

class MediaFragment : BaseFragment<MediaContract.State, MediaContract.Event>(R.layout.fragment_media) {

    override fun observeState(state: MediaContract.State?) = Unit

    override val viewModel by injectViewModel()
}