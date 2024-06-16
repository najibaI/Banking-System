/**
 *
 * @author Najiba Imam
 * date: March 23, 2024
 */

package coe528.project;

import java.util.*;

/**
* @Overview BankAccounts are mutable, and they display how much money (ie. balance)
*           a user has in their account. The balance must be greater than or equal
*           to zero as the balance amount cannot be negative.
* 
*  The abstraction function is:
*  AF(c) = bank account, B, such that
*          B.balance = c.balance
*
*  The rep invariant is:
*  RI(c) = true if c.balance >= 0
*        = false otherwise
* 
*/

public abstract class BankAccount {
    // the rep
    protected int balance;  // this allows access within the same package and by subclasses within the program
    
    // constructor
    // REQUIRES: none
    // MODIFIES: none
    // EFFECTS: sets this.balance to 100
    public BankAccount(){
        this.balance = 100;   // each new customer's account will hold an initial balance of $100
    }
    
    // REQUIRES: none
    // MODIFIES: none
    // EFFECTS: returns balance
    protected int getBalance(){
        return this.balance;
    }
    
    // REQUIRES: newBal
    // MODIFIES: this.balance
    // EFFECTS: sets this.balance to the new balance if the new balance is greater than or equal to 0
    protected void setBalance(int newBal){
        if(newBal >= 0)
            this.balance = newBal;
    }
    
    // REQUIRES: amount
    // MODIFIES: this.balance
    // EFFECTS: adds amount to this.balance if the amount is not a negative integer
    protected void addAmount(int amount){
        this.balance = this.balance + amount;
    }
    
    // REQUIRES: amount
    // MODIFIES: this.balance
    // EEFECTS: removes amount from this.balance if the amount is not negative integer 
    //          and amount is less than or equal to this.balance
    protected void removeAmount(int amount){
        this.balance = this.balance - amount;
    }
    
    // REQUIRES: amount
    // MODIFIES: none
    // EFFECTS: If the amount is greater than or equal to $50, and if this.balance greater than or equal to
    // to the (amount and service fee), then the (amount and service fee) is subtracted from this.balance 
    public void onlinePurchase(int amount){
    
    } 
    
    // REQUIRES: none
    // MODIFIES: none
    // EFFECTS: returns state of customer's current level
    public  String getLevel(){
        return ""; // empty string for now
    }
    
    // REQUIRES: none
    // MODIFIES: none
    // EFFECTS: returns balance of this.balance (ie. abstraction function)
    @Override
    public String toString(){
        return "Your Balance is $" + balance;
    }
    
    // REQUIRES: none
    // MODIFIES: none
    // EFFECTS: Returns true if the Rep Invariant holds for this object; 
    //          otherwise returns false
    public boolean repOK(){
        if(this.balance > 0)
            return true;
        return false;
    }
    
}
