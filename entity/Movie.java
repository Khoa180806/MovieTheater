package entity;

public class Movie {
    private String movieId;
    private String movieName;
    private String movieType;
    private String movieDuration;

    public Movie(String movieId, String movieName, String movieType, String movieDuration) {
        this.movieId = movieId;
        this.movieName = movieName;
        this.movieType = movieType;
        this.movieDuration = movieDuration;
    }

    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getMovieType() {
        return movieType;
    }

    public void setMovieType(String movieType) {
        this.movieType = movieType;
    }

    public String getMovieDuration() {
        return movieDuration;
    }

    public void setMovieDuration(String movieDuration) {
        this.movieDuration = movieDuration;
    }

    public String toString() {
        return "Movie ID: " + this.movieId + ", Movie Name: " + this.movieName + ", Movie Type: " + this.movieType + ", Movie Duration: " + this.movieDuration;
    }
}
