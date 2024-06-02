import java.util.ArrayList;
import java.util.List;

public class cart {
    private List<Order> orders;

    public cart() {
        this.orders = new ArrayList<>();
    }

    public void addOrder(Order order) {
        orders.add(order);
        System.out.println("Added to cart: " + order.getDrinkName() + " - $" + order.getPrice());
    }

    public void displayCart() {
        System.out.println("Your cart:");
        double total = 0;
        for (Order order : orders) {
            System.out.println(order.getDrinkName() + " - $" + order.getPrice());
            total += order.getPrice();
        }
        System.out.println("Total: $" + total);
    }

    public void checkout(String email) {
        double total = 0;
        for (Order order : orders) {
            total += order.getPrice();
        }

        if (!signup.hasPlacedOrder(email)) {
            total *= 0.31; // Apply 69% discount for the first order
            System.out.println("A 69% discount has been applied to your first order.");
        } else {
            total *= 0.94; // Apply 6% discount for subsequent orders
            System.out.println("A 6% discount has been applied to your order.");
        }

        System.out.println("Final total: $" + total);
        signup.placeOrder(email);
        orders.clear();
    }
}
