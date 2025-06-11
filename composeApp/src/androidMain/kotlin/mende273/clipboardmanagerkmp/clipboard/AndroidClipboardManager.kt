package mende273.clipboardmanagerkmp.clipboard

import android.content.ClipData
import android.content.Context

class AndroidClipboardManager(private val context: Context) : ClipboardManager {
    override suspend fun copyText(text: String) {
        val clipboard =
            context.getSystemService(Context.CLIPBOARD_SERVICE) as android.content.ClipboardManager
        val clip = ClipData.newPlainText("label", text)
        clipboard.setPrimaryClip(clip)
    }
}