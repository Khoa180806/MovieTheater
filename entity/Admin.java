package entity;

public class Admin extends User {
    public Admin(String username, String password, String role) {
        super(username, password, role);
    }

    @Override
    public void displayMenu() {
        System.out.println("--------------------------------");
        System.out.println("Admin Menu");
        System.out.println("--------------------------------");
        System.out.println("1. Add Movie");
        System.out.println("2. Add Show Time");
        System.out.println("3. Find Movie by ID");
        System.out.println("4. Find Show Time by ID");
        System.out.println("5. Update Movie by ID");
        System.out.println("6. Update Show Time by ID");
        System.out.println("7. Delete Movie by ID");
        System.out.println("8. Delete Show Time by ID");
        System.out.println("9. Show All Movies");
        System.out.println("10. Show All Show Times");
        System.out.println("11. Show All Tickets");
        System.out.println("12. Exit");
        System.out.println("--------------------------------");
        System.out.print("Enter your choice: ");
    }
}
