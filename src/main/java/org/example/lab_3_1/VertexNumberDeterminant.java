package org.example.lab_3_1;

public class VertexNumberDeterminant {

    public static void main(String[] args) {
        int[][] incidenceMatrix = {
                {0, 1, 1, 0},
                {1, 0, 1, 1},
                {1, 1, 0, 1},
                {0, 1, 0, 1}
        };

        System.out.println("Матрица инцидентности:");
        printMatrix(incidenceMatrix);

        System.out.println("Вершины со степенью 2:");
        findVerticesWithDegreeTwo(incidenceMatrix);
    }

    public static void findVerticesWithDegreeTwo(int[][] incidenceMatrix) {
        for (int i = 0; i < incidenceMatrix.length; i++) {
            int degree = 0;
            for (int j = 0; j < incidenceMatrix[0].length; j++) {
                if (incidenceMatrix[i][j] == 1) {
                    degree++;
                }
            }
            if (degree == 2) {
                System.out.println(i);
            }
        }
    }

    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

}
