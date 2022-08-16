import java.util.*;
import java.lang.*;
import java.io.*;

public class Solution {
    public static String decodeString(String str) {
        String cur = "";
        int num = 0;
        Deque<String> stack = new ArrayDeque<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (Character.isDigit(c)) {
                num = num * 10 + str.charAt(i) - '0';
            } else if (Character.isAlphabetic(c)) {
                cur = cur + c;
            } else if (c == '[') {
                stack.push(cur);
                cur = "";
            } else if (c == '}') {
                String lastStr = stack.pop();
                StringBuilder curStr = new StringBuilder();
                while (num > 0) {
                    curStr.append(cur);
                    num--;
                }
                cur = lastStr + curStr.toString();
                num = 0;
            }
        }

        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }
        result.append(cur);
        return result.toString();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.next();
        String result = decodeString(input);
        System.out.println(result);
    }
}