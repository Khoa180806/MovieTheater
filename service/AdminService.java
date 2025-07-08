package service;

import entity.Movie;
import entity.ShowTime;
import entity.Ticket;

public interface AdminService {
    void addMovie(Movie movie);
    void addShowTime(ShowTime showTime);
    void addTicket(Ticket ticket);
    void findMovieById(String movieId);
    void findShowTimeById(String showTimeId);
    void updateMovieById(String movieId);
    void updateShowTimeById(String showTimeId);
    void deleteMovieById(String movieId);
    void deleteShowTimeById(String showTimeId);
    void showAllMovies();
    void showAllShowTimes();
    void showAllTickets();
}
