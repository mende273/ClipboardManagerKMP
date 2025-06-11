package mende273.clipboardmanagerkmp.clipboard

import platform.UIKit.UIPasteboard

class IOSClipboardManager : ClipboardManager {
    override suspend fun copyText(text: String) {
        UIPasteboard.generalPasteboard.string = text
    }
}