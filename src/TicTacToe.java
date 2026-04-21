public class TicTacToe {

    // Board initialization
    static char[][] board = {
            {'-', '-', '-'},
            {'-', '-', '-'},
            {'-', '-', '-'}
    };

    // Entry point
    public static void main(String[] args) {

        int slot = 7;  // sample slot

        int row = getRowFromSlot(slot);
        int col = getColFromSlot(slot);

        // UC6: Place move
        placeMove(row, col, 'X');

        // Print result
        System.out.println("Slot: " + slot);
        System.out.println("Row: " + row);
        System.out.println("Column: " + col);
        System.out.println("Value at position: " + board[row][col]);
    }

    // Convert slot → row
    static int getRowFromSlot(int slot) {
        return (slot - 1) / 3;
    }

    // Convert slot → column
    static int getColFromSlot(int slot) {
        return (slot - 1) % 3;
    }

    // UC6 method
    static void placeMove(int row, int col, char symbol) {
        board[row][col] = symbol;
    }
}git add .