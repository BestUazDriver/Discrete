package org.example.lab_1_1;
import java.util.ArrayList;
import java.util.List;

public class MatrixFormBuilder
{

    public static void main(String[] args) {
        int[][] adjacencyMatrix = {
                {0, 0, 1, 0, 0},
                {1, 0, 1, 1, 0},
                {1, 0, 0, 1, 1},
                {0, 0, 1, 1, 1},
                {0, 0, 1, 1, 0}
        };

        System.out.println("Матрица смежности:");
        printMatrix(adjacencyMatrix);

        int[][] incidenceMatrix = convertToIncidenceMatrix(adjacencyMatrix);
        System.out.println("\nМатрица инцидентности:");
        printMatrix(incidenceMatrix);

        List<List<Integer>> adjacencyList = convertToAdjacencyList(adjacencyMatrix);
        System.out.println("\nСписок смежности:");
        printAdjacencyList(adjacencyList);
    }

    public static int[][] convertToIncidenceMatrix(int[][] adjacencyMatrix) {
        int vertexCount = adjacencyMatrix.length;
        int edgeCount = countEdges(adjacencyMatrix);
        int[][] incidenceMatrix = new int[vertexCount][edgeCount];
        int edgeIndex = 0;

        for (int i = 0; i < vertexCount; i++) {
            for (int j = i + 1; j < vertexCount; j++) {
                if (adjacencyMatrix[i][j] == 1) {
                    incidenceMatrix[i][edgeIndex] = 1;
                    incidenceMatrix[j][edgeIndex] = 1;
                    edgeIndex++;
                }
            }
        }
        return incidenceMatrix;
    }

    public static List<List<Integer>> convertToAdjacencyList(int[][] adjacencyMatrix) {
        List<List<Integer>> adjacencyList = new ArrayList<>();
        int vertexCount = adjacencyMatrix.length;

        for (int i = 0; i < vertexCount; i++) {
            List<Integer> neighbors = new ArrayList<>();
            for (int j = 0; j < vertexCount; j++) {
                if (adjacencyMatrix[i][j] == 1) {
                    neighbors.add(j);
                }
            }
            adjacencyList.add(neighbors);
        }
        return adjacencyList;
    }

    public static int countEdges(int[][] adjacencyMatrix) {
        int vertexCount = adjacencyMatrix.length;
        int edgeCount = 0;

        for (int i = 0; i < vertexCount; i++) {
            for (int j = i + 1; j < vertexCount; j++) {
                if (adjacencyMatrix[i][j] == 1) {
                    edgeCount++;
                }
            }
        }
        return edgeCount;
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }

    public static void printAdjacencyList(List<List<Integer>> adjacencyList) {
        for (int i = 0; i < adjacencyList.size(); i++) {
            System.out.print(i + ": ");
            for (int neighbor : adjacencyList.get(i)) {
                System.out.print(neighbor + " ");
            }
            System.out.println();
        }
    }
}

