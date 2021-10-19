package GUI.MainFrame;

import GUI.AdminFrame.AdminLoginFrame;
import GUI.AdminFrame.AdminMenu;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignInAdmin extends JButton implements ActionListener {
    public SignInAdmin(){
        this.setText("Sign in as admin");
        this.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        MainMenu.mainFrame.dispose();
        AdminLoginFrame.adminLoginFrame = new AdminLoginFrame();
    }
}
