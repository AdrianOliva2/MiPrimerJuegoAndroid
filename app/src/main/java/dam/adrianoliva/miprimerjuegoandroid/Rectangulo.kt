package dam.adrianoliva.miprimerjuegoandroid

import android.graphics.Canvas
import android.graphics.Paint

class Rectangulo(id: Int, x: Float, y: Float, var ancho: Float, var largo: Float, color: Int): Figura(id, x, y, color) {

    private val paint: Paint = Paint()

    init {
        paint.isAntiAlias = true
        paint.color = color
    }

    override fun draw(canvas: Canvas) {
        canvas.drawRect(this.x, this.y, this.x + this.ancho, this.y + this.largo, paint)
    }

}