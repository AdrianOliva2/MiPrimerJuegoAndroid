package dam.adrianoliva.miprimerjuegoandroid

import android.graphics.Canvas

abstract class Figura(var id: Int, var x: Float, var y: Float, var color: Int) {

     abstract fun draw(canvas: Canvas)

     fun update(desx: Float, desy: Float) {
          x += desx
          y += desy
     }

}