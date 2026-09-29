import java.util.*;

public class Main {

    static int V;
    static int[][] capacity;
    static int[][] flow;

    public static boolean bfs(int source, int sink, int[] parent) {

        boolean[] visited = new boolean[V];
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(source);
        visited[source] = true;
        parent[source] = -1;

        while(!queue.isEmpty()) {

            int u = queue.poll();

            for(int v = 0; v < V; v++) {

                if(!visited[v] && capacity[u][v] - flow[u][v] > 0) {

                    parent[v] = u;
                    visited[v] = true;
                    queue.offer(v);

                    if(v == sink) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public static int fordFulkerson(int source, int sink) {

        int maxFlow = 0;
        int[] parent = new int[V];

        while(bfs(source, sink, parent)) {

            int pathFlow = Integer.MAX_VALUE;

            int v = sink;

            while(v != source) {

                int u = parent[v];

                pathFlow = Math.min(
                    pathFlow,
                    capacity[u][v] - flow[u][v]
                );

                v = u;
            }

            v = sink;

            while(v != source) {

                int u = parent[v];

                flow[u][v] += pathFlow;
                flow[v][u] -= pathFlow;

                v = u;
            }

            maxFlow += pathFlow;
        }

        return maxFlow;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        V = sc.nextInt();
        int E = sc.nextInt();

        capacity = new int[V][V];
        flow = new int[V][V];

        for(int i = 0; i < E; i++) {

            int u = sc.nextInt();
            int v = sc.nextInt();
            int cap = sc.nextInt();

            capacity[u][v] += cap;
        }

        int source = 0;
        int sink = V - 1;

        System.out.println(fordFulkerson(source, sink));
    }
}
