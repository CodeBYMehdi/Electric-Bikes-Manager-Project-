
/**
 * This class establishes the operating rules 
 * for the Electric Bike Stations
 *
 * @author Mehdi, Zakhar Alshuk
 * @version 0.0.1
 */
public class Station {
    
    private String stationName;
    private int capacity;
    private Bike[] dockedBikes;
    
    public Station(String stationName, int capacity, Bike[] dockedBikes) {
        this.stationName = stationName;
        this.capacity = capacity;
        this.dockedBikes = dockedBikes;
    }
    
    public String getStationName() {return stationName;}
    public int getCapacity() {return capacity;}
    
    public boolean existsStation(String otherStation) {return stationName.equals(otherStation);}
    
    public boolean canBeReturned() {return dockedBikes.length < capacity;}
    
    public void addBike() {
        //TODO
    }
    
}

public class BikeIterator {
    private Bike[] dockedBikes;
    private int capacity;
    private int nextIndex;
        
    public BikeIterator(Bike[] dockedBikes, int capacity) {
        this.dockedBikes = dockedBikes;
        this.capacity = capacity;
        nextIndex = 0;
    } 
    
    public boolean hasNext() {return nextIndex < capacity;}
    
    public Bike next() {return dockedBikes[nextIndex++];}
}

    