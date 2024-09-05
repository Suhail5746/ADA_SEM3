import java.util.Scanner;

public class TridiagonalMatrix {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the size of the matrix: ");
        int n = scanner.nextInt();

        // Read the first tridiagonal matrix
        int[][] matrixA = new int[n][n];
        System.out.println("Enter the elements of the first tridiagonal matrix:");
        readTridiagonalMatrix(scanner, matrixA, n);

        // Read the second tridiagonal matrix
        int[][] matrixB = new int[n][n];
        System.out.println("Enter the elements of the second tridiagonal matrix:");
        readTridiagonalMatrix(scanner, matrixB, n);

        // Print the matrices
        System.out.println("First matrix:");
        printMatrix(matrixA, n);
        System.out.println("Second matrix:");
        printMatrix(matrixB, n);

        // Multiply the matrices
        int[][] result = multiplyTridiagonalMatrices(matrixA, matrixB, n);
        System.out.println("Product matrix:");
        printMatrix(result, n);
    }

    private static void readTridiagonalMatrix(Scanner scanner, int[][] matrix, int n) {
        for (int i = 0; i < n; i++) {
            if (i > 0) {
                System.out.print("Enter the value for (" + (i-1) + ", " + i + "): ");
                matrix[i][i-1] = scanner.nextInt();
            }
            System.out.print("Enter the value for (" + i + ", " + i + "): ");
            matrix[i][i] = scanner.nextInt();
            if (i < n - 1) {
                System.out.print("Enter the value for (" + i + ", " + (i+1) + "): ");
                matrix[i][i+1] = scanner.nextInt();
            }
        }
    }

    private static void printMatrix(int[][] matrix, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static int[][] multiplyTridiagonalMatrices(int[][] A, int[][] B, int n) {
        int[][] C = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    // Main diagonal
                    C[i][j] = A[i][j] * B[i][j];
                    if (i > 0) C[i][j] += A[i][i-1] * B[i-1][j];
                    if (i < n - 1) C[i][j] += A[i][i+1] * B[i+1][j];
                } else if (i == j + 1) {
                    // Below main diagonal
                    C[i][j] = A[i][j] * B[i][j];
                    if (j < n - 1) C[i][j] += A[i][i-1] * B[i-1][j];
                } else if (i == j - 1) {
                    // Above main diagonal
                    C[i][j] = A[i][j] * B[i][j];
                    if (j > 0) C[i][j] += A[i][i+1] * B[i+1][j];
                }
            }
        }

        return C;
    }
}
