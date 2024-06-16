/**
 *
 * @author Najiba Imam
 * date: March 23, 2024
 */

package coe528.project;
      
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.util.*;
        
public class Customer{
    // declaring the instance variables
    private String username;
    private String password;
    private BankAccount level;
    
    // constructor
    public Customer(String username, String password) {
        try{
            File loginInfo = new File(username + ".txt");
            if (loginInfo.createNewFile() == true) {
                System.out.println("Provided user: " + loginInfo.getName());  // will be printed out in the output console
                this.username = username;
                this.password = password;
                level = new SilverLevel(); // the bankAccount level can change to gold/platinum 
                                           // after depositing, withdrawing or purchasing online;
                                           // right now, it's set to silver
                FileWriter writeFile = new FileWriter(username + ".txt");
                writeFile.write(username + "\n");
                writeFile.write(password + "\n");
                writeFile.write("" + 100);
                writeFile.close(); 
            } 
            else if (loginInfo.exists()) {
                this.username = username;
                this.password = password;
                level = new SilverLevel();
            } 
            else if (loginInfo.getName().equals(username)){
                DisplayBox.display("ERROR", "Username already taken! Please try again.");
            }
        }
        catch(IOException e){
            System.out.println("IOException error occurred!");
        } 
    }

    // all the getters of this class
    public int getBalance(){
        return level.getBalance();
    }
    
    public String getUsername(){
        return username;
    }
    public String getPassword(){ 
       return password;
    }
    
    public String getLevel(){
        return level.getLevel();
    }
    
    // the setter of this class
    public void setLevel(){ 
        int balance = level.getBalance();

        switch(balance/10000) {
            case 0:  // if balance is less than $10000
                level = new SilverLevel();
                break;
            case 1:  // if balance is exactly $10000 or more but less than $20000
                level = new GoldLevel();
                break;
            default:  // if balance is more than $20000
                level = new PlatinumLevel();
                break;
        }
        level.setBalance(balance);
    }
    
    public void depositMoney(int amount){
        level.addAmount(amount);
        DisplayBox.display("DEPOSIT", "$" + amount + " has been deposited for your account.");
        this.setLevel();
    }

    public void withdrawMoney(int amount){
        if(level.getBalance() >= amount){
            level.removeAmount(amount);
            DisplayBox.display("WITHDRAWAL", "$" + amount + " has been withdrawn from your account."); 
            this.setLevel();
        }
        else
             DisplayBox.display("WARNING", "Sorry, you do not have enough credit to withdraw $" + amount + "."); 
            
    }
    public void onlinePurchase(int amount){
        if(amount < 50){
            // returns an error message saying that the online purchase couldn't be made because of the conditions
            DisplayBox.display("ERROR", "Online purchase must be $50 or more!"); 
            return; }
        level.onlinePurchase(amount);
        this.setLevel();
    }
    
}

