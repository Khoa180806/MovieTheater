package service;

import java.util.ArrayList;
import java.util.List;

import entity.Movie;
import entity.ShowTime;
import entity.Ticket;

public class AdminServiceImpl implements AdminService {

    private static List<Movie> movies = new ArrayList<>();
    private static List<ShowTime> showTimes = new ArrayList<>();
    private static List<Ticket> tickets = new ArrayList<>();

    @Override
    public void addMovie(List<Movie> movies) {
        this.movies.addAll(movies);
        System.out.println("Movie added successfully");
    }

    @Override
    public void addShowTime(List<ShowTime> showTimes) {
       this.showTimes.addAll(showTimes);
        System.out.println("Show time added successfully");
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
    public void updateMovieById(String movieId, Movie movie) {
        for (Movie m : movies) {
            if (m.getMovieId().equals(movieId)) {
                m.setMovieName(movie.getMovieName());
                m.setMovieType(movie.getMovieType());
                m.setMovieDuration(movie.getMovieDuration());
                System.out.println("Movie updated successfully");
                return;
            }
        }
        System.out.println("Movie not found");
    }

    @Override
    public void updateShowTimeById(String showTimeId, ShowTime showTime) {
        for (ShowTime s : showTimes) {
            if (s.getShowTimeId().equals(showTimeId)) {
                s.setShowTimeId(showTime.getShowTimeId());
                s.setShowDate(showTime.getShowDate());
                s.setRoomNumber(showTime.getRoomNumber());
                s.setMovieId(showTime.getMovieId());
                System.out.println("Show time updated successfully");
                return;
            }
        }
        System.out.println("Show time not found");
    }

    @Override
    public void deleteMovieById(String movieId) {
        for (Movie m : movies) {
            if (m.getMovieId().equals(movieId)) {
                movies.remove(m);
                System.out.println("Movie deleted successfully");
                return;
            }
        }
        System.out.println("Movie not found");
    }

    @Override
    public void deleteShowTimeById(String showTimeId) {
        for (ShowTime s : showTimes) {
            if (s.getShowTimeId().equals(showTimeId)) {
                showTimes.remove(s);
                System.out.println("Show time deleted successfully");
                return;
            }
        }
        System.out.println("Show time not found");
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
                System.out.println(t);
            }
        }
    }
}