package org.example.lab_6_1;

import java.util.*;

public class DepthFirstSearch {
    public static void main(String[] args) {
        Map<Integer, List<Integer>> adjacencyList = new HashMap<>();
        adjacencyList.put(0, Arrays.asList(4, 2));
        adjacencyList.put(1, Arrays.asList(1, 2));
        adjacencyList.put(2, Arrays.asList(0, 3, 4));
        adjacencyList.put(3, Arrays.asList(1, 2, 4));
        adjacencyList.put(4, Arrays.asList(2, 3));

        System.out.println("Обход в глубину:");
        depthFirstSearch(adjacencyList);
    }

    public static void depthFirstSearch(Map<Integer, List<Integer>> adjacencyList) {
        Set<Integer> visited = new HashSet<>();
        for (int vertex : adjacencyList.keySet()) {
            if (!visited.contains(vertex)) {
                dfsUtil(vertex, adjacencyList, visited);
            }
        }
    }

    public static void dfsUtil(int vertex, Map<Integer, List<Integer>> adjacencyList, Set<Integer> visited) {
        visited.add(vertex);
        System.out.print(vertex + " ");
        List<Integer> neighbors = adjacencyList.get(vertex);
        if (neighbors != null) {
            for (int neighbor : neighbors) {
                if (!visited.contains(neighbor)) {
                    dfsUtil(neighbor, adjacencyList, visited);
                }
            }
        }
    }
}
