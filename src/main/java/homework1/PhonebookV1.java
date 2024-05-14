package homework1;

import java.io.IOException;
import java.sql.SQLOutput;
import java.util.Scanner;

public class PhonebookV1 {
    public static void main(String[] args) throws IOException {
        // main application logic
        System.out.println("Loading the entries...");
        Entry[] entries = FileUtils.readFile("C:\\Users\\ohuse\\IdeaProjects\\DataStructures\\src\\main\\java\\homework1\\sorted_phonebook_data.csv");
        //Entry[] entries = FileUtils.readFile("C:\\Users\\ohuse\\IdeaProjects\\DataStructures\\src\\main\\java\\homework1\\raw_phonebook_data.csv");
        //System.out.println("Sorting the entries...");
        //MergeSort.sort(entries);
        //System.out.println("Saving the sorted file...");
        //FileUtils.writeToFile(entries, "C:\\Users\\ohuse\\IdeaProjects\\DataStructures\\src\\main\\java\\homework1\\sorted_phonebook_data.csv");


        Scanner scanner = new Scanner(System.in);
        System.out.println("===============================================");
        System.out.println("System is ready.");

        System.out.print("Type in Surname, Name OR -1 if you want to close the program: ");
        String choice = scanner.nextLine();
        while(!choice.equals("-1")){
            int[] found = BinarySearch.search(entries, choice);
            if(found.length==0){
                System.out.println("No such name and surname.");
            }
            else if(found.length>0){
                int nOfEntries = 0;
                for(int i=found[0]; i<=found[1]; i++){
                    System.out.println("ENTRY NUMBER: "+i);
                    System.out.println("Name: "+entries[i].getName());
                    System.out.println("Street address: "+entries[i].getStreetAddress());
                    System.out.println("City: "+entries[i].getCity());
                    System.out.println("Postal code: "+entries[i].getPostcode());
                    System.out.println("Country: "+entries[i].getCountry());
                    System.out.println("Phone number: "+entries[i].getPhoneNumber());
                    System.out.println("--------------------------------------");
                    nOfEntries++;
                }
                System.out.println("Entries found: "+nOfEntries+"\n===================");
            }
            System.out.print("Type in Surname, Name OR -1 if you want to close the program: ");
            choice = scanner.nextLine();
        }
        System.out.println("Thank you for using the phonebook.");
    }

}
