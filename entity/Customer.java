package entity;

public class Customer extends User {
    public Customer(String username, String password, String role) {
        super(username, password, role);
    }

    @Override
    public void displayMenu() {
        System.out.println("--------------------------------");
        System.out.println("Customer Menu");
        System.out.println("--------------------------------");
        System.out.println("1. Buy Ticket");
        System.out.println("2. Show Tickets");
        System.out.println("3. Logout");
        System.out.println("--------------------------------");
        System.out.print("Enter your choice: ");
    }
}
