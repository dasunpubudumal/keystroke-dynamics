package utilities;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class FileHelper {

    private File file;

    public void write(String text) throws IOException {

        BufferedWriter writer = new BufferedWriter(new FileWriter("src/registration_info.txt", false));
        writer.write(text);
        writer.close();
    }

    public ArrayList<Long> read() throws IOException {
        ArrayList<Long> array = new ArrayList<>();
        ArrayList<String> tmp = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader("src/registration_info.txt"));
        // Convert the read file into an array
        String ar = reader.readLine();
        ar = ar.replace("[","");
        ar = ar.replace("]","");
        String[] list = ar.split(",");
        System.out.println(Arrays.toString(list));
        tmp.addAll(Arrays.asList(list));

        // This doesnt work
        for (int i = 0; i <  tmp.size(); i++) {
            array.add(i, Long.parseLong(tmp.get(i)));
        }
        reader.close();
        return array;
    }
}
