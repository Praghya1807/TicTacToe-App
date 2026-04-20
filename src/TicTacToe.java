import java.util.Scanner;

public class TicTacToe {

    public static void main(String[] args) {
        int slot = getUserSlot();
        System.out.println("Slot entered: " + slot);
    }

    // UC3 - Accept user input (1–9)
    static int getUserSlot() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter slot number (1-9): ");
        int slot = sc.nextInt();

        return slot;
    }
}