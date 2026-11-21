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
    
    public final String BIKE_EXISTS = "Bike %s already exists.%n";
    public final String INEXISTENT_STATION = "Station %s not found.%n";
    public final String NO_FREE_DOCKS = "Station %s does not have available docks.%n";
    public final String BIKE_SUCCESSFULLY_ADDED = "Station %s now has bike %s in one of its docking stations.%n";
    
    public final String USER_ALREADY_REGISTERED = "User %s already registered.%n";
    public final String USER_SUCCESSFULLY_ADDED = "User %s successfully registered with balance %.2f euros.%n";
    
    public static final int INITIAL_STATIONS_CAPACITY = 10;
    public static final int INITIAL_BIKES_CAPACITY = 10;
    public static final int INITIAL_CLIENTS_CAPACITY = 10;
    
    private Station[] stations = new Station[INITIAL_STATIONS_CAPACITY];
    private int stationsCount = 0;
    
    private Bike[] bikes = new Bike[INITIAL_BIKES_CAPACITY];
    private int bikesCount = 0;
    
    private Client[] clients = new Client[INITIAL_CLIENTS_CAPACITY];
    private int clientsCount = 0;

    public void growStations() {
        Station[] moreStations = new Station[stations.length + INITIAL_STATIONS_CAPACITY];
        
        for (int i = 0; i < stations.length; i++) {
            moreStations[i] = stations[i];
        }
        
        stations = moreStations;
    } 
    
    public void growBikes() {
        Bike[] moreBikes = new Bike[bikes.length + INITIAL_BIKES_CAPACITY];
        
        for (int i = 0; i < bikesCount; i++) {
            moreBikes[i] = bikes[i];
        }
        
        bikes = moreBikes;
    }
    
    public void growClients() {
        Client[] moreClients = new Client[clients.length + INITIAL_CLIENTS_CAPACITY];
        
        for (int i = 0; i < clientsCount; i++) {
            moreClients[i] = clients[i];
        }
        
        clients = moreClients;
    }
    
    public Station findStation(String stationName) {
        for (int i = 0; i<stationsCount; i++) {
            if (stations[i].existsStation(stationName)) {
                return stations[i];
            }
        }
        return null;
    }
    
    public Bike findBike(String bikeId) {
        for (int i = 0; i < bikesCount; i++) {
            if (bikes[i].existsBike(bikeId)) {
                return bikes[i];
            }
        }
        return null;
    }
    
    public Client findClient(String userName) {
        for (int i = 0; i < clientsCount; i++) {
            if (clients[i].equals(userName)) {
                return clients[i];
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
                growStations();
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
        
        if (findBike(bikeId) != null) {
            System.out.printf(BIKE_EXISTS, bikeId);
        } else if (findStation(stationName) == null) {
            System.out.printf(INEXISTENT_STATION, stationName);
        } else if (findStation(stationName) != null && !(findStation(stationName).existsFreeDock())) {
            System.out.printf(NO_FREE_DOCKS, stationName);    
        } else {
            addBike();
            System.out.printf(BIKE_SUCCESSFULLY_ADDED, stationName, bikeId);
        }
    }
    public void processRegister(Scanner in){
        String userName = in.next();
        int balance = in.nextInt();
        
        if (findClient(userName) != null) {
            System.out.printf(USER_ALREADY_REGISTERED, userName);
        } else if (findClient(userName) == null) {
            if (balance < 0) {
                Client newClient = Client(userName, balance = 0);
            }
        }
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
