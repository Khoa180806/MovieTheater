package service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entity.Movie;
import entity.ShowTime;
import entity.Ticket;

public class AdminServiceImpl implements AdminService {

    private static List<Movie> movies = new ArrayList<>();
    private static List<ShowTime> showTimes = new ArrayList<>();
    private static List<Ticket> tickets = new ArrayList<>();

    @Override
    public void addMovie(Movie movie) {
        this.movies.add(movie);
        System.out.println("Movie added successfully");
    }

    @Override
    public void addShowTime(ShowTime showTime) {
       this.showTimes.add(showTime);
        System.out.println("Show time added successfully");
    }

    @Override
    public void addTicket(Ticket ticket) {
        this.tickets.add(ticket);
    }

    @Override
    public void findMovieById(String movieId) {
        for (Movie movie : movies) {
            if (movie.getMovieId().equals(movieId)) {
                System.out.println(movie);
                return;
            }
        }
        System.out.println("Movie not found");
    }

    @Override
    public void findShowTimeById(String showTimeId) {
        for (ShowTime showTime : showTimes) {
            if (showTime.getShowTimeId().equals(showTimeId)) {
                System.out.println(showTime);
                return;
            }
        }
        System.out.println("Show time not found");
    }

    @Override
    public void updateMovieById(String movieId) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What do you want to update? ");
        System.out.println("--------------------------------");
        System.out.println("1. Update movie name");
        System.out.println("2. Update movie type");
        System.out.println("3. Update movie duration");
        System.out.println("--------------------------------");
        System.out.print("Choose your option: ");
        int option = scanner.nextInt();
        scanner.nextLine();
        switch (option) {
            case 1:
                System.out.print("Enter movie name: ");
                String movieName = scanner.nextLine();
                for (Movie m : movies) {
                    if (m.getMovieId().equals(movieId)) {
                        m.setMovieName(movieName);
                        System.out.println("Movie updated successfully");
                        return;
                    }
                }
                break;
            case 2:
                System.out.print("Enter movie type: ");
                String movieType = scanner.nextLine();
                for (Movie m : movies) {
                    if (m.getMovieId().equals(movieId)) {
                        m.setMovieType(movieType);
                        System.out.println("Movie updated successfully");
                        return;
                    }
                }
                break;
            case 3:
                System.out.print("Enter movie duration: ");
                String movieDuration = scanner.nextLine();
                for (Movie m : movies) {
                    if (m.getMovieId().equals(movieId)) {
                        m.setMovieDuration(movieDuration);
                        System.out.println("Movie updated successfully");
                        return;
                    }
                }
                break;
            default:
                System.out.println("Invalid option");
                break;
        }
        System.out.println("Movie not found");
    }

    @Override
    public void updateShowTimeById(String showTimeId) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What do you want to update? ");
        System.out.println("--------------------------------");
        System.out.println("1. Update show date");
        System.out.println("2. Update room number");
        System.out.println("3. Update movie id");
        System.out.println("--------------------------------");
        System.out.print("Choose your option: ");
        int option = scanner.nextInt();
        scanner.nextLine();
        switch (option) {
            case 1:
                System.out.print("Enter show date: ");
                String showDate = scanner.nextLine();
                for (ShowTime s : showTimes) {
                    if (s.getShowTimeId().equals(showTimeId)) {
                        s.setShowDate(showDate);
                        System.out.println("Show time updated successfully");
                        return;
                    }
                }
                break;
            case 2:
                System.out.print("Enter room number: ");
                int roomNumber = scanner.nextInt();
                scanner.nextLine();
                for (ShowTime s : showTimes) {
                    if (s.getShowTimeId().equals(showTimeId)) {
                        s.setRoomNumber(roomNumber);
                        System.out.println("Show time updated successfully");
                        return;
                    }
                }
                break;
            case 3:
                System.out.print("Enter movie id: ");
                String movieId = scanner.nextLine();
                for (ShowTime s : showTimes) {
                    if (s.getShowTimeId().equals(showTimeId)) {
                        s.setMovieId(movieId);
                        System.out.println("Show time updated successfully");
                        return;
                    }
                }
                break;
            default:
                System.out.println("Invalid option");
                break;
        }
        System.out.println("Show time not found");
    }

    @Override
    public void deleteMovieById(String movieId) {
        movies.removeIf(movie -> movie.getMovieId().equals(movieId));
        System.out.println("Movie deleted successfully");
    }

    @Override
    public void deleteShowTimeById(String showTimeId) {
        showTimes.removeIf(showTime -> showTime.getShowTimeId().equals(showTimeId));
        System.out.println("Show time deleted successfully");
    }

    @Override
    public void showAllMovies() {
        if (movies.isEmpty()) {
            System.out.println("No movies found");
        } else {
            for (Movie m : movies) {
                System.out.println(m);
            }
        }
    }

    @Override
    public void showAllShowTimes() {
        if (showTimes.isEmpty()) {
            System.out.println("No show times found");
        } else {
            for (ShowTime s : showTimes) {
                System.out.println(s);
            }
        }
    }

    @Override
    public void showAllTickets() {
        if (tickets.isEmpty()) {
            System.out.println("No tickets found");
        } else {
            for (Ticket t : tickets) {
                System.out.println("Ticket ID: " + t.getTicketId() + "\nShow Date: " + t.getShowDate() + "\nRoom Number: " + t.getRoomNumber() + "\nSeat Number: " + t.getSeatNumber() + "\nCustomer Name: " + t.getCustomerName());
            }
        }
    }
}