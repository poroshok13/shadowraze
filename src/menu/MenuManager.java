package menu;

import dao.EmployeeDAO;
import exception.InvalidInputException;
import model.*;
import java.util.Scanner;
import java.util.List;

public class MenuManager implements Menu {
    private final Scanner sc = new Scanner(System.in);
    private final EmployeeDAO employeeDAO = new EmployeeDAO();

    @Override
    public void displayMenu() {
        System.out.println("\n=== STAFF MANAGEMENT (Week 8) ===");
        System.out.println("1) Add Cashier");
        System.out.println("2) View All Staff");
        System.out.println("3) Update Staff");
        System.out.println("4) Delete Staff");
        System.out.println("5) Search by Name");
        System.out.println("6) Search by Salary Range");
        System.out.println("7) High-Paid Staff (Min)");
        System.out.println("8) Polymorphism Demo");
        System.out.println("9) Add Product (Stub)");
        System.out.println("10) View Products (Stub)");
        System.out.println("11) About System");
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
                    case 3 -> updateStaff();
                    case 4 -> deleteStaff();
                    case 5 -> searchByName();
                    case 6 -> searchBySalaryRange();
                    case 7 -> searchByMinSalary();
                    case 8 -> demoWork();
                    case 0 -> { return; }
                    default -> System.out.println("Wrong number");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    private void deleteStaff() throws InvalidInputException {
        int id = readInt("Enter ID to delete: ");
        Employee e = employeeDAO.getById(id);
        if (e == null) {
            System.out.println("Staff not found");
            return;
        }
        System.out.println("Deleting: " + e);
        System.out.print("Are you sure? (yes/no): ");
        if (sc.nextLine().equalsIgnoreCase("yes")) {
            if (employeeDAO.deleteById(id)) System.out.println("Deleted successfully");
        } else {
            System.out.println("Cancelled");
        }
    }

    private void updateStaff() throws InvalidInputException {
        int id = readInt("Enter ID to update: ");
        Employee existing = employeeDAO.getById(id);
        if (existing == null) return;

        System.out.println("Current: " + existing);

        System.out.print("New Name [" + existing.getName() + "]: ");
        String name = sc.nextLine();
        if (name.isEmpty()) name = existing.getName();

        System.out.print("New Salary [" + existing.getSalary() + "]: ");
        String salStr = sc.nextLine();
        double salary = salStr.isEmpty() ? existing.getSalary() : Double.parseDouble(salStr);

        int reg = ((Cashier)existing).getRegisterNumber();

        if (employeeDAO.updateCashier(new Cashier(id, name, salary, reg))) {
            System.out.println("Updated!");
        }
    }

    private void searchByName() {
        String name = readLine("Enter name part: ");
        printList(employeeDAO.searchByName(name));
    }

    private void searchBySalaryRange() throws InvalidInputException {
        double min = readDouble("Min salary: ");
        double max = readDouble("Max salary: ");
        printList(employeeDAO.searchBySalaryRange(min, max));
    }

    private void searchByMinSalary() throws InvalidInputException {
        double min = readDouble("Enter min salary: ");
        printList(employeeDAO.searchByMinSalary(min));
    }

    private void printList(List<Employee> list) {
        if (list.isEmpty()) System.out.println("Nothing found");
        else list.forEach(System.out::println);
    }

    private void viewEmployees() {
        printList(employeeDAO.getAll());
    }

    private void demoWork() {
        employeeDAO.getAll().forEach(Employee::work);
    }

    private String readLine(String label) { System.out.print(label); return sc.nextLine(); }
    private int readInt(String label) throws InvalidInputException {
        try { return Integer.parseInt(readLine(label).trim()); }
        catch (Exception e) { throw new InvalidInputException("Integer required"); }
    }
    private double readDouble(String label) throws InvalidInputException {
        try { return Double.parseDouble(readLine(label).trim()); }
        catch (Exception e) { throw new InvalidInputException("Decimal required"); }
    }

    private void addCashier() throws InvalidInputException {
        int id = readInt("ID: ");
        String name = readLine("Name: ");
        double salary = readDouble("Salary: ");
        int reg = readInt("Register: ");
        employeeDAO.insertCashier(new Cashier(id, name, salary, reg));
    }
}