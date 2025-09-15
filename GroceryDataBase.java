import java.util.ArrayList;

public class GroceryDatabase {
    private ArrayList<GroceryItem> items = new ArrayList<>();

    public GroceryDatabase() {
        // Preload some grocery items (like DB)
        items.add(new GroceryItem("1001", "Apple", 5.00));
        items.add(new GroceryItem("1002", "Banana", 2.50));
        items.add(new GroceryItem("1003", "Milk", 30.00));
        items.add(new GroceryItem("1004", "Bread", 25.00));
        items.add(new GroceryItem("1005", "Eggs (Dozen)", 60.00));
    }

    // Search by barcode or name
    public GroceryItem findItem(String input) {
        for (GroceryItem item : items) {
            if (item.getBarcode().equalsIgnoreCase(input) || 
                item.getName().equalsIgnoreCase(input)) {
                return item;
            }
        }
        return null; // not found
    }

    public void listItems() {
        System.out.println("\n=== Available Grocery Items ===");
        for (GroceryItem item : items) {
            System.out.println(item);
        }
        System.out.println("===============================");
    }
}
