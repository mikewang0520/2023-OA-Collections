import java.util.*;

public class Chess {
    public static void Chess_board(int n) {
        int i, j;
        for (i = 0; i < n; i++) {
            for (j = 0; j < n; j++) {
                if ((i + j) % 2 == 0) {
                    System.out.print('W' + " ");
                } else {
                    System.out.print('B' + " ");
                }
            }
            System.out.println("");
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        Chess_board(n);
    }
}