package com.example.tictactoe

import android.app.AlertDialog
import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MultiBoardActivity  : AppCompatActivity() {

    private lateinit var game : TicTacToe

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.board2)
        showAlertDialogButtonClicked("Choose your Character Player 1")
        boardButtonListener()
        val playerView = findViewById<TextView>(R.id.winnerView)
        playerView.text = "Your Turn: Player 1"
    }

    private fun showAlertDialogButtonClicked(title: String) {
        var player1 : String
        var player2 : String

        // setup the alert builder
        val builder = AlertDialog.Builder(this)
        builder.setTitle(title)
        builder.apply {
            setPositiveButton("O"
            ) { _, _ ->
                // User clicked X button
                player1 = "O"
                player2 = "X"
                game = TicTacToe(player1,player2)
                game.turn = player1
                game.newGame()
            }
            setNegativeButton("X"
            ) { _, _ ->
                // User clicked O button
                player1 = "X"
                player2 = "O"
                game = TicTacToe(player1,player2)
                game.turn = player1
                game.newGame()
            }
        }
        // Create the AlertDialog and show it
        val dialog = builder.create()
        dialog.show()

        // Make buttons centered
        val btnPositive: Button = dialog.getButton(AlertDialog.BUTTON_POSITIVE)
        val btnNegative: Button = dialog.getButton(AlertDialog.BUTTON_NEGATIVE)

        val layoutParams: LinearLayout.LayoutParams =
            btnPositive.layoutParams as LinearLayout.LayoutParams
        layoutParams.weight = 10F
        btnPositive.setTextColor(Color.parseColor("#000000"))
        btnNegative.setTextColor(Color.parseColor("#000000"))
        btnPositive.layoutParams = layoutParams
        btnNegative.layoutParams = layoutParams
    }

    private fun showAlertDialogWinnerDraw(winner: String) {

        // setup the alert builder
        val builder = AlertDialog.Builder(this)
        when (winner) {
            game.player1 -> {
                builder.setTitle("You won Player 1")
            }
            game.player2 -> {
                builder.setTitle("You won Player 2")
            }
            else -> {
                builder.setTitle("Looks like we have a draw")
            }
        }
        builder.setMessage("Would like to play a new game?")
        builder.apply {
            setPositiveButton("New match"
            ) { _, _ ->
                // User clicked X button
                val intent = intent
                finish()
                startActivity(intent)
            }
            setNegativeButton("Back"
            ) { _, _ ->
                // User clicked O button
                finish()
            }
        }
        // Create the AlertDialog and show it
        val dialog = builder.create()
        dialog.show()

        // Make buttons centered
        val btnPositive: Button = dialog.getButton(AlertDialog.BUTTON_POSITIVE)
        val btnNegative: Button = dialog.getButton(AlertDialog.BUTTON_NEGATIVE)

        val layoutParams: LinearLayout.LayoutParams =
            btnPositive.layoutParams as LinearLayout.LayoutParams
        layoutParams.weight = 10F
        btnPositive.setTextColor(Color.parseColor("#000000"))
        btnNegative.setTextColor(Color.parseColor("#000000"))
        btnPositive.layoutParams = layoutParams
        btnNegative.layoutParams = layoutParams
    }

    private fun boardButtonListener() {
        val playerView = findViewById<TextView>(R.id.winnerView)

        val a1Button = findViewById<Button>(R.id.a1button)
        a1Button.setOnClickListener {
            val placeMark = this.game.placeMark(Pair(0, 0), this.game.turn)
            if (placeMark) {
                a1Button.text = this.game.turn
                val win : Boolean = this.game.checkBoardStats(playerView)
                if(!win){
                    this.game.switchTurn(playerView)
                }else{
                    showAlertDialogWinnerDraw(this.game.winner)
                }
            } else {
                playerView.text = "Invalid play"
            }
        }
        val a2Button = findViewById<Button>(R.id.a2button)
        a2Button.setOnClickListener {
            val placeMark = this.game.placeMark(Pair(0, 1), this.game.turn)
            if (placeMark) {
                a2Button.text = this.game.turn
                val win : Boolean = this.game.checkBoardStats(playerView)
                if(!win){
                    this.game.switchTurn(playerView)
                }else{
                    showAlertDialogWinnerDraw(this.game.winner)
                }
            } else {
                playerView.text = "Invalid play"
            }
        }
        val a3Button = findViewById<Button>(R.id.a3button)
        a3Button.setOnClickListener {
            val placeMark = this.game.placeMark(Pair(0, 2), this.game.turn)
            if (placeMark) {
                a3Button.text = this.game.turn
                val win : Boolean = this.game.checkBoardStats(playerView)
                if(!win){
                    this.game.switchTurn(playerView)
                }else{
                    showAlertDialogWinnerDraw(this.game.winner)
                }
            } else {
                playerView.text = "Invalid play"
            }
        }

        val b1Button = findViewById<Button>(R.id.b1button)
        b1Button.setOnClickListener {
            val placeMark = this.game.placeMark(Pair(1, 0), this.game.turn)
            if (placeMark) {
                b1Button.text = this.game.turn
                val win : Boolean = this.game.checkBoardStats(playerView)
                if(!win){
                    this.game.switchTurn(playerView)
                }else{
                    showAlertDialogWinnerDraw(this.game.winner)
                }
            } else {
                playerView.text = "Invalid play"
            }
        }
        val b2Button = findViewById<Button>(R.id.b2button)
        b2Button.setOnClickListener {
            val placeMark = this.game.placeMark(Pair(1, 1), this.game.turn)
            if (placeMark) {
                b2Button.text = this.game.turn
                val win : Boolean = this.game.checkBoardStats(playerView)
                if(!win){
                    this.game.switchTurn(playerView)
                }else{
                    showAlertDialogWinnerDraw(this.game.winner)
                }
            } else {
                playerView.text = "Invalid play"
            }
        }
        val b3Button = findViewById<Button>(R.id.b3button)
        b3Button.setOnClickListener {
            val placeMark = this.game.placeMark(Pair(1, 2), this.game.turn)
            if (placeMark) {
                b3Button.text = this.game.turn
                val win : Boolean = this.game.checkBoardStats(playerView)
                if(!win){
                    this.game.switchTurn(playerView)
                }else{
                    showAlertDialogWinnerDraw(this.game.winner)
                }
            } else {
                playerView.text = "Invalid play"
            }
        }

        val c1Button = findViewById<Button>(R.id.c1button)
        c1Button.setOnClickListener {
            val placeMark = this.game.placeMark(Pair(2, 0), this.game.turn)
            if (placeMark) {
                c1Button.text = this.game.turn
                val win : Boolean = this.game.checkBoardStats(playerView)
                if(!win){
                    this.game.switchTurn(playerView)
                }else{
                    showAlertDialogWinnerDraw(this.game.winner)
                }
            } else {
                playerView.text = "Invalid play"
            }
        }
        val c2Button = findViewById<Button>(R.id.c2button)
        c2Button.setOnClickListener {
            val placeMark = this.game.placeMark(Pair(2, 1), this.game.turn)
            if (placeMark) {
                c2Button.text = this.game.turn
                val win : Boolean = this.game.checkBoardStats(playerView)
                if(!win){
                    this.game.switchTurn(playerView)
                }else{
                    showAlertDialogWinnerDraw(this.game.winner)
                }
            } else {
                playerView.text = "Invalid play"
            }
        }
        val c3Button = findViewById<Button>(R.id.c3button)
        c3Button.setOnClickListener {
            val placeMark = this.game.placeMark(Pair(2, 2), this.game.turn)
            if (placeMark) {
                c3Button.text = this.game.turn
                val win : Boolean = this.game.checkBoardStats(playerView)
                if(!win){
                    this.game.switchTurn(playerView)
                }else{
                    showAlertDialogWinnerDraw(this.game.winner)
                }
            } else {
                playerView.text = "Invalid play"
            }
        }
    }
}