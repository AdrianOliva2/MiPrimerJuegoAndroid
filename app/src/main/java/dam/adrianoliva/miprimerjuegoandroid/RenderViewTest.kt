package dam.adrianoliva.miprimerjuegoandroid

import android.app.Activity
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.view.Window
import android.view.WindowManager
import kotlin.random.Random

class RenderViewTest : LandScapeActivity() {
    class RenderView(activity: Activity): View(activity) {

        override fun onDraw(canvas: Canvas) {
            super.onDraw(canvas)
            val paint = Paint()
            paint.style = Paint.Style.FILL
            paint.color = Color.rgb(Random.nextInt(0,256), Random.nextInt(0,256), Random.nextInt(0,256))
            canvas.drawPaint(paint)
        }

        override fun onTouchEvent(event: MotionEvent): Boolean {
            this.invalidate()
            return false
        }

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(RenderView(this))
    }
}