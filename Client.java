
/**
 * This class defines the behavior of the Client/User 
 *
 * @author Mehdi, Zakhar Alshuk
 * @version 0.0.1
 */
public class Client {
    
    private String userName;
    private int balance;
    
    public Client(String userName, int balance) {
        this.userName = userName;
        this.balance = balance;
    }
    
    public String getUserName() {return userName;}
    public int getBalance() {return balance;}
    
    public boolean canPickBike() {return balance >= 100;}
    
    public boolean existsClient(String otherClient) {return otherClient.equals(userName);}
    
    public void pay(int amount) {
        if (amount > 0) {
            balance += amount;
        }
    }
    
    
    

}