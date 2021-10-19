package GUI.SignInButton;

import GUI.MainFrame.MainMenu;
import GUI.SignUpButton.SignUpFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignInFrame extends JFrame{
    public static SignInFrame signInFrame;

    JLabel frameLabel;

    ExitButton exitButton;
    BackButton backButton;

    JLabel usernameLabel;
    JTextField usernameField;

    JLabel passwordLabel;
    JPasswordField passwordField;

    SignInButtonLogic signIn;

    public SignInFrame(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new GridLayout(8, 1, 15, 0));
        this.setResizable(false);
        this.setTitle("Sign in page");

        //Frame Label
        frameLabel = new JLabel("Please enter your username and password");
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

        signIn = new SignInButtonLogic();

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
        this.add(signIn);
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
            SignInFrame.signInFrame.dispose();
            MainMenu.mainFrame = new MainMenu();
        }
    }
}
