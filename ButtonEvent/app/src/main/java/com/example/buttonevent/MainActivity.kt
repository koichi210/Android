package com.example.buttonevent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var textCtrl = findViewById<TextView>(R.id.text_message)
        var buttonCtrl = findViewById<Button>(R.id.button_push)

        button_push.setOnClickListener{
            textCtrl.setText(R.string.text_message_push)
        }
    }
}