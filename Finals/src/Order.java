public class Order {
    private String drinkName;
    private double price;

    public Order(String drinkName, double price) {
        this.drinkName = drinkName;
        this.price = price;
    }

    public String getDrinkName() {
        return drinkName;
    }

    public double getPrice() {
        return price;
    }
}

