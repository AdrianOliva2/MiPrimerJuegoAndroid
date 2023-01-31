package dam.adrianoliva.miprimerjuegoandroid

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Color
import android.view.SurfaceHolder
import android.view.SurfaceView

class GameView(context: Context): SurfaceView(context), SurfaceHolder.Callback {

    private lateinit var bmp: Bitmap
    private lateinit var sprite: Sprite

    init {
        holder.addCallback(this)
        setBackgroundColor(Color.WHITE)
    }

    override fun surfaceCreated(p0: SurfaceHolder) {
        val gameLoop = HiloDraw(this)
        gameLoop.setRunning(true)
        gameLoop.start()
        bmp = BitmapFactory.decodeResource(resources, R.drawable.sprite1)
        sprite = Sprite(this,  bmp)
    }

    override fun surfaceChanged(p0: SurfaceHolder, p1: Int, p2: Int, p3: Int) {
        //TODO("Not yet implemented")
    }

    override fun surfaceDestroyed(p0: SurfaceHolder) {
        //TODO("Not yet implemented")
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        canvas?.drawColor(Color.WHITE)
        if (canvas != null) {
            sprite.onDraw(canvas)
        }
    }

}