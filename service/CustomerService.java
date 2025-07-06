package service;

import entity.Ticket;

public interface CustomerService {
    void buyTicket(Ticket ticket);
    void showTickets();
}
