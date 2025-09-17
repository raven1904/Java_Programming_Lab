package Java_Programming_Lab;

// Program: ATM Machine Simulation with PIN authentication and Transaction History
// Concepts: Encapsulation, Classes, Objects, Methods, Static Members, Custom Exception, Checked & Unchecked Exceptions, ArrayList for transaction history

import java.util.*;

//custom checked exception for insufficient balance
//exception must be either caught or declared in the method signature using throws
class InsufficientBalanceException extends Exception {
  // constructor
  public InsufficientBalanceException(String message) {
    super(message);
  }
}

// Account class- performs encapsulation
class Account {
  private int accountNumber;
  private String accountHolder;
  private double balance;
  private int pin;

  private ArrayList<String> transactionHistory = new ArrayList<>();

  private static int userCount;
  private static int nextAccountNumber = 1000; // Start from 1001

  static {
    userCount = 0;
    System.out.println("-=<< Welcome to ATM Simulation System >>=-");
  }

  // constructor for new accounts (auto-assign account number)
  public Account(String accountHolder, double balance, int pin) {
    this.accountNumber = ++nextAccountNumber; // auto-generated
    this.accountHolder = accountHolder;
    this.balance = balance;
    this.pin = pin;
    userCount++;
  }

  // overloaded constructor for pre-defined accounts (manual account numbers
  // allowed if needed)
  public Account(int accountNumber, String accountHolder, double balance, int pin) {
    this.accountNumber = accountNumber;
    this.accountHolder = accountHolder;
    this.balance = balance;
    this.pin = pin;
    userCount++;
    if (accountNumber > nextAccountNumber) {
      nextAccountNumber = accountNumber; // keep sequence consistent
    }
  }

  public int getAccountNumber() {
    return accountNumber;
  }

  public boolean authenticate(int enteredPin) {
    return this.pin == enteredPin;
  }

  public void deposit(double amount) {
    balance += amount;
    String record = "Deposited: " + amount + " | Balance: " + balance;
    transactionHistory.add(record);
    System.out.println(record);
  }

  public void withdraw(double amount) throws InsufficientBalanceException {
    if (amount > balance) {
      throw new InsufficientBalanceException("You're broke!! Go earn some money *__*");
    }
    balance -= amount;
    String record = "Withdrew: " + amount + " | Balance: " + balance;
    transactionHistory.add(record);
    System.out.println(record);
  }

  public void checkBalance() {
    String record = "Your current balance is: " + balance;
    transactionHistory.add(record);
    System.out.println(record);
  }

  public void showTransactionHistory() {
    System.out.println("\nTransaction history for " + accountHolder + " (Acc No: " + accountNumber + "): ");
    if (transactionHistory.isEmpty()) {
      System.out.println("No transactions performed yet!");
    } else {
      for (String transaction : transactionHistory) {
        System.out.println(transaction);
      }
    }
  }

  public static void showUserCount() {
    System.out.println("Total ATM users so far: " + userCount);
  }

}

// Main class
public class ATM {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    // Store accounts in a HashMap
    Map<Integer, Account> accounts = new HashMap<>();

    // Pre-existing accounts
    accounts.put(1001, new Account(1001, "Anand", 5000.0, 1234));
    accounts.put(1002, new Account(1002, "Cassie", 3000.0, 5678));

    while (true) {
      System.out.println("\n=== ATM Main Menu ===");
      System.out.println("1. Login to Account");
      System.out.println("2. Create New Account");
      System.out.println("3. Exit");
      System.out.print("Enter your choice: ");
      int mainChoice = sc.nextInt(  );

      if (mainChoice == 1) {
        // ---- Login flow ----
        System.out.print("Enter your account number: ");
        int accNum = sc.nextInt();

        Account currentAcc = accounts.get(accNum);
        if (currentAcc == null) {
          System.out.println("Account not found.");
          continue; // Back to main menu
        }

        System.out.print("Enter your PIN: ");
        int enteredPin = sc.nextInt();
        if (!currentAcc.authenticate(enteredPin)) {
          System.out.println("Incorrect PIN. Returning to menu...");
          continue;
        }
        System.out.println("Authentication successful!\n");

        int option;
        do {
          System.out.println("\nATM Menu:");
          System.out.println("1. Deposit");
          System.out.println("2. Withdraw");
          System.out.println("3. Balance Inquiry");
          System.out.println("4. Show Transaction History");
          System.out.println("5. Logout");
          System.out.print("Enter your choice: ");
          option = sc.nextInt();

          try {
            switch (option) {
              case 1:
                System.out.print("Enter deposit amount: ");
                double depositAmt = sc.nextDouble();
                currentAcc.deposit(depositAmt);
                break;

              case 2:
                System.out.print("Enter withdrawal amount: ");
                double withdrawAmt = sc.nextDouble();
                currentAcc.withdraw(withdrawAmt);
                break;

              case 3:
                currentAcc.checkBalance();
                break;

              case 4:
                currentAcc.showTransactionHistory();
                break;

              case 5:
                System.out.println("Logging out...");
                break;

              default:
                throw new IllegalArgumentException("Invalid option! Try again.");
            }
          } catch (InsufficientBalanceException e) {
            System.out.println("Exception: " + e.getMessage());
          } catch (IllegalArgumentException e) {
            System.out.println("Runtime Exception: " + e.getMessage());
          }
        } while (option != 5);

      } else if (mainChoice == 2) {
        // ---- Account creation flow ----
        sc.nextLine(); // consume newline
        System.out.print("Enter account holder name: ");
        String name = sc.nextLine();

        System.out.print("Enter initial balance: ");
        double balance = sc.nextDouble();

        System.out.print("Set your 4-digit PIN: ");
        int pin = sc.nextInt();

        // auto-assign account number
        Account newAcc = new Account(name, balance, pin);
        accounts.put(newAcc.getAccountNumber(), newAcc);

        System.out.println("Account created successfully!");
        System.out.println("Your Account Number is: " + newAcc.getAccountNumber());
      } else if (mainChoice == 3) {
        System.out.println("Thank you for using the ATM. Goodbye!");
        break;
      } else {
        System.out.println("Invalid option! Try again.");
      }
    }

    Account.showUserCount(); // Show number of users created
    sc.close();
  }
}
