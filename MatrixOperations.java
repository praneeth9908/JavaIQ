public class MatrixOperations {

    public static int[][] additionMatrix(int[][] A, int[][] B){
        int rows = A.length;
        int cols = A[0].length;
        // int res[][] = new int[rows][cols];  
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                A[i][j] += B[i][j];
            }
        }

        return A;
    }

    public static int[][] multiplicationMatrix(int[][] A, int[][] B){
        int rowsA = A.length;
        int colsA = A[0].length;
        int colsB = B[0].length;
        int res[][] = new int[rowsA][colsB];  
        for(int i=0; i<rowsA; i++){
            for(int j=0; j<colsB; j++){
                for(int k=0; k<colsA; k++){
                    res[i][j] += A[i][k] * B[k][j];
                }
            }
        }

        return res;
    }

    public static int[][] transposeMatrix(int[][] A){
        int rows = A.length;
        // int cols = A[0].length;
        for(int i=0; i<rows; i++){
            for(int j=0; j<=i; j++){
                int temp = A[i][j];
                A[i][j] = A[j][i];
                A[j][i] = temp;
            }
        }
        return A;
    }

    public static void printDoubleArray(int arr[][]){
        for(int i = 0; i < arr.length; i++){
            for(int j=0; j< arr[0].length; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
    
    public static void main(String[] args) {
        int[][] arr1 = {{1,2,3},{4,5,6},{7,8,9}};
        int[][] arr2 = {{1,1,1},{1,1,1},{1,1,1}};

        int[][] out1 = additionMatrix(arr1, arr2);
        printDoubleArray(out1);

        // int out2[][] = multiplicationMatrix(arr1, arr2);
        // printDoubleArray(out2);

    //     System.out.println("Original:-");
    //     printDoubleArray(arr1);
    //     int out3[][] = transposeMatrix(arr1);
    //     System.out.println("Transposed:-");
    //     printDoubleArray(out3);
    }
}
