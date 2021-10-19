package GUI.SignInButton;

import Classes.Account;
import GUI.UserFrame.UserMenu;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignInButtonLogic extends JButton implements ActionListener {
    SignInButtonLogic() {
        this.setText("Sign in");
        this.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String username = SignInFrame.signInFrame.usernameField.getText();
        char[] password = SignInFrame.signInFrame.passwordField.getPassword();
        Account currentAccount = Account.checkUsername(username);

        if (currentAccount == null)
            JOptionPane.showMessageDialog(null, "Username doesn't exist", "Sign in error", JOptionPane.ERROR_MESSAGE);
        else if (currentAccount.isBlocked() == true)
            JOptionPane.showMessageDialog(null, "This account is blocked", "Blocked account", JOptionPane.WARNING_MESSAGE);
        else if(currentAccount.checkPassword(password) == false)
            JOptionPane.showMessageDialog(null, "Incorrect password", "Sign in error", JOptionPane.ERROR_MESSAGE);
        else {
            SignInFrame.signInFrame.dispose();
            UserMenu.userMenu = new UserMenu(currentAccount);
        }
    }
}
