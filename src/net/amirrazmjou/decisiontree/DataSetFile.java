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
    /**
     * Reads "whatever" separated variable file into a List of Lists
     * where each outer list represents a line in the data file
     *
     * @param fileName input file name
     * @param regex    the deliminator or a regular expression on how
     *                 values are separated
     * @return A list of list of strings
     * @throws IOException throws exception if the file
     *                     cannot be found or be read
     */
    public static List<List<String>> read(String fileName, String regex) throws IOException {
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
