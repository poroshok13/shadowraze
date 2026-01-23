package menu;

import exception.InvalidInputException;
import model.*;

import java.util.ArrayList;
import java.util.Scanner;

public class MenuManager implements Menu {

    private final Scanner sc = new Scanner(System.in);
    private final ArrayList<Employee> employees = new ArrayList<>();
    private final ArrayList<Product> products = new ArrayList<>();

    @Override
    public void displayMenu() {
        System.out.println("\n=== Grocery Store ===");
        System.out.println("1) Add cashier");
        System.out.println("2) View employees");
        System.out.println("3) Add product");
        System.out.println("4) View products");
        System.out.println("5) Polymorphism demo (work)");
        System.out.println("0) Exit");
    }

    @Override
    public void run() {
        while (true) {
            displayMenu();

            try {
                int choice = readInt("Choice: ");

                switch (choice) {
                    case 1 -> addCashier();
                    case 2 -> viewEmployees();
                    case 3 -> addProduct();
                    case 4 -> viewProducts();
                    case 5 -> demoWork();
                    case 0 -> { sc.close(); return; }
                    default -> System.out.println("Wrong menu number");
                }

            } catch (InvalidInputException e) {
                System.out.println("Input error: " + e.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    private void addCashier() throws InvalidInputException {
        int id = readInt("ID: ");
        String name = readLine("Name: ");
        double salary = readDouble("Salary: ");
        int reg = readInt("Register: ");

        employees.add(new Cashier(id, name, salary, reg));
        System.out.println("✅ Cashier added");
    }

    private void addProduct() throws InvalidInputException {
        int id = readInt("ID: ");
        String name = readLine("Name: ");
        double price = readDouble("Price: ");

        products.add(new Product(id, name, price));
        System.out.println("✅ Product added");
    }

    private void viewEmployees() {
        if (employees.isEmpty()) {
            System.out.println("No employees yet");
            return;
        }
        for (Employee e : employees) System.out.println(e);
    }

    private void viewProducts() {
        if (products.isEmpty()) {
            System.out.println("No products yet");
            return;
        }
        for (Product p : products) System.out.println(p);
    }

    private void demoWork() {
        if (employees.isEmpty()) {
            System.out.println("No employees yet");
            return;
        }
        for (Employee e : employees) e.work();
    }

    private String readLine(String label) {
        System.out.print(label);
        return sc.nextLine();
    }

    private int readInt(String label) throws InvalidInputException {
        try {
            return Integer.parseInt(readLine(label).trim());
        } catch (NumberFormatException e) {
            throw new InvalidInputException("Expected integer number");
        }
    }

    private double readDouble(String label) throws InvalidInputException {
        try {
            return Double.parseDouble(readLine(label).trim());
        } catch (NumberFormatException e) {
            throw new InvalidInputException("Expected decimal number");
        }
    }
}
