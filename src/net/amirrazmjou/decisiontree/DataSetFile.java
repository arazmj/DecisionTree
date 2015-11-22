package net.amirrazmjou.decisiontree;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Amir Razmjou on 11/21/15.
 */
public class DataSetFile {

    static List<List<String>> read(String fileName, String regex) throws IOException {
        String line;
        BufferedReader stream = null;
        List<List<String>> data = new ArrayList<>();

        try {
            stream = new BufferedReader(new FileReader(fileName));
            while ((line = stream.readLine()) != null) {
                String[] record = line.split(regex);
                ArrayList<String> dataLine = new ArrayList<>(record.length);
                Collections.addAll(dataLine, record);
                data.add(dataLine);
            }
        } finally {
            if (stream != null)
                stream.close();
        }
        return data;
    }
}
