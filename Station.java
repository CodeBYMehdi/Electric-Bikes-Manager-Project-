
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
    private int dockedBikesCount;
    
    public Station(String stationName, int capacity, Bike[] dockedBikes) {
        this.stationName = stationName;
        this.capacity = capacity;
        this.dockedBikes = dockedBikes;
        dockedBikesCount = 0;
    }
    
    public String getStationName() {return stationName;}
    
    public int getCapacity() {return capacity;}
    
    public boolean existsStation(String otherStation) {return stationName.equals(otherStation);}
    
    public boolean existsFreeDock() {return dockedBikesCount < capacity;}
    
    public void addBike(Bike newBike) {
        dockedBikes[dockedBikesCount] = newBike;
        dockedBikesCount++;
    }
    
}

class BikeIterator {
    private Bike[] dockedBikes;
    private int dockedBikesCount;
    private int nextIndex;
        
    public BikeIterator(Bike[] dockedBikes, int dockedBikesCount) {
        this.dockedBikes = dockedBikes;
        this.dockedBikesCount = dockedBikesCount;
        nextIndex = 0;
    } 
    
    public boolean hasNext() {return nextIndex < dockedBikesCount;}
    
    public Bike next() {return dockedBikes[nextIndex++];}
}

    