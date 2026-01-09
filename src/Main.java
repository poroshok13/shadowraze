import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static ArrayList<Employee> employees = new ArrayList<>();
    static ArrayList<Product> products = new ArrayList<>();

    public static void main(String[] args) {

        int choice;

        do {
            System.out.println("\n=== Grocery Store Menu ===");
            System.out.println("1. Add Cashier");
            System.out.println("2. View Employees");
            System.out.println("3. Add Product");
            System.out.println("4. View Products");
            System.out.println("5. Demonstrate Polymorphism");
            System.out.println("0. Exit");

            choice = sc.nextInt();

            switch (choice) {
                case 1 -> addCashier();
                case 2 -> viewEmployees();
                case 3 -> addProduct();
                case 4 -> viewProducts();
                case 5 -> demonstratePolymorphism();
            }

        } while (choice != 0);
    }

    static void addCashier() {
        System.out.print("ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Name: ");
        String name = sc.nextLine();

        System.out.print("Salary: ");
        double salary = sc.nextDouble();

        System.out.print("Register number: ");
        int reg = sc.nextInt();

        employees.add(new Cashier(id, name, salary, reg));
    }

    static void viewEmployees() {
        for (Employee e : employees) {
            System.out.println(e);
        }
    }

    static void addProduct() {
        System.out.print("ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Name: ");
        String name = sc.nextLine();

        System.out.print("Price: ");
        double price = sc.nextDouble();

        products.add(new Product(id, name, price));
    }

    static void viewProducts() {
        for (Product p : products) {
            System.out.println(p);
        }
    }

    static void demonstratePolymorphism() {
        for (Employee e : employees) {
            e.work(); // ← ПОЛИМОРФИЗМ
        }
    }
}
