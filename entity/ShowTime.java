package entity;

public class ShowTime {
    private String showTimeId;
    private String showDate;
    private int roomNumber;
    private String movieId;

    public ShowTime(String showTimeId, String showDate, int roomNumber, String movieId) {
        this.showTimeId = showTimeId;
        this.showDate = showDate;
        this.roomNumber = roomNumber;
        this.movieId = movieId;
    }

    public String getShowTimeId() {
        return showTimeId;
    }

    public void setShowTimeId(String showTimeId) {
        this.showTimeId = showTimeId;
    }

    public String getShowDate() {
        return showDate;
    }

    public void setShowDate(String showDate) {
        this.showDate = showDate;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public String toString() {
        return "Show Time ID: " + this.showTimeId + ", Show Date: " + this.showDate + ", Room Number: " + this.roomNumber + ", Movie ID: " + this.movieId;
    }
}
