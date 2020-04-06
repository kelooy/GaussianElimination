package pl.kelooystore.gaussianelimination;

import java.util.Scanner;
import static pl.kelooystore.gaussianelimination.GaussianElimination.solveMatrix;

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Enter the number of variables: ");
        int n = scanner.nextInt();
        System.out.println();

        double[][] matrixA = new double[n][n];
        double[] matrixB = new double[n];

        System.out.println("Left side of matrix.\nEnter " + n + " coefficients if variables:\n");
        for (int i = 0; i < n; i++) {
            System.out.println("The "+(i+1)+". row is...");
            for (int j = 0; j < n; j++) {
                matrixA[i][j] = scanner.nextDouble();
            }
        }

        System.out.println("\nRight side of matrix.\nEnter " + n + " solutions:");
        for (int i = 0; i < n; i++) {
            matrixB[i] = scanner.nextDouble();
        }

        double[] matrixC = solveMatrix(matrixA, matrixB);

        System.out.println("\nResulting matrix:\n");
        for (int i = 0; i < n; i++) {
            System.out.println(matrixC[i]);
        }
    }
}


