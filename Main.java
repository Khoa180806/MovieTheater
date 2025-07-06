import java.util.*;

import entity.Admin;
import entity.Customer;
import entity.Movie;
import entity.ShowTime;
import service.AdminService;
import service.AdminServiceImpl;
import service.CustomerService;
import service.CustomerServiceImpl;

public class Main { 
    private static Scanner scanner = new Scanner(System.in);
    
    private static List<Movie> movies = new ArrayList<>();
    private static List<ShowTime> showTimes = new ArrayList<>();
    
    public static void main(String[] args) {
        Admin admin = new Admin("admin", "123", "admin");
        Customer customer = new Customer("customer", "123", "customer");

        AdminService adminService = new AdminServiceImpl();
        CustomerService customerService = new CustomerServiceImpl();

        //menu login
        try {
        System.out.println("Welcome to the Movie Ticket Booking System");
        System.out.println("--------------------------------");
        System.out.println("1. Login");
        System.out.println("2. Exit");
        System.out.println("--------------------------------");
        System.out.print("Enter your choice: ");

        int choice = scanner.nextInt();
        scanner.nextLine();
        switch (choice) {
            case 1:
                System.out.print("Enter your username: ");
                String username = scanner.nextLine();
                System.out.print("Enter your password: ");
                String password = scanner.nextLine();
                if (username.equals("admin") && password.equals("123")) {
                    System.out.println("Login successful");
                    adminMenu(admin, adminService);
                } else if (username.equals("customer") && password.equals("123")) {
                    System.out.println("Login successful");
                    customerMenu(customer);
                } else {
                    System.out.println("Login failed");
                }
                break;
            case 2:
                System.out.println("Thank you for using the Movie Ticket Booking System");
                break;
            default:
                System.out.println("Invalid choice");
            }
            scanner.close();
        } catch (Exception e) {
            System.out.println("Invalid choice");
            scanner.close();
        }
    }

    public static void adminMenu(Admin admin, AdminService adminService) {
        int choice;
        do {
        admin.displayMenu();
        choice = scanner.nextInt();
        scanner.nextLine();
        switch (choice) {
            case 1:
                System.out.print("Enter movie id: ");
                String movieId = scanner.nextLine();
                System.out.print("Enter movie name: ");
                String movieName = scanner.nextLine();
                System.out.print("Enter movie type: ");
                String movieType = scanner.nextLine();
                System.out.print("Enter movie duration: ");
                String movieDuration = scanner.nextLine();
                movies.add(new Movie(movieId, movieName, movieType, movieDuration));
                adminService.addMovie(movies);
                break;
            case 2:
                System.out.print("Enter show time id: ");
                String showTimeId = scanner.nextLine();
                System.out.print("Enter show time date: ");
                String showTimeDate = scanner.nextLine();
                System.out.print("Enter room number: ");
                int roomNumber = scanner.nextInt();
                System.out.println("Choose movie id: ");
                for (Movie movie : movies) {
                    System.out.println(movie.getMovieId() + " " + movie.getMovieName());
                }
                System.out.print("Enter movie id: ");
                String id = scanner.nextLine();
                showTimes.add(new ShowTime(showTimeId, showTimeDate, roomNumber, id));
                adminService.addShowTime(showTimes);
                break;
            case 9:
                adminService.showAllMovies();
                break;
            case 10:
                adminService.showAllShowTimes();
                break;
            case 11:
                adminService.showAllTickets();
                break;
            case 12:
                System.out.println("Thank you for using the Movie Ticket Booking System");
                break;
            default:
                System.out.println("Invalid choice");
            }
        } while (choice != 12);
    }

    public static void customerMenu(Customer customer) {
        customer.displayMenu();
    }
}