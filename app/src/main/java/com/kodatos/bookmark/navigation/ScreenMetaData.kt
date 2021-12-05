package com.kodatos.bookmark.navigation

import androidx.navigation.NamedNavArgument
import java.security.cert.CertPath

data class ScreenMetaData(
    val completePath: String,
    val argsList: List<NamedNavArgument>
)
