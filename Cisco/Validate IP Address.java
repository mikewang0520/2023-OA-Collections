import java.util.*;
import java.lang.*;
import java.io.*;

public class Solution {
    public static String validIPAddress(String IP) {
        if (IP.charAt(IP.length() - 1) == '.')
            return "No";
        String[] IPElements = IP.split("\\.");
        if (IPElements.length != 4)
            return "No";
        for (String element : IPElements) {
            if (!validIPv4Element(element))
                return "No";
        }
        return "4";
    }

    public static boolean validIPv4Element(String element) {
        if (element.startsWith("0") && element.length() > 1)
            return false;
        try {
            int elementInt = Integer.parseInt(element);
            if (elementInt < 0 || elementInt > 255)
                return false;
            if (elementInt == 0 && element.charAt(0) != '0')
                return false;
        } catch (NumberFormatException notANumber) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String ipInput = input.next();
        String result = validIPAddress(ipInput);
        System.out.println(result);
    }
}