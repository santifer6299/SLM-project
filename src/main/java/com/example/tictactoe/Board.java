package com.example.tictactoe;

public class Board {
    public char[][] cells;

    public Board() {
        cells = new char[3][3];
        clear();
    }

    public boolean isCellEmpty(int x, int y) {
        return cells[x][y] == ' ';
    }

    public void place(int x, int y, char marker) {
        if (isCellEmpty(x, y)) {
            cells[x][y] = marker;
        }
    }

    public boolean isFull() {
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                if (isCellEmpty(i, j)) {
                    return false;
                }
            }
        }
        return true;
    }

    public void clear() {
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                cells[i][j] = ' ';
            }
        }
    }

    public void print() {
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                System.out.print(cells[i][j]);
                if (j < cells[i].length - 1) {
                    System.out.print("|");
                }
            }
            System.out.println();
            if (i < cells.length - 1) {
                System.out.println("-----");
            }
        }
    }
}
