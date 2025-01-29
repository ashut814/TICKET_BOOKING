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


    public Train(String trainId, String trainNumber, List<List<Integer>> seats, String source, String destination, Map<String, Time> stationTime, List<String> stations) {
        this.trainId = trainId;
        this.trainNumber = trainNumber;
        this.seats = seats;
        this.source = source;
        this.destination = destination;
        this.stationTime = stationTime;
        this.stations = stations;
    }


    public String getTrainId() {
        return trainId;
    }

    public String getTrainNumber() {
        return trainNumber;
    }

    public List<List<Integer>> getSeats() {
        return seats;
    }

    public String getSource() {
        return source;
    }

    public String getDestination() {
        return destination;
    }

    public Map<String, Time> getStationTime() {
        return stationTime;
    }

    public List<String> getStations() {
        return stations;
    }

}
