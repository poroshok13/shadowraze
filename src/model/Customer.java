package model;

public class Customer {

    private int id;
    private String name;
    private double totalSpent;

    public Customer(int id, String name) {
        this.id = id;
        this.name = name;
        this.totalSpent = 0;
    }

    public void addPurchase(double amount) {
        totalSpent += amount;
    }

    public boolean isVIP() {
        return totalSpent > 100000;
    }

    @Override
    public String toString() {
        return "model.Customer | ID: " + id + ", Name: " + name +
                ", Total spent: " + totalSpent;
    }
}
