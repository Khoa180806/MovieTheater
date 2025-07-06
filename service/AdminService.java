package service;

import java.util.List;

import entity.Movie;
import entity.ShowTime;

public interface AdminService {
    void addMovie(List<Movie> movies);
    void addShowTime(List<ShowTime> showTimes);
    void findMovieById(String movieId);
    void findShowTimeById(String showTimeId);
    void updateMovieById(String movieId, Movie movie);
    void updateShowTimeById(String showTimeId, ShowTime showTime);
    void deleteMovieById(String movieId);
    void deleteShowTimeById(String showTimeId);
    void showAllMovies();
    void showAllShowTimes();
    void showAllTickets();
}
