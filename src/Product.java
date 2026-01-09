public class Product {

    private int id;
    private String name;
    private double price;

    public Product(int id, String name, double price) {
        setId(id);
        setName(name);
        setPrice(price);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if (id <= 0) {
            System.out.println("Invalid product ID");
            return;
        }
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.isEmpty()) {
            System.out.println("Product name cannot be empty");
            return;
        }
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price < 0) {
            System.out.println("Price cannot be negative");
            return;
        }
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product | ID: " + id + ", Name: " + name + ", Price: " + price;
    }
}
