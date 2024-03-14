package week3.labTask;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {
    public static IPAddress[] readFile(String filePath) throws FileNotFoundException {
        BufferedReader bufferedReader = new BufferedReader(
                new FileReader(filePath)
        );
        List<String> allLines = bufferedReader.lines().toList();
        int sizeOfArray = allLines.size();
        IPAddress[] arrayOfIPAdresses = new IPAddress[sizeOfArray];
        int i = 0;
        for (String line : allLines){
            String[] splitter = line.split(";");
            IPAddress ipAddress = new IPAddress(
                    splitter[0] != "0" ? Long.parseLong(splitter[0]) : 0,
                    splitter[1] != "0" ? Long.parseLong(splitter[1]) : 0,
                    splitter[2],
                    splitter[3],
                    splitter[4],
                    splitter[5]
            );
            arrayOfIPAdresses[i] = ipAddress;
            i++;
        }
        return arrayOfIPAdresses;
    }
}
