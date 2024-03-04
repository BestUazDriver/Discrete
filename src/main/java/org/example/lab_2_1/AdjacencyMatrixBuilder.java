package org.example.lab_2_1;

public class AdjacencyMatrixBuilder {

    public static void main(String[] args) {
        int[][] adjacencyMatrix = {
                {0, 0, 1, 0, 1},
                {1, 0, 0, 1, 0},
                {1, 1, 0, 1, 1},
                {0, 1, 0, 0, 1},
                {0, 0, 1, 1, 0}
        };

        System.out.println("Матрица смежности:");
        printMatrix(adjacencyMatrix);
    }

    public static void printMatrix(int[][] matrix) {
        int rowCount = matrix.length;
        int colCount = matrix[0].length;

        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

}
