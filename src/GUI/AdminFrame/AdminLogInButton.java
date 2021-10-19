package GUI.AdminFrame;

import Classes.Admin;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminLogInButton extends JButton implements ActionListener {
    AdminLogInButton() {
        this.setText("Sign in");
        this.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        char[] password = AdminLoginFrame.adminLoginFrame.adminPassField.getPassword();

        if (Admin.checkPassword(password) == false)
            JOptionPane.showMessageDialog(null, "Incorrect password", "Sign in error", JOptionPane.ERROR_MESSAGE);
        else if (Admin.checkPassword(password) == true) {
            AdminLoginFrame.adminLoginFrame.dispose();

            AdminMenu.adminMenu = new AdminMenu();
        }
    }
}
