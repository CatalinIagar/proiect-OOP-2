package GUI.AdminFrame;

import Classes.Account;
import Classes.Car;
import GUI.MainFrame.MainMenu;
import Main.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminMenu extends JFrame {
    public static AdminMenu adminMenu;

    JPanel leftPanel;
    JPanel rightPanel;

    JLabel adminLabel;
    JButton showCarsButton;
    JButton showAccButton;
    JButton addCarButton;
    JButton signOutButton;

    JLabel[] accounts;
    JLabel[] makes;
    JLabel[] models;
    JLabel[] colors;
    JLabel[] rents;

    JButton[] deleteButton;
    JButton[] blockButton;
    JButton[] unblockButton;

    public AdminMenu() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new GridLayout(0, 2, 15, 15));
        this.setPreferredSize(new Dimension(1024, 480));
        this.setResizable(false);
        this.setTitle("Admin page");

        accounts = new JLabel[Account.accounts.size()];
        deleteButton = new JButton[Account.accounts.size()];
        blockButton = new JButton[Account.accounts.size()];
        unblockButton = new JButton[Account.accounts.size()];

        makes = new JLabel[Car.cars.size()];
        models = new JLabel[Car.cars.size()];
        colors = new JLabel[Car.cars.size()];
        rents = new JLabel[Car.cars.size()];

        //Left label
        leftPanel = new JPanel();
        leftPanel.setLayout(new GridLayout(6, 0, 15, 10));

        adminLabel = new JLabel("Admin menu");
        adminLabel.setPreferredSize(new Dimension(512, 48));
        adminLabel.setVerticalAlignment(JLabel.CENTER);
        adminLabel.setHorizontalAlignment(JLabel.CENTER);
        adminLabel.setFont(new Font("Arial", Font.BOLD, 25));

        showAccButton = new ShowAcc();
        showCarsButton = new ShowCars();
        addCarButton = new AddCar();

        signOutButton = new JButton("Sign out");
        signOutButton.addActionListener(new SignOutButton());

        leftPanel.add(adminLabel);
        leftPanel.add(showAccButton);
        leftPanel.add(showCarsButton);
        leftPanel.add(addCarButton);
        leftPanel.add(signOutButton);


        //RightPanel
        rightPanel = new JPanel();
        rightPanel.setLayout(new GridLayout(0, 4, 15, 10));

        this.add(leftPanel);
        this.add(rightPanel);

        this.pack();
        this.setVisible(true);
    }

   public class ShowAcc extends JButton implements ActionListener {

        public ShowAcc() {
            this.setText("Show Accounts");
            this.addActionListener(this);
            this.setPreferredSize(new Dimension(512, 48));
        }

        @Override
        public void actionPerformed(ActionEvent e) {

            AdminMenu.adminMenu.remove(rightPanel);
            rightPanel.removeAll();

            for (int i = 0; i < Account.accounts.size(); i++) {
                accounts[i] = new JLabel(Account.accounts.get(i).getUsername());
                accounts[i].setVerticalAlignment(JLabel.CENTER);
                accounts[i].setHorizontalAlignment(JLabel.CENTER);
                accounts[i].setPreferredSize(new Dimension(100, 25));

                deleteButton[i] = new JButton("Delete");
                deleteButton[i].setPreferredSize(new Dimension(100, 35));
                deleteButton[i].addActionListener(new DeleteButtons());

                blockButton[i] = new JButton("Block");
                blockButton[i].setPreferredSize(new Dimension(100, 35));
                blockButton[i].addActionListener(new BlockButtons());

                unblockButton[i] = new JButton("Unblock");
                unblockButton[i].setPreferredSize(new Dimension(100, 35));
                unblockButton[i].addActionListener(new UnblockButtons());

                rightPanel.add(accounts[i]);
                rightPanel.add(deleteButton[i]);
                rightPanel.add(blockButton[i]);
                rightPanel.add(unblockButton[i]);
            }

            AdminMenu.adminMenu.add(rightPanel);
            AdminMenu.adminMenu.revalidate();
            AdminMenu.adminMenu.repaint();

        }
    }

    public class ShowCars extends JButton implements ActionListener {

        public ShowCars() {
            this.setText("Show Cars");
            this.addActionListener(this);
            this.setPreferredSize(new Dimension(512, 48));
        }

        @Override
        public void actionPerformed(ActionEvent e) {

            makes = new JLabel[Car.cars.size()];
            models = new JLabel[Car.cars.size()];
            colors = new JLabel[Car.cars.size()];
            rents = new JLabel[Car.cars.size()];

            AdminMenu.adminMenu.remove(rightPanel);
            rightPanel.removeAll();

            for (int i = 0; i < Car.cars.size(); i++) {
                makes[i] = new JLabel(Car.cars.get(i).getMake());
                makes[i].setVerticalAlignment(JLabel.CENTER);
                makes[i].setHorizontalAlignment(JLabel.CENTER);
                makes[i].setPreferredSize(new Dimension(100, 25));

                models[i] = new JLabel(Car.cars.get(i).getModel());
                models[i].setVerticalAlignment(JLabel.CENTER);
                models[i].setHorizontalAlignment(JLabel.CENTER);
                models[i].setPreferredSize(new Dimension(100, 25));

                colors[i] = new JLabel(Car.cars.get(i).getColor());
                colors[i].setVerticalAlignment(JLabel.CENTER);
                colors[i].setHorizontalAlignment(JLabel.CENTER);
                colors[i].setPreferredSize(new Dimension(100, 25));

                rents[i] = new JLabel(Car.cars.get(i).isRented());
                rents[i].setVerticalAlignment(JLabel.CENTER);
                rents[i].setHorizontalAlignment(JLabel.CENTER);
                rents[i].setPreferredSize(new Dimension(100, 25));

                rightPanel.add(makes[i]);
                rightPanel.add(models[i]);
                rightPanel.add(colors[i]);
                rightPanel.add(rents[i]);
            }

            AdminMenu.adminMenu.add(rightPanel);
            AdminMenu.adminMenu.revalidate();
            AdminMenu.adminMenu.repaint();

        }
    }

    public class AddCar extends JButton implements ActionListener {

        public AddCar() {
            this.setText("Add car");
            this.addActionListener(this);
            this.setPreferredSize(new Dimension(512, 48));
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            String make = JOptionPane.showInputDialog("Please introduce the make");
            String model = JOptionPane.showInputDialog("Please introduce the model");
            String color = JOptionPane.showInputDialog("Please introduce the color");

            Car.cars.add(new Car(make, model, color));
        }
    }

    public class SignOutButton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int option = JOptionPane.showConfirmDialog(null, "Are you sure you want to sign out?", "Sign out", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

            if (option == JOptionPane.YES_OPTION){
                AdminMenu.adminMenu.dispose();
                MainMenu.mainFrame = new MainMenu();
            }
        }
    }
}
