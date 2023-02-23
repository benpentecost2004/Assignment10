import java.util.Scanner;

public class PasswordValidator {
    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            displayPassParameters();
            String password = input.nextLine();
            
            if (isValidPassword(password)) {
                System.out.println("The password '" + password + "' is valid!");
            } else {
                System.out.println("The password '" + password + "' is invalid.");
            }
        }
    }

    public static void displayPassParameters() {
        System.out.println("Create a password. Password must:");
        System.out.println("1. Have between 8 - 16 characters.");
        System.out.println("2. Must contain atleast one uppercase & lowercase letter.");
        System.out.println("3. Must contain atleast one number.");
        System.out.print("Please enter your password: ");
    }
    
    public static boolean isValidPassword(String password) {
        if (password.length() < 8 || password.length() > 16) {
            return false;
        }
        
        int categories = 0;
        for (char c : password.toCharArray()) {
            if (Character.isLowerCase(c)) {
                categories |= 1;
            } else if (Character.isUpperCase(c)) {
                categories |= 2;
            } else if (Character.isDigit(c)) {
                categories |= 4;
            }
        }
        
        int count = 0;
        while (categories != 0) {
            count += categories & 1;
            categories >>= 1;
        }
        return count >= 3;
    }
}
