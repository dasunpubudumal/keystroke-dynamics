package utilities;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class FileHelper {

    private File file;

    public void write(String text, String filename) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(filename, false));
        writer.write(text);
        writer.close();
    }

    public ArrayList<Long> read() throws IOException {
        ArrayList<Long> array = new ArrayList<>();
        ArrayList<String> tmp = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader("registration_info.txt"));
        String ar = reader.readLine();
        ar = ar.replace("[","");
        ar = ar.replace("]","");
        String[] list = ar.split(",");
        tmp.addAll(Arrays.asList(list));

        for (int i = 0; i <  tmp.size(); i++) {
            array.add(i, Long.parseLong(tmp.get(i).trim()));
        }

        reader.close();
        return array;
    }

    public String readName() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("name_info.txt"));
        String ar = reader.readLine();
        return ar;
    }
}
