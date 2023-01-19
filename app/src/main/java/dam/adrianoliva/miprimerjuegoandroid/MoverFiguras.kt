package dam.adrianoliva.miprimerjuegoandroid

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.Log
import android.view.MotionEvent
import android.view.SurfaceHolder
import android.view.SurfaceView
import androidx.core.content.pm.ShortcutInfoCompat.Surface
import androidx.core.graphics.toColor
import com.google.android.material.canvas.CanvasCompat
import kotlin.concurrent.thread
import kotlin.math.pow

class MoverFiguras(context: Context): SurfaceView(context), SurfaceHolder.Callback {

    private lateinit var hiloDraw: HiloDraw
    private val figuras: ArrayList<Figura> = ArrayList()
    private var figuraActiva: Int = -1
    private var iniX: Float = -1F
    private var iniY: Float = -1F

    init {
        holder.addCallback(this)
        setBackgroundColor(Color.WHITE)

    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        val x: Float = event.x
        val y: Float = event.y
        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                iniX = event.x
                iniY = event.y
                for (figura: Figura in figuras) {
                    if (figura is Circulo) {
                        val circulo: Circulo = figura
                        val distanciaX = x - circulo.x
                        val distanciaY = y - circulo.y
                        if (circulo.radio.toDouble().pow(2.0) > (distanciaX.toDouble().pow(2.0) + distanciaY.toDouble().pow(2.0)))
                            figuraActiva = circulo.id
                    }
                    else if (figura is Rectangulo) {
                        var rectangulo: Rectangulo = figura
                        if (x > rectangulo.x && x < rectangulo.x + rectangulo.ancho && y > rectangulo.y && y < rectangulo.y + rectangulo.largo)
                            figuraActiva = rectangulo.id
                    }
                }
                Log.i("figuraActiva", figuraActiva.toString())
            }

            MotionEvent.ACTION_MOVE -> {
                if (figuraActiva != -1){
                    figuras[figuraActiva].update(x - iniX, y - iniY)
                    iniX = event.x
                    iniY = event.y
                }
            }

            MotionEvent.ACTION_UP -> {
                figuraActiva = -1
                Log.i("figuraActiva", figuraActiva.toString())
            }
        }

        return true
    }

    override fun onDraw(canvas: Canvas) {
        canvas.drawColor(Color.WHITE)
        for (figura in figuras) {
            figura.draw(canvas)
        }
        val bmp: Bitmap = BitmapFactory.decodeResource(resources, R.drawable.imagen)
        val img = Bitmap.createScaledBitmap(bmp, (width * 0.2).toInt(), (height * 0.2).toInt(), true)
        canvas.drawBitmap(img, ((width - img.width) / 2).toFloat(), ((height - img.height) / 2).toFloat(), null)
    }

    override fun surfaceCreated(p0: SurfaceHolder) {
        var id = 0
        figuras += Circulo(id, 200F, 220F, 100F, Color.BLACK)
        id++
        figuras += Rectangulo(id, 200F, 400F, 200F, 200F, Color.RED)

        hiloDraw = HiloDraw(this)
        hiloDraw.setRunning(true)
        hiloDraw.start()
    }

    override fun surfaceChanged(surfaceHolder: SurfaceHolder, p1: Int, p2: Int, p3: Int) {

    }

    override fun surfaceDestroyed(p0: SurfaceHolder) {
        var retry = true
        hiloDraw.setRunning(false)

        while (retry) {
            try {
                hiloDraw.join()
                retry = false
            } catch (e: InterruptedException) {

            }
        }
    }

}