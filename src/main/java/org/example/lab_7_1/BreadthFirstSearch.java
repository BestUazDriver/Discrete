package org.example.lab_7_1;
import java.util.*;

public class BreadthFirstSearch {

    public static void main(String[] args) {
        Map<Integer, List<Integer>> adjacencyList = new HashMap<>();
        adjacencyList.put(0, Arrays.asList(4, 3));
        adjacencyList.put(1, Arrays.asList(1, 2));
        adjacencyList.put(2, Arrays.asList(0, 3, 4));
        adjacencyList.put(3, Arrays.asList(1, 2, 4));
        adjacencyList.put(4, Arrays.asList(2, 3));

        System.out.println("Обход в ширину:");
        breadthFirstSearch(adjacencyList);
    }

    public static void breadthFirstSearch(Map<Integer, List<Integer>> adjacencyList) {
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();

        for (int vertex : adjacencyList.keySet()) {
            if (!visited.contains(vertex)) {
                queue.offer(vertex);
                visited.add(vertex);
                while (!queue.isEmpty()) {
                    int currentVertex = queue.poll();
                    System.out.print(currentVertex + " ");
                    List<Integer> neighbors = adjacencyList.get(currentVertex);
                    if (neighbors != null) {
                        for (int neighbor : neighbors) {
                            if (!visited.contains(neighbor)) {
                                queue.offer(neighbor);
                                visited.add(neighbor);
                            }
                        }
                    }
                }
            }
        }
    }

}
