package ticket.booking.entities;

import java.sql.Time;
import java.util.List;
import java.util.Map;

public class Train {
    private String trainId;
    private String trainNumber;
    private List<List<Integer>> seats;
    private String source;
    private String destination;
    private Map<String, Time> stationTime;
    private List<String> stations; // List of station names>

}
