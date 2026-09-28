import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    static Map<Long, Integer> map = new HashMap<>();

    static int cycleLength(long n) {

        if (map.containsKey(n)) {
            return map.get(n);
        }

        int ans;

        if (n % 2 == 0) {
            ans = 1 + cycleLength(n / 2);
        } else {
            ans = 1 + cycleLength(3 * n + 1);
        }

        map.put(n, ans);
        return ans;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int i = sc.nextInt();
        int j = sc.nextInt();

        int originalI = i;
        int originalJ = j;

        if (i > j) {
            int temp = i;
            i = j;
            j = temp;
        }

        map.put(1L, 1);

        int maxCycle = 0;

        for (int curr = i; curr <= j; curr++) {
            maxCycle = Math.max(maxCycle, cycleLength(curr));
        }

        System.out.println(originalI + " " + originalJ + " " + maxCycle);
    }
}
