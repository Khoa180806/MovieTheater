package service;

import java.util.List;

import entity.Movie;
import entity.ShowTime;

public interface AdminService {
    void addMovie(Movie movie);
    void addShowTime(ShowTime showTime);
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
