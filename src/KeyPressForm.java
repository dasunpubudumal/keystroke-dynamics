import utilities.LoginButtonHelper;
import utilities.RegisterButtonHelper;
import utilities.KeyPressHelper;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class KeyPressForm {
    private JPanel backPlane;
    private JLabel lblRegister;
    private JTextField txtRegister;
    private JTextField txtLogin;
    private JButton btnLogin;
    private JButton btnRegister;
    private JLabel lblName;
    private JTextField txtName;
    private JLabel lblNameLogin;
    private JTextField txtNameLogin;
    private JButton btnRegisterMe;
    private JButton btnLoginMe;


    public KeyPressForm() {

        // Initialize Helpers
        KeyPressHelper keyPressHelpeRegister = new KeyPressHelper();
        KeyPressHelper keyPressHelperLogin = new KeyPressHelper();
        RegisterButtonHelper registerButtonHelper = new RegisterButtonHelper(txtRegister, txtLogin, btnRegister, btnLogin, keyPressHelpeRegister, keyPressHelperLogin, txtName, txtNameLogin);
        LoginButtonHelper loginButtonHelper = new LoginButtonHelper(txtRegister, txtLogin, btnRegister, btnLogin, keyPressHelpeRegister, keyPressHelperLogin, txtName, txtNameLogin);

        // Listeners
        txtRegister.addKeyListener(keyPressHelpeRegister);
        txtLogin.addKeyListener(keyPressHelperLogin);
        txtLogin.setEnabled(false);
        btnLogin.setEnabled(false);
        txtName.setEnabled(false);
        txtRegister.setEnabled(false);
        btnRegister.setEnabled(false);
        txtNameLogin.setEnabled(false);
        btnLogin.setEnabled(false);

        btnRegisterMe.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnRegister.addActionListener(registerButtonHelper);
                txtName.setEnabled(true);
                txtRegister.setEnabled(true);
                btnRegister.setEnabled(true);
            }
        });
        btnLoginMe.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnLogin.addActionListener(loginButtonHelper);
                txtNameLogin.setEnabled(true);
                txtLogin.setEnabled(true);
                btnLogin.setEnabled(true);
            }
        });
    }

    // Main method
    public static void main(String[] args) {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) { }

        JFrame jf = new JFrame("BioAuth");
        jf.setContentPane(new KeyPressForm().backPlane);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.pack();
        jf.setResizable(false);
        jf.setVisible(true);
    }
}
