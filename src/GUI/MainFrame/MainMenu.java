package GUI.MainFrame;

import GUI.SignInButton.SignInFrame;
import GUI.SignUpButton.SignUpFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu extends JFrame {
    public static MainMenu mainFrame;

    JPanel upperPanel;
    JPanel centerPanel;
    JPanel exitPanel;

    JLabel welcomeLabel;
    JLabel logLabel;

    SignUpButton signUp;
    SignInButton signIn;
    SignInAdmin signInAdmin;

    ExitButton exitButton;


    public MainMenu(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400, 400);
        this.setLayout(new BorderLayout(0, 20));
        this.setTitle("Rent a car");
        this.setResizable(false);

        //Upper Panel
        upperPanel = new JPanel();
        upperPanel.setLayout(new GridLayout(2, 1, 0, 25));

        welcomeLabel = new JLabel("Welcome to Rent a Car");
        welcomeLabel.setVerticalAlignment(JLabel.CENTER);
        welcomeLabel.setHorizontalAlignment(JLabel.CENTER);
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 25));

        logLabel = new JLabel("Create an account or connect to an existing one");
        logLabel.setVerticalAlignment(JLabel.CENTER);
        logLabel.setHorizontalAlignment(JLabel.CENTER);
        logLabel.setFont(new Font("Arial", Font.ITALIC, 15));

        upperPanel.add(welcomeLabel);
        upperPanel.add(logLabel);

        //Center Panel
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 25, 25));
        centerPanel.setSize(400, 50);

        signIn = new SignInButton();
        signUp = new SignUpButton();
        signInAdmin = new SignInAdmin();

        centerPanel.add(signUp);
        centerPanel.add(signIn);
        centerPanel.add(signInAdmin);

        //Exit Panel
        exitPanel = new JPanel();
        exitPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 25, 25));

        exitButton = new ExitButton();
        exitButton.setVerticalAlignment(JLabel.CENTER);
        exitButton.setHorizontalAlignment(JLabel.CENTER);

        exitPanel.add(exitButton);

        this.add(upperPanel, BorderLayout.NORTH);
        this.add(centerPanel, BorderLayout.CENTER);
        this.add(exitPanel, BorderLayout.SOUTH);
        this.setVisible(true);
    }

    public static class ExitButton extends JButton implements ActionListener {
        ExitButton(){
            this.setText("Exit");
            this.addActionListener(this);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            MainMenu.mainFrame.dispose();
        }
    }

    public static class SignUpButton extends JButton implements ActionListener{
        SignUpButton(){
            this.setText("Sign up");
            this.addActionListener(this);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            SignUpFrame.signUpFrame = new SignUpFrame();
            MainMenu.mainFrame.dispose();
        }
    }

    public static class SignInButton extends JButton implements ActionListener{
        SignInButton(){
            this.setText("Sign in");
            this.addActionListener(this);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            SignInFrame.signInFrame = new SignInFrame();
            MainMenu.mainFrame.dispose();
        }
    }
}
