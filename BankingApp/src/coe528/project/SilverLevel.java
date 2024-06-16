/**
 *
 * @author Najiba Imam
 * date: March 23, 2024
 */

package coe528.project;

public class SilverLevel extends BankAccount {
    // doing an online purchase
    public void onlinePurchase(int amount){
        if(balance >= (amount + 20)){
            balance = balance - (amount + 20);
            DisplayBox.display("ONLINE PURCHASE CONFIRMATION", "You have made a purchase of $" + amount +"\nwith an additional service fee of $20.\n\nThe total cost is $" + (amount+20) + ".");    
        }
        else
            DisplayBox.display("WARNING", "Sorry, you don't have enough credit to make a purchase of $" + amount +"\nas the total cost is $" + (amount+20) + ".");
    }
    public String getLevel(){
        return "You're a SILVER Client!"; // displays the current level of the customer
    }
}
