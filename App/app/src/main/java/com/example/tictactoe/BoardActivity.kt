package com.example.tictactoe

import android.app.AlertDialog
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class BoardActivity : AppCompatActivity() {

    private lateinit var game : TicTacToeBot

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.board)
        showAlertDialogButtonClicked("Choose your Character")
        boardButtonListener()
        val playerView = findViewById<TextView>(R.id.winnerView)
        playerView.text = "Your Turn: Player 1"
    }

    private fun showAlertDialogWinnerDraw(winner: String) {

        // setup the alert builder
        val builder = AlertDialog.Builder(this)
        when (winner) {
            game.player1 -> {
                builder.setTitle("You won Player 1")
            }
            game.player2 -> {
                builder.setTitle("I've won")
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
        btnPositive.layoutParams = layoutParams
        btnNegative.layoutParams = layoutParams
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
                game = TicTacToeBot(player1,player2)
                game.turn = player1
                game.newGame()
            }
            setNegativeButton("X"
            ) { _, _ ->
                // User clicked O button
                player1 = "X"
                player2 = "O"
                game = TicTacToeBot(player1,player2)
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

        val layoutParams:LinearLayout.LayoutParams =
            btnPositive.layoutParams as LinearLayout.LayoutParams
        layoutParams.weight = 10F
        btnPositive.layoutParams = layoutParams
        btnNegative.layoutParams = layoutParams
    }

    private fun changeButtonText(placeMarkBot: Pair<Int, Int>, player2: String) {
        if(placeMarkBot.first == 0 && placeMarkBot.second == 0){
            val a1Button = findViewById<Button>(R.id.a1button)
            a1Button.text = player2
        }
        else if(placeMarkBot.first == 0 && placeMarkBot.second == 1){
            val a2Button = findViewById<Button>(R.id.a2button)
            a2Button.text = player2
        }else if(placeMarkBot.first == 0 && placeMarkBot.second == 2){
            val a3Button = findViewById<Button>(R.id.a3button)
            a3Button.text = player2
        }

        if(placeMarkBot.first == 1 && placeMarkBot.second == 0){
            val b1Button = findViewById<Button>(R.id.b1button)
            b1Button.text = player2
        }else if(placeMarkBot.first == 1 && placeMarkBot.second == 1){
            val b2Button = findViewById<Button>(R.id.b2button)
            b2Button.text = player2
        }else if(placeMarkBot.first == 1 && placeMarkBot.second == 2){
            val b3Button = findViewById<Button>(R.id.b3button)
            b3Button.text = player2
        }

        if(placeMarkBot.first == 2 && placeMarkBot.second == 0){
            val c1Button = findViewById<Button>(R.id.c1button)
            c1Button.text = player2
        }else if(placeMarkBot.first == 2 && placeMarkBot.second == 1){
            val c2Button = findViewById<Button>(R.id.c2button)
            c2Button.text = player2
        }else if(placeMarkBot.first == 2 && placeMarkBot.second == 2){
            val c3Button = findViewById<Button>(R.id.c3button)
            c3Button.text = player2
        }
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
                    switchTurnBot(playerView)
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
                    switchTurnBot(playerView)
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
                    switchTurnBot(playerView)
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
                    switchTurnBot(playerView)
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
                    switchTurnBot(playerView)
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
                    switchTurnBot(playerView)
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
                    switchTurnBot(playerView)
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
                    switchTurnBot(playerView)
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
                    switchTurnBot(playerView)
                }else{
                    showAlertDialogWinnerDraw(this.game.winner)
                }
            } else {
                playerView.text = "Invalid play"
            }
        }
    }

    private fun switchTurnBot(playerView: TextView) {
        this.game.turn = if (this.game.turn == "X")
            "O"
        else "X"
        if(this.game.turn == "X") {
            playerView.text = if(this.game.player1 == "X")
                "Your Turn Player 1"
            else "My Turn"
        }else{
            playerView.text = if(this.game.player1 =="O")
                "Your Turn Player 1"
            else "My Turn"
        }
        if(this.game.turn==this.game.player2){
            changeButtonText(this.game.placeMarkBot(),this.game.player2)
            val win : Boolean = this.game.checkBoardStats(playerView)
            if(win){
                showAlertDialogWinnerDraw(this.game.winner)
            }
            else{
                playerView.text = "Your Turn Player 1"
                this.game.turn = if (this.game.turn == "X")
                    "O"
                else "X"
            }
        }
    }
}
