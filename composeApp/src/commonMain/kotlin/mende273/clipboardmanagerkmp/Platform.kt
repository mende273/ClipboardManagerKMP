package mende273.clipboardmanagerkmp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform