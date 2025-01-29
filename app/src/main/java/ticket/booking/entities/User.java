package ticket.booking.entities;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class User {
    private String name;
    private String email;
    private String password;
    private String hashedPassword;
    private List<Ticket> ticketsBooked;
    private String userId;

    public <E> User(String userName, String hashedPassword, ArrayList<E> es, String string) {
        this.name = userName;
        this.hashedPassword = hashedPassword;
        this.ticketsBooked = new ArrayList<>();
        this.userId = string;
    }

    public User(String userNameToLogin, String passwordToLogin) {
        this.name = userNameToLogin;
        this.password = passwordToLogin;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getHashedPassword() {
        return hashedPassword;
    }

    private void saveUserListToFile() {
        File usersFile = new File("../localDb/users.json");
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writeValue(usersFile, this); // Save entire user data instead of just tickets
        } catch (IOException e) {
            System.err.println("Error saving user data: " + e.getMessage());
        }
    }

    public void printTickets() {
        for (Ticket ticket : ticketsBooked) {
            System.out.println(ticket.getTicketInfo());
        }
    }

    public boolean cancelTicket(String ticketId) {
        for (int i = 0; i < ticketsBooked.size(); i++) {
            if (ticketsBooked.get(i).getTicketId().equals(ticketId)) {
                ticketsBooked.remove(i);
                saveUserListToFile();
                return true;
            }
        }
        return false;
    }

    public String getSource() {
        return null;
    }

    public String getDestination() {
        return null;
    }
}
