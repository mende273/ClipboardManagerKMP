package mende273.clipboardmanagerkmp.di

import mende273.clipboardmanagerkmp.clipboard.ClipboardManager
import mende273.clipboardmanagerkmp.clipboard.DesktopClipboardManager
import org.koin.core.module.Module
import org.koin.dsl.module

actual fun platformModule(): Module = module {

    single<ClipboardManager> { DesktopClipboardManager() }
}