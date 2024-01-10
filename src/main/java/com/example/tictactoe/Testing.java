package com.example.tictactoe;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class Testing {
    @Test
    public void testCloseScanner() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Main.closeScanner();

        assertTrue(outContent.toString().isEmpty()); // If scanner closed properly, no output should be present.
    }

    @Test
    public void testGetUserInput_ValidInput() {
        String input = "5\n"; // Valid input
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        int result = Main.getUserInput("Enter a number: ");

        assertEquals(5, result);
    }

    @Test
    public void testGetUserInput_InvalidInputThenValidInput() {
        String input = "invalid\n7\n"; // Invalid input followed by valid input
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        int result = Main.getUserInput("Enter a number: ");

        assertEquals(7, result);
    }

    @Test
    public void testPlace_EmptyCell() {
        Board board = new Board();
        board.place(1, 1, 'X');
        assertEquals('X', board.cells[1][1]);
    }

    @Test
    public void testPlace_NonEmptyCell() {
        Board board = new Board();
        board.place(0, 0, 'X');
        board.place(0, 0, 'O'); // Attempt to place in a non-empty cell
        assertEquals('X', board.cells[0][0]); // Cell should remain unchanged
    }

    @Test
    public void testIsFull_NotFull() {
        Board board = new Board();
        assertFalse(board.isFull());
    }

    @Test
    public void testIsFull_Full() {
        Board board = new Board();
        // Fill the board
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board.place(i, j, 'X');
            }
        }
        assertTrue(board.isFull());
    }

    @Test
    public void testIsCellEmpty_EmptyCell() {
        Board board = new Board();
        assertTrue(board.isCellEmpty(1, 1));
    }

    @Test
    public void testIsCellEmpty_NonEmptyCell() {
        Board board = new Board();
        board.place(0, 0, 'X');
        assertFalse(board.isCellEmpty(0, 0));
    }

    @Test
    public void testClear() {
        Board board = new Board();
        board.place(0, 0, 'X');
        board.clear();
        assertTrue(board.isCellEmpty(0, 0)); // Cell should be empty after clearing
    }
}
