package GUI.AdminFrame;

import GUI.MainFrame.MainMenu;
import GUI.SignInButton.SignInFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminLoginFrame extends JFrame {
    public static AdminLoginFrame adminLoginFrame;

    JPanel upperPanel;
    JPanel centerPanel;

    JLabel adminLabel;
    JLabel adminPassLabel;

    ExitButton exitButton;
    BackButton backButton;

    JPasswordField adminPassField;

    AdminLogInButton adminLogInButton;

    public AdminLoginFrame(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout(0, 20));
        this.setResizable(false);
        this.setTitle("Admin login page");

        upperPanel = new JPanel();
        upperPanel.setLayout(new GridLayout(1, 1, 0, 25));

        adminLabel = new JLabel("Admin login page");
        adminLabel.setHorizontalAlignment(JLabel.CENTER);
        adminLabel.setFont(new Font("Arial", Font.BOLD, 25));

        upperPanel.add(adminLabel);

        adminPassLabel = new JLabel("Insert your password");
        adminPassField = new JPasswordField();

        centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(5, 1, 0, 10));

        adminLogInButton = new AdminLogInButton();

        centerPanel.add(adminPassLabel);
        centerPanel.add(adminPassField);
        centerPanel.add(adminLogInButton);

        backButton = new BackButton();
        backButton.setVerticalAlignment(JLabel.CENTER);
        backButton.setHorizontalAlignment(JLabel.CENTER);

        exitButton = new ExitButton();
        exitButton.setVerticalAlignment(JLabel.CENTER);
        exitButton.setHorizontalAlignment(JLabel.CENTER);

        centerPanel.add(backButton);
        centerPanel.add(exitButton);

        this.add(upperPanel, BorderLayout.NORTH);
        this.add(centerPanel, BorderLayout.CENTER);

        this.pack();
        this.setVisible(true);
    }

    public static class ExitButton extends JButton implements ActionListener {
        ExitButton(){
            this.setText("Exit");
            this.addActionListener(this);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }

    public static class BackButton extends JButton implements ActionListener {
        BackButton(){
            this.setText("Back");
            this.addActionListener(this);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            AdminLoginFrame.adminLoginFrame.dispose();
            MainMenu.mainFrame = new MainMenu();
        }
    }
}
