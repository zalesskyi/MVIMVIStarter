package com.example.mvistarter.ui.media

import com.example.mvistarter.ui.base.UiEvent
import com.example.mvistarter.ui.base.UiState

class MediaContract {

    sealed class Event : UiEvent

    sealed class State : UiState {
        object Initial : State()
    }
}