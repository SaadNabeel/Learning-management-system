import java.util.*;

class LMS {

    private static final Scanner scanner = new Scanner(System.in);

    
    private static Map<String, User> users = new HashMap<>();
    private static Map<String, Course> courses = new HashMap<>();
    private static User currentUser;

    public static void main(String[] args) {
        initializeDemoData();
        mainMenu();
    }
    import java.util.*;

class LMS {

    private static final Scanner scanner = new Scanner(System.in);

   
    private static Map<String, User> users = new HashMap<>();
    private static Map<String, Course> courses = new HashMap<>();
    private static User currentUser;

    public static void main(String[] args) {
        initializeDemoData();
        mainMenu();
    }
    import java.util.*;

class LMS {

    private static final Scanner scanner = new Scanner(System.in);

    
    private static Map<String, User> users = new HashMap<>();
    private static Map<String, Course> courses = new HashMap<>();
    private static User currentUser;

    public static void main(String[] args) {
        initializeDemoData();
        mainMenu();
    }
 private static void login() {
        System.out.print("Username: ");
        String username = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();

        if (!users.containsKey(username)) {
            System.out.println("User not found.");
            return;
        }

        User user = users.get(username);
        if (!user.password.equals(password)) {
            System.out.println("Incorrect password.");
            return;
        }

        currentUser = user;
        System.out.println("Welcome, " + currentUser.name + "!");
        userMenu();
    }
    private static void userMenu() {
        if (currentUser instanceof Admin) adminMenu();
        else if (currentUser instanceof Teacher) teacherMenu();
        else if (currentUser instanceof Student) studentMenu();
    }

    private static void adminMenu() {
        while (true) {
            System.out.println("\n=== Admin Menu ===");
            System.out.println("1. Create User");
            System.out.println("2. Create Course");
            System.out.println("3. Logout");
            System.out.print("Choice: ");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1": createUser(); break;
                case "2": createCourse(); break;
                case "3": return;
                default: System.out.println("Invalid choice.");
            }
        }
    }
private static void userMenu() {
        if (currentUser instanceof Admin) adminMenu();
        else if (currentUser instanceof Teacher) teacherMenu();
        else if (currentUser instanceof Student) studentMenu();
    }

    private static void adminMenu() {
        while (true) {
            System.out.println("\n=== Admin Menu ===");
            System.out.println("1. Create User");
            System.out.println("2. Create Course");
            System.out.println("3. Logout");
            System.out.print("Choice: ");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1": createUser(); break;
                case "2": createCourse(); break;
                case "3": return;
                default: System.out.println("Invalid choice.");
            }
        }
    }
private static void studentMenu() {
        while (true) {
            System.out.println("\n=== Student Menu ===");
            System.out.println("1. Submit Assignment");
            System.out.println("2. View Grades");
            System.out.println("3. Logout");
            System.out.print("Choice: ");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1": submitAssignment(); break;
                case "2": viewGrades(); break;
                case "3": return;
                default: System.out.println("Invalid choice.");
            }
        }
    }
private static void studentMenu() {
        while (true) {
            System.out.println("\n=== Student Menu ===");
            System.out.println("1. Submit Assignment");
            System.out.println("2. View Grades");
            System.out.println("3. Logout");
            System.out.print("Choice: ");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1": submitAssignment(); break;
                case "2": viewGrades(); break;
                case "3": return;
                default: System.out.println("Invalid choice.");
            }
        }
    }
