package utilities;

/*
 Validations for key presses will be done here.
*/

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

    public ValidationHelper(ArrayList<Long> loginFightTimes, ArrayList<Long> registerFlightTimes, double errorMargin, KeyPressHelper keyPressHelperLogin, KeyPressHelper keyPressHelperRegister){
        this.loginFightTimes = loginFightTimes;
        this.registerFlightTimes = registerFlightTimes;
        this.errorMargin = errorMargin;
        this.difference = 0;
        this.keyPressHelperLogin = keyPressHelperLogin;
        this.getKeyPressHelperRegister = keyPressHelperRegister;
    }

    public boolean validate() {

        boolean validated = false;

        if(loginFightTimes.size() != registerFlightTimes.size()){
            validated = false;
        } else if (!keyPressHelperLogin.getKeysPressed().equals(getKeyPressHelperRegister.getKeysPressed())){
            validated = false;
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
