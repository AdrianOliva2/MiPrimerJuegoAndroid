package dam.adrianoliva.miprimerjuegoandroid

import android.app.Activity
import android.content.pm.ActivityInfo
import android.os.Bundle

open class PortraitActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
    }
}