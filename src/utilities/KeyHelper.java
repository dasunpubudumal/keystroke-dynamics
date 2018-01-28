package utilities;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class KeyHelper implements KeyListener {

    private ArrayList<Long> keyPressedInstances;
    private ArrayList<Long> keyReleasedInstances;
    private ArrayList<Long> flightTimes;
    private ArrayList<Character> keysPressed;
    private ArrayList<Character> keysReleased;

    public KeyHelper() {
        keyPressedInstances = new ArrayList<>();
        keyReleasedInstances = new ArrayList<>();
        keysPressed = new ArrayList<>();
        keysReleased = new ArrayList<>();
        flightTimes = new ArrayList<>();
    }

    @Override
    public void keyTyped(KeyEvent e) { }

    @Override
    public void keyPressed(KeyEvent e) {
        keyPressedInstances.add(System.currentTimeMillis());
        keysPressed.add(e.getKeyChar());
        System.out.println(keyPressedInstances);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        keyReleasedInstances.add(System.currentTimeMillis());
        keysReleased.add(e.getKeyChar());
    }

    public ArrayList<Long> getFlightTimes() {
        return flightTimes;
    }

    public void setFlightTimes() {
        for (int i = 1; i < keyPressedInstances.size(); i++) {
            flightTimes.add(keyPressedInstances.get(i-1) - keyPressedInstances.get(i));
        }
    }


    /*
     Get the flight times and calculate for some error margin.
    */
    public double validate(double errorMargin) {
        double validation = 0;

        return validation;
    }

    public void setKeyPressedInstances(ArrayList<Long> keyPressedInstances) {
        this.keyPressedInstances = keyPressedInstances;
    }

    public void setKeyReleasedInstances(ArrayList<Long> keyReleasedInstances) {
        this.keyReleasedInstances = keyReleasedInstances;
    }


    public ArrayList<Long> getKeyPressedInstances() {
        return this.keyPressedInstances;
    }

    public ArrayList<Long> getKeyReleasedInstances() {
        return keyReleasedInstances;
    }
}
