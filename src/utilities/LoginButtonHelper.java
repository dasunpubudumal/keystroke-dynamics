package utilities;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginButtonHelper implements ActionListener{

    private JTextField register;
    private JTextField login;
    private JButton registerBtn;
    private JButton loginBtn;
    private KeyHelper keyHelperRegister;
    private KeyHelper keyHelperLogin;

    public LoginButtonHelper(JTextField register, JTextField login, JButton registerBtn, JButton loginBtn, KeyHelper keyHelperRegister, KeyHelper keyHelperLogin){
        this.register = register;
        this.login = login;
        this.registerBtn = registerBtn;
        this.loginBtn = loginBtn;
        this.keyHelperLogin = keyHelperLogin;
        this.keyHelperRegister = keyHelperRegister;
    }

    public void login(){
        keyHelperLogin.setFlightTimes();
        System.out.println(keyHelperLogin.getFlightTimes());
        login.setEnabled(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.login();
    }
}
