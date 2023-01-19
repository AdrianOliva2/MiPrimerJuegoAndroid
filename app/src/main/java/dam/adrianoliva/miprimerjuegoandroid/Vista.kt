package dam.adrianoliva.miprimerjuegoandroid

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.Log
import android.view.ActionMode
import android.view.MotionEvent
import android.view.View

class Vista(context: Context): View(context), View.OnTouchListener {

    init {
        this.setOnTouchListener(this)
    }

    private lateinit var canvas: Canvas

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        this.canvas = canvas
        val paint = Paint()
        paint.style = Paint.Style.FILL
        paint.color = Color.BLUE
        canvas.drawPaint(paint)

        paint.color = Color.BLACK
        paint.isAntiAlias = true
        canvas.drawRect(16F, 16F, (width - 16).toFloat(), (height - 16).toFloat(), paint)
    }

    override fun onTouch(view: View, event: MotionEvent): Boolean {
        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                Log.i("down (", "x:${event.x}, y:${event.y})")
            }
            MotionEvent.ACTION_MOVE -> {
                Log.i("move (", "x:${event.x}, y:${event.y})")
            }
            MotionEvent.ACTION_CANCEL -> {
                Log.i("cancel (", "x:${event.x}, y:${event.y})")
            }
            MotionEvent.ACTION_UP -> {
                Log.i("up (", "x:${event.x}, y:${event.y})")
            }
        }
        this.invalidate()
        return true
    }
}