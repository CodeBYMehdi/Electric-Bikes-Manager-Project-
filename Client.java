
/**
 * This class defines the behavior of the Client/User 
 *
 * @author Mehdi, Zakhar
 * @version 0.0.1
 */
public class Client {
    
    private String name;
    private int balance;
    
    public Client(String name, int balance) {
        this.name = name;
        this.balance = balance;
    }
    
    public String getName() {return name;}
    public int getBalance() {return balance;}
    
    public boolean canPickBike() {return balance >= 100;}
    

    
    public void pay(int amount) {
        if (amount > 0) {
            balance += amount;
        }
    }
    
    
    

}