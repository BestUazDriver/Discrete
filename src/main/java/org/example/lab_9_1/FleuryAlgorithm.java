package org.example.lab_9_1;
import java.util.*;

public class FleuryAlgorithm {

    public static List<Integer> fleuryAlgorithm(Map<Integer, List<Integer>> adjacencyList) {
        int startVertex = findStartVertex(adjacencyList);
        List<Integer> eulerianPath = new ArrayList<>();
        dfs(adjacencyList, startVertex, eulerianPath);
        return eulerianPath;
    }

    private static void dfs(Map<Integer, List<Integer>> adjacencyList, int vertex, List<Integer> eulerianPath) {
        while (!adjacencyList.get(vertex).isEmpty()) {
            int neighbor = adjacencyList.get(vertex).get(0);
            removeEdge(adjacencyList, vertex, neighbor);
            dfs(adjacencyList, neighbor, eulerianPath);
        }
        eulerianPath.add(vertex);
    }

    private static void removeEdge(Map<Integer, List<Integer>> adjacencyList, int u, int v) {
        adjacencyList.put(u, new ArrayList<>(adjacencyList.get(u)));
        adjacencyList.put(v, new ArrayList<>(adjacencyList.get(v)));

        adjacencyList.get(u).remove((Integer) v);
        adjacencyList.get(v).remove((Integer) u);
    }


    private static int findStartVertex(Map<Integer, List<Integer>> adjacencyList) {
        int oddDegreeVertexCount = 0;
        int startVertex = 0;
        for (int vertex : adjacencyList.keySet()) {
            if (adjacencyList.get(vertex).size() % 2 != 0) {
                oddDegreeVertexCount++;
                startVertex = vertex;
            }
        }
        if (oddDegreeVertexCount == 0 || oddDegreeVertexCount == 2) {
            return startVertex;
        } else {
            throw new IllegalArgumentException("Граф не содержит Эйлеров цикл или путь");
        }
    }

    public static void main(String[] args) {
        // Пример представления графа в виде списка смежности
        Map<Integer, List<Integer>> adjacencyList = new HashMap<>();
        adjacencyList.put(0, Arrays.asList(1, 2, 3));
        adjacencyList.put(1, Arrays.asList(0, 2));
        adjacencyList.put(2, Arrays.asList(0, 1, 3));
        adjacencyList.put(3, Arrays.asList(0, 2));

        List<Integer> eulerianPath = fleuryAlgorithm(adjacencyList);

        System.out.println("Эйлеров цикл или путь:");
        for (int vertex : eulerianPath) {
            System.out.print(vertex + " ");
        }
    }
}
