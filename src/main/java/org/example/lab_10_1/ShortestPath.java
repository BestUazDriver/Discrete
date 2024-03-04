import java.util.*;

public class ShortestPath {

    // Класс для представления ребра графа
    static class Edge {
        int destination;
        int weight;

        public Edge(int destination, int weight) {
            this.destination = destination;
            this.weight = weight;
        }
    }

    // Метод для нахождения кратчайшего пути между двумя вершинами
    public static void shortestPath(List<List<Edge>> adjacencyList, int source, int destination) {
        int vertices = adjacencyList.size();
        int[] distances = new int[vertices];
        int[] parents = new int[vertices];
        Arrays.fill(distances, Integer.MAX_VALUE);
        Arrays.fill(parents, -1);
        distances[source] = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>((v1, v2) -> distances[v1] - distances[v2]);
        pq.offer(source);

        while (!pq.isEmpty()) {
            int currentVertex = pq.poll();
            List<Edge> edges = adjacencyList.get(currentVertex);

            for (Edge edge : edges) {
                int newDistance = distances[currentVertex] + edge.weight;
                if (newDistance < distances[edge.destination]) {
                    distances[edge.destination] = newDistance;
                    parents[edge.destination] = currentVertex;
                    pq.offer(edge.destination);
                }
            }
        }

        // Вывод кратчайшего пути
        System.out.print("Кратчайший путь от вершины " + source + " к вершине " + destination + ": ");
        printPath(parents, destination);
        System.out.println("\nДлина пути: " + distances[destination]);
    }

    // Метод для вывода кратчайшего пути
    private static void printPath(int[] parents, int destination) {
        if (parents[destination] == -1) {
            System.out.print(destination + " ");
            return;
        }
        printPath(parents, parents[destination]);
        System.out.print(destination + " ");
    }

    public static void main(String[] args) {
        // Пример графа в виде списков смежности
        List<List<Edge>> adjacencyList = new ArrayList<>();
        int vertices = 5; // Количество вершин

        // Инициализация списков смежности
        for (int i = 0; i < vertices; i++) {
            adjacencyList.add(new ArrayList<>());
        }

        // Добавление ребер
        adjacencyList.get(0).add(new Edge(1, 10)); // Ребро из вершины 0 в вершину 1 с весом 10
        adjacencyList.get(0).add(new Edge(3, 5));  // Ребро из вершины 0 в вершину 3 с весом 5
        adjacencyList.get(1).add(new Edge(2, 1));  // Ребро из вершины 1 в вершину 2 с весом 1
        adjacencyList.get(1).add(new Edge(3, 2));  // Ребро из вершины 1 в вершину 3 с весом 2
        adjacencyList.get(2).add(new Edge(4, 4));  // Ребро из вершины 2 в вершину 4 с весом 4
        adjacencyList.get(3).add(new Edge(1, 3));  // Ребро из вершины 3 в вершину 1 с весом 3
        adjacencyList.get(3).add(new Edge(2, 9));  // Ребро из вершины 3 в вершину 2 с весом 9
        adjacencyList.get(3).add(new Edge(4, 2));  // Ребро из вершины 3 в вершину 4 с весом 2

        int source = 0; // Исходная вершина
        int destination = 4; // Целевая вершина

        shortestPath(adjacencyList, source, destination);
    }
}
