package patikadev.mayintarlasi;

public class Main {
    public static void main(String[] args) {
        int rows = 3;
        int cols = 3;
        int mines = 2;
        MineSweeper game = new MineSweeper(rows, cols, mines);
        game.play();
    }
}
