
/**
 * This class defines the behavior of the Client/User 
 *
 * @author Mehdi, Zakhar Alshuk
 * @version 0.0.1
 */
public class Client {
    private Bike currentBike;
    private int pickupTime;
    private int complTrips; // completed trips
    private int totalMinutes;
    private final String userName;
    private int balance;

    public Client(String userName, int balance) {
        this.userName = userName;
        this.balance = balance;
    }
    public Bike getCurrentBike() {return currentBike;}
    public int getComplTrips() {return complTrips;}
    public int getTotalMinutes() {return totalMinutes;}

    public boolean isRiding(){return currentBike != null;}

    public String getUserName() {return userName;}
    public int getBalance() {
        if(balance < 0){return 0;}
        return balance;
    }
    
    public boolean canPickBike() {return balance >= 100;}
    
    public boolean existsClient(String otherClient) {return userName.equals(otherClient);}

    public void startRide(Bike bike , int timestamp ){
        currentBike = bike;
        pickupTime = timestamp;

    }
    public void pay(int amount) {
        if (amount > 0) {
            balance += amount;
        }
    }
    public int finishRide( int timestamp){
        int duration = timestamp - pickupTime;
        int parts = 1 + (duration - 1)/45;
        int cost = parts * 100;
        currentBike.batteryUsage(duration);
        balance -= cost;
        complTrips++;
        totalMinutes += duration;
        currentBike  = null;
        return cost;
    }

    
    

}