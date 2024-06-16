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

public class Manager {
    // declaring the instance variables
    private final String username = "admin";
    private final String password = "admin"; 

    // constructor
    public Manager(){
        try{
            File loginInfo = new File(username + ".txt");
            if(loginInfo.createNewFile() == true){
                FileWriter writeFile = new FileWriter(username + ".txt");
                writeFile.write(username + "\n");
                writeFile.write(password);
                writeFile.close();
            }
        }

        catch(IOException e){
            System.out.println("IOException occured!");
        }
 
    }
    
    public Customer addCustomer(String username, String password){
        return new Customer(username,password);
    }
   
    public void deleteCustomer(Customer userToDelete){
        File file = new File(userToDelete.getUsername() + ".txt");
        if(file.delete()) {
            DisplayBox.display("CONFIRMATION", "File of user successfully deleted!"); }
    }
}
