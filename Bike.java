
/**
 * This class establishes the limits, 
 * the functioning and the rules
 * for renting electric bikes.
 *
 * @author Mehdi, Zakhar Alshuk
 * @version 0.0.1
 */
public class Bike {
    private String bikeId;
    private int battery;
    
    public Bike(String bikeId, int battery) {
        this.bikeId = bikeId;
        battery = 100;
    }
    
    public String getId() {return bikeId;}
    public int getBattery() {return battery;}
    
    public boolean existsBike(String otherBike) {return bikeId.equals(otherBike);}
    
    public boolean canBePicked() {return battery > 20;}
    
    public boolean isFullyCharged() {return battery == 100;}
    
    public void batteryUsage(int time) {
       battery -= (time/5);
       if (battery < 0) {
           battery = 0; 
       }
    }
    
    public int rechargingBattery(int time) {
        battery += time;
        if (battery > 100) {
            battery = 100;
        }
        return battery;
    }
}