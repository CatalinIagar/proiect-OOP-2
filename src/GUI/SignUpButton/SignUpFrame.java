package GUI.SignUpButton;

import GUI.MainFrame.MainMenu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignUpFrame extends JFrame {
    public static SignUpFrame signUpFrame;

    JLabel frameLabel;

    ExitButton exitButton;
    BackButton backButton;

    JLabel usernameLabel;
    JTextField usernameField;

    JLabel passwordLabel;
    JPasswordField passwordField;

    JLabel firstNameLabel;
    JTextField firstNameField;

    JLabel lastNameLabel;
    JTextField lastNameField;

    JLabel idNumberLabel;
    JTextField idNumberField;

    JLabel addressNumberLabel;
    JTextField addressNumberField;

    JLabel phoneNumberLabel;
    JTextField phoneNumberField;

    SignUpButtonLogic signUp;

    public SignUpFrame(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new GridLayout(18, 1, 15, 10));
        this.setResizable(false);
        this.setTitle("Sign up page");

        //Frame Label
        frameLabel = new JLabel("Please fill the following fields");
        frameLabel.setFont(new Font("Ariel", Font.BOLD, 15));
        frameLabel.setPreferredSize(new Dimension(450, 25));
        frameLabel.setVerticalAlignment(JLabel.CENTER);
        frameLabel.setHorizontalAlignment(JLabel.CENTER);
        //username
        usernameLabel = new JLabel("Username: ");
        usernameLabel.setVerticalAlignment(JLabel.CENTER);
        usernameField = new JTextField();
        //password
        passwordLabel = new JLabel("Password: ");
        usernameLabel.setVerticalAlignment(JLabel.CENTER);
        passwordField = new JPasswordField();
        //firstName
        firstNameLabel = new JLabel("First Name: ");
        firstNameLabel.setVerticalAlignment(JLabel.CENTER);
        firstNameField = new JTextField();
        //lastName
        lastNameLabel = new JLabel("Last Name: ");
        lastNameLabel.setVerticalAlignment(JLabel.CENTER);
        lastNameField = new JTextField();
        //idNumber
        idNumberLabel = new JLabel("ID Number: ");
        idNumberLabel.setVerticalAlignment(JLabel.CENTER);
        idNumberField = new JTextField();
        //address
        addressNumberLabel = new JLabel("Address: ");
        addressNumberLabel.setVerticalAlignment(JLabel.CENTER);
        addressNumberField = new JTextField();
        //phoneNumber
        phoneNumberLabel = new JLabel("Phone number: ");
        phoneNumberLabel.setVerticalAlignment(JLabel.CENTER);
        phoneNumberField = new JTextField();

        signUp = new SignUpButtonLogic();

        backButton = new BackButton();
        backButton.setVerticalAlignment(JLabel.CENTER);
        backButton.setHorizontalAlignment(JLabel.CENTER);

        exitButton = new ExitButton();
        exitButton.setVerticalAlignment(JLabel.CENTER);
        exitButton.setHorizontalAlignment(JLabel.CENTER);

        this.add(frameLabel);
        this.add(usernameLabel);
        this.add(usernameField);
        this.add(passwordLabel);
        this.add(passwordField);
        this.add(firstNameLabel);
        this.add(firstNameField);
        this.add(lastNameLabel);
        this.add(lastNameField);
        this.add(idNumberLabel);
        this.add(idNumberField);
        this.add(addressNumberLabel);
        this.add(addressNumberField);
        this.add(phoneNumberLabel);
        this.add(phoneNumberField);
        this.add(signUp);
        this.add(backButton);
        this.add(exitButton);

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
            SignUpFrame.signUpFrame.dispose();
            MainMenu.mainFrame = new MainMenu();
        }
    }
}
