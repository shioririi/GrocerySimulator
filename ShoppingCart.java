import java.util.*;

public class ShoppingCart {
    private Map<GroceryItem, Integer> cart = new LinkedHashMap<>();

    public void addItem(GroceryItem item, int quantity) {
        cart.put(item, cart.getOrDefault(item, 0) + quantity);
    }

    public double getTotal() {
        double sum = 0;
        for (Map.Entry<GroceryItem, Integer> entry : cart.entrySet()) {
            sum += entry.getKey().getPrice() * entry.getValue();
        }
        return sum;
    }

    public void printReceipt(double paid) {
        System.out.println("\n===== RECEIPT =====");
        for (Map.Entry<GroceryItem, Integer> entry : cart.entrySet()) {
            GroceryItem item = entry.getKey();
            int qty = entry.getValue();
            double subtotal = item.getPrice() * qty;
            System.out.printf("%-12s x%d = ₱%.2f%n", item.getName(), qty, subtotal);
        }
        double total = getTotal();
        System.out.printf("-------------------%n");
        System.out.printf("TOTAL:   ₱%.2f%n", total);
        System.out.printf("PAID:    ₱%.2f%n", paid);
        System.out.printf("CHANGE:  ₱%.2f%n", paid - total);
        System.out.println("===================\n");
    }
}