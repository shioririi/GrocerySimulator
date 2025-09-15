import java.util.*;

public class GroceryDatabase {
    private static Map<String, GroceryItem> items = new HashMap<>();

    static {
        items.put("apple", new GroceryItem("Apple", 10.0));
        items.put("milk", new GroceryItem("Milk", 30.0));
        items.put("bread", new GroceryItem("Bread", 25.0));
        items.put("egg", new GroceryItem("Egg", 7.0));
        items.put("rice", new GroceryItem("Rice (1kg)", 50.0));
    }

    public static GroceryItem getItem(String name) {
        return items.get(name.toLowerCase());
    }

    public static void displayItems() {
        System.out.println("\n=== Available Items ===");
        for (GroceryItem item : items.values()) {
            System.out.printf("- %s : ₱%.2f%n", item.getName(), item.getPrice());
        }
        System.out.println("=======================");
    }
}
