package ticket.booking.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import ticket.booking.entities.Ticket;
import ticket.booking.entities.Train;
import ticket.booking.entities.User;
import ticket.booking.util.userServiceUtil;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserBookingService {

    private User user;

    private List<User> userList; // <User>
    private static final String USERS_FILE_PATH = "/Users/Ashutosh/irctc-app/app/src/main/java/ticket/booking/localDb/users.json";



    private ObjectMapper OBJECT_MAPPER = new ObjectMapper();
    public UserBookingService(User user) throws IOException {
        this.user = user;
        loadUsers();
    }

    public UserBookingService() {
        loadUsers();
    }

    public List<User> loadUsers() {
        File users = new File(USERS_FILE_PATH);

        try {
            if (users.exists() && users.length() > 0) {
                userList = OBJECT_MAPPER.readValue(users, new TypeReference<List<User>>() {});
            } else {
                userList = new ArrayList<>();
                System.out.println("User file is empty or does not exist. Starting with an empty list.");
            }
        } catch (IOException e) {
            System.out.println("Error reading users file: " + e.getMessage());
            userList = new ArrayList<>();
        }
        return userList;
    }


    public Boolean login(String username) {
        Optional<User> foundUser = userList.stream()
                .filter(existingUser -> existingUser.getName().equals(username)
                        && userServiceUtil.checkPassword(this.user.getPassword(), existingUser.getHashedPassword()))
                .findFirst();
        return foundUser.isPresent();
    }


    public boolean signup(User user1) {
        try {
            userList.add(user1);
            saveUserListToFile();
            return true;
        } catch (Exception e) {
            System.out.println("'exeption' while saving user list to file");
            return false;
        }
    }

    private void saveUserListToFile() {
        try {
            File usersFile = new File(USERS_FILE_PATH);
            OBJECT_MAPPER.writeValue(usersFile, userList);
        } catch (IOException e) {
            System.out.println("seedhe expection pe jaa raha hu");
        }
    }


    public void fetchTickets() {
        user.printTickets();
    }

    public boolean cancelTicket(String ticketId) {
        return user.cancelTicket(ticketId);
    }

    public void bookTicket(String eventId, String seatNumber, String a) {
        Ticket newTicket = new Ticket(eventId,seatNumber,user.getName());
    }

    public List<Train> getTrains() {
        return new TrainService().searchTrains(user.getSource(), user.getDestination());
    }
}
