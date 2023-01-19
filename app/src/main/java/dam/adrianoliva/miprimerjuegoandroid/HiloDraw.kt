package dam.adrianoliva.miprimerjuegoandroid

import android.graphics.Canvas
import android.view.SurfaceHolder

class HiloDraw(private var moverFiguras: MoverFiguras): Thread() {

    private var run: Boolean = false
    private val surfaceHolder: SurfaceHolder = moverFiguras.holder

    fun setRunning(running: Boolean) {
        this.run = running
    }

    override fun run() {
        super.run()
        while (run) {
            var canvas: Canvas? = null
            try {
                canvas = surfaceHolder.lockCanvas()
                if (canvas != null){
                    synchronized(surfaceHolder) {
                        moverFiguras.postInvalidate()
                    }
                }
            } finally {
                if (canvas != null)
                    surfaceHolder.unlockCanvasAndPost(canvas)
            }
        }
    }

}