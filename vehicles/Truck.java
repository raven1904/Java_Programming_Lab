package Java_Programming_Lab.vehicles;

public class Truck extends Vehicle {
  private double loadCapacity;

  public Truck(String brand, String model, int year, double loadCapacity) {
    super(brand, model, year);
    this.loadCapacity = loadCapacity;
  }

  // Method overriding
  @Override
  public void displayDetails() {
    System.out.println("Truck -> Brand: " + brand + ", Model: " + model +
        ", Year: " + year + ", Load Capacity: " + loadCapacity + " tons");
  }
}
