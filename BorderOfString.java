import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        int n = s.length();

        ArrayList<String> prefixList = new ArrayList<>();
        ArrayList<String> suffixList = new ArrayList<>();

        for (int i = 1; i < n; i++) {
            prefixList.add(s.substring(0, i));
        }

        for (int i = 1; i < n; i++) {
            suffixList.add(s.substring(n - i, n));
        }

        HashSet<String> set = new HashSet<>(prefixList);

        int maxLength = 0;

        for (String suffix : suffixList) {
            if (set.contains(suffix)) {
                maxLength = Math.max(maxLength, suffix.length());
            }
        }


        if (maxLength > 0) {
            System.out.println(s.substring(0, maxLength));
        }
    }
}
