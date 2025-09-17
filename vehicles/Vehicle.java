package vehicles;

// Abstract base class
public abstract class Vehicle {
    protected String brand;
    protected String model;
    protected int year;

    // Constructor
    public Vehicle(String brand, String model, int year) {
        this.brand = brand;
        this.model = model;
        this.year = year;
    }

    // Abstract method (must be overridden by subclasses)
    public abstract void displayDetails();
}
