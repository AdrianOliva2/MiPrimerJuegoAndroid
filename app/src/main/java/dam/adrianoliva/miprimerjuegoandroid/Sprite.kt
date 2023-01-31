package dam.adrianoliva.miprimerjuegoandroid

import android.graphics.Bitmap
import android.graphics.Canvas

class Sprite(private val gameView: GameView, private val bmp: Bitmap) {

    private var x: Float = 0F
    private val xSpeed: Float = 5F

    private fun update() {
        x += xSpeed
    }

    fun onDraw(canvas: Canvas) {
        update()
        canvas.drawBitmap(bmp, x, 10F, null)
    }

}