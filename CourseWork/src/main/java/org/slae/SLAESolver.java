package org.slae;

import java.util.Arrays;

public class SLAESolver {

    public static double[] multiply(double[][] A, double[] x) {
        int n = A.length; double[] r = new double[n];
        for (int i = 0; i < n; i++) {
            double s = 0;
            for (int j = 0; j < n; j++) s += A[i][j] * x[j];
            r[i] = s;
        }
        return r;
    }

    public static boolean checkSolution(double[][] A, double[] B, double[] X, double tol) {
        double[] AX = multiply(A, X);
        for (int i = 0; i < B.length; i++)
            if (Math.abs(AX[i] - B[i]) > tol) return false;
        return true;
    }

    public static double[] cramer(double[][] A, double[] B) {
        int n = A.length;
        double detA = determinant(A);
        if (Math.abs(detA) < 1e-15) return null;
        double[] X = new double[n];
        for (int i = 0; i < n; i++) {
            double[][] M = copyMatrix(A);
            for (int r = 0; r < n; r++) M[r][i] = B[r];
            X[i] = determinant(M) / detA;
        }
        return X;
    }

    public static double[][] copyMatrix(double[][] A) {
        int n = A.length; double[][] R = new double[n][n];
        for (int i = 0; i < n; i++) System.arraycopy(A[i], 0, R[i], 0, n);
        return R;
    }

    public static double determinant(double[][] A) {
        int n = A.length;
        if (n == 1) return A[0][0];
        if (n == 2) return A[0][0]*A[1][1] - A[0][1]*A[1][0];
        double det = 0;
        for (int c = 0; c < n; c++) {
            double[][] sub = new double[n-1][n-1];
            for (int i = 1; i < n; i++) {
                int cc = 0;
                for (int j = 0; j < n; j++) if (j != c) sub[i-1][cc++] = A[i][j];
            }
            det += Math.pow(-1, c) * A[0][c] * determinant(sub);
        }
        return det;
    }

    public static double[] gauss(double[][] Aorig, double[] Borig) {
        int n = Aorig.length;
        double[][] A = copyMatrix(Aorig);
        double[] B = Arrays.copyOf(Borig, n);

        for (int k = 0; k < n; k++) {
            int pivot = k;
            double max = Math.abs(A[k][k]);
            for (int i = k+1; i < n; i++) {
                if (Math.abs(A[i][k]) > max) { max = Math.abs(A[i][k]); pivot = i; }
            }
            if (Math.abs(max) < 1e-15) return null;
            if (pivot != k) {
                double[] tmp = A[k]; A[k] = A[pivot]; A[pivot] = tmp;
                double t = B[k]; B[k] = B[pivot]; B[pivot] = t;
            }
            for (int i = k+1; i < n; i++) {
                double factor = A[i][k] / A[k][k];
                for (int j = k; j < n; j++) A[i][j] -= factor * A[k][j];
                B[i] -= factor * B[k];
            }
        }

        double[] x = new double[n];
        for (int i = n-1; i >= 0; i--) {
            double s = B[i];
            for (int j = i+1; j < n; j++) s -= A[i][j] * x[j];
            x[i] = s / A[i][i];
        }
        return x;
    }

    public static double[] gaussJordan(double[][] Aorig, double[] Borig) {
        int n = Aorig.length;
        double[][] M = new double[n][n+1];
        for (int i = 0; i < n; i++) {
            System.arraycopy(Aorig[i], 0, M[i], 0, n);
            M[i][n] = Borig[i];
        }
        int row = 0;
        for (int col = 0; col < n && row < n; col++) {
            int sel = row;
            for (int i = row; i < n; i++) if (Math.abs(M[i][col]) > Math.abs(M[sel][col])) sel = i;
            if (Math.abs(M[sel][col]) < 1e-15) continue;
            double[] tmp = M[row]; M[row] = M[sel]; M[sel] = tmp;
            double div = M[row][col];
            for (int j = col; j <= n; j++) M[row][j] /= div;
            for (int i = 0; i < n; i++) if (i != row) {
                double factor = M[i][col];
                for (int j = col; j <= n; j++) M[i][j] -= factor * M[row][j];
            }
            row++;
        }
        double[] x = new double[n];
        for (int i = 0; i < n; i++) x[i] = M[i][n];
        return x;
    }

    public static double[] jacobi(double[][] A, double[] B, double eps, int maxIter) {
        int n = A.length;
        double[] x = new double[n];
        double[] xnew = new double[n];
        for (int iter = 0; iter < maxIter; iter++) {
            for (int i = 0; i < n; i++) {
                double s = B[i];
                for (int j = 0; j < n; j++) if (j != i) s -= A[i][j] * x[j];
                if (Math.abs(A[i][i]) < 1e-15) return null;
                xnew[i] = s / A[i][i];
            }
            double maxDiff = 0;
            for (int i = 0; i < n; i++) maxDiff = Math.max(maxDiff, Math.abs(xnew[i] - x[i]));
            System.arraycopy(xnew, 0, x, 0, n);
            if (maxDiff < eps) return x;
        }
        return null;
    }

    public static double[] gaussSeidel(double[][] A, double[] B, double eps, int maxIter) {
        int n = A.length;
        double[] x = new double[n];
        for (int iter = 0; iter < maxIter; iter++) {
            double maxDiff = 0;
            for (int i = 0; i < n; i++) {
                double s = B[i];
                for (int j = 0; j < n; j++) if (j != i) s -= A[i][j] * x[j];
                if (Math.abs(A[i][i]) < 1e-15) return null;
                double xi_new = s / A[i][i];
                maxDiff = Math.max(maxDiff, Math.abs(xi_new - x[i]));
                x[i] = xi_new;
            }
            if (maxDiff < eps) return x;
        }
        return null;
    }
}
