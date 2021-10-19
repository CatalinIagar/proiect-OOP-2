package GUI.AdminFrame;

import Classes.Account;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BlockButtons implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < Account.accounts.size(); i++) {
            if (e.getSource() == AdminMenu.adminMenu.blockButton[i]) {
                Account currentAccount = Account.accounts.get(i);
                if (currentAccount.isBlocked())
                    JOptionPane.showMessageDialog(null, "This account is already blocked.", "Block account", JOptionPane.INFORMATION_MESSAGE);
                else {
                    int option = JOptionPane.showConfirmDialog(null, "Do you want to block this account?", "Block account", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

                    if (option == JOptionPane.YES_OPTION) {
                        AdminMenu.adminMenu.dispose();
                        currentAccount.setBlocked(true);
                        AdminMenu.adminMenu = new AdminMenu();
                    }
                }
            }
        }

    }
}
