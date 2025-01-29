package ticket.booking.entities;

import java.util.Date;

public class Ticket {
    private String ticketId;
    private String userId;
    private String source;
    private String destination;
    private Date dateOfTravel;
    private String price;

    private  Train train;

    public Ticket(String ticketId, String userId, String source, String destination, Date dateOfTravel, String price, Train train) {
        this.ticketId = ticketId;
        this.userId = userId;
        this.source = source;
        this.destination = destination;
        this.dateOfTravel = dateOfTravel;
        this.price = price;
        this.train = train;
    }

    public Ticket(String eventId, String seatNumber, String name) {
        this.ticketId = eventId;
        this.userId = name;
        this.source = seatNumber;
    }


    public String getTicketInfo() {
        return "Ticket Id: " + ticketId + ", User Id: " + userId + ", Source: " + source + ", Destination: " + destination + ", Date of Travel: " + dateOfTravel + ", Price: " + price;
    }

    public String getTicketId(){
        return ticketId;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Date getDateOfTravel() {
        return dateOfTravel;
    }

    public void setDateOfTravel(Date dateOfTravel) {
        this.dateOfTravel = dateOfTravel;
    }

    public Train getTrain() {
        return train;
    }

    public void setTrain(Train train) {
        this.train = train;
    }
}
