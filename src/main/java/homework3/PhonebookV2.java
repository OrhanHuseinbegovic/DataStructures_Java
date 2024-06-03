package homework3;

import java.io.IOException;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

public class PhonebookV2 {
    public static void main(String[] args) throws IOException {
        // main application logic
        System.out.println("Loading the entries...");
        RedBlackTree<Entry> entryRedBlackTree = FileUtils.readFile("C:\\Users\\ohuse\\IdeaProjects\\DataStructures\\src\\main\\java\\homework3\\raw_phonebook_data.csv");
        System.out.println("========================================");
        System.out.println("System is ready.");
        int[] edges = entryRedBlackTree.countRedAndBlackEdges();
        System.out.println("Total red edges in the tree: "+edges[1]);
        System.out.println("Total black edges in the tree: "+edges[0]);

        Scanner scanner = new Scanner(System.in);
        String choice;

        while(true){
            System.out.print("Enter the name that you wish to search for, or -1 to exit: ");
            choice = scanner.nextLine();

            if(choice.equals("-1")){
                System.out.println("Thank you for using the phonebook.");
                break;
            }
            ArrayList<Entry> entries = entryRedBlackTree.get(choice);

            if (entries == null) {
                System.out.println("No entries found for: " + choice);
            } else {
                System.out.println("Entries found: " + entries.size());
                for (Entry entry : entries) {
                    System.out.println(entry.toString());
                }
            }
        }
    }
}
