
/**
 * This class establishes the operating rules 
 * for the Electric Bike Stations
 *
 * @author Mehdi, Zakhar Alshuk
 * @version 0.0.1
 */
public class Station {
    
    private final  String stationName;
    private final int capacity;
    private final Bike[] dockedBikes;
    private int dockedBikesCount;
    
    public Station(String stationName, int capacity, Bike[] dockedBikes) {
        this.stationName = stationName;
        this.capacity = capacity;
        this.dockedBikes = dockedBikes;
        dockedBikesCount = 0;
    }
    
    public String getStationName() {return stationName;}
    
    public int getCapacity() {return capacity;}

    public int getDockedBikesCount() {return dockedBikesCount;}

    public BikeIterator getBikeIterator() {return new BikeIterator(dockedBikes,
        dockedBikesCount);}
    
    public boolean existsStation(String otherStation) {return stationName.equals(otherStation);}
    
    public boolean existsFreeDock() {return dockedBikesCount < capacity;}

    public boolean isEmpty() {return dockedBikesCount == 0;}

    public void addBike(Bike newBike) {
        dockedBikes[dockedBikesCount] = newBike;
        dockedBikesCount++;
    }

    public void rechargeBike(int elapesedMinutes) {
        for (int i = 0; i < dockedBikesCount; i++) {
            dockedBikes[i].rechargingBattery(elapesedMinutes);
        }
    }

    private boolean priority(Bike first, Bike second){
        if( first.getBattery() != second.getBattery()){
            return first.getBattery() > second.getBattery();
        }
        return first.getId().compareTo(second.getId()) < 0;
    }

    public Bike pickupBike(){
        int bestIndex = -1;
        for  (int i = 0; i < dockedBikesCount; i++) {
            Bike candidate = dockedBikes[i];
            if (candidate.canBePicked()&&(bestIndex == -1 ||
                    priority(candidate, dockedBikes[bestIndex]))) {
                bestIndex = i;
            }
        }
        if (bestIndex == -1){
            return null;
        }
        Bike chosen = dockedBikes[bestIndex];

        for(int i = bestIndex; i < dockedBikesCount-1; i++){
            dockedBikes[i] = dockedBikes[i+1];
        }

        dockedBikesCount--;
        dockedBikes[dockedBikesCount] = null;
        return chosen;
    }

    public Bike[] getSortedBikes(){
        Bike[] sortedBikes = new Bike[dockedBikesCount];

        for(int i = 0; i < dockedBikesCount; i++){
            sortedBikes[i] = dockedBikes[i];
        }
        return sortedBikes;
        //TODO Acabar a seleçãp !!!
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

    