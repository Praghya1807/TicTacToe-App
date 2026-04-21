import java.util.Random;

public class TicTacToe {

    static char[][] board = {
            {'-', '-', '-'},
            {'-', '-', '-'},
            {'-', '-', '-'}
    };

    static char humanSymbol = 'X';
    static char computerSymbol = 'O';

    static boolean isHumanTurn = true;
    static boolean gameOver = false;

    public static void main(String[] args) {

        while (!gameOver) {

            printBoard();

            if (isHumanTurn) {
                // TEMP: fixed move (you can change later to Scanner input)
                System.out.println("Human turn");
                placeMove(0, 0, humanSymbol);
            } else {
                System.out.println("Computer turn");
                computerMove();
            }

            // ✅ UC9 + UC10 LOGIC
            if (hasWon(humanSymbol)) {
                printBoard();
                System.out.println("Human wins!");
                gameOver = true;
            }
            else if (hasWon(computerSymbol)) {
                printBoard();
                System.out.println("Computer wins!");
                gameOver = true;
            }
            else if (isDraw()) {   // ⭐ UC10
                printBoard();
                System.out.println("It's a draw!");
                gameOver = true;
            }

            isHumanTurn = !isHumanTurn;
        }
    }

    // ---------- UC6 ----------
    static void placeMove(int row, int col, char symbol) {
        if (board[row][col] == '-') {
            board[row][col] = symbol;
        }
    }

    // ---------- UC7 ----------
    static void computerMove() {
        Random rand = new Random();

        while (true) {
            int slot = rand.nextInt(9) + 1;

            int row = getRowFromSlot(slot);
            int col = getColFromSlot(slot);

            if (board[row][col] == '-') {
                placeMove(row, col, computerSymbol);
                break;
            }
        }
    }

    // ---------- UC9 ----------
    static boolean hasWon(char symbol) {

        // rows
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == symbol &&
                    board[i][1] == symbol &&
                    board[i][2] == symbol)
                return true;
        }

        // columns
        for (int j = 0; j < 3; j++) {
            if (board[0][j] == symbol &&
                    board[1][j] == symbol &&
                    board[2][j] == symbol)
                return true;
        }

        // diagonals
        if (board[0][0] == symbol &&
                board[1][1] == symbol &&
                board[2][2] == symbol)
            return true;

        if (board[0][2] == symbol &&
                board[1][1] == symbol &&
                board[2][0] == symbol)
            return true;

        return false;
    }

    // ---------- UC10 ----------
    static boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '-') {
                    return false;
                }
            }
        }
        return true;
    }

    static boolean isDraw() {
        return isBoardFull() &&
                !hasWon(humanSymbol) &&
                !hasWon(computerSymbol);
    }

    // ---------- UTIL ----------
    static int getRowFromSlot(int slot) {
        return (slot - 1) / 3;
    }

    static int getColFromSlot(int slot) {
        return (slot - 1) % 3;
    }

    static void printBoard() {
        System.out.println();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}