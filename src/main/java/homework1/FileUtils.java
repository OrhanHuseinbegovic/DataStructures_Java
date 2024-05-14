package homework1;

import java.io.*;
import java.util.List;
import java.util.Objects;


public class FileUtils {
    public static Entry[] readFile(String filePath) throws IOException {
        // implement the actual logic (remove next line)
        BufferedReader bufferedReader = new BufferedReader(
                new FileReader(filePath)
        );
        bufferedReader.readLine();
        List<String> lines = bufferedReader.lines().toList();
        int size = lines.size();
        Entry[] entries = new Entry[size];
        int i=0;
        for(String line : lines){
            String[] splitter = line.split(";");
            Entry entry = new Entry(
                    splitter[0],
                    splitter[1],
                    splitter[2],
                    splitter[3],
                    splitter[4],
                    splitter[5]
            );
            entries[i] = entry;
            i++;
        }
        bufferedReader.close();
        return entries;
    }

    public static void writeToFile(Entry[] entries, String filePath) throws IOException {
        // implement the actual logic
        BufferedWriter bufferedWriter = new BufferedWriter(
                new FileWriter(filePath)
        );

        for(int i=0; i<entries.length; i++){
            bufferedWriter.write(entries[i].getName() + ";" + entries[i].getStreetAddress() + ";" + entries[i].getCity() + ";" + entries[i].getPostcode() + ";" + entries[i].getCountry() + ";" + entries[i].getPhoneNumber());
            bufferedWriter.newLine();
        }

        bufferedWriter.close();
    }
}