package Java_Programming_Lab;
// Program: Calculator for arithmetic operations using switch-case and do-while loop

import java.util.Scanner; // Import Scanner class for user input

public class lab1 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in); // Create Scanner object
    char choice; // store user's choice (Y/N)

    do {
      // Taking two numbers(operands) as input
      System.out.print("Enter first number: ");
      double num1 = sc.nextDouble();

      System.out.print("Enter second number: ");
      double num2 = sc.nextDouble();

      // Menu for arithmetic operations(to choose the operator)
      System.out.println("\n--- Calculator Menu ---");
      System.out.println("1. Addition (+)");
      System.out.println("2. Subtraction (-)");
      System.out.println("3. Multiplication (*)");
      System.out.println("4. Division (/)");
      System.out.println("5. Modulus (%)");
      System.out.print("Choose an operation (1-5): ");
      int option = sc.nextInt();

      double result; // store result

      // Perform operations
      switch (option) {
        case 1:
          result = num1 + num2;
          System.out.println("Result = " + result);
          break;
        case 2:
          result = num1 - num2;
          System.out.println("Result = " + result);
          break;
        case 3:
          result = num1 * num2;
          System.out.println("Result = " + result);
          break;
        case 4:
          // Handling division by zero
          if (num2 != 0) {
            result = num1 / num2;
            System.out.println("Result = " + result);
          } else {
            System.out.println("Error! Division by zero is not allowed.");
          }
          break;
        case 5:
          result = num1 % num2;
          System.out.println("Result = " + result);
          break;
        default:
          System.out.println("Invalid option! Please choose between 1-5.");
      }

      // Asking user whether to continue or exit
      System.out.print("\nDo you want to perform another calculation? (Y/N): ");
      choice = sc.next().charAt(0);

    } while (choice == 'Y' || choice == 'y'); // Continue loop if user enters Y/y

    System.out.println("Calculator closed. Thank you!");
    sc.close(); // Close scanner- must do after using scanner class
  }
}