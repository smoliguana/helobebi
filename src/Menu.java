import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Menu {
    private static cart cart = new cart();
    private static String userEmail;

    public static void handleMenu(String email) {
        userEmail = email;
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("Pick your preferred drink!");
            System.out.println("1. Non Coffee \n2. Coffee \n3. Checkout \n4. Exit");

            int user_input = sc.nextInt();

            if (user_input == 3) {
                cart.displayCart();
                System.out.println("Do you want to checkout? (yes/no)");
                String checkoutInput = sc.next();
                if (checkoutInput.equalsIgnoreCase("yes")) {
                    cart.checkout(userEmail);
                }
                break;
            } else if (user_input == 4) {
                break;
            }

            handleDrinkSelection(user_input);
        }
    }

    private static void handleDrinkSelection(int type) {
        Scanner sc = new Scanner(System.in);

        HashMap<Integer, String> drinkMenu = new HashMap<>();
        HashMap<Integer, Double> drinkPrices = new HashMap<>();

        if (type == 1) {
            drinkMenu.put(1, "Lychee Tea");
            drinkMenu.put(2, "Oolong Tea");
            drinkMenu.put(3, "Green Tea");
            drinkMenu.put(4, "Jasmine Tea");
            drinkMenu.put(5, "Lemon Tea");
            drinkMenu.put(6, "Strawberry Milk");
            drinkMenu.put(7, "Chocolate Milk");
            drinkMenu.put(8, "Mineral Water");
            drinkMenu.put(9, "Coke");
            drinkMenu.put(10, "Hojicha");
            drinkMenu.put(11, "Milk Tea");

            drinkPrices.put(1, 3.00);
            drinkPrices.put(2, 3.00);
            drinkPrices.put(3, 3.00);
            drinkPrices.put(4, 3.00);
            drinkPrices.put(5, 3.00);
            drinkPrices.put(6, 6.52);
            drinkPrices.put(7, 6.52);
            drinkPrices.put(8, 1.00);
            drinkPrices.put(9, 4.00);
            drinkPrices.put(10, 4.42);
            drinkPrices.put(11, 3.39);
        } else if (type == 2) {
            drinkMenu.put(1, "Americano");
            drinkMenu.put(2, "Latte");
            drinkMenu.put(3, "Cappuccino");
            drinkMenu.put(4, "Cold Brew");
            drinkMenu.put(5, "Long Black");
            drinkMenu.put(6, "Mocha");
            drinkMenu.put(7, "Macchiato");

            drinkPrices.put(1, 3.60);
            drinkPrices.put(2, 4.32);
            drinkPrices.put(3, 5.26);
            drinkPrices.put(4, 4.02);
            drinkPrices.put(5, 5.28);
            drinkPrices.put(6, 3.56);
            drinkPrices.put(7, 6.58);
        }

        System.out.println("Here are the available drinks from the menu:");
        for (Map.Entry<Integer, String> entry : drinkMenu.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }

        System.out.println("Type in the key of your drink from the menu: ");
        int drinkKey = sc.nextInt();

        if (drinkMenu.containsKey(drinkKey)) {
            String drinkName = drinkMenu.get(drinkKey);
            double drinkPrice = drinkPrices.get(drinkKey);
            Order order = new Order(drinkName, drinkPrice);

            // Add toppings
            handleToppingsSelection(order);

            cart.addOrder(order);
        } else {
            System.out.println("The entered drink is not available in the menu.");
        }
    }

    private static void handleToppingsSelection(Order order) {
        Scanner sc = new Scanner(System.in);

        HashMap<Integer, String> toppingsMenu = new HashMap<>();
        HashMap<Integer, Double> toppingsPrices = new HashMap<>();

        toppingsMenu.put(1, "Whipped Cream");
        toppingsMenu.put(2, "Boba");
        toppingsMenu.put(3, "Vanilla Pudding");
        toppingsMenu.put(4, "Grass Jelly");
        toppingsMenu.put(5, "Extra Shot of Espresso");

        toppingsPrices.put(1, 0.50);
        toppingsPrices.put(2, 0.75);
        toppingsPrices.put(3, 0.70);
        toppingsPrices.put(4, 0.80);
        toppingsPrices.put(5, 1.00);

        System.out.println("Do you want to add toppings? (yes/no)");
        String addToppingsInput = sc.next();

        while (addToppingsInput.equalsIgnoreCase("yes")) {
            System.out.println("Here are the available toppings:");
            for (Map.Entry<Integer, String> entry : toppingsMenu.entrySet()) {
                System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
            }

            System.out.println("Type in the key of the topping you want to add: ");
            int toppingKey = sc.nextInt();

            if (toppingsMenu.containsKey(toppingKey)) {
                String toppingName = toppingsMenu.get(toppingKey);
                double toppingPrice = toppingsPrices.get(toppingKey);
                order.addTopping(toppingName, toppingPrice);
            } else {
                System.out.println("The entered topping is not available in the menu.");
            }

            System.out.println("Do you want to add more toppings? (yes/no)");
            addToppingsInput = sc.next();
        }
    }
}


