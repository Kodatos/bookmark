package com.kodatos.shared.domain.unit

interface LoadingState : State

open class ProgressBarLoadingState(
    val text: String
): LoadingState

open class LottieLoadingState(
    val url: String,
    val text: String?
): LoadingState