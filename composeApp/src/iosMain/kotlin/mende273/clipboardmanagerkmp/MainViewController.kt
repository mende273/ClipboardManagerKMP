package mende273.clipboardmanagerkmp

import androidx.compose.ui.window.ComposeUIViewController
import mende273.clipboardmanagerkmp.di.initKoin

fun MainViewController() = ComposeUIViewController(
    configure = {
        initKoin()
    }
) { App() }