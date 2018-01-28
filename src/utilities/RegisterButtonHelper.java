package utilities;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterButtonHelper implements ActionListener{

    private JTextField register;
    private JTextField login;
    private JButton registerBtn;
    private JButton loginBtn;
    private KeyPressHelper keyPressHelperRegister;
    private KeyPressHelper keyPressHelperLogin;

    public RegisterButtonHelper(JTextField register, JTextField login, JButton registerBtn, JButton loginBtn, KeyPressHelper keyPressHelperRegister, KeyPressHelper keyPressHelperLogin){
        this.register = register;
        this.login = login;
        this.registerBtn = registerBtn;
        this.loginBtn = loginBtn;
        this.keyPressHelperLogin = keyPressHelperLogin;
        this.keyPressHelperRegister = keyPressHelperRegister;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        keyPressHelperRegister.setFlightTimes();
        System.out.println(keyPressHelperRegister.getFlightTimes());
        register.setEnabled(false);
        registerBtn.setEnabled(false);
        login.requestFocus(true);
        login.setEnabled(true);
        loginBtn.setEnabled(true);
        login.addKeyListener(keyPressHelperLogin);
    }
}
