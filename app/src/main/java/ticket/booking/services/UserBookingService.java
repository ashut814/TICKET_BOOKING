package ticket.booking.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import ticket.booking.entities.User;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

public class UserBookingService {

    private User user;

    private List<User> userList; // <User>
    private static final String USERS_FILE_PATH = "../localDb/users.json";

    private ObjectMapper OBJECT_MAPPER = new ObjectMapper();
    public UserBookingService(User user) throws IOException {
        this.user = user;
        File users = new File(USERS_FILE_PATH);
        userList = OBJECT_MAPPER.readValue(users, new TypeReference<List<User>>() {});
    }

    public Boolean login(){
        Optional<User> foundUser = userList.stream().filter(user1 -> {
            return user1.getName().equals(this.user.getName()) && user1.getPassword().equals(this.user.getPassword());
        }).findFirst();
        return foundUser.isPresent();
    }
}
