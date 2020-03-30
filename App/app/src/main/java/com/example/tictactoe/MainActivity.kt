package com.example.tictactoe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val singlePlayerButton = findViewById<Button>(R.id.buttonSingle)
        singlePlayerButton.setOnClickListener {
            // Handler code here.
            val intent = Intent(this, BoardActivity::class.java)
            startActivity(intent);
        }

        val multiPlayerButton = findViewById<Button>(R.id.buttonMulti)
        multiPlayerButton.setOnClickListener {
            // Handler code here.
            val intent = Intent(this, MultiBoardActivity::class.java)
            startActivity(intent);
        }

        val statsButton = findViewById<Button>(R.id.buttonStats)
        statsButton.setOnClickListener {
            // Handler code here.
            val intent = Intent(this, StatisticsActivity::class.java)
            startActivity(intent);
        }
    }
}

