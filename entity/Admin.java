package entity;

public class Admin extends User {
    public Admin(String username, String password, String role) {
        super(username, password, role);
    }

    @Override
    public void displayMenu() {
        System.out.println("1. Add Movie");
        System.out.println("2. Add Show Time");
        System.out.println("3. Show All Movies");
        System.out.println("4. Show All Show Times");
        System.out.println("5. Show All Tickets");
        System.out.println("6. Exit");
    }
}
