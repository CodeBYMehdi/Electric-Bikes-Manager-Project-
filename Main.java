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
    public final String EMPTY_STATION = "No bike available.%n";
    
    public final String BIKE_EXISTS = "Bike %s already exists.%n";
    public final String INEXISTENT_STATION = "Station %s not found.%n";
    public final String NO_FREE_DOCKS = "Station %s does not have available docks.%n";
    public final String BIKE_SUCCESSFULLY_ADDED = "Station %s now has bike %s in one of its docking stations.%n";
    
    public final String USER_ALREADY_REGISTERED = "User %s already registered.%n";
    public final String USER_SUCCESSFULLY_ADDED = "User %s successfully registered with balance %.2f euros.%n";
    public final String INEXISTENT_USER = "User %s not registered.%n";
    public final String INSUFFICIENT_BALANCE = "Insufficient balance.%n";
    
    public static final int INITIAL_STATIONS_CAPACITY = 10;
    public static final int INITIAL_BIKES_CAPACITY = 10;
    public static final int INITIAL_CLIENTS_CAPACITY = 10;
    
    
    public static final int CENTS_TO_EURO_COEFFICIENT = 100;
    
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
            if (clients[i].existsClient(userName)) {
                return clients[i];
            }
        }
        return null;
    }
    
    public void processInstall(Scanner in) {
        String stationName = in.next();
        int capacity = in.nextInt();
        
        Station correspondingStation = findStation(stationName);

        if (correspondingStation != null) {
            System.out.printf(STATION_EXISTS, stationName);
        } else if (capacity <= 0) {
            System.out.printf(INVALID_CAPACITY, stationName, capacity);
        } else {
            Bike[] dockedBikes = new Bike[capacity];
            Station newStation = new Station(stationName, capacity, dockedBikes);
            if (stationsCount == stations.length) {
                growStations();
            }
            stations[stationsCount] = newStation;
            stationsCount++;
            
            System.out.printf(STATION_SUCCESSFULLY_CREATED, stationName, capacity);
        }
        
    }
    public void processExit(Scanner in) {
        //TODO
    }
    public void processAdd(Scanner in) {
        String bikeId = in.next();
        String stationName = in.next();
        
        Bike correspondingBike = findBike(bikeId);
        Station correspondingStation = findStation(stationName);
        
        if (correspondingBike != null) {
            System.out.printf(BIKE_EXISTS, bikeId);
        } else if (correspondingStation == null) {
            System.out.printf(INEXISTENT_STATION, stationName);
        } else if (!correspondingStation.existsFreeDock()) {
            System.out.printf(NO_FREE_DOCKS, stationName);
        } else {
            Bike newBike = new Bike(bikeId);
            if (bikesCount == bikes.length) {
                growBikes();
            }
            correspondingStation.addBike(newBike);
            bikes[bikesCount] = newBike;
            bikesCount++;
            
            System.out.printf(BIKE_SUCCESSFULLY_ADDED, stationName, bikeId);
        }
    }
    public void processRegister(Scanner in){
        String userName = in.next();
        int balance = in.nextInt();
        
        if (findClient(userName) != null) {
            System.out.printf(USER_ALREADY_REGISTERED, userName);
        } else {
            if (balance < 0) {
                balance = 0;
            }
            Client newClient = new Client(userName, balance);
            if (clientsCount == clients.length) {
                growClients();
            }
            clients[clientsCount] = newClient;
            clientsCount++;
            
            System.out.printf(USER_SUCCESSFULLY_ADDED, userName, (double) balance/CENTS_TO_EURO_COEFFICIENT);   
        }
    }
    public void processPickUp(Scanner in){
        String userName = in.next();
        String stationName = in.next();
        int timestamp = in.nextInt();
        
        if (findClient(userName) == null) {
            System.out.printf(INEXISTENT_USER, userName);
        } else {
            if (!(findClient(userName).canPickBike())) {
                System.out.printf(INSUFFICIENT_BALANCE);
            }
        }
        if (findStation(stationName) == null) {
            System.out.printf(INEXISTENT_STATION, stationName);
        } else {
            if (findStation(stationName).isEmpty()) {
                System.out.printf(EMPTY_STATION);
            }
        }
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
        //TODO
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
