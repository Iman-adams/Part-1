// 'import' tells Java where to find pre-built tools like Scanner for keyboard input or Pattern for regex that are stored in Java's built-in toolboxes so we don't have to write them from scratch.
import java.util.Scanner;
import java.util.regex.Pattern; // A regex (regular expression) pattern is a search rule/sequence of characters that defines a specific text format we want to match (like checking for uppercase letters, numbers, or phone codes).

public class Login {
    // 'public' variables can be accessed and modified by any class anywhere in the project whereas 'private' variables can ONLY be accessed or modified within the class where they are declared.
    private String username;
    private String password;
    private String cellPhoneNumber;
    private String firstName;
    private String lastName;

    // Constructor to initialize user credentials and details
    // Declares the public constructor method for the Login class, which takes 5 text parameters when creating a user.
    public Login(String username, String password, String cellPhoneNumber, String firstName, String lastName) {
        // 'this' keyword differentiates class instance variables from local parameters
        this.username = username; // Assigns the 'username' parameter passed into the constructor to the private 'username' field of this Login object.
        this.password = password; // Assigns the 'password' parameter passed into the constructor to the private 'password' field of this Login object.
        this.cellPhoneNumber = cellPhoneNumber; // Assigns the 'cellPhoneNumber' parameter passed into the constructor to the private 'cellPhoneNumber' field of this Login object.
        this.firstName = firstName; // Assigns the 'firstName' parameter passed into the constructor to the private 'firstName' field of this Login object.
        this.lastName = lastName; // Assigns the 'lastName' parameter passed into the constructor to the private 'lastName' field of this Login object.
    }

    // Allows instantiation without initial parameters if needed
    public Login() {
    }

    // Getters and setters. It is optional but it is good practice
    // Getters allow other classes to safely read our private variables.
    // Setters allow other classes to safely change or update our private variables.
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public String getCellPhoneNumber() {
        return cellPhoneNumber;
    }
    public void setCellPhoneNumber(String cellPhoneNumber) {
        this.cellPhoneNumber = cellPhoneNumber;
    }

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    // Method to check if username contains an underscore and is <= 5 characters
    public boolean checkUserName() {
        return username != null && username.contains("_") && username.length() <= 5;
    }

    public boolean checkPasswordComplexity() {
        // Must be at least 8 chars long, contain a capital letter, a number, and a special character
        String passwordRegex = "^(?=.*[A-Z])(?=.*[0-9])(?=.*[@#$%^&+=!._-]).{8,}$";
        return password != null && Pattern.matches(passwordRegex, password);
    }

    // Method to verify cell phone number formatting
    // Reference/Attribution: Regex pattern adapted from standard E.164 international phone number format specifications.
    public boolean checkCellPhoneNumber() {
        // Ensures international country code (+27) followed by exactly 9 digits (max 10 chars after +)
        String cellPhoneRegex = "^\\+27[0-9]{9}$";
        return cellPhoneNumber != null && Pattern.matches(cellPhoneRegex, cellPhoneNumber);
    }

    // Method to process registration status messages
    public String registerUser() {
        if (!checkUserName()) {
            return "Username is not correctly formatted; please ensure that your username contains an underscore and is no more than five characters in length.";
        }
        if (!checkPasswordComplexity()) {
            return "Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.";
        }
        if (!checkCellPhoneNumber()) {
            return "Cell phone number incorrectly formatted or does not contain international code.";
        }
        return "Username successfully captured.\nPassword successfully captured.\nCell phone number successfully added."; // '\n' is basically a line breaker
    }

    // Method to verify login credentials
    public boolean loginUser(String enteredUsername, String enteredPassword) {
        return this.username.equals(enteredUsername) && this.password.equals(enteredPassword);
    }

    // Method to return formatted login confirmation status
    // Method that checks if the username and password typed at login match the details stored in this user object.
    public String returnLoginStatus(boolean isLoggedIn) {
        if (isLoggedIn) {
            return "Welcome " + firstName + " " + lastName + " it is great to see you.";
        } else {
            return "Username or password incorrect, please try again."; // Compares the stored username and password with the entered values, returning 'true' only if BOTH match exactly.
        }
    }
}
