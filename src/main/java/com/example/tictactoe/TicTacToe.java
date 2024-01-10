package com.example.tictactoe;

public class TicTacToe {
    private Player player1;
    private Player player2;
    private Player currentPlayer;
    private Board board;

    public TicTacToe(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        this.currentPlayer = player1; // Player1 starts
        this.board = new Board();
    }

    public void start() {
        try {
            while (true) {
                System.out.println("Current Player: " + currentPlayer.getMarker());
                board.print();

                int x = Main.getUserInput("row (0-2): ");
                int y = Main.getUserInput("column (0-2): ");

                if (board.isCellEmpty(x, y)) {
                    board.place(x, y, currentPlayer.getMarker());
                    if (hasWinner()) {
                        board.print();
                        System.out.println("Player " + currentPlayer.getMarker() + " wins!");
                        break;
                    } else if (board.isFull()) {
                        board.print();
                        System.out.println("The game is a draw!");
                        break;
                    }
                    switchCurrentPlayer();
                } else {
                    System.out.println("Cell is not empty. Try again.");
                }
            }
        } finally {
            Main.closeScanner();
        }
    }

    private int getUserInput(String prompt) {
        // Stub for user input - in a real application, use Scanner or similar
        return 0; // Replace with actual user input
    }

    private void switchCurrentPlayer() {
        currentPlayer = (currentPlayer == player1) ? player2 : player1;
    }

    private boolean hasWinner() {
        // Check rows, columns, and diagonals for a winner
        return checkRowsForWinner() || checkColumnsForWinner() || checkDiagonalsForWinner();
    }

    private boolean checkRowsForWinner() {
        for (int i = 0; i < 3; i++) {
            if (board.cells[i][0] != ' ' && board.cells[i][0] == board.cells[i][1] && board.cells[i][1] == board.cells[i][2]) {
                return true;
            }
        }
        return false;
    }

    private boolean checkColumnsForWinner() {
        for (int i = 0; i < 3; i++) {
            if (board.cells[0][i] != ' ' && board.cells[0][i] == board.cells[1][i] && board.cells[1][i] == board.cells[2][i]) {
                return true;
            }
        }
        return false;
    }

    private boolean checkDiagonalsForWinner() {
        if (board.cells[0][0] != ' ' && board.cells[0][0] == board.cells[1][1] && board.cells[1][1] == board.cells[2][2]) {
            return true;
        }
        if (board.cells[0][2] != ' ' && board.cells[0][2] == board.cells[1][1] && board.cells[1][1] == board.cells[2][0]) {
            return true;
        }
        return false;
    }
}