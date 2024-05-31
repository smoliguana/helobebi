import java.util.Scanner;
import java.util.HashMap;



public class Main{


    public static void main(String[] cupshot){

        while(true) {

            System.out.println("------------------  Welcome to CupShot!  ------------------");
            System.out.println(" ");
            System.out.println("1. Sign up for free voucher ( for first time purchase only ) \n2. Log in \n3. Continue as guest \n4. Exit Program");

            System.out.println(" ");
            System.out.println(" Choose your option: ");
            System.out.println(" ");

            Scanner sc = new Scanner(System.in); // creating the scanner, named "sc"

            Integer user_input = sc.nextInt(); // user input


            switch (user_input) {
                case 1: // sign in
                    signup.handleSignUp();
                    break;

                case 2: // login with exsisting account
                    login.handlelogin();
                    break;

                case 3: // continue as a guest
                    guest.handleGuest();
                    break;

                case 4: // exit program
                    sc.close(); // Close the scanner
                    System.exit(0); // Exit the program
                    break;
            }
        }
    }
}