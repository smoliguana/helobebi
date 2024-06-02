import java.util.HashMap;
import java.util.Map;

public class Order {
    private String drinkName;
    private double price;
    private HashMap<String, Double> toppings;

    public Order(String drinkName, double price) {
        this.drinkName = drinkName;
        this.price = price;
        this.toppings = new HashMap<>();
    }

    public String getDrinkName() {
        return drinkName;
    }

    public double getPrice() {
        return price;
    }

    public void addTopping(String toppingName, double toppingPrice) {
        toppings.put(toppingName, toppingPrice);
        this.price += toppingPrice;
    }

    public HashMap<String, Double> getToppings() {
        return toppings;
    }

    public void displayOrder() {
        System.out.println("Drink: " + drinkName);
        System.out.println("Base Price: $" + price);
        if (!toppings.isEmpty()) {
            System.out.println("Toppings:");
            for (Map.Entry<String, Double> entry : toppings.entrySet()) {
                System.out.println(" - " + entry.getKey() + ": $" + entry.getValue());
            }
        }
        System.out.println("Total Price: $" + price);
    }
}
