package Java_Programming_Lab;
import vehicles.*;
import java.util.*;

public class MainVehicle {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    // Using dynamic method dispatch (base class reference, subclass object)
    MainVehicle v;

    System.out.println("=== Vehicle Management System ===");
    System.out.println("Choose a vehicle type: 1. Car  2. Bike  3. Truck");
    int choice = sc.nextInt();

    switch (choice) {
      case 1:
        v = new Car("Toyota", "Corolla", 2020, 5);
        break;
      case 2:
        v = new Bike("Honda", "Shine", 2021, true);
        break;
      case 3:
        v = new Truck("Tata", "LPT 1618", 2019, 10.5);
        break;
      default:
        System.out.println("Invalid choice! Defaulting to Car.");
        v = new Car("Maruti", "Swift", 2022, 5);
    }

    // Dynamic Method Dispatch: base class reference calling overridden method
    v.displayDetails();

    sc.close();
  }
}
