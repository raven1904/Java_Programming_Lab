package Java_Programming_Lab;

// Program: Perform addition of two matrices
// Concepts used: 2D array, nested for loops, Scanner input

import java.util.Scanner;

public class lab3 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    // accept matrix dimensions(rows & columns)
    System.out.print("Enter number of rows: ");
    int rows = input.nextInt();
    System.out.print("Enter number of columns: ");
    int cols = input.nextInt();

    // declare two matrices and result matrix
    int[][] mat1 = new int[rows][cols];
    int[][] mat2 = new int[rows][cols];
    int[][] sum = new int[rows][cols];

    // input elements of first matrix
    System.out.println("Enter elements of first matrix:");
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        mat1[i][j] = input.nextInt();
      }
    }

    // input elements of second matrix
    System.out.println("Enter elements of second matrix:");
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        mat2[i][j] = input.nextInt();
      }
    }

    // add
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        sum[i][j] = mat1[i][j] + mat2[i][j];
      }
    }

    // display o/p
    System.out.println("Resultant Matrix after Addition:");
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        System.out.print(sum[i][j] + " ");
      }
      System.out.println(); // new row
    }

    input.close();
  }
}