import java.util.ArrayList;

public class ReceiptGenerator {
    public void printReceipt(ArrayList<GroceryItem> cart, ArrayList<Integer> quantities) {
        System.out.println("\n===== RECEIPT =====");
        double total = 0;
        for (int i = 0; i < cart.size(); i++) {
            GroceryItem item = cart.get(i);
            int qty = quantities.get(i);
            double subtotal = item.getPrice() * qty;

            System.out.printf("%-15s %3d x %.2f = %.2f\n",
                              item.getName(),
                              qty,
                              item.getPrice(),
                              subtotal);
            total += subtotal;
        }
        System.out.println("-------------------");
        System.out.printf("TOTAL: %.2f\n", total);
        System.out.println("===================");
    }
}
