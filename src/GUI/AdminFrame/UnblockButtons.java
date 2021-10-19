package GUI.AdminFrame;

import Classes.Account;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UnblockButtons implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < Account.accounts.size(); i++) {
            if (e.getSource() == AdminMenu.adminMenu.unblockButton[i]) {
                Account currentAccount = Account.accounts.get(i);
                if (currentAccount.isBlocked() == false)
                    JOptionPane.showMessageDialog(null, "This account is already unblocked.", "Unblock account", JOptionPane.INFORMATION_MESSAGE);
                else {
                    int option = JOptionPane.showConfirmDialog(null, "Do you want to unblock this account?", "Unblock account", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

                    if (option == JOptionPane.YES_OPTION) {
                        AdminMenu.adminMenu.dispose();
                        currentAccount.setBlocked(false);
                        AdminMenu.adminMenu = new AdminMenu();
                    }
                }
            }
        }

    }
}
