package model;

public class Product implements Sellable {
    private int id;
    private String name;
    private double price;

    public Product(int id, String name, double price) {
        setId(id);
        setName(name);
        setPrice(price);
    }

    public void setId(int id) {
        if (id <= 0) throw new IllegalArgumentException("Product ID must be > 0");
        this.id = id;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) throw new IllegalArgumentException("Product name is empty");
        this.name = name.trim();
    }

    public void setPrice(double price) {
        if (price < 0) throw new IllegalArgumentException("Price < 0");
        this.price = price;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Product | " + id + " | " + name + " | " + price;
    }
}
