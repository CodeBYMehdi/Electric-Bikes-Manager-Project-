import java.util.Scanner;

/**
 * 
 *
 * @author Mehdi Ben Jemia,Zakhar Alshuk
 * @version 0.0.1
 */

public class Main{
    public final String INVALID_COMAND_MSG = "Invalid command.";
    public final String EXIT_MSG = "Application exited.";
    public final String INSTALL = "install";
    public final String EXIT = "exit";
    public final String ADD = "add";
    public final String REGISTER = "register";
    public final String PICK_UP = "pickup";
    public final String RETURN = "return";
    public final String STATION = "station";
    public final String PAY  = "pay";
    public final String TOP = "top";
    public static final String STATION_EXISTS = "Station %s already exists.%n";
    public static final String INVALID_CAPACITY = "Station %s cannot be created with %d docking stations.%n";
    public static final String STATION_CREATED = "Station %s is available with %d docking stations.%n";
    public static final String EMPTY_STATION = "No bike available.%n";
    public static final String BIKE_EXISTS = "Bike %s already exists.%n";
    public static final String STATION_DOES_NOT_EXISTS = "Station %s  not found.%n";
    public static final String BIKE_ADDED = "Station %s now has bike %s in one of its docking stations.%n";
    public static final String USER_ADDED = "User %s successfully registered with balance %s euros.%n";
    public static final String USER_ALREADY_EXISTS = "User %s already registered.%n";
    public static final String USER_DONT_EXISTS = "User %s not registered.%n";
    public static final String INSUFFICIENT_BALANCE = "Insufficient balance.%n";


    public static void main(String[] args) {
        Scanner in =  new Scanner(System.in);
        in.close();
    }
    void processCommands(Scanner in){
        String command;
        do {
            command = in.nextLine();
            executeOperations(in,
                    command);
        } while (!command.equals(EXIT) );
    }
    public void processInstall(Scanner in){
        //TODO
    }
    public void processExit(){
        System.out.printf(EXIT_MSG);
    }
    public void processAdd(Scanner in){
        //TODO
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


    public  void executeOperations(Scanner in, String command) {
        switch (command) {
            case INSTALL -> processInstall(in);
            case EXIT -> processExit();
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
}
