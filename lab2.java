
// Program: Count number of even and odd elements in an array
// Concepts used: for loop, if-else statements, single-dimensional array

import java.util.Scanner;

public class lab2 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    // Take size of array from user
    System.out.print("Enter size of the array: ");
    int size = input.nextInt();

    // Create array of given size
    int[] arr = new int[size];

    // take array elements from user
    System.out.println("Enter " + size + " elements (space seperated):");
    int entered = 0; // track number of elements entered

    // handles cases where user enters less or more elements
    while (entered < size) { // loop until the size of array reaches given size

      if (input.hasNextInt()) { // if there is a next valid number
        arr[entered] = input.nextInt();
        entered++;
      } else {
        System.out.println("Invalid input. Please enter an integer:");
        input.next(); // discard invalid input
      }
    }

    // counters for even and odd
    int evenCount = 0;
    int oddCount = 0;

    // Linear traversal to check even/odd
    for (int i = 0; i < size; i++) {
      if (arr[i] % 2 == 0) {
        evenCount++;
      } else {
        oddCount++;
      }
    }

    // display results
    System.out.println("\nNumber of even elements = " + evenCount);
    System.out.println("Number of odd elements = " + oddCount);

    input.close(); // Close scanner
  }
}