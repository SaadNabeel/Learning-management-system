import java.util.*;

class LMS {

    private static final Scanner scanner = new Scanner(System.in);

    // Users storage
    private static Map<String, User> users = new HashMap<>();
    private static Map<String, Course> courses = new HashMap<>();
    private static User currentUser;

    public static void main(String[] args) {
        initializeDemoData();
        mainMenu();
    }

    private static void initializeDemoData() {
        // Create some demo users
        users.put("admin", new Admin("admin", "admin123"));
        users.put("teacher1", new Teacher("teacher1", "teach123"));
        users.put("student1", new Student("student1", "stud123"));
    }

    private static void mainMenu() {
        while (true) {
            System.out.println("\n=== Learning Management System ===");
            System.out.println("1. Login");
            System.out.println("2. Exit");
            System.out.print("Choice: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1": login(); break;
                case "2": System.out.println("Exiting..."); return;
                default: System.out.println("Invalid choice.");
            }
        }
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

    private static void teacherMenu() {
        while (true) {
            System.out.println("\n=== Teacher Menu ===");
            System.out.println("1. Create Assignment");
            System.out.println("2. Grade Assignment");
            System.out.println("3. Logout");
            System.out.print("Choice: ");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1": createAssignment(); break;
                case "2": gradeAssignment(); break;
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

    // Admin functions
    private static void createUser() {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        System.out.print("Role (Student/Teacher): ");
        String role = scanner.nextLine().toLowerCase();

        if (role.equals("student")) users.put(username, new Student(username, password));
        else if (role.equals("teacher")) users.put(username, new Teacher(username, password));
        else { System.out.println("Invalid role."); return; }

        System.out.println("User created successfully.");
    }

    private static void createCourse() {
        System.out.print("Enter course name: ");
        String cname = scanner.nextLine();
        System.out.print("Enter teacher username: ");
        String tname = scanner.nextLine();

        if (!users.containsKey(tname) || !(users.get(tname) instanceof Teacher)) {
            System.out.println("Teacher not found.");
            return;
        }

        Course course = new Course(cname, (Teacher) users.get(tname));
        courses.put(cname, course);
        System.out.println("Course created successfully.");
    }

    // Teacher functions
    private static void createAssignment() {
        System.out.print("Enter course name: ");
        String cname = scanner.nextLine();
        if (!courses.containsKey(cname)) {
            System.out.println("Course not found.");
            return;
        }
        System.out.print("Enter assignment title: ");
        String title = scanner.nextLine();
        courses.get(cname).assignments.add(new Assignment(title));
        System.out.println("Assignment created successfully.");
    }

    private static void gradeAssignment() {
        System.out.println("Feature not implemented yet.");
    }

    // Student functions
    private static void submitAssignment() {
        System.out.println("Feature not implemented yet.");
    }

    private static void viewGrades() {
        System.out.println("Feature not implemented yet.");
    }

    // ---------------- Classes ----------------
    static abstract class User {
        String name;
        String password;
        User(String name, String password) { this.name = name; this.password = password; }
    }

    static class Admin extends User {
        Admin(String name, String password) { super(name, password); }
    }

    static class Teacher extends User {
        Teacher(String name, String password) { super(name, password); }
    }

    static class Student extends User {
        Student(String name, String password) { super(name, password); }
    }

    static class Course {
        String name;
        Teacher teacher;
        List<Assignment> assignments = new ArrayList<>();
        Course(String name, Teacher teacher) { this.name = name; this.teacher = teacher; }
    }

    static class Assignment {
        String title;
        Map<Student, Integer> grades = new HashMap<>();
        Assignment(String title) { this.title = title; }
    }
}
