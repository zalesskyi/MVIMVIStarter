package com.example.mvistarter.ui.media.di

import com.example.mvistarter.ui.media.MediaFragment
import com.example.mvistarter.ui.media.MediaViewModel
import com.example.mvistarter.ui.media.MediaViewModelImpl
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.androidx.viewmodel.ext.android.getViewModel
import org.koin.dsl.module

val mediaModule = module {
    viewModel { MediaViewModelImpl() }
}

fun MediaFragment.injectViewModel(): Lazy<MediaViewModel> =
    lazy { getViewModel<MediaViewModelImpl>(null) }