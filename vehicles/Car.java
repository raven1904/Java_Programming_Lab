package Java_Programming_Lab.vehicles;

public class Car extends Vehicle {
    private int seatingCapacity;

    public Car(String brand, String model, int year, int seatingCapacity) {
        super(brand, model, year); // call to base constructor
        this.seatingCapacity = seatingCapacity;
    }

    // Method overriding
    @Override
    public void displayDetails() {
        System.out.println("Car -> Brand: " + brand + ", Model: " + model +
                           ", Year: " + year + ", Seating Capacity: " + seatingCapacity);
    }
}
