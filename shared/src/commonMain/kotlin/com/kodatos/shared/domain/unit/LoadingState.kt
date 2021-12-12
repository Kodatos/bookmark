package com.kodatos.shared.domain.unit

/**
 * Interface representing common initial loading [State]s
 */
interface LoadingState : State

open class ProgressBarLoadingState(
    val text: String
): LoadingState

open class LottieLoadingState(
    val url: String,
    val text: String?
): LoadingState