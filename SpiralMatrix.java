import java.util.*;

public class Main {


static int[] dr = {-1, 1, 0, 0};
static int[] dc = {0, 0, -1, 1};

public static int orangesRotting(int[][] grid) {
    int m = grid.length;
    int n = grid[0].length;

    Queue<int[]> queue = new LinkedList<>();
    int fresh = 0;

    // Add all rotten oranges to the queue
    // and count fresh oranges.
    for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
            if (grid[i][j] == 2) {
                queue.offer(new int[]{i, j});
            } else if (grid[i][j] == 1) {
                fresh++;
            }
        }
    }

    int time = 0;

    // Multi-source BFS
    while (!queue.isEmpty() && fresh > 0) {
        int size = queue.size();

        for (int i = 0; i < size; i++) {
            int[] curr = queue.poll();

            for (int d = 0; d < 4; d++) {
                int newRow = curr[0] + dr[d];
                int newCol = curr[1] + dc[d];

                if (newRow < 0 || newRow >= m ||
                    newCol < 0 || newCol >= n) {
                    continue;
                }

                if (grid[newRow][newCol] == 1) {
                    grid[newRow][newCol] = 2;
                    fresh--;

                    queue.offer(new int[]{newRow, newCol});
                }
            }
        }

        time++;
    }

    // If fresh oranges remain, they cannot be reached.
    if (fresh > 0) {
        return -1;
    }

    return time;
}

public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int m = sc.nextInt();

    int[][] grid = new int[n][m];

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            grid[i][j] = sc.nextInt();
        }
    }

    System.out.println(orangesRotting(grid));

    sc.close();
}


}
