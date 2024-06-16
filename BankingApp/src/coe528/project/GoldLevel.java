/**
 *
 * @author Najiba Imam
 * date: March 23, 2024
 */

package coe528.project;

public class GoldLevel extends BankAccount {
    // doing an online purchase
    public void onlinePurchase(int amount){
        if(balance >= amount + 10) {
            balance = balance - (amount + 10);
            DisplayBox.display("ONLINE PURCHASE CONFIRMATION", "You have made a purchase of $" + amount +"\nwith an additional service fee of $10.\n\nThe total cost is $" + (amount+10) + ".");
        }
        else {
            DisplayBox.display("WARNING", "Sorry, you don't have enough credit to make a purchase of $" + amount +"\nas the total cost is $" + (amount+10) + "."); }
    }
    public String getLevel(){
        return "You're a GOLD Client!"; // displays the current level of the customer
    }
}
