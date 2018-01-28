import utilities.LoginButtonHelper;
import utilities.RegisterButtonHelper;
import utilities.KeyPressHelper;

import javax.swing.*;

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


    public KeyPressForm() {

        // Initialize Helpers
        KeyPressHelper keyPressHelpeRegister = new KeyPressHelper();
        KeyPressHelper keyPressHelperLogin = new KeyPressHelper();
        RegisterButtonHelper registerButtonHelper = new RegisterButtonHelper(txtRegister, txtLogin, btnRegister, btnLogin, keyPressHelpeRegister, keyPressHelperLogin, txtName, txtNameLogin);
        LoginButtonHelper loginButtonHelper = new LoginButtonHelper(txtRegister, txtLogin, btnRegister, btnLogin, keyPressHelpeRegister, keyPressHelperLogin, txtName, txtNameLogin);

        // Listeners
        txtRegister.addKeyListener(keyPressHelpeRegister);
        txtLogin.setEnabled(false);
        btnLogin.setEnabled(false);
        txtNameLogin.setEnabled(false);
        btnRegister.addActionListener(registerButtonHelper);
        btnLogin.addActionListener(loginButtonHelper);

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
