import java.util.*;

public class Main {

    static String getCamel(String s) {
        StringBuilder sb = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (Character.isUpperCase(c)) {
                sb.append(c);
            }
        }

        return sb.toString();
    }

    static boolean match(String s, String pattern) {
        int j = 0;

        for (int i = 0; i < s.length(); i++) {
            if (j < pattern.length() && s.charAt(i) == pattern.charAt(j)) {
                j++;
            }
        }

        return j == pattern.length();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();

        final String[] dict = sc.nextLine().split(",");
        final String pattern = sc.nextLine();

        final String[] camel = new String[n];

        for (int i = 0; i < n; i++) {
            dict[i] = dict[i].trim();
            camel[i] = getCamel(dict[i]);
        }

        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (match(camel[i], pattern)) {
                result.add(i);
            }
        }

        Collections.sort(result, new Comparator<Integer>() {

            public int compare(Integer a, Integer b) {

                int x = camel[a].compareTo(camel[b]);

                if (x == 0) {
                    return dict[a].compareTo(dict[b]);
                }

                return x;
            }
        });

        if (result.isEmpty()) {
            System.out.println("No match found");
        } else {
            for (int i : result) {
                System.out.println(dict[i]);
            }
        }
    }
}
