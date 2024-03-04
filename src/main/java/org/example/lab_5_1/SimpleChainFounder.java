package org.example.lab_5_1;
import java.util.ArrayList;
import java.util.List;

public class SimpleChainFounder {

    public static void main(String[] args) {
        int[][] adjacencyMatrix = {
                {0, 1, 1, 0, 0},
                {1, 0, 0, 1, 0},
                {1, 0, 0, 1, 1},
                {0, 1, 1, 0, 1},
                {0, 0, 1, 1, 0}
        };

        System.out.println("Матрица смежности:");
        printMatrix(adjacencyMatrix);

        int startVertex = 0;
        int endVertex = 4;

        List<List<Integer>> paths = findPaths(adjacencyMatrix, startVertex, endVertex);

        System.out.println("Простые цепи между вершинами " + startVertex + " и " + endVertex + ":");
        for (List<Integer> path : paths) {
            System.out.println(path);
        }
    }

    public static List<List<Integer>> findPaths(int[][] adjacencyMatrix, int startVertex, int endVertex) {
        List<List<Integer>> paths = new ArrayList<>();
        List<Integer> currentPath = new ArrayList<>();
        currentPath.add(startVertex);

        findPathsHelper(adjacencyMatrix, startVertex, endVertex, currentPath, paths);

        return paths;
    }

    public static void findPathsHelper(int[][] adjacencyMatrix, int currentVertex, int endVertex,
                                       List<Integer> currentPath, List<List<Integer>> paths) {
        if (currentVertex == endVertex) {
            paths.add(new ArrayList<>(currentPath));
            return;
        }

        for (int i = 0; i < adjacencyMatrix.length; i++) {
            if (adjacencyMatrix[currentVertex][i] == 1 && !currentPath.contains(i)) {
                currentPath.add(i);
                findPathsHelper(adjacencyMatrix, i, endVertex, currentPath, paths);
                currentPath.remove(currentPath.size() - 1);
            }
        }
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }

}
