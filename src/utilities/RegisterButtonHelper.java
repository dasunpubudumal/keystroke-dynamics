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
    private JTextField txtName;
    private JTextField txtNameLogin;

    public RegisterButtonHelper(JTextField register, JTextField login, JButton registerBtn, JButton loginBtn, KeyPressHelper keyPressHelperRegister, KeyPressHelper keyPressHelperLogin, JTextField txtName, JTextField txtNameLogin){
        this.register = register;
        this.login = login;
        this.registerBtn = registerBtn;
        this.loginBtn = loginBtn;
        this.keyPressHelperLogin = keyPressHelperLogin;
        this.keyPressHelperRegister = keyPressHelperRegister;
        this.txtName = txtName;
        this.txtNameLogin = txtNameLogin;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        keyPressHelperRegister.setFlightTimes();
        keyPressHelperRegister.setName(txtName.getText());
        System.out.println(keyPressHelperRegister.getFlightTimes());
        txtName.setEnabled(false);
        register.setEnabled(false);
        registerBtn.setEnabled(false);
        txtNameLogin.requestFocus(true);
        login.setEnabled(true);
        txtNameLogin.setEnabled(true);
        loginBtn.setEnabled(true);
        login.addKeyListener(keyPressHelperLogin);
    }
}
