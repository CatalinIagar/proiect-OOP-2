package GUI.AdminFrame;

import Classes.Account;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteButtons implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        int option = JOptionPane.showConfirmDialog(null, "Do you want to delete this account?", "Delete account", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

        if (option == JOptionPane.YES_OPTION){
            for (int i = 0; i < Account.accounts.size(); i++){
                if (e.getSource() == AdminMenu.adminMenu.deleteButton[i]){
                    AdminMenu.adminMenu.dispose();
                    Account.accounts.remove(i);
                    AdminMenu.adminMenu = new AdminMenu();
                }
            }
        }

    }
}
