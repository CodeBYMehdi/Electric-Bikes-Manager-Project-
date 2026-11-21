import java.util.Scanner;

/**
 * 
 *
 * @author Mehdi Ben Jemia
 * @version 0.0.1
 */

public class Main{
    public final  String INVALID_COMAND_MSG = "Invalid command .";
    
    public final String INSTALL = "install";
    public final String EXIT = "exit";
    public final String ADD = "add";
    public final String REGISTER = "register";
    public final String PICK_UP = "pickup";
    public final String RETURN = "return";
    public final String STATION = "station";
    public final String PAY  = "pay";
    public final String TOP = "top";
    
    public final String STATION_EXISTS = "Station %s already exists.%n";
    public final String INVALID_CAPACITY = "Station %s cannot be created with %d docking stations.%n";
    public final String STATION_SUCCESSFULLY_CREATED = "Station %s is available with %d docking stations.%n";
    
    public static final int INITIAL_STATIONS_CAPACITY = 10;
    
    private Station[] stations = new Station[INITIAL_STATIONS_CAPACITY];
    private int stationsCount = 0;
    
    

    public void growArray() {
        Station[] moreStations = new Station[stations.length + INITIAL_STATIONS_CAPACITY];
        
        for (int i = 0; i < stations.length; i++) {
            moreStations[i] = stations[i];
        }
        
        stations = moreStations;
    } 
    
    public Station findStation(String stationName) {
        for (int i = 0; i<stationsCount; i++) {
            if (stations[i].existsStation(stationName)) {
                return stations[i];
            }
        }
        return null;
    }
    
    public void processInstall(Scanner in) {
        String stationName = in.next();
        int capacity = in.nextInt();
        
        
        if (findStation(stationName) != null) {
            System.out.printf(STATION_EXISTS, stationName);
        } else if (capacity <= 0) {
            System.out.printf(INVALID_CAPACITY, stationName, capacity);
        } else {
            Bike[] dockedBikes = new Bike[capacity];
            Station newStation = new Station(stationName, capacity, dockedBikes);
            if (stationsCount < stations.length) {
                stations[stationsCount] = newStation;
                stationsCount++;
            } else {
                growArray();
                stations[stationsCount] = newStation;
                stationsCount++;
            }
            System.out.printf(STATION_SUCCESSFULLY_CREATED, stationName, capacity);
        }
        
    }
    public void processExit(Scanner in){
        //TODO
    }
    public void processAdd(Scanner in) {
        String bikeId = in.next();
        int battery = 100;
        String stationName = in.next();
        

        Bike newBike = new Bike(bikeId, battery);
    }
    public void processRegister(Scanner in){
        //TODO
    }
    public void processPickUp(Scanner in){
        //TODO
    }
    public void processReturn(Scanner in){
        //TODO
    }
    public void processStation(Scanner in){
        //TODO
    }
    public void processPay(Scanner in){
        //TODO
    }
    public void processTop(){
        //TODO mm
    }
    public void processUnknownCommand(){System.out.println(INVALID_COMAND_MSG);}
    
    
    void processCommands(Scanner in){
        String command;
        do {
            command = in.nextLine();
            executeOperations(in,
                    command);
        } while (!command.equals(EXIT) );
    }


    public  void executeOperations(Scanner in, String command) {
        switch (command) {
            case INSTALL -> processInstall(in);
            case EXIT -> processExit(in);
            case ADD -> processAdd(in);
            case REGISTER -> processRegister(in);
            case PICK_UP -> processPickUp(in);
            case RETURN -> processReturn(in);
            case STATION -> processStation(in);
            case PAY -> processPay(in);
            case TOP -> processTop();
            default -> processUnknownCommand();
        }
    }
    
    
    public static void main(String[] args) {
        Scanner in =  new Scanner(System.in);
        in.close();
    }
}
