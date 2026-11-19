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
    public final  String ADD = "add";
    public final String REGISTER = "register";
    public final String PICK_UP = "pickup";
    public final String RETURN = "return";
    public final String STATION = "station";
    public final String PAY  = "pay";
    public final String TOP = "top";

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
    public void processInstall(Scanner in){}
    public void processExit(Scanner in){}
    public void processAdd(Scanner in){}
    public void processRegister(Scanner in){}
    public void processPickUp(Scanner in){}
    public void processReturn(Scanner in){}
    public void processStation(Scanner in){}
    public void processPay(Scanner in){}
    public void processTop(){}
    public void processUnknownCommand(){System.out.println(INVALID_COMAND_MSG);}


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
}
