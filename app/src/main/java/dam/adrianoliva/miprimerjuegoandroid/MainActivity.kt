package dam.adrianoliva.miprimerjuegoandroid

import android.app.Activity
import android.content.Intent
import android.os.Bundle

class MainActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val vista = GameView(this)
        this.setContentView(vista)
    }
}