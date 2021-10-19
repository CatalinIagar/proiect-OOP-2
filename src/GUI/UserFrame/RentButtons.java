package GUI.UserFrame;

import Classes.Account;
import Classes.Car;
import GUI.AdminFrame.AdminMenu;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RentButtons implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < Car.cars.size(); i++) {
            if (e.getSource() == UserMenu.userMenu.rentButton[i]) {
                Car currentCar = Car.cars.get(i);
                if (currentCar.isRent() == true)
                    JOptionPane.showMessageDialog(null, "This car is already rented.", "Rent car", JOptionPane.INFORMATION_MESSAGE);
                else {
                    int option = JOptionPane.showConfirmDialog(null, "Do you want to rent this car?", "Rent car", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

                    if (option == JOptionPane.YES_OPTION) {
                        currentCar.setRented(true);
                        UserMenu.userMenu.account.rentedCars.add(currentCar);
                    }
                }
            }
        }
    }
}
