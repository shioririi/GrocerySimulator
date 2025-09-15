import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ShoppingCart cart = new ShoppingCart();

        System.out.println("=== Grocery Simulator ===");
        boolean shopping = true;

        while (shopping) {
            GroceryDatabase.displayItems();
            System.out.print("Enter item name (or 'done' to checkout): ");
            String choice = sc.nextLine().trim();

            if (choice.equalsIgnoreCase("done")) {
                shopping = false;
                break;
            }

            GroceryItem item = GroceryDatabase.getItem(choice);
            if (item == null) {
                System.out.println("❌ Item not found, try again.");
                continue;
            }

            System.out.print("Enter quantity: ");
            int qty;
            try {
                qty = Integer.parseInt(sc.nextLine());
                if (qty <= 0) {
                    System.out.println("❌ Quantity must be positive.");
                    continue;
                }
            } catch (NumberFormatException e) {
                System.out.println("❌ Invalid quantity.");
                continue;
            }

            cart.addItem(item, qty);
            System.out.println("✅ Added to cart!");
        }

        double total = cart.getTotal();
        if (total == 0) {
            System.out.println("Cart is empty. Goodbye!");
            return;
        }

        System.out.printf("Your total is ₱%.2f%n", total);

        double paid = 0;
        while (true) {
            System.out.print("Enter amount paid: ");
            try {
                paid = Double.parseDouble(sc.nextLine());
                if (paid < total) {
                    System.out.println("❌ Not enough money. Please enter again.");
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("❌ Invalid amount.");
            }
        }

        cart.printReceipt(paid);
        System.out.println("Thank you for shopping!");
        sc.close();
    }
}
