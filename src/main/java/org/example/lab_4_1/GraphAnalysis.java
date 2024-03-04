package org.example.lab_4_1;

import java.util.*;

public class GraphAnalysis {

    public static void main(String[] args) {
        // Пример представления графа в виде списков смежности
        Map<Integer, List<Integer>> adjacencyList = new HashMap<>();
        adjacencyList.put(0, Arrays.asList(1, 2));
        adjacencyList.put(1, Arrays.asList(0, 2, 3));
        adjacencyList.put(2, Arrays.asList(0, 1, 3));
        adjacencyList.put(3, Arrays.asList(1, 2));

        // Вывод числа рёбер через число вершин
        int vertexCount = adjacencyList.size();
        int edgeCount = calculateEdgeCount(adjacencyList);
        System.out.println("Число рёбер через число вершин: " + edgeCount);

        // Вывод компонентов связности
        List<List<Integer>> components = findConnectedComponents(adjacencyList);
        System.out.println("Компоненты связности:");
        for (List<Integer> component : components) {
            System.out.println(component);
        }
    }

    // Метод для оценки числа рёбер через число вершин
    public static int calculateEdgeCount(Map<Integer, List<Integer>> adjacencyList) {
        int edgeCount = 0;
        for (List<Integer> neighbors : adjacencyList.values()) {
            edgeCount += neighbors.size();
        }
        // Каждое ребро было учтено дважды (для каждой вершины), поэтому делим на 2
        return edgeCount / 2;
    }

    // Метод для поиска компонентов связности
    public static List<List<Integer>> findConnectedComponents(Map<Integer, List<Integer>> adjacencyList) {
        List<List<Integer>> components = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();
        for (int vertex : adjacencyList.keySet()) {
            if (!visited.contains(vertex)) {
                List<Integer> component = new ArrayList<>();
                dfs(adjacencyList, vertex, visited, component);
                components.add(component);
            }
        }
        return components;
    }

    // Обход в глубину для поиска компонентов связности
    public static void dfs(Map<Integer, List<Integer>> adjacencyList, int vertex, Set<Integer> visited, List<Integer> component) {
        visited.add(vertex);
        component.add(vertex);
        for (int neighbor : adjacencyList.getOrDefault(vertex, Collections.emptyList())) {
            if (!visited.contains(neighbor)) {
                dfs(adjacencyList, neighbor, visited, component);
            }
        }
    }
}
