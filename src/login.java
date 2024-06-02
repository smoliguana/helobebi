import java.util.Scanner;

public class login {
    public static void handlelogin() {

        Scanner login = new Scanner(System.in); // create the scanner

        System.out.println(" ");
        System.out.println("Login");

        System.out.println("Enter your email : ");
        String enteredEMAIL = login.next();
        System.out.println(" ");

        System.out.println("Enter your password : ");
        String enteredPASSWORD = login.next();


        boolean found = signup.verifyCredentials(enteredEMAIL, enteredPASSWORD);

        if (found) {
            System.out.println(" ");
            System.out.println("Login Successful!");
            // Check if it's the user's first order
            if (!signup.hasPlacedOrder(enteredEMAIL)) {
                if (signup.isEligibleForDiscount(enteredEMAIL)) {
                    System.out.println("A 69% discount has been applied to your first order.");
                    signup.applyDiscount(enteredEMAIL);
                } else {
                    System.out.println("Invalid discount.");
                }
            } else {
                // Subsequent orders
                System.out.println("A 6% discount has been applied to your order.");
                // No need to check for eligibility, apply the discount directly
            }
            // Mark the order as placed
            signup.placeOrder(enteredEMAIL);
            Menu.handleMenu(enteredEMAIL);
        } else {
            System.out.println("Invalid email or password. Please try again.");
        }
    }
}
