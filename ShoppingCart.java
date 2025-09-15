import java.util.ArrayList;
import java.util.Scanner;

public class ShoppingCart {
    private ArrayList<GroceryItem> cart = new ArrayList<>();
    private ArrayList<Integer> quantities = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);
    private GroceryDatabase db = new GroceryDatabase();

    public void startShopping() {
        db.listItems();

        System.out.println("=== Start Shopping ===");
        while (true) {
            System.out.print("Enter item name or barcode (or 'done' to finish): ");
            String input = sc.nextLine();
            if (input.equalsIgnoreCase("done")) break;

            GroceryItem item = db.findItem(input);
            if (item == null) {
                System.out.println("Item not found in database!");
                continue;
            }

            System.out.print("Enter quantity: ");
            int qty = Integer.parseInt(sc.nextLine());

            cart.add(item);
            quantities.add(qty);
            System.out.println("Added: " + qty + " x " + item.getName());
        }
    }

    public ArrayList<GroceryItem> getCart() {
        return cart;
    }

    public ArrayList<Integer> getQuantities() {
        return quantities;
    }
}