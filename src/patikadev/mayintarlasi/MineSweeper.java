package patikadev.mayintarlasi;

import java.util.Random;
import java.util.Scanner;

public class MineSweeper {
    private char[][] board;
    private char[][] mineBoard;
    private int rows;
    private int cols;
    private int mines;

    public MineSweeper(int rows, int cols, int mines) {
        this.rows = rows;
        this.cols = cols;
        this.mines = mines;
        board = new char[rows][cols];
        mineBoard = new char[rows][cols];
        initializeBoard();
        placeMines();
    }

    private void initializeBoard() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                board[i][j] = '-';
            }
        }
    }

    private void placeMines() {
        Random random = new Random();
        for (int i = 0; i < mines; i++) {
            int row, col;
            do {
                row = random.nextInt(rows);
                col = random.nextInt(cols);
            } while (mineBoard[row][col] == '*');
            mineBoard[row][col] = '*';
        }
    }

    private boolean isValidMove(int row, int col) {
        return row >= 0 && row < rows && col >= 0 && col < cols;
    }

    private boolean isMine(int row, int col) {
        return mineBoard[row][col] == '*';
    }

    private int countAdjacentMines(int row, int col) {
        int count = 0;
        for (int r = row - 1; r <= row + 1; r++) {
            for (int c = col - 1; c <= col + 1; c++) {
                if (isValidMove(r, c) && isMine(r, c)) {
                    count++;
                }
            }
        }
        return count;
    }

    public void printBoard(boolean revealMines) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (revealMines) {
                    System.out.print(mineBoard[i][j] + " ");
                } else {
                    System.out.print(board[i][j] + " ");
                }
            }
            System.out.println();
        }
    }

    public void play() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Mayın Tarlası Oyuna Hoşgeldiniz!");
        printBoard(true);
        System.out.println("==========================");

        while (true) {
            System.out.print("Satır Giriniz: ");
            int row = scanner.nextInt();
            System.out.print("Sütun Giriniz: ");
            int col = scanner.nextInt();

            if (!isValidMove(row, col)) {
                System.out.println("Geçersiz hamle. Tekrar deneyin.");
                continue;
            }

            if (isMine(row, col)) {
                System.out.println("Game Over!!");
                break;
            }

            int adjacentMines = countAdjacentMines(row, col);
            board[row][col] = (char) (adjacentMines + '0');
            printBoard(false);

            if (checkWin()) {
                System.out.println("Oyunu Kazandınız!");
                break;
            }
        }

        scanner.close();
    }

    private boolean checkWin() {
        int safeCells = rows * cols - mines;
        int revealedCells = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] != '-') {
                    revealedCells++;
                }
            }
        }
        return revealedCells == safeCells;
    }
}