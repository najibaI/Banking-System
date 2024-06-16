/**
 *
 * @author Najiba Imam
 * date: March 23, 2024
 */

package coe528.project;

public class PlatinumLevel extends BankAccount{
    // doing an online purchase
    public void onlinePurchase(int amount){
        if(balance >= amount){
            balance = balance - amount;
            DisplayBox.display("ONLINE PURCHASE CONFIRMATION", "You have made a purchase of $" + amount +"\nwith no additional service fee.\n\nThe total cost is $" + (amount) + ".");
        }
        else
            DisplayBox.display("WARNING", "Sorry, you don't have enough credit to make a purchase of $" + amount + ".");
    }
    public String getLevel(){
        return "You're a PLATINUM Client!";  // displays the current level of the customer
    }
}
