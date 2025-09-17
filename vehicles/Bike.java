package Java_Programming_Lab.vehicles;

public class Bike extends Vehicle {
  private boolean hasGear;

  public Bike(String brand, String model, int year, boolean hasGear) {
    super(brand, model, year);
    this.hasGear = hasGear;
  }

  // Method overriding
  @Override
  public void displayDetails() {
    System.out.println("Bike -> Brand: " + brand + ", Model: " + model +
        ", Year: " + year + ", Has Gear: " + hasGear);
  }
}
