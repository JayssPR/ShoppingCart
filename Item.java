public class Item {

    private String name;
    private double price;
    private int stock;

    // Constructor to initialize an item with its name, price, and stock
    public Item(String name, double price, int stock) {
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    // Reduce the stock by a specified quantity
    public void reduceStock(int quantity) {
        stock -= quantity;
    }
}
