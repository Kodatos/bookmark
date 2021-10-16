package com.kodatos.shared

import com.kodatos.shared.platform.Platform

class Greeting {
    fun greeting(): String {
        return "Hello, ${Platform().platform}!"
    }
}