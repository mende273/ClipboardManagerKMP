package mende273.clipboardmanagerkmp.clipboard

import java.awt.Toolkit
import java.awt.datatransfer.StringSelection

class DesktopClipboardManager : ClipboardManager {
    override suspend fun copyText(text: String) {
        val clipboard = Toolkit.getDefaultToolkit().systemClipboard
        val selection = StringSelection(text)
        clipboard.setContents(selection, null)
    }
}