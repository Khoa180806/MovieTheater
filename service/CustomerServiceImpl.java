package service;

import java.util.ArrayList;
import java.util.List;

import entity.Ticket;

public class CustomerServiceImpl implements CustomerService {
    private List<Ticket> tickets = new ArrayList<>();

    @Override
    public void buyTicket(Ticket ticket) {
        tickets.add(ticket);
        System.out.println("Ticket bought successfully");
    }

    @Override
    public void showTickets() {
        for (Ticket t : tickets) {
            System.out.println(t);
        }
    }
}
