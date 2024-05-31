import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class guest {
    private static String userEmail;
    private static String email;

    public static void handleGuest() {
        userEmail = email;
        Menu.handleMenu(email);
    }
}