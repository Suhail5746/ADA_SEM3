import java.util.*;
public class MatrixMultiplication {

    static void input(int[][]a, int n){
        Random rand = new Random();
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                a[i][j]=rand.nextInt(10);
            }
        }
    }

    static void print(int[][]a, int n){
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                System.out.print(a[i][j]+" ");
            }
            System.out.println();
        }
    }

    static int[][] directMultiply(int[][]a, int[][]b, int n){
        int[][]c = new int[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                c[i][j]=0;
                for(int k=0; k<n; k++){
                    c[i][j]+=a[i][k]*b[k][j];
                }
            }
        }
        return c;
    }
    static int[][] add(int[][]a, int[][]b, int n)
    {
        int[][] c = new int[n][n];
        for(int i=0; i<n; i++)
            for(int j=0; j<n; j++)
                c[i][j]=a[i][j]+b[i][j];
        return c;
    }

    static int[][] sub(int[][]a, int[][]b, int n)
    {
        int[][] c = new int[n][n];
        for(int i=0; i<n; i++)
            for(int j=0; j<n; j++)
                c[i][j]=a[i][j]-b[i][j];
        return c;
    }
    static int[][] divideAndConquer(int[][]a, int[][]b, int n){
        if(n>1){
            int[][] A11 = new int[n/2][n/2];
            int[][] A12 = new int[n/2][n/2];
            int[][] A21 = new int[n/2][n/2];
            int[][] A22 = new int[n/2][n/2];
            int[][] B11 = new int[n/2][n/2];
            int[][] B12 = new int[n/2][n/2];
            int[][] B21 = new int[n/2][n/2];
            int[][] B22 = new int[n/2][n/2];
            int[][] C = new int[n][n];
            for(int i=0; i<n/2; i++)
                for(int j=0; j<n/2; j++){
                    A11[i][j]=a[i][j];
                    A12[i][j]=a[i][j+n/2];
                    A21[i][j]=a[i+n/2][j];
                    A22[i][j]=a[i+n/2][j+n/2];
                    B11[i][j]=b[i][j];
                    B12[i][j]=b[i][j+n/2];
                    B21[i][j]=b[i+n/2][j];
                    B22[i][j]=b[i+n/2][j+n/2];
                }
            int[][] C11 = add(divideAndConquer(A11, B11, n/2), divideAndConquer(A12, B21, n/2), n/2);
            int[][] C12 = add(divideAndConquer(A11, B12, n/2), divideAndConquer(A12, B22, n/2), n/2);
            int[][] C21 = add(divideAndConquer(A21, B11, n/2), divideAndConquer(A22, B21, n/2), n/2);
            int[][] C22 = add(divideAndConquer(A21, B12, n/2), divideAndConquer(A22, B22, n/2), n/2);
            for(int i=0; i<n/2; i++)
                for(int j=0; j<n/2; j++){
                    C[i][j]=C11[i][j];
                    C[i][j+n/2]=C12[i][j];
                    C[i+n/2][j]=C21[i][j];
                    C[i+n/2][j+n/2]=C22[i][j];
                }
            return C;
        }else{
            int [][]c = new int[1][1];
            c[0][0]=a[0][0]*b[0][0];
            return c;
        }
    }
    static int[][] strassen(int[][]a, int[][]b, int n){
        if(n>1){
            int[][] A11 = new int[n/2][n/2];
            int[][] A12 = new int[n/2][n/2];
            int[][] A21 = new int[n/2][n/2];
            int[][] A22 = new int[n/2][n/2];
            int[][] B11 = new int[n/2][n/2];
            int[][] B12 = new int[n/2][n/2];
            int[][] B21 = new int[n/2][n/2];
            int[][] B22 = new int[n/2][n/2];
            int[][] C = new int[n][n];
            for(int i=0; i<n/2; i++)
                for(int j=0; j<n/2; j++){
                    A11[i][j]=a[i][j];
                    A12[i][j]=a[i][j+n/2];
                    A21[i][j]=a[i+n/2][j];
                    A22[i][j]=a[i+n/2][j+n/2];
                    B11[i][j]=b[i][j];
                    B12[i][j]=b[i][j+n/2];
                    B21[i][j]=b[i+n/2][j];
                    B22[i][j]=b[i+n/2][j+n/2];
                }
            int[][] M1=strassen(add(A11, A22, n/2), add(B11, B22, n/2), n/2);
            int[][] M2=strassen(add(A21, A22, n/2), B11, n/2);
            int[][] M3=strassen(A11, sub(B12, B22,n/2), n/2);
            int[][] M4 = strassen(A22, sub(B21, B11, n/2), n/2);
            int[][] M5 = strassen(add(A11, A12, n/2), B22, n/2);
            int[][] M6 = strassen(sub(A21, A11, n/2), add(B11, B12, n/2), n/2);
            int[][] M7 = strassen(sub(A12, A22, n/2), add(B21, B22, n/2), n/2);
            int[][] C11 = add(sub(add(M1, M4, n/2), M5, n/2), M7, n/2);
            int[][] C12 = add(M3, M5, n/2);
            int[][] C21 = add(M2, M4, n/2);
            int[][] C22 = add(sub(add(M1, M3, n/2), M2, n/2), M6, n/2);
            for(int i=0; i<n/2; i++)
                for(int j=0; j<n/2; j++){
                    C[i][j]=C11[i][j];
                    C[i][j+n/2]=C12[i][j];
                    C[i+n/2][j]=C21[i][j];
                    C[i+n/2][j+n/2]=C22[i][j];
                }
            return C;
        }
        else{
            int[][] c = new int[1][1];
            c[0][0]=a[0][0]*b[0][0];
            return c;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the order of the matrix:");
        int n=sc.nextInt();
        int[][] a = new int[n][n];
        int[][] b = new int[n][n];
        input(a, n);
        input(b, n);
        System.out.println("\nMatrix A: ");
        print(a, n);
        System.out.println("\nMatrix B: ");
        print(b, n);
        int[][] product = directMultiply(a, b, n);
        System.out.println("\nResult from Direct Multiplication:");
        print(product, n);
        int[][] c = divideAndConquer(a, b, n);
        System.out.println("\nResult from Divide and Conquer:");
        print(c, n);
        int[][] d = strassen(a, b, n);
        System.out.println("\nResult from Strassen:");
        print(d, n);
        sc.close();
    }
}

