package utilities;

import jdk.nashorn.internal.scripts.JO;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginButtonHelper implements ActionListener{

    private JTextField register;
    private JTextField login;
    private JButton registerBtn;
    private JButton loginBtn;
    private KeyPressHelper keyPressHelperRegister;
    private KeyPressHelper keyPressHelperLogin;
    private ValidationHelper validationHelper;

    public LoginButtonHelper(JTextField register, JTextField login, JButton registerBtn, JButton loginBtn, KeyPressHelper keyPressHelperRegister, KeyPressHelper keyPressHelperLogin){
        this.register = register;
        this.login = login;
        this.registerBtn = registerBtn;
        this.loginBtn = loginBtn;
        this.keyPressHelperLogin = keyPressHelperLogin;
        this.keyPressHelperRegister = keyPressHelperRegister;
        this.validationHelper = new ValidationHelper(keyPressHelperLogin.getFlightTimes(), keyPressHelperRegister.getFlightTimes(), 100, keyPressHelperLogin, keyPressHelperRegister);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        keyPressHelperLogin.setFlightTimes();
        System.out.println(keyPressHelperLogin.getFlightTimes());
        login.setEnabled(false);
        if(validationHelper.validate()){
            JOptionPane.showMessageDialog(null, "You are authorized!");
        } else {
            JOptionPane.showMessageDialog(null, "You are not authorized!");
        }
    }
}
