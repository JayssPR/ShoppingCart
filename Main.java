import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args) {
        // Create a Scanner object to read user input
        Scanner scanner = new Scanner(System.in);

        // Create an array of items available in the store with their stock quantities
        Item[] store = {
                new Phone(10),
                new TV(3),
                new Laptop(2),
                new USB(20),
                new SmartWatch(10)
        };

        // Initialize a shopping cart with the store's items
        ShoppingCart cart = new ShoppingCart(store);
        boolean running = true; // Control variable for the main loop

        // Main loop to keep the program running until the user chooses to exit
        while (running) {
            try {
                cart.viewStore(); // Display available items in the store
                System.out.println("\nChoose: 1=Add, 2=Remove, 3=View, 4=Exit");

                int choice = scanner.nextInt();// Read user choice
                scanner.nextLine(); // Consume the leftover newline character

                switch (choice) {
                    case 1:  // Case 1: Add items to the cart
                        System.out.print("Enter first letter of item: ");
                        String addLetter = scanner.nextLine();// Read item identifier
                        System.out.print("Enter quantity: ");
                        int SNI = scanner.nextInt();// Read quantity to add
                        cart.addItem(addLetter,SNI); // Add the item to the cart
                        break;

                    case 2:// Case 2: Remove an item from the cart
                        System.out.print("Enter first letter of item to remove: ");
                        String removeLetter = scanner.nextLine();
                        cart.removeItem(removeLetter); // Remove the item from the cart
                        break;
                    case 3:
                        System.out.print("Cart Status: ");
                        cart.viewCart();
                        System.out.println();
                        break;
                    case 4: // Case 4: Exit the program
                        running = false; // Set running to false to end the loop
                        System.out.println("Exiting...");
                        break;

                    default: // Handle invalid menu choices
                        System.err.println("Invalid choice.");
                }

            } catch (InputMismatchException e) {
                // Handle cases where the user enters the wrong type of input
                System.err.println("Invalid input! Enter numbers correctly.");
                scanner.nextLine();// Clear the invalid input
            } catch (IllegalArgumentException | OutOfStockException inputError) {
                // Handle custom exceptions from cart operations
                System.err.println(inputError.getMessage());
            } finally {
                // Always display the current status of the cart
                System.out.print("Cart Status: ");
                cart.viewCart();
                System.out.println();
            }
        }
        scanner.close();// Close the scanner
    }
}

