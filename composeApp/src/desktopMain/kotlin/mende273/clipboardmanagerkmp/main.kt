package mende273.clipboardmanagerkmp

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import mende273.clipboardmanagerkmp.di.initKoin

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "ClipboardManagerKMP",
    ) {
        initKoin()
        App()
    }
}