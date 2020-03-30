package com.example.tictactoe

import android.util.Log
import android.widget.Button
import android.widget.TextView
import java.util.*

class TicTacToeBot(val player1 : String, val player2: String) {

    lateinit var board: Array<CharArray>
    var turn : String = ""
    var winner : String = ""

    fun placeMark(tuple: Pair<Any, Any>, player: String): Boolean {
        val row: Int = tuple.first as Int
        val col: Int = tuple.second as Int
        // Make sure that row and column are in bounds of the board.
        if (row in 0..2) {
            if (col in 0..2) {
                if (board[row][col] == '-') {
                    board[row][col] = player[0]
                    return true
                }
            }
        }
        return false
    }

    fun placeMarkBot(): Pair<Int,Int> {
        val rand = Random()
        var row = 0
        var col = 0

        var placement = false;
        while(!placement){
            if(!placement) {
                row = rand.nextInt(3)
                col = rand.nextInt(3)
                //Log.w("PlaceMarkBot","Random: $row Random: $col")
                placement = placeMark(Pair(row, col), player2)
            }
        }
        //Log.w("PlaceMarkBot","Linha: $row Coluna: $col")
        return Pair(row, col)
    }

    fun checkBoardStats(playerView: TextView):Boolean {
        // Did we have a winner?
        if (checkForWin()) {
            winner = turn
            playerView.text = "We have a winner"
            return true
        }
        else if (isBoardFull()) {
            winner = ""
            playerView.text = "Appears we have a draw!"
            return true
        }
        return false
    }

    fun newGame() {
        board = Array(3) { CharArray(3) }
        // Loop through rows
        for (i in 0..2) {
            // Loop through columns
            for (j in 0..2) {
                board[i][j] = '-'
            }
        }
    }

    private fun isBoardFull(): Boolean {
        var isFull = true
        for (i in 0..2) {
            for (j in 0..2) {
                if (board[i][j] == '-') {
                    isFull = false
                }
            }
        }
        return isFull
    }

    // Returns true if there is a win, false otherwise.
    // This calls our other win check functions to check the entire board.
    private fun checkForWin(): Boolean {
        return checkRowsForWin() || checkColumnsForWin() || checkDiagonalsForWin()
    }


    // Loop through rows and see if any are winners.
    private fun checkRowsForWin(): Boolean {
        for (i in 0..2) {
            if (checkRowCol(board[i][0], board[i][1], board[i][2])) {
                return true
            }
        }
        return false
    }

    // Loop through columns and see if any are winners.
    private fun checkColumnsForWin(): Boolean {
        for (i in 0..2) {
            if (checkRowCol(board[0][i], board[1][i], board[2][i])) {
                return true
            }
        }
        return false
    }

    // Check the two diagonals to see if either is a win. Return true if either wins.
    private fun checkDiagonalsForWin(): Boolean {
        return checkRowCol(
            board[0][0],
            board[1][1],
            board[2][2]
        ) || checkRowCol(board[0][2], board[1][1], board[2][0])
    }

    // Check to see if all three values are the same (and not empty) indicating a win.
    private fun checkRowCol(
        c1: Char,
        c2: Char,
        c3: Char
    ): Boolean {
        return c1 != '-' && c1 == c2 && c2 == c3
    }
}