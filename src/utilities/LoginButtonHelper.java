package utilities;

import jdk.nashorn.internal.scripts.JO;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.IOException;

public class LoginButtonHelper implements ActionListener{

    private JTextField register;
    private JTextField login;
    private JButton registerBtn;
    private JButton loginBtn;
    private KeyPressHelper keyPressHelperRegister;
    private KeyPressHelper keyPressHelperLogin;
    private ValidationHelper validationHelper;
    private JTextField txtName;
    private JTextField txtNameLogin;
    private FileHelper fileHelper;

    public LoginButtonHelper(JTextField register, JTextField login, JButton registerBtn, JButton loginBtn, KeyPressHelper keyPressHelperRegister, KeyPressHelper keyPressHelperLogin, JTextField txtName, JTextField txtNameLogin){
        this.fileHelper = new FileHelper();
        this.register = register;
        this.login = login;
        this.registerBtn = registerBtn;
        this.loginBtn = loginBtn;
        this.keyPressHelperLogin = keyPressHelperLogin;
        this.keyPressHelperRegister = keyPressHelperRegister;
        this.txtName = txtName;
        this.txtNameLogin = txtNameLogin;
        this.validationHelper = new ValidationHelper(keyPressHelperLogin.getFlightTimes(), keyPressHelperRegister.getFlightTimes(), 300, keyPressHelperLogin, keyPressHelperRegister);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        keyPressHelperLogin.setFlightTimes();
        keyPressHelperLogin.setName(txtNameLogin.getText());
        System.out.println(keyPressHelperLogin.getFlightTimes());
        login.setEnabled(false);
        if(validationHelper.validate()){
            JOptionPane.showMessageDialog(null, "You are authorized!");
//            loginBtn.setEnabled(false);
        } else {
            JOptionPane.showMessageDialog(null, "You are not authorized! Restart and try again.");
            login.setEnabled(true);
            login.setText("");
            login.requestFocus(true);
            login.setEnabled(false);
        }

    }
}
