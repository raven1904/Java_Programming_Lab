
public class addMatrix {
  public static void main(String[] args) {
    if (args.length < 2) {
      System.out.println("Usage: java Java_Programming_Lab.addMatrix <rows> <cols> <mat1 elements> <mat2 elements>");
      return;
    }

    int rows = Integer.parseInt(args[0]);
    int cols = Integer.parseInt(args[1]);
    int totalElements = rows * cols;

    if (args.length != 2 + 2 * totalElements) {
      System.out.println("Error: Please provide correct number of matrix elements.");
      return;
    }

    int[][] mat1 = new int[rows][cols];
    int[][] mat2 = new int[rows][cols];
    int[][] sum = new int[rows][cols];

    // Fill mat1
    int idx = 2;
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        mat1[i][j] = Integer.parseInt(args[idx++]);
      }
    }

    // Fill mat2
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        mat2[i][j] = Integer.parseInt(args[idx++]);
      }
    }

    // Add matrices
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        sum[i][j] = mat1[i][j] + mat2[i][j];
      }
    }

    // Display result
    System.out.println("Matrix after Addition:");
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        System.out.print(sum[i][j] + " ");
      }
      System.out.println();
    }
  }
}