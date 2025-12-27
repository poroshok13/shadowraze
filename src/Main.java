public class Main {
    public static void main(String[] args) {

        System.out.println("=== Grocery Store Management System ===\n");

            Product p1 = new Product(1, "Milk", 650, 20);
        Product p2 = new Product(2, "Bread", 200, 0);

        Customer c1 = new Customer(101, "Danil", "Regular", 90000);
        Customer c2 = new Customer(102, "Madiyar", "Gold", 150000);

        Sale s1 = new Sale(1001, "Danil", 0, "26.12.2025");

        System.out.println("--- PRODUCTS ---");
        System.out.println(p1);
        System.out.println(p2);

        System.out.println("\n--- CUSTOMERS ---");
        System.out.println(c1);
        System.out.println(c2);

        System.out.println("\n--- SALE ---");
        System.out.println(s1);

        System.out.println("\n--- TESTING METHODS ---");
        System.out.println("Milk in stock: " + p1.isInStock());
        p2.restock(15);
        System.out.println("Bread after restock: " + p2.getStockQuantity());

        s1.addItem(p1.getPrice());
        s1.addItem(1000);
        System.out.println("Sale total: " + s1.getTotalAmount());
        System.out.println("Large sale: " + s1.isLargeSale());

        c1.addPurchase(s1.getTotalAmount());
        System.out.println("Danil VIP: " + c1.isVIP());

        System.out.println("\n=== Program Complete ===");
    }
}
