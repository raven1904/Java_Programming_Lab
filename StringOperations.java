

import java.util.Scanner; //for user input
// Program: Demonstrate String class operations and Boxing/Unboxing concepts in Java

public class StringOperations {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    // String class opertaions
    System.out.println("-=<<String Operations in Java >>=-");

    // input 2 strings from user
    System.out.println("Enter frist string: ");
    String str1 = sc.nextLine();

    System.out.println("Enter second string: ");
    String str2 = sc.nextLine();

    // string methods
    System.out.println("\n--- Results of String Methods ---");

    // returns length
    System.out.println("Length of first string: " + str1.length());
    System.out.println("First string in Uppercase: " + str1.toUpperCase());
    System.out.println("Second string in Lowercase: " + str2.toLowerCase());
    System.out.println("Concatenation of both: " + str1.concat(" " + str2));
    System.out.println("Does first string equal second string? " + str1.equals(str2));
    System.out.println("Does first string contain 'a'? " + str1.contains("a"));
    System.out.println("Substring of first string (0 to 3): " + str1.substring(0, 3));

    System.out.println("\n=== Boxing and Unboxing ===");

    int num = 25; // Primitive type
    Integer boxedNum = Integer.valueOf(num); // BOXING: converting primitive -> object
    System.out.println("Boxed Integer object: " + boxedNum);

    Integer autoBoxed = num; // AUTO-BOXING (Java does it automatically)
    System.out.println("Auto-Boxed Integer object: " + autoBoxed);

    int unBoxedNum = boxedNum.intValue(); // UNBOXING: object -> primitive
    System.out.println("Unboxed int value: " + unBoxedNum);

    int autoUnboxed = autoBoxed; // AUTO-UNBOXING
    System.out.println("Auto-Unboxed int value: " + autoUnboxed);

    sc.close();
  }
}
