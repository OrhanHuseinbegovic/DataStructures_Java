package homework4;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws URISyntaxException, FileNotFoundException {
        // main application logic
        Scanner fileScanner = null;
        try {
            fileScanner = new Scanner(new File("C:\\Users\\ohuse\\IdeaProjects\\DataStructures\\src\\main\\java\\homework4\\social_network.csv"));
        } catch (FileNotFoundException e) {
            System.out.println("Problem occurred");
        }

        SocialNetwork socialNetwork = new SocialNetwork(fileScanner);

        System.out.println("Total number of users: "+socialNetwork.totalNumberOfUsers());
        System.out.println("Total number of friendships: "+socialNetwork.totalNumberOfFriendships());
        System.out.println("==========================================================");

        Scanner input = new Scanner(System.in);
        while(true){
            System.out.println("Enter a name to recommend for, or -1 to exit: ");
            String choice = input.nextLine();
            if(!choice.equals("-1")){
                if(socialNetwork.exists(choice)){
                    ArrayList<FriendshipRecommendation> usersToRecommend = socialNetwork.recommendFriends(choice);
                    System.out.println("Total number of recommendations: "+usersToRecommend.size());
                    for(int i=0; i<10; i++){
                        System.out.println(usersToRecommend.get(i).getRecommendedUser() + ": "+usersToRecommend.get(i).getRecommendationStrength());
                    }
                }
                else{
                    System.out.println("The user you are looking for does not exist in the network.");
                }
            }
            else{
                System.out.println("Thank you for using our friendship recommender algorithm.");
                break;
            }
        }
    }
}
