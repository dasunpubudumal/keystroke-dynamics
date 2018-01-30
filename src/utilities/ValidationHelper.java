package utilities;

/*
 Validations for key presses will be done here.
*/

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ValidationHelper {

    private ArrayList<Long> loginFightTimes;
    private ArrayList<Long> registerFlightTimes;
    private long difference;
    private double errorMargin;
    private KeyPressHelper keyPressHelperLogin;
    private KeyPressHelper getKeyPressHelperRegister;
    private FileHelper fileHelper;


    public ValidationHelper(ArrayList<Long> loginFightTimes, ArrayList<Long> registerFlightTimes, double errorMargin, KeyPressHelper keyPressHelperLogin, KeyPressHelper keyPressHelperRegister){
        this.fileHelper = new FileHelper();
        this.loginFightTimes = loginFightTimes;
        this.registerFlightTimes = registerFlightTimes;
        this.errorMargin = errorMargin;
        this.difference = 0;
        this.keyPressHelperLogin = keyPressHelperLogin;
        this.getKeyPressHelperRegister = keyPressHelperRegister;
    }

    public boolean validate() {

        boolean validated = false;

        try {
            this.getKeyPressHelperRegister.setName(fileHelper.readName());
            this.registerFlightTimes = fileHelper.read();
            this.getKeyPressHelperRegister.setKeysPressed(fileHelper.getKeysPressed());
        } catch (IOException e2) {
            e2.printStackTrace();
        }

        System.out.println(keyPressHelperLogin.getKeysPressed());
        System.out.println(getKeyPressHelperRegister.getKeysPressed());


        if(loginFightTimes.size() != registerFlightTimes.size()){
            validated = false;
            System.out.println("ARRAY SIZES");
        } else if (!keyPressHelperLogin.getName().toString().equals(getKeyPressHelperRegister.getName().toString())) {
            System.out.println("NOT PASSED!");
            validated = false;
        } else if (!keyPressHelperLogin.getKeysPressed().equals(getKeyPressHelperRegister.getKeysPressed())){
            validated = false;
            System.out.println("KEYS DIFFERED");
        }
        else {

            for (int i = 0; i < loginFightTimes.size() ; i++) {
                difference += Math.abs(Math.abs(loginFightTimes.get(i)) - Math.abs(registerFlightTimes.get(i)));
            }

            System.out.println("Total difference is: " + difference);
            if(difference < errorMargin) validated = true;
        }
        return validated;
    }

}
