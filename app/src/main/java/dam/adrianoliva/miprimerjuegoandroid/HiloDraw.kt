package dam.adrianoliva.miprimerjuegoandroid

import android.content.Context
import android.graphics.Canvas
import android.view.SurfaceHolder
import android.view.SurfaceView

class HiloDraw(private var moverFiguras: SurfaceView): Thread() {

    companion object {
        const val FPS: Int = 10
    }

    private var run: Boolean = false
    private val surfaceHolder: SurfaceHolder = moverFiguras.holder

    fun setRunning(running: Boolean) {
        this.run = running
    }

    override fun run() {
        super.run()
        val tPS: Int = 1000 / FPS
        var startTime: Long
        var sleepTime: Long
        while (run) {
            var canvas: Canvas? = null
            startTime = System.currentTimeMillis()
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
            sleepTime = tPS - (System.currentTimeMillis() - startTime)
            try {
                if (sleepTime > 0) sleep(sleepTime)
                else sleep(10)
            } catch (_: Exception) {}
        }
    }

}