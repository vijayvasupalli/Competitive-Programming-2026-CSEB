import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        int seen = 0;
        int duplicate = 0;
        int printed = 0;

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            int pos = ch - 'a';
            int mask = 1 << pos;

            if ((seen & mask) == 0) {

                seen = seen | mask;
            } 
            else {

                duplicate = duplicate | mask;
            }
        }

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            int pos = ch - 'a';
            int mask = 1 << pos;

            if ((duplicate & mask) != 0) {

                if ((printed & mask) == 0) {

                    result.append(ch).append(" ");

                    printed = printed | mask;
                }
            }
        }

        if (result.length() == 0) {
            System.out.println("No duplicates");
        } 
        else {
            System.out.println(result.toString().trim());
        }
    }
}
