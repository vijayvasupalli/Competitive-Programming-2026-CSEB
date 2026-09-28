import java.util.*;

public class Solution {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int x = sc.nextInt();
        int y = sc.nextInt();

        if (y == 0) {
            System.out.println("Division by zero is not possible");
            return;
        }

        int low = 0;
        int high = Math.abs(x);
        int ans = 0;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            long product = (long) y * mid;

            if (product == x) {
                ans = mid;
                break;
            }
            else if (product < x) {
                ans = mid;      // Best answer so far
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }

        System.out.println(ans);
    }
}
