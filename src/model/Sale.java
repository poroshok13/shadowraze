package model;

public class Sale {

    private double total;

    public Sale() {
        total = 0;
    }

    public void addProduct(Product product) {
        total += product.getPrice();
    }

    public double getTotal() {
        return total;
    }

    public boolean isLargeSale() {
        return total > 20000;
    }
}
