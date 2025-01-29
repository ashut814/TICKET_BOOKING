package ticket.booking.services;

import ticket.booking.entities.Train;

import java.util.List;

public class TrainService {

    private List<Train> trainList; // <Train>
    public List<Train> searchTrains(String source, String destination) {
        return trainList.stream()
                .filter(train -> validateTrain(train, source, destination))
                .toList();

    }

    private boolean validateTrain(Train train, String source, String destination) {
       List<String> stations = train.getStations();
       int sourceIndex = stations.indexOf(source);
       int destinationIndex = stations.indexOf(destination);
       return sourceIndex != -1 && destinationIndex != -1 && sourceIndex < destinationIndex;
    }
}
