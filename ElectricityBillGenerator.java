import java.util.*;

// Custom Exception for invalid unit entries
class InvalidUnitException extends Exception {
  public InvalidUnitException(String message) {
    super(message);
  }
}

// Interface for electricity bill calculation
interface ElectricityBill {
  double calculateBill(int units) throws InvalidUnitException;

  String getCustomerType();
}

// Domestic customer implementation
class DomesticCustomer implements ElectricityBill {
  private String customerName;
  private String customerId;

  public DomesticCustomer(String name, String id) {
    this.customerName = name;
    this.customerId = id;
  }

  @Override
  public double calculateBill(int units) throws InvalidUnitException {
    if (units < 0) {
      throw new InvalidUnitException("Units cannot be negative: " + units);
    }

    double billAmount = 0;

    // Domestic tariff rates
    if (units <= 100) {
      billAmount = units * 3.0;
    } else if (units <= 200) {
      billAmount = 100 * 3.0 + (units - 100) * 4.5;
    } else if (units <= 300) {
      billAmount = 100 * 3.0 + 100 * 4.5 + (units - 200) * 6.0;
    } else {
      billAmount = 100 * 3.0 + 100 * 4.5 + 100 * 6.0 + (units - 300) * 7.5;
    }

    return billAmount;
  }

  @Override
  public String getCustomerType() {
    return "Domestic";
  }

  public String getCustomerName() {
    return customerName;
  }

  public String getCustomerId() {
    return customerId;
  }
}

// Commercial customer implementation
class CommercialCustomer implements ElectricityBill {
  private String customerName;
  private String customerId;
  private String businessType;

  public CommercialCustomer(String name, String id, String businessType) {
    this.customerName = name;
    this.customerId = id;
    this.businessType = businessType;
  }

  @Override
  public double calculateBill(int units) throws InvalidUnitException {
    if (units < 0) {
      throw new InvalidUnitException("Units cannot be negative: " + units);
    }

    double billAmount = 0;

    // Commercial tariff rates (higher than domestic)
    if (units <= 200) {
      billAmount = units * 5.0;
    } else if (units <= 400) {
      billAmount = 200 * 5.0 + (units - 200) * 7.0;
    } else if (units <= 600) {
      billAmount = 200 * 5.0 + 200 * 7.0 + (units - 400) * 9.0;
    } else {
      billAmount = 200 * 5.0 + 200 * 7.0 + 200 * 9.0 + (units - 600) * 11.0;
    }

    return billAmount;
  }

  @Override
  public String getCustomerType() {
    return "Commercial";
  }

  public String getCustomerName() {
    return customerName;
  }

  public String getCustomerId() {
    return customerId;
  }

  public String getBusinessType() {
    return businessType;
  }
}

// Main class to demonstrate the electricity bill generator
public class ElectricityBillGenerator {
  private Scanner sc;
  private List<ElectricityBill> customers;

  public ElectricityBillGenerator() {
    sc = new Scanner(System.in);
    customers = new ArrayList<>();
  }

  public void addCustomer() {
    System.out.println("\n=== Add New Customer ===");
    System.out.println("1. Domestic Customer");
    System.out.println("2. Commercial Customer");
    System.out.print("Choose customer type: ");

    int choice = getValidIntInput();

    System.out.print("Enter customer name: ");
    String name = sc.nextLine();

    System.out.print("Enter customer ID: ");
    String id = sc.nextLine();

    ElectricityBill customer = null;

    switch (choice) {
      case 1:
        customer = new DomesticCustomer(name, id);
        break;
      case 2:
        System.out.print("Enter business type: ");
        String businessType = sc.nextLine();
        customer = new CommercialCustomer(name, id, businessType);
        break;
      default:
        System.out.println("Invalid choice!");
        return;
    }

    customers.add(customer);
    System.out.println("Customer added successfully!");
  }

  public void generateBill() {
    if (customers.isEmpty()) {
      System.out.println("No customers available. Please add customers first.");
      return;
    }

    System.out.println("\n-=<< Generate Electricity Bill >>=-");
    displayCustomers();

    System.out.print("Select customer (enter index): ");
    int index = getValidIntInput();

    if (index < 0 || index >= customers.size()) {
      System.out.println("Invalid customer index!");
      return;
    }

    ElectricityBill customer = customers.get(index);

    System.out.print("Enter units consumed: ");
    int units = getValidIntInput();

    try {
      double billAmount = customer.calculateBill(units);
      displayBill(customer, units, billAmount);
    } catch (InvalidUnitException e) {
      System.out.println("Error: " + e.getMessage());
    }
  }

  private void displayBill(ElectricityBill customer, int units, double amount) {
    System.out.println("\n -=<< ELECTRICITY BILL >>=-");
    System.out.println("Customer Type: " + customer.getCustomerType());
    System.out.println();

    if (customer instanceof DomesticCustomer) {
      DomesticCustomer domestic = (DomesticCustomer) customer;
      System.out.println("Customer Name: " + domestic.getCustomerName());
      System.out.println("Customer ID: " + domestic.getCustomerId());
      System.out.println();
    } else if (customer instanceof CommercialCustomer) {
      CommercialCustomer commercial = (CommercialCustomer) customer;
      System.out.println("Customer Name: " + commercial.getCustomerName());
      System.out.println("Customer ID: " + commercial.getCustomerId());
      System.out.println("Business Type: " + commercial.getBusinessType());
      System.out.println();
    }

    System.out.println("Units Consumed: " + units);
    System.out.println("Total Amount:   INR " + String.format("%.2f", amount));
    System.out.println();
  }

  private void displayCustomers() {
    System.out.println("\n-=<< Registered Customers >>=-");
    for (int i = 0; i < customers.size(); i++) {
      ElectricityBill customer = customers.get(i);
      System.out.print(i + ". " + customer.getCustomerType() + " - ");

      if (customer instanceof DomesticCustomer) {
        DomesticCustomer domestic = (DomesticCustomer) customer;
        System.out.println(domestic.getCustomerName() + " (" + domestic.getCustomerId() + ")");
      } else if (customer instanceof CommercialCustomer) {
        CommercialCustomer commercial = (CommercialCustomer) customer;
        System.out.println(
            commercial.getCustomerName() + " (" + commercial.getCustomerId() + ") - " + commercial.getBusinessType());
      }
    }
  }

  private int getValidIntInput() {
    while (true) {
      try {
        int input = Integer.parseInt(sc.nextLine());
        return input;
      } catch (NumberFormatException e) {
        System.out.print("Invalid input! Please enter a valid number: ");
      }
    }
  }

  public void displayMenu() {
    System.out.println("\n -=<< Electricity Bill Generator >>=-");
    System.out.println("1. Add Customer");
    System.out.println("2. Generate Bill");
    System.out.println("3. Display All Customers");
    System.out.println("4. Exit");
    System.out.print("Choose an option: ");
  }

  public void run() {
    System.out.println("Welcome to Electricity Bill Generator!");

    while (true) {
      displayMenu();
      int choice = getValidIntInput();

      switch (choice) {
        case 1:
          addCustomer();
          break;
        case 2:
          generateBill();
          break;
        case 3:
          displayCustomers();
          break;
        case 4:
          System.out.println("Thank you for using Electricity Bill Generator!");
          return;
        default:
          System.out.println("Invalid choice! Please try again.");
      }
    }
  }

  public static void main(String[] args) {
    ElectricityBillGenerator generator = new ElectricityBillGenerator();
    generator.run();
  }
}
