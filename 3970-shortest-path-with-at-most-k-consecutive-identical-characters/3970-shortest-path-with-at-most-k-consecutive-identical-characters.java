import java.util.*;

class Solution {
    public int shortestPath(int n, int[][] edges, String labels, int k) {
        // Build adjacency list: node -> list of int[]{neighbor, weight}
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(new int[]{edge[1], edge[2]});
        }

        // dist[u][count] stores the minimum weight to reach node u with 'count' consecutive same labels
        int[][] dist = new int[n][k + 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        // Priority Queue elements: {distance, node, consecutive_count}
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

        // Initialize node 0 with consecutive count of 1
        dist[0][1] = 0;
        pq.offer(new int[]{0, 0, 1});

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int d = curr[0];
            int u = curr[1];
            int count = curr[2];

            // If target node reached, return the minimal distance
            if (u == n - 1) {
                return d;
            }

            // Skip stale states
            if (d > dist[u][count]) {
                continue;
            }

            for (int[] edge : graph.get(u)) {
                int v = edge[0];
                int weight = edge[1];

                int nextCount = (labels.charAt(u) == labels.charAt(v)) ? count + 1 : 1;

                // Validate state transition against k
                if (nextCount <= k) {
                    if (d + weight < dist[v][nextCount]) {
                        dist[v][nextCount] = d + weight;
                        pq.offer(new int[]{dist[v][nextCount], v, nextCount});
                    }
                }
            }
        }

        return -1;
    }
}