package com.example.mvistarter.ui.media

import com.example.mvistarter.ui.base.BaseViewModel
import com.example.mvistarter.ui.base.BaseViewModelImpl

interface MediaViewModel : BaseViewModel<MediaContract.State, MediaContract.Event>

class MediaViewModelImpl : BaseViewModelImpl<MediaContract.State, MediaContract.Event>(), MediaViewModel {

    override suspend fun initialState(): MediaContract.State = MediaContract.State.Initial

    override fun onEventArrived(event: MediaContract.Event?) = Unit
}