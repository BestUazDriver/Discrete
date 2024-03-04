import java.util.*;

public class DijkstraShortestPath {

    static final int INF = Integer.MAX_VALUE;

    public static void dijkstra(int[][] graph, int source) {
        int vertices = graph.length;
        int[] dist = new int[vertices];
        boolean[] visited = new boolean[vertices];

        Arrays.fill(dist, INF);
        dist[source] = 0;

        for (int i = 0; i < vertices - 1; i++) {
            int u = minDistance(dist, visited);
            visited[u] = true;
            for (int v = 0; v < vertices; v++) {
                if (!visited[v] && graph[u][v] != 0 && dist[u] != INF && dist[u] + graph[u][v] < dist[v]) {
                    dist[v] = dist[u] + graph[u][v];
                }
            }
        }

        printSolution(dist, source);
    }

    public static int minDistance(int[] dist, boolean[] visited) {
        int min = INF, minIndex = -1;
        for (int v = 0; v < dist.length; v++) {
            if (!visited[v] && dist[v] <= min) {
                min = dist[v];
                minIndex = v;
            }
        }
        return minIndex;
    }

    public static void printSolution(int[] dist, int source) {
        System.out.println("Кратчайшие расстояния от вершины " + source + " до остальных вершин:");
        for (int i = 0; i < dist.length; i++) {
            System.out.println("Вершина " + i + ": " + dist[i]);
        }
    }

    public static void main(String[] args) {
        int[][] graph = {
                {0, 4, 0, 0, 0, 0, 0, 8, 0},
                {4, 0, 8, 0, 0, 0, 0, 11, 0},
                {0, 8, 0, 7, 0, 4, 0, 0, 2},
                {0, 0, 7, 0, 9, 14, 0, 0, 0},
                {0, 0, 0, 9, 0, 10, 0, 0, 0},
                {0, 0, 4, 14, 10, 0, 2, 0, 0},
                {0, 0, 0, 0, 0, 2, 0, 1, 6},
                {8, 11, 0, 0, 0, 0, 1, 0, 7},
                {0, 0, 2, 0, 0, 0, 6, 7, 0}
        };
        int source = 0;
        dijkstra(graph, source);
    }
}
