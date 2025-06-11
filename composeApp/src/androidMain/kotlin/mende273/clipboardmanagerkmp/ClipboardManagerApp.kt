package mende273.clipboardmanagerkmp

import android.app.Application
import mende273.clipboardmanagerkmp.di.initKoin
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.component.KoinComponent

class ClipboardManagerApp : Application(), KoinComponent {

    override fun onCreate() {
        super.onCreate()
        initKoin {
            androidLogger()
            androidContext(this@ClipboardManagerApp)
        }
    }
}