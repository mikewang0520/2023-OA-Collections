
//Import the required header file.
import java.util.*;

//Define the class with class name Main.
public class Main {
    // Create an array m and n such that we can move in all the four direction.
    static int[] m = {
            -1,
            0,
            0,
            1
    };
    static int[] n = {
            0,
            -1,
            1,
            0
    };

    // Define a search_word() method to search a word inside the grid.
    static boolean search_word(char[][] grid, int row, int column, String word) {
        // Use word.length() to calculate word length.
        int len = word.length();

        // If the word at 0 index is not present, return false.
        if (grid[row][column] != word.charAt(0)) {
            return false;
        }

        // Use for-loop to iterate the cell of the two-D grid.
        for (int i = 0; i < 4; i++) {
            // Initialize the variable j,rd and cd.
            int j, r = row + m[i], c = column + n[i];

            // Use for-loop to iterate the word length.
            for (j = 1; j < len; j++) {
                if (r >= grid.length || r < 0 || c >= grid[0].length || c < 0) {
                    break;
                }

                // Compare the words inside the grid.
                if (grid[r][c] != word.charAt(j)) {
                    break;
                }
                r = r + m[i];
                c = c + n[i];
            }

            // If the j is equal to length of the word,return true.
            if (j == len) {
                return true;
            }
        }
        return false;
    }

    // Define the find_pattern() function to find pattern.
    static boolean find_pattern(char[][] grid, String word) {
        // Use two for-loop to search a word inside the grid.
        for (int row = 0; row < grid.length; row++) {
            for (int column = 0; column < grid[row].length; column++) {
                // If the word is found inside the grid,return true otherwise return false.
                if (search_word(grid, row, column, word)) {
                    return true;
                }
            }
        }
        return false;
    }

    // Define the main method to execute the program.
    public static void main(String[] args) {

        // Prompt users to take input.
        Scanner sc = new Scanner(System.in);

        // Declare the grid array of char type.
        char[][] grid;
        int row = sc.nextInt();
        sc.nextLine();
        grid = new char[row][row];

        // Use for-loop to take the inputs.
        for (int i = 0; i < row; i++) {
            String line = sc.nextLine();
            int k = 0;
            for (int j = 0; j < line.length(); j = j + 2) {
                grid[i][k] = line.charAt(j);

                k = k + 1;
            }
        }

        // Declare the variable n of integer type.
        int n;

        // Create an array of string type.
        String words[];
        n = sc.nextInt();
        sc.nextLine();
        String input_words = sc.nextLine();
        words = input_words.split(" ");

        if (words.length < n) {
            n = words.length;
        }
        String[] word_to_be_search = new String[n];

        // Use for-loop to take words as an input.
        for (int i = 0; i < n; i++) {
            word_to_be_search[i] = words[i];
        }

        // Use for loop to search the words.
        for (String search : word_to_be_search) {
            // If word is found inside the grid,print yes otherwise print no.
            boolean isFound = find_pattern(grid, search);
            System.out.print(isFound ? "Yes " : "No ");
        }
        System.out.println();
    }
}