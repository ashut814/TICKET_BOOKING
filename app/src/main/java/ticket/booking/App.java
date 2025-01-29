package ticket.booking;

import ticket.booking.entities.User;
import ticket.booking.services.UserBookingService;
import ticket.booking.util.userServiceUtil;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;

public class App {

    public static void main(String[] args) {
        System.out.println("Running Train Booking System");

        try (Scanner scanner = new Scanner(System.in)) {
            UserBookingService userBookingService = new UserBookingService();
            int option = 0;

            while (option != 6) {
                System.out.println("\n1. Signup");
                System.out.println("2. Login");
                System.out.println("3. Fetch Booked Tickets");
                System.out.println("4. Book Ticket");
                System.out.println("5. Cancel Ticket");
                System.out.println("6. Exit");
                System.out.print("Enter your choice: ");

                if (scanner.hasNextInt()) {
                    option = scanner.nextInt();
                    scanner.nextLine();

                    switch (option) {
                        case 1:
                            System.out.print("Enter your username: ");
                            String userName = scanner.nextLine();
                            System.out.print("Enter your password: ");
                            String password = scanner.nextLine();

                            String hashedPassword = userServiceUtil.hashedPassword(password);
                            User userToSignup = new User(userName, hashedPassword, new ArrayList<>(), UUID.randomUUID().toString());
                            if (userBookingService.signup(userToSignup)) {
                                System.out.println("User signed up successfully!");
                            } else {
                                System.out.println("Signup failed.");
                            }
                            break;

                        case 2:
                            System.out.print("Enter your username: ");
                            String userNameToLogin = scanner.nextLine();
                            System.out.print("Enter your password: ");
                            String passwordToLogin = scanner.nextLine();

                            User userToLogin = new User(userNameToLogin, passwordToLogin);
                            if (userBookingService.login(String.valueOf(userToLogin))) {
                                System.out.println("User logged in successfully!");
                            } else {
                                System.out.println("Login failed.");
                            }
                            break;

                        case 3:
                            userBookingService.fetchTickets();
                            break;

                        case 4:
                            userBookingService.bookTicket("event1", "A1", "Ashutosh");
                            break; // Fixed missing method call

                        case 5:
                            System.out.print("Enter Ticket ID to cancel: ");
                            String ticketId = scanner.nextLine();
                            if (userBookingService.cancelTicket(ticketId)) {
                                System.out.println("Ticket canceled successfully.");
                            } else {
                                System.out.println("Cancellation failed. Ticket not found.");
                            }
                            break;

                        case 6:
                            System.out.println("Exiting...");
                            break;

                        default:
                            System.out.println("Invalid option. Please enter a number between 1 and 6.");
                    }
                } else {
                    System.out.println("Invalid input. Please enter a number.");
                    scanner.nextLine(); // Clear invalid input
                }
            }
        }
    }
}
