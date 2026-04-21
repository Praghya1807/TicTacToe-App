import java.util.Random;

public class TicTacToe {

    // Board initialization
    static char[][] board = {
            {'-', '-', '-'},
            {'-', '-', '-'},
            {'-', '-', '-'}
    };

    static char computerSymbol = 'O';

    public static void main(String[] args) {
        computerMove();
        printBoard();
    }

    // UC4: slot → row
    static int getRowFromSlot(int slot) {
        return (slot - 1) / 3;
    }

    // UC4: slot → column
    static int getColFromSlot(int slot) {
        return (slot - 1) % 3;
    }

    // UC5: validate move
    static boolean isValidMove(int row, int col) {
        if (row < 0 || row > 2 || col < 0 || col > 2) {
            return false;
        }

        if (board[row][col] != '-') {
            return false;
        }

        return true;
    }

    // UC6: place move
    static void placeMove(int row, int col, char symbol) {
        board[row][col] = symbol;
    }

    // ✅ UC7: computer random move
    static void computerMove() {
        Random rand = new Random();

        while (true) {
            int slot = rand.nextInt(9) + 1; // 1–9
            int row = getRowFromSlot(slot);
            int col = getColFromSlot(slot);

            if (isValidMove(row, col)) {
                placeMove(row, col, computerSymbol);
                System.out.println("Computer chose slot: " + slot);
                break;
            }
        }
    }

    // Print board
    static void printBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}