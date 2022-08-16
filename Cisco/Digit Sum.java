import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {
    public static int digitSumCnt(int X, int Y) {
        int result = 0;
        for (int i = 1; i <= X; i++) {
            if (i < 10) {
                if (i == Y)
                    result++;
            } else {
                if (digitSum(i) == Y)
                    result++;
            }
        }
        return result;
    }

    public static int digitSum(int n) {
        int sum = 0;
        while (n != 0) {
            sum += n % 10;
            n = n / 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int X = input.nextInt();
        int Y = input.nextInt();
        int result = digitSumCnt(X, Y);
        System.out.println(result);
    }
}