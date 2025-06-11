package mende273.clipboardmanagerkmp.clipboard

interface ClipboardManager {
    suspend fun copyText(text: String)
}