package com.kodatos.bookmark.viewmodels

import androidx.lifecycle.ViewModel
import com.kodatos.bookmark.helper.EventChannelProducer
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val eventChannelProducer: EventChannelProducer
): ViewModel() {
}