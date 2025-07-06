package entity;

public class Ticket {
    private String ticketId;
    private String showDate;
    private int roomNumber;
    private String seatNumber;
    private String customerName;
    private String showTimeId;
    private String movieId;

    public Ticket(String ticketId, String showDate, int roomNumber, String seatNumber, String customerName, String showTimeId, String movieId) {
        this.ticketId = ticketId;
        this.showDate = showDate;
        this.roomNumber = roomNumber;
        this.seatNumber = seatNumber;
        this.customerName = customerName;
        this.showTimeId = showTimeId;
        this.movieId = movieId;
    }

    public String getTicketId() {
        return ticketId;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
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

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getShowTimeId() {
        return showTimeId;
    }

    public void setShowTimeId(String showTimeId) {
        this.showTimeId = showTimeId;
    }

    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public String toString() {
        return "Ticket ID: " + this.ticketId + ", Show Date: " + this.showDate + ", Room Number: " + this.roomNumber + ", Seat Number: " + this.seatNumber + ", Customer Name: " + this.customerName + ", Show Time ID: " + this.showTimeId + ", Movie ID: " + this.movieId;
    }
}
