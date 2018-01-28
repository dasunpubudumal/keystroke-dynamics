import utilities.ButtonHelper;
import utilities.KeyHelper;

import javax.swing.*;

public class KeyPressForm {
    private JPanel backPlane;
    private JLabel lblRegister;
    private JTextField txtRegister;
    private JTextField txtLogin;
    private JButton btnLogin;
    private JButton btnRegister;


    public KeyPressForm() {

        KeyHelper keyHelpeRegister = new KeyHelper();
        KeyHelper keyHelperLogin = new KeyHelper();
        ButtonHelper buttonHelper = new ButtonHelper(txtRegister, txtLogin, btnRegister, btnLogin, keyHelpeRegister, keyHelperLogin);

        // Listeners
        txtRegister.addKeyListener(keyHelpeRegister);
        txtLogin.setEnabled(false);
        btnRegister.addActionListener(buttonHelper);

    }

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
