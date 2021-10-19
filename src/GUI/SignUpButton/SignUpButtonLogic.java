package GUI.SignUpButton;

import Classes.Account;
import GUI.MainFrame.MainMenu;
import Main.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SignUpButtonLogic extends JButton implements ActionListener {
    SignUpButtonLogic() {
        this.setText("Sign up");
        this.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String username = SignUpFrame.signUpFrame.usernameField.getText();
        char[] password = SignUpFrame.signUpFrame.passwordField.getPassword();
        String firstName = SignUpFrame.signUpFrame.firstNameField.getText();
        String lastName = SignUpFrame.signUpFrame.lastNameField.getText();
        String idNumber = SignUpFrame.signUpFrame.idNumberField.getText();
        String address = SignUpFrame.signUpFrame.addressNumberField.getText();
        String phoneNumber = SignUpFrame.signUpFrame.phoneNumberField.getText();


        //username Logic
        if (username.equals("")) {
            JOptionPane.showMessageDialog(null, "No username introduced", "Cannot create account", JOptionPane.ERROR_MESSAGE);
        }else if (username.length() < 3 || username.length() > 16){
            JOptionPane.showMessageDialog(null, "Username must be between 3 and 16 characters", "Cannot create account", JOptionPane.ERROR_MESSAGE);
        }else if (Account.usernameAlreadyExists(username))
            JOptionPane.showMessageDialog(null, "Username already exists", "Cannot create account", JOptionPane.ERROR_MESSAGE);

        //password Logic
        else if (password.length == 0){
            JOptionPane.showMessageDialog(null, "No password introduced", "Cannot create account", JOptionPane.ERROR_MESSAGE);
        }else if (password.length < 8){
            JOptionPane.showMessageDialog(null, "Password must be at least 8 characters", "Cannot create account", JOptionPane.ERROR_MESSAGE);
        }else if(password.length == 13){
            boolean hasLowerCase = false;
            boolean hasUpperCase = false;
            boolean hasNumber = false;
            boolean hasSpecialChar = false;

            for (int i = 0; i < password.length; i++) {
                if (password[i] > 96 && password[i] < 123)
                    hasLowerCase = true;
                if (password[i] > 64 && password[i] < 91)
                    hasUpperCase = true;
                if (password[i] > 47 && password[i] < 58)
                    hasNumber = true;
                if (password[i] > 32 && password[i] < 48 || password[i] > 57 && password[i] < 65 || password[i] > 90 && password[i] < 97 || password[i] > 122 && password[i] < 127)
                    hasSpecialChar = true;
            }

            if (hasLowerCase == false)
                JOptionPane.showMessageDialog(null, "Password must Contain at least 1 lower case character", "Cannot create account", JOptionPane.ERROR_MESSAGE);
            else if (hasUpperCase == false)
                JOptionPane.showMessageDialog(null, "Password must Contain at least 1 upper case character", "Cannot create account", JOptionPane.ERROR_MESSAGE);
            else if (hasNumber == false)
                JOptionPane.showMessageDialog(null, "Password must Contain at least 1 number case character", "Cannot create account", JOptionPane.ERROR_MESSAGE);
            else if (hasSpecialChar == false)
                JOptionPane.showMessageDialog(null, "Password must Contain at least 1 special character", "Cannot create account", JOptionPane.ERROR_MESSAGE);
        }

        //firstName Logic
        else if (firstName.equals(""))
            JOptionPane.showMessageDialog(null, "No first name introduced", "Cannot create account", JOptionPane.ERROR_MESSAGE);

        //lastName Logic
        else if (lastName.equals(""))
            JOptionPane.showMessageDialog(null, "No last name introduced", "Cannot create account", JOptionPane.ERROR_MESSAGE);

        //id Logic
        else if (idNumber.equals(""))
            JOptionPane.showMessageDialog(null, "No ID number introduced", "Cannot create account", JOptionPane.ERROR_MESSAGE);
        else if (idNumber.length() != 13)
            JOptionPane.showMessageDialog(null, "ID number must have 13 numbers", "Cannot create account", JOptionPane.ERROR_MESSAGE);
        Pattern pattern = Pattern.compile("[1-6]{1}[0-9]{2}[0-1]{1}[0-9]{1}[0-3]{1}[0-9]{1}[0-9]{6}");
        Matcher matcher = pattern.matcher(idNumber);
        if (matcher.find() == false)
            JOptionPane.showMessageDialog(null, "ID number not valid", "Cannot create account", JOptionPane.ERROR_MESSAGE);

        //address logic
        else if (address.equals(""))
            JOptionPane.showMessageDialog(null, "No address introduced", "Cannot create account", JOptionPane.ERROR_MESSAGE);

        //phoneNumber logic
        else if (phoneNumber.equals(""))
            JOptionPane.showMessageDialog(null, "No phone number introduced", "Cannot create account", JOptionPane.ERROR_MESSAGE);
        else if (phoneNumber.length() != 10)
            JOptionPane.showMessageDialog(null, "Phone number must have 10 numbers", "Cannot create account", JOptionPane.ERROR_MESSAGE);
        else
        {
            Account.accounts.add(new Account(username, password, firstName, lastName, idNumber, address, phoneNumber));
            SignUpFrame.signUpFrame.dispose();
            JOptionPane.showMessageDialog(null, "Account was created", "Account created", JOptionPane.INFORMATION_MESSAGE);
            MainMenu.mainFrame = new MainMenu();
        }
    }
}
