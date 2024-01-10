package com.example.tictactoe;

import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Create players with their respective markers 'X' and 'O'
        Player player1 = new Player('X');
        Player player2 = new Player('O');

        // Create the game instance with the two players
        TicTacToe game = new TicTacToe(player1, player2);

        // Start the game
        game.start();
    }

    public static int getUserInput(String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextInt()) {
            scanner.next(); // Consume the invalid input
            System.out.print(prompt);
        }
        return scanner.nextInt();
    }

    public static void closeScanner() {
        scanner.close();
    }
}

