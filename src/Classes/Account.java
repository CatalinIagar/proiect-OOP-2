package Classes;

import javax.swing.*;
import java.util.ArrayList;

public class Account {
    public static ArrayList<Account> accounts = new ArrayList<>();

    private String username;
    private char[] password;
    private String firstName;
    private String lastName;
    private String idNumber;
    private String address;
    private String phoneNumber;
    private boolean blocked;
    public ArrayList<Car> rentedCars = new ArrayList<>();

    public Account(String username, char[] password, String firstName, String lastName, String idNumber, String address, String phoneNumber){
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.idNumber = idNumber;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.blocked = false;
    }

    public static boolean usernameAlreadyExists(String username){
        for(Account currentAccount: accounts)
        {
            if (currentAccount.username.equals(username))
                return true;
        }
        return false;
    }

    public static Account checkUsername(String username){
        for (Account currentAccount: accounts){
            if (currentAccount.username.equals(username))
                return currentAccount;
        }
        return null;
    }

    public boolean checkPassword(char[] password) {
        if (this.password.length != password.length)
            return false;
        for (int i = 0; i < this.password.length; i++)
            if (this.password[i] != password[i])
                return false;
        return true;
    }

    public char[] getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public boolean isBlocked() {
        return blocked;
    }

    public void setBlocked(boolean blocked) {
        this.blocked = blocked;
    }
}
