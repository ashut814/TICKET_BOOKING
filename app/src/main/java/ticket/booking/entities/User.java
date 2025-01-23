package ticket.booking.entities;

import java.util.List;

public class User {

    private String name;

    private String email;

    private String password;

    private String hashedPassword;

    private List<Ticket> ticketsBooked;

    private String userId;

    public Object getEmail() {
        return email;
    }

    public Object getPassword() {
        return password;
    }
}
