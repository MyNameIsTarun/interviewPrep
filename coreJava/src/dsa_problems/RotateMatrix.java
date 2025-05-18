package dsa_problems;

/*
 * Rotate a matrix by 90 degree in clock wise direction
 * 
 * O(n*n) time, O(1) space
 */
public class RotateMatrix {

	public static void main(String[] args) {
		
		int [][]matrix3 = new int[3][3];
		int [][]matrix4 = new int[4][4];
		int count = 1;
		
		for(int i=0; i<matrix3.length; i++) {
			for(int j=0; j<matrix3[0].length; j++) {
				matrix3[i][j] = count++;
			}
		}
		
		count = 1;
		for(int i=0; i<matrix4.length; i++) {
			for(int j=0; j<matrix4[0].length; j++) {
				matrix4[i][j] = count++;
			}
		}
		
		printMatrix(matrix3);
		System.out.println("------------------- rotate right by 90deg ----------------------");
		rotateRightBy90Deg(matrix3);
		printMatrix(matrix3);
		
		System.out.println();
		
		printMatrix(matrix4);
		System.out.println("------------------- rotate left by 90deg ----------------------");
		rotateLeftBy90Deg(matrix4);
		printMatrix(matrix4);

	}

	private static void rotateRightBy90Deg(int[][] matrix) {
		
		int temp;
		// First: Transpose of matrix
		for(int i=0; i<matrix.length; i++) {
			for(int j=i; j<matrix[i].length; j++) {
				if(i != j) {
					temp = matrix[i][j];
					matrix[i][j] = matrix[j][i];
					matrix[j][i] = temp;
				}
			}
		}
		
		// Second: swap columns
		int l, r, col = matrix[0].length;
		
		// For each row swap column values
		for(int row=0; row<matrix.length; row++) {
			l = 0;
			r = col-1;
			while(l < r) {
				temp = matrix[row][l];
				matrix[row][l] = matrix[row][r];
				matrix[row][r] = temp;
				l++; r--;
			}
		}
		
	}

	private static void rotateLeftBy90Deg(int[][] matrix) {
		int temp;
		// First: Transpose of matrix
		for(int i=0; i<matrix.length; i++) {
			for(int j=i; j<matrix[i].length; j++) {
				if(i != j) {
					temp = matrix[i][j];
					matrix[i][j] = matrix[j][i];
					matrix[j][i] = temp;
				}
			}
		}
		
		// Second: swap rows
		int t, b, row = matrix.length;
		
		// For each column swap row values
		for(int col=0; col<matrix[0].length; col++) {
			t=0;
			b=row-1;
			
			while(t < b) {
				temp = matrix[t][col];
				matrix[t][col] = matrix[b][col];
				matrix[b][col] = temp;
				t++;
				b--;
			}
		}
		
	}

	private static void printMatrix(int[][] matrix) {
		
		for(int i=0; i<matrix.length; i++) {
			for(int j=0; j<matrix[i].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
		
	}

}
