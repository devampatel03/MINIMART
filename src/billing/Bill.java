package billing;

import items.BillingItem;
import items.Item;

import java.util.ArrayList;
import java.util.List;
public class Bill {
    private List<BillingItem> items;

    public Bill() {
        items = new ArrayList<>();
    }

    public void addItem(Item item, int quantity) {
        items.add(new BillingItem(item, quantity));
    }

    public double calculateTotal() {
        double total = 0.0;
        for (BillingItem billingItem : items) {
            total += billingItem.getItem().getPrice() * billingItem.getQuantity();
        }
        return total;
    }

//    public void generateReceipt() {
//        System.out.println("Receipt:");
//        for (BillingItem billingItem : items) {
//            System.out.println(billingItem.getItem().getName() + "\t" + billingItem.getQuantity() + "\t" + billingItem.getItem().getPrice());
//        }
//        double total = calculateTotal();
//        System.out.println("Total: " + total);
//    }
}
