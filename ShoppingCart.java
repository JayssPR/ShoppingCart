import java.util.ArrayList;

public class ShoppingCart {

    // List to store the names of items added to the cart
    private ArrayList<String> cart = new ArrayList<>();

    // Array of items available in the store
    private Item[] store;

    // Constructor initializes the shopping cart with the store's inventory
    public ShoppingCart(Item[] store) {
        this.store = store;
    }

    // Display all items in the store
    public void viewStore() {
        System.out.println("\nAvailable Items:");
        for (Item i : store) {
            System.out.println(i.getName() + " (" + i.getName().charAt(0) + ") - Price: " + i.getPrice() + ", Stock: " + i.getStock());
        }
    }

    // Private helper method to find an item by its first letter
    private Item findItemByLetter(String letter) {
        Item found = null;
        for (Item i : store) {
            String firstLetter = String.valueOf(i.getName().charAt(0));
            if (firstLetter.equalsIgnoreCase(letter)) {
                found = i;// Assign the matched item to 'found'
            }
        }
        return found;
    }

    // Add a specified quantity of an item to the cart
    public void addItem(String letter, int quantity) throws OutOfStockException {
        Item item = findItemByLetter(letter);// Find item by first letter
        if (item == null) {
            // Throw exception if item does not exist in the store
            throw new IllegalArgumentException("Item does not exist.");
        }
        if (quantity > item.getStock()) {
            // Throw exception if requested quantity exceeds available stock
            throw new OutOfStockException("Error: Insufficient stock for this item. Available: " + item.getStock());
        }

        // Add the item to the cart 'quantity' times
        for (int i = 0; i < quantity; i++) {
            cart.add(item.getName());
        }
        item.reduceStock(quantity);// Reduce the stock in the store
        System.out.println(quantity + " " + item.getName() + "(s) added to cart.");
    }

    // Remove an item from the cart
    public void removeItem(String letter) {
        Item item = findItemByLetter(letter);
        if (item == null || !cart.remove(item.getName())) {
            throw new IllegalArgumentException("Item not found in cart.");
        }
        System.out.println(item.getName() + " removed from cart.");
    }

    // Display the current contents of the cart
    public void viewCart() {
        String message = cart.isEmpty() ? "Cart is empty." : "Cart Contents: " + cart;
        System.out.println(message);
    }
}


