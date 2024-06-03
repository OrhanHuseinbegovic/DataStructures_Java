package homework3;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {
    public static RedBlackTree<Entry> readFile(String filePath) throws IOException {
        // implement the actual logic (remove next line)
        BufferedReader bufferedReader = new BufferedReader(
                new FileReader(filePath)
        );
        bufferedReader.readLine();
        List<String> lines = bufferedReader.lines().toList();
        int size = lines.size();
        RedBlackTree<Entry> entries = new RedBlackTree<Entry>();
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
            entries.put(entry.getName(),entry);
            i++;
        }
        bufferedReader.close();
        return entries;
    }
}