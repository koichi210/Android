package com.example.drawdiagram

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.util.DisplayMetrics
import android.util.Log
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 自作画面への遷移
        val myView = MyView(this)
        setContentView(myView)
    }

    // Viewを継承したクラス
    internal inner class MyView(context: Context) : View(context) {
//        private var paint: Paint = Paint()

        private val paint = Paint()
        private val path = Path()

        private val strokeW1 = 20f
        private val strokeW2 = 40f
        private val dp: Float

        init {
            // スクリーンサイズからdipのようなものを作る
            val metrics = DisplayMetrics()
            //windowManager.defaultDisplay.getMetrics(metrics)

            dp = resources.displayMetrics.density
            Log.d("debug", "fdp=$dp")
        }

        override fun onDraw(canvas: Canvas) {
            DrawBackground(canvas)
            DrawSquare(canvas)
            DrawCircle(canvas)
            DrawLine(canvas)
            DrawTriangle(canvas)
        }

        private fun DrawBackground(canvas: Canvas) {
            canvas.drawColor(Color.argb(255, 0, 255, 0))
        }

        private fun DrawSquare(canvas: Canvas) {
            // 色
            paint.color = Color.argb(255, 255, 127, 0)

            // ペンの太さ
            paint.strokeWidth = 10f

            // ペンのスタイル
            paint.style = Paint.Style.STROKE

            // 矩形描画
            canvas.drawRect(200f, 200f, 600f, 600f, paint)
        }

        private fun DrawCircle(canvas: Canvas) {
            paint.color = Color.argb(255, 125, 125, 255)
            paint.strokeWidth = strokeW1.toFloat()
            paint.isAntiAlias = true
            paint.style = Paint.Style.STROKE

            // 円描画
            canvas.drawCircle(300f, 800f, 200 / 2f, paint)
        }

        private fun DrawLine(canvas: Canvas) {
            paint.strokeWidth = strokeW1
            paint.color = Color.argb(255, 255, 0, 0)

            // 線描画
            canvas.drawLine(200f, 200f, 400f, 900f, paint)
        }

        private fun DrawTriangle(canvas: Canvas) {
            val tx1 = 230f
            val ty1 = 370f
            val tx2 = 100f
            val ty2 = 500f
            val tx3 = 350f
            val ty3 = 500f

            paint.strokeWidth = 5f
            paint.color = Color.WHITE
            path.moveTo(tx1, ty1)
            path.lineTo(tx2, ty2)
            path.lineTo(tx3, ty3)
            path.lineTo(tx1, ty1)

            // 三角形描画
            canvas.drawPath(path, paint)
        }

        private fun GetCentrpostion() {
            val xc = (width / 2).toFloat()
            val yc = (height / 2).toFloat()
        }
    }
}
