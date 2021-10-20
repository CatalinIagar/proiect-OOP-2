package Main;

import Classes.Account;
import Classes.Car;
import GUI.AdminFrame.AdminLoginFrame;
import GUI.AdminFrame.AdminMenu;
import GUI.MainFrame.MainMenu;
import GUI.UserFrame.UserMenu;

public class Main {
    public static void main(String[] args) {
        Account.accounts.add(new Account("test1", "A65p96xyz@".toCharArray(), "asd", "asd", "5010623260052", "asd", "0734512363"));
        Account.accounts.add(new Account("test2", "A65p96xyz@".toCharArray(), "asd", "asd", "5010623260052", "asd", "0734512363"));
        Account.accounts.add(new Account("test3", "A65p96xyz@".toCharArray(), "asd", "asd", "5010623260052", "asd", "0734512363"));
        Account.accounts.add(new Account("test4", "A65p96xyz@".toCharArray(), "asd", "asd", "5010623260052", "asd", "0734512363"));
        Account.accounts.add(new Account("test5", "A65p96xyz@".toCharArray(), "asd", "asd", "5010623260052", "asd", "0734512363"));
        Account.accounts.add(new Account("test6", "A65p96xyz@".toCharArray(), "asd", "asd", "5010623260052", "asd", "0734512363"));
        Account.accounts.add(new Account("test7", "A65p96xyz@".toCharArray(), "asd", "asd", "5010623260052", "asd", "0734512363"));

        Car.cars.add(new Car("Dacia", "Logan", "Rosu"));
        Car.cars.add(new Car("VW", "Golf", "Negru"));
        Car.cars.add(new Car("Skoda", "Fabia", "Verde"));
        Car.cars.add(new Car("Opel", "Astra", "Alb"));


        MainMenu.mainFrame = new MainMenu();
        //AdminLoginFrame.adminLoginFrame = new AdminLoginFrame();
        //UserMenu.userMenu = new UserMenu(Account.accounts.get(0));
    }
}
