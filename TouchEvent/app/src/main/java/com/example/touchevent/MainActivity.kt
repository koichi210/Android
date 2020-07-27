package com.example.touchevent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onTouchEvent(event: MotionEvent) :Boolean {
        val cord : TextView = findViewById(R.id.cordText)
        var x : Int
        var y : Int

        when(event.getAction()) {
            MotionEvent.ACTION_DOWN -> {
                x = event.getX().toInt()
                y = event.getY().toInt()
                cord.text = "down = ($x, $y)"
            }
            MotionEvent.ACTION_UP -> {
                x = event.getX().toInt()
                y = event.getY().toInt()
                cord.text = "up = ($x, $y)"
            }
            MotionEvent.ACTION_MOVE -> {
                x = event.getX().toInt()
                y = event.getY().toInt()
                cord.text = "move = ($x, $y)"
            }
        }
        return super.onTouchEvent(event)
    }
}