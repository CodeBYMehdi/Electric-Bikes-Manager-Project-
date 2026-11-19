
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
    public Bike[] getDockedBikes() {return dockedBikes;}
    
    public boolean existsStation(String otherStation) {return stationName.equals(otherStation);}
    
}