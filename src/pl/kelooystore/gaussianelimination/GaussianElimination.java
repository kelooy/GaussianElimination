package pl.kelooystore.gaussianelimination;

public class GaussianElimination {

    public static double[] solveMatrix(double[][] matrixA, double[] matrixB) {
        final double EPSILON = 1e-10;
        final int n = matrixB.length;

        for (int k = 0; k < n; k++) {
            // find pivot row
            // set row with highest coefficient on the top
            int max = k;
            for (int i = k + 1; i < n; i++) {
                if (Math.abs(matrixA[i][k]) > Math.abs(matrixA[max][k])) {
                    max = i;
                }
            }

            // swap row with pivot row
            double[] temp = matrixA[k];
            matrixA[k] = matrixA[max];
            matrixA[max] = temp;
            double t = matrixB[k];
            matrixB[k] = matrixB[max];
            matrixB[max] = t;

            // check if matrix is singular
            if (Math.abs(matrixA[k][k]) <= EPSILON) {
                throw new ArithmeticException("Matrix is singular!");
            }

            // achieve upper triangular matrix
            for (int i = k + 1; i < n; i++) {
                double alpha = matrixA[i][k] / matrixA[k][k];
                matrixB[i] -= alpha * matrixB[k];
                for (int j = k; j < n; j++) {
                    matrixA[i][j] -= alpha * matrixA[k][j];
                }
            }
        }

        // back-substitution
        double[] outputMatrix = new double[n];
        for (int i = n - 1; i >= 0; i--) {
            double sum = 0;
            for (int j = i + 1; j < n; j++) {
                sum += matrixA[i][j] * outputMatrix[j];
            }
            outputMatrix[i] = (matrixB[i] - sum) / matrixA[i][i];
        }
        return outputMatrix;
    }
}
