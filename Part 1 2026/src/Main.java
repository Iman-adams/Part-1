import java.util.Scanner;

// The Main class controls program execution
public class Main {
    public static void main(String[] args) {
        // Initialize Scanner to read text input from standard command line
        Scanner scanner = new Scanner(System.in);
        // Declare variables within the main class to temporarily hold console input during registration phase
        // Local variables declared inside a method (like main) belong only to that method block. They don't take 'public' or 'private' access modifiers because they can't be accessed outside this method anyway.
        String firstName;
        String lastName;
        String username;
        String password;
        String cellPhoneNumber;

        // register user
        System.out.println("Registration");
        // you are asking the user to enter their details sequentially using scanner.nextLine();
        System.out.print("Enter first name: ");
        firstName = scanner.nextLine();
        // If you don't call your variable at the beginning it will look like this:
        // System.out.print("Enter first name: ");
        // String firstName = scanner.nextLine();

        System.out.print("Enter last name: ");
        lastName = scanner.nextLine();

        System.out.print("Enter Username: ");
        username = scanner.nextLine(); // scanner.nextLine() tells Java to pause, wait for the user to type something on the keyboard, and save whatever they typed or until they press Enter into a variable.

        System.out.print("Enter password: ");
        password = scanner.nextLine();

        System.out.print("Enter cellphone number: ");
        cellPhoneNumber = scanner.nextLine();

        // Create the login
        // This creates a new Login 'object' in memory like filling out a blank form and stores all the user's details inside it so we can use them later in the program
        // An 'object' is a real instance of a class that holds actual data like a completed ID card created from a blank template.
        Login user = new Login(username, password, cellPhoneNumber, firstName, lastName);

        // Display registration status and print returned validation output string
        String registrationResult = user.registerUser();
        System.out.println("\n--- REGISTRATION STATUS ---"); // '\n' is basically a line breaker
        System.out.println(registrationResult);

        // user login
        // You will only be able to proceed to login if all registration rules were successfully met
        // This 'if' statement checks if ALL three registration rules (username format, password complexity, and cell phone format) returned 'true' before allowing the user to proceed to the login screen.
        if (user.checkUserName() &&
                user.checkPasswordComplexity() &&
                user.checkCellPhoneNumber()) {

            System.out.println("Login user");

            // Declare local variables to hold user login attempts
            System.out.print("Enter Login username: ");
            String inputUsername = scanner.nextLine();

            System.out.print("Enter Login password: ");
            String inputPassword = scanner.nextLine();

            // Pass login attempt to loginUser method to obtain boolean result (true or false)
            boolean isAuthenication = user.loginUser(inputUsername, inputPassword);

            // Pass boolean result into returnLoginStatus to print output text
            String loginOutput = user.returnLoginStatus(isAuthenication);
            System.out.println("\n--- LOGIN STATUS ---");
            System.out.println(loginOutput);
        } else {
            // Inform user why login step was skipped
            System.out.println("\n [!] Registration failed, please try again."); // '\n' is basically a line breaker
        }
    }
}