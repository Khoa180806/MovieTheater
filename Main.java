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
            System.out.println("--------------------------------");
            System.out.println("Enter any key to continue");
            scanner.nextLine();
        } catch (Exception e) {
            System.out.println("Invalid choice");
        }
    }

    public static void adminMenu(Admin admin, AdminService adminService) {
        int choice;
        String showTimeId;
        String movieId;
        do {
        admin.displayMenu();
        choice = scanner.nextInt();
        scanner.nextLine();
        switch (choice) {
            case 1:
                System.out.print("Enter movie id: ");
                movieId = scanner.nextLine();
                System.out.print("Enter movie name: ");
                String movieName = scanner.nextLine();
                System.out.print("Enter movie type: ");
                String movieType = scanner.nextLine();
                System.out.print("Enter movie duration: ");
                String movieDuration = scanner.nextLine();
                Movie newMovie = new Movie(movieId, movieName, movieType, movieDuration);
                movies.add(newMovie);
                adminService.addMovie(newMovie);
                break;
            case 2:
                showTimeId = "ST" + (int)(Math.random() * 900) + 100;
                System.out.print("Enter show time date: ");
                String showTimeDate = scanner.nextLine();
                System.out.print("Enter room number: ");
                int roomNumber = scanner.nextInt();
                scanner.nextLine();
                if (movies.isEmpty()) {
                    System.out.println("No movie found");
                    System.out.println("--------------------------------");
                    System.out.println("Enter any key to continue");
                    scanner.nextLine();
                    break;
                } else {
                    System.out.println("--------------------------------");
                    for (Movie movie : movies) {
                        System.out.println(movie.getMovieId() + ": " + movie.getMovieName());
                    }
                    System.out.println("--------------------------------");
                    System.out.print("Choose movie id: ");
                    String id = scanner.nextLine();
                    ShowTime newShowTime = new ShowTime(showTimeId, showTimeDate, roomNumber, id);
                    showTimes.add(newShowTime);
                    adminService.addShowTime(newShowTime);
                }
                break;
            case 3:
                System.out.print("Enter movie id: ");
                movieId = scanner.nextLine();
                adminService.findMovieById(movieId);
                break;
            case 4:
                System.out.print("Enter show time id: ");
                showTimeId = scanner.nextLine();
                adminService.findShowTimeById(showTimeId);
                break;
            case 5:
                System.out.print("Enter movie id: ");
                movieId = scanner.nextLine();
                adminService.updateMovieById(movieId);
                break;
            case 6:
                System.out.print("Enter show time id: ");
                String showtid = scanner.nextLine();
                adminService.updateShowTimeById(showtid);
                break;
            case 7:
                System.out.print("Enter movie id: ");
                movieId = scanner.nextLine();
                adminService.deleteMovieById(movieId);
                break;
            case 8:
                System.out.print("Enter show time id: ");
                showTimeId = scanner.nextLine();
                adminService.deleteShowTimeById(showTimeId);
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
            System.out.println("--------------------------------");
            System.out.println("Enter any key to continue");
            scanner.nextLine();
        } while (choice != 12);
    }

    public static void customerMenu(Customer customer) {
        int choice;
        do {
            customer.displayMenu();
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    break;
                case 2:
                    break;
            }
        } while (choice != 12);
    }
}