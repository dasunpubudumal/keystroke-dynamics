package utilities;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonHelper implements ActionListener{

    JTextField register;
    JTextField login;
    JButton registerBtn;
    JButton loginBtn;
    KeyHelper keyHelperRegister;
    KeyHelper keyHelperLogin;

    public ButtonHelper(JTextField register, JTextField login, JButton registerBtn, JButton loginBtn, KeyHelper keyHelperRegister, KeyHelper keyHelperLogin){
        this.register = register;
        this.login = login;
        this.registerBtn = registerBtn;
        this.loginBtn = loginBtn;
        this.keyHelperLogin = keyHelperLogin;
        this.keyHelperRegister = keyHelperRegister;
    }

    public void register() {
        keyHelperRegister.setFlightTimes();
        System.out.println(keyHelperRegister.getFlightTimes());
        register.setEnabled(false);
        login.setEnabled(true);
        login.addKeyListener(keyHelperLogin);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.register();
    }
}
