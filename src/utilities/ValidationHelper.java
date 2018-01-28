package utilities;

/*
 Validations for key presses will be done here.
*/

import java.util.ArrayList;

public class ValidationHelper {

    private ArrayList<Long> loginFightTimes;
    private ArrayList<Long> registerFlightTimes;
    private long difference;
    private double errorMargin;

    public ValidationHelper(ArrayList<Long> loginFightTimes, ArrayList<Long> registerFlightTimes, double errorMargin){
        this.loginFightTimes = loginFightTimes;
        this.registerFlightTimes = registerFlightTimes;
        this.errorMargin = errorMargin;
        this.difference = 0;
    }

    public boolean validate() {

        boolean validated = false;

        if(loginFightTimes.size() != registerFlightTimes.size()){
            validated = false;
        } else {
            for (int i = 0; i < loginFightTimes.size() ; i++) {
                difference += Math.abs(Math.abs(loginFightTimes.get(i)) - Math.abs(registerFlightTimes.get(i)));
            }

            System.out.println("Total difference is: " + difference);
            if(difference < errorMargin) validated = true;
        }
        return validated;
    }

}
