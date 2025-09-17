public class diamond {
  public static void main(String[] args) {
    int[] pattern = { 1, 2, 4, 6 };

    int max = pattern[pattern.length - 1]; // maximum stars (6 here)

    // Upper half including middle
    for (int stars : pattern) {
      int spaces = max - stars;

      // print spaces
      for (int s = 0; s < spaces; s++) {
        System.out.print(" ");
      }

      // print stars (no extra space at end)
      for (int j = 0; j < stars; j++) {
        System.out.print("* ");
      }

      System.out.println();
    }

    // Lower half (mirror, skip middle row)
    for (int i = pattern.length - 2; i >= 0; i--) {
      int stars = pattern[i];
      int spaces = max - stars;

      // print spaces
      for (int s = 0; s < spaces; s++) {
        System.out.print(" ");
      }

      // print stars
      for (int j = 0; j < stars; j++) {
        System.out.print("* ");
      }

      System.out.println();
    }
  }
}