import java.util.*;

import entity.Admin;
import entity.Customer;
import entity.Movie;
import entity.ShowTime;
import entity.Ticket;
import service.AdminService;
import service.AdminServiceImpl;
import service.CustomerService;
import service.CustomerServiceImpl;

public class Main { 
    private static Scanner scanner = new Scanner(System.in);
    
    private static List<Movie> movies = new ArrayList<>();
    private static List<ShowTime> showTimes = new ArrayList<>();
    private static List<Ticket> tickets = new ArrayList<>();
    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            login();
            
            System.out.println("Do you want to continue? (y/n): ");
            String choice = scanner.nextLine().toLowerCase();
            if (choice.equals("n") || choice.equals("no")) {
                running = false;
                System.out.println("Thank you for using the system!");
            }
        }
    }

    public static void adminMenu(Admin admin, AdminService adminService) {
        int choice;
        String showTimeId;
        String movieId;
        do {
            try {
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
                        do {
                            showTimeId = "ST" + (int)(Math.random() * 900) + 100;
                        } while (isShowTimeIdExists(showTimeId));
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
                            System.out.println("List of movies: ");
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
                        System.out.println("Logout successful");
                        return;
                    default:
                        System.out.println("Invalid choice");
                        break;   
                }
            } catch (Exception e) {
                System.out.println("Invalid input! Please enter a number.");
                scanner.nextLine();
                choice = 0;
            }
            
            if (choice != 12) {
                System.out.println("--------------------------------");
                System.out.println("Enter any key to continue");
                scanner.nextLine();
            }
        } while (choice != 12);
    }

    public static void customerMenu(Customer customer, CustomerService customerService, AdminService adminService) {
        int choice;
        String movieId;
        String showTimeId;
        String showDate = "";
        int roomNumber = 0;
        do {
            customer.displayMenu();
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    String ticketId = "T" + (int)(Math.random() * 900) + 100;
                    System.out.println("List of movies: ");
                    for (Movie movie : movies) {
                        System.out.println(movie.getMovieId() + ": " + movie.getMovieName());
                    }
                    System.out.println("--------------------------------");
                    System.out.print("Enter movie id: ");
                    movieId = scanner.nextLine();   
                    System.out.println("List of show times: ");
                    for (ShowTime showTime : showTimes) {
                        if (showTime.getMovieId().equals(movieId)) {
                            System.out.println("Show Time ID: " + showTime.getShowTimeId() + ", Show Date: " + showTime.getShowDate() + ", Room Number: " + showTime.getRoomNumber());
                        }
                    }
                    System.out.println("--------------------------------");
                    System.out.print("Enter show time id: ");
                    showTimeId = scanner.nextLine();
                    for (ShowTime showTime : showTimes) {
                        if (showTime.getShowTimeId().equals(showTimeId)) {
                            roomNumber = showTime.getRoomNumber();
                            showDate = showTime.getShowDate();
                            break;
                        }
                    }
                    
                    System.out.println("Booked seats for this show time:");
                    for (Ticket ticket : tickets) {
                        if (ticket.getShowTimeId().equals(showTimeId)) {
                            System.out.print(ticket.getSeatNumber() + " ");
                        }
                    }
                    System.out.println("\n--------------------------------");
                    
                    System.out.println("Available seat numbers: ");
                    for (int i = 1; i <= 50; i++) {
                        boolean isBooked = false;
                        for (Ticket ticket : tickets) {
                            if (ticket.getShowTimeId().equals(showTimeId) && 
                                ticket.getSeatNumber().equals(String.valueOf(i))) {
                                isBooked = true;
                                break;
                            }
                        }
                        
                        if (!isBooked) {
                            System.out.print(i + " ");
                        }
                        if (i % 10 == 0) {
                            System.out.println();
                        }
                    }
                    System.out.println("--------------------------------");
                    System.out.print("Enter seat number: ");
                    String seatNumber = scanner.nextLine();
                    
                    boolean seatTaken = false;
                    for (Ticket ticket : tickets) {
                        if (ticket.getShowTimeId().equals(showTimeId) && 
                            ticket.getSeatNumber().equals(seatNumber)) {
                            seatTaken = true;
                            break;
                        }
                    }
                    
                    if (seatTaken) {
                        System.out.println("Seat " + seatNumber + " is already booked! Please try again.");
                        break;
                    }
                    
                    System.out.print("Enter customer name: ");
                    String customerName = scanner.nextLine();
                    Ticket newTicket = new Ticket(ticketId, showDate, roomNumber, seatNumber, customerName, showTimeId, movieId);
                    tickets.add(newTicket);
                    customerService.buyTicket(newTicket);
                    adminService.addTicket(newTicket);
                    break;
                case 2:
                    customerService.showTickets();
                    break;
                case 3:
                    System.out.println("Logout successful");
                    return;
                default:
                    System.out.println("Invalid choice");
            }
            System.out.println("--------------------------------");
            System.out.println("Enter any key to continue");
            scanner.nextLine();
        } while (choice != 3);
    }

    public static void login() {
        Admin admin = new Admin("admin", "123", "admin");
        Customer customer = new Customer("customer", "123", "customer");
        AdminService adminService = new AdminServiceImpl();
        CustomerService customerService = new CustomerServiceImpl();

        while (true) {
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
                            customerMenu(customer, customerService, adminService);
                        } else {
                            System.out.println("Login failed");
                        }
                        break;
                        
                    case 2:
                        System.out.println("Thank you for using the Movie Ticket Booking System");
                        return;
                        
                    default:
                        System.out.println("Invalid choice");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Invalid choice");
                scanner.nextLine();
            }
            
            System.out.println("--------------------------------");
            System.out.println("Enter any key to continue");
            scanner.nextLine();
        }
    }

    public static boolean isShowTimeIdExists(String showTimeId) {
        for (ShowTime showTime : showTimes) {
            if (showTime.getShowTimeId().equals(showTimeId)) {
                return true;
            }
        }
        return false;
    }
}
