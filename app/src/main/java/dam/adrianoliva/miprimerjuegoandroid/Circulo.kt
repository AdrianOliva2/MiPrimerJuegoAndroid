package dam.adrianoliva.miprimerjuegoandroid

import android.graphics.Canvas
import android.graphics.Paint

class Circulo(id: Int, x: Float, y: Float, var radio: Float, color: Int): Figura(id, x, y, color) {

    private val paint: Paint = Paint()

    init {
        paint.isAntiAlias = true
        paint.color = color
    }

    override fun draw(canvas: Canvas) {
        canvas.drawCircle(this.x + this.radio, this.y, this.radio, paint)
    }

}