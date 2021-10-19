package GUI.UserFrame;

import Classes.Account;
import Classes.Car;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GiveBackButtons implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < UserMenu.userMenu.account.rentedCars.size(); i++) {
            if (e.getSource() == UserMenu.userMenu.giveBackButton[i]) {
                Car currentCar = UserMenu.userMenu.account.rentedCars.get(i);
                int option = JOptionPane.showConfirmDialog(null, "Do you want to return this car?", "Return car", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

                if (option == JOptionPane.YES_OPTION) {
                    currentCar.setRented(false);
                    UserMenu.userMenu.account.rentedCars.remove(currentCar);
                }
            }
        }
    }
}
