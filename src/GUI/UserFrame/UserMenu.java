package GUI.UserFrame;

import Classes.Account;
import Classes.Car;
import GUI.AdminFrame.AdminMenu;
import GUI.AdminFrame.DeleteButtons;
import GUI.MainFrame.MainMenu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserMenu extends JFrame{
    public static UserMenu userMenu;
    public Account account;

    JPanel leftPanel;
    JPanel rightPanel;

    JLabel userLabel;
    JButton showCarsButton;
    JButton signOutButton;
    JButton showRentedCars;

    JLabel[] cars;
    JLabel[] rentedCars;
    JButton[] rentButton;
    JButton[] giveBackButton;

    public UserMenu(Account currentAccount){

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new GridLayout(0, 2, 15, 15));
        this.setPreferredSize(new Dimension(1024, 480));
        this.setResizable(false);
        this.setTitle("User page");
        this.account = currentAccount;

        cars = new JLabel[Car.cars.size()];
        rentedCars = new JLabel[currentAccount.rentedCars.size()];
        rentButton = new JButton[Car.cars.size()];
        giveBackButton = new JButton[(currentAccount.rentedCars.size())];

        //Left label
        leftPanel = new JPanel();
        leftPanel.setLayout(new GridLayout(6, 0, 15, 10));

        userLabel = new JLabel("User menu");
        userLabel.setPreferredSize(new Dimension(512, 48));
        userLabel.setVerticalAlignment(JLabel.CENTER);
        userLabel.setHorizontalAlignment(JLabel.CENTER);
        userLabel.setFont(new Font("Arial", Font.BOLD, 25));

        showCarsButton = new ShowCars();
        showRentedCars = new ShowRentedCars(currentAccount);

        signOutButton = new JButton("Sign out");
        signOutButton.addActionListener(new SignOutButton());

        leftPanel.add(userLabel);
        leftPanel.add(showCarsButton);
        leftPanel.add(showRentedCars);
        leftPanel.add(signOutButton);

        //RightPanel
        rightPanel = new JPanel();
        rightPanel.setLayout(new GridLayout(0, 2, 15, 10));

        this.add(leftPanel);
        this.add(rightPanel);

        this.pack();
        this.setVisible(true);
    }

    public class ShowCars extends JButton implements ActionListener {

        public ShowCars() {
            this.setText("Show Cars");
            this.addActionListener(this);
            this.setPreferredSize(new Dimension(512, 48));
        }

        @Override
        public void actionPerformed(ActionEvent e) {

            cars = new JLabel[Car.cars.size()];
            rentButton = new JButton[Car.cars.size()];

            UserMenu.userMenu.remove(rightPanel);
            rightPanel.removeAll();

            for (int i = 0; i < Car.cars.size(); i++) {
                Car currentCar = Car.cars.get(i);
                String carDetails = currentCar.getMake() + " " + currentCar.getModel() + " " + currentCar.getColor();
                cars[i] = new JLabel(carDetails);

                rentButton[i] = new JButton("Rent car");
                rentButton[i].setPreferredSize(new Dimension(100, 35));
                rentButton[i].addActionListener(new RentButtons());

                rightPanel.add(cars[i]);
                rightPanel.add(rentButton[i]);
            }

            UserMenu.userMenu.add(rightPanel);
            UserMenu.userMenu.revalidate();
            UserMenu.userMenu.repaint();

        }
    }

    public class ShowRentedCars extends JButton implements ActionListener {
        private Account account;

        public ShowRentedCars(Account currentAccount) {
            this.setText("Show rented cars");
            this.addActionListener(this);
            this.setPreferredSize(new Dimension(512, 48));
            this.account = currentAccount;
        }

        @Override
        public void actionPerformed(ActionEvent e) {

            rentedCars = new JLabel[account.rentedCars.size()];
            giveBackButton = new JButton[(account.rentedCars.size())];

            UserMenu.userMenu.remove(rightPanel);
            rightPanel.removeAll();

            for (int i = 0; i < account.rentedCars.size(); i++) {
                Car currentCar = account.rentedCars.get(i);
                String carDetails = currentCar.getMake() + " " + currentCar.getModel() + " " + currentCar.getColor();
                rentedCars[i] = new JLabel(carDetails);

                giveBackButton[i] = new JButton("Return car");
                giveBackButton[i].setPreferredSize(new Dimension(100, 35));
                giveBackButton[i].addActionListener(new GiveBackButtons());

                rightPanel.add(rentedCars[i]);
                rightPanel.add(giveBackButton[i]);
            }

            UserMenu.userMenu.add(rightPanel);
            UserMenu.userMenu.revalidate();
            UserMenu.userMenu.repaint();

        }
    }

    public class SignOutButton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int option = JOptionPane.showConfirmDialog(null, "Are you sure you want to sign out?", "Sign out", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

            if (option == JOptionPane.YES_OPTION){
                UserMenu.userMenu.dispose();
                MainMenu.mainFrame = new MainMenu();
            }
        }
    }
}
