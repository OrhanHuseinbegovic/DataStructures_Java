package homework4;

import java.util.*;

public class SocialNetwork {
    private int V; //this is number of vertices
    private int E; //this is number of edges

    private HashMap<String, ArrayList<Friendship>> adj; //this is adjacency list where (user name -> list of adjacent Friendsips)

    public SocialNetwork() {
        // implement the actual logic
        this.V = 0;
        this.E = 0;
        adj = new HashMap<>();
    }

    public SocialNetwork(Scanner in) {
        // implement the actual logic
        this();
        in.nextLine();

        while(in.hasNextLine()){
            String line = in.nextLine().trim();
            String[] sentence = line.split(";");
            String fr1 = sentence[0];
            String fr2 = sentence[1];
            int str = Integer.parseInt(sentence[2]);
            addUser(fr1);
            addUser(fr2);
            addFriendship(new Friendship(fr1,fr2,str));
        }
    }


    public void addUser(String user) {
        // implement the actual logic
        if(!adj.containsKey(user)){
            adj.put(user, new ArrayList<Friendship>());
            V++;
        }
    }

    public void addFriendship(Friendship f) {
        // implement the actual
        String first = f.getFirstFriend();
        String second = f.getSecondFriend();
        int strength = f.getStrength();
        if(adj.containsKey(first) && adj.containsKey(second)){
            adj.get(first).add(f);
            adj.get(second).add(f);
            E++;
        }
        //maybe need to check if the user exists, if doesnt
        //add them to graph, then connect them
        //NOT SURE, NEED TO TEST
    }

    public ArrayList<FriendshipRecommendation> recommendFriends(String user) {
        // implement the actual logic (remove next line)
        HashMap<String, Integer> recommendations = new HashMap<>();

        //here we are getting the users friends
        ArrayList<Friendship> userFriends = adj.get(user);
        if (userFriends == null) {
            return new ArrayList<>();
        }

        // For every friend, we check their friends
        for (Friendship userFriendship : userFriends) {
            String friend = userFriendship.getFirstFriend().equals(user) ? userFriendship.getSecondFriend() : userFriendship.getFirstFriend();
            ArrayList<Friendship> friendsOfFriend = adj.get(friend);

            if (friendsOfFriend == null) continue;

            for (Friendship foFriendship : friendsOfFriend) {
                String potentialRecommendation = foFriendship.getFirstFriend().equals(friend) ? foFriendship.getSecondFriend() : foFriendship.getFirstFriend();

                if (potentialRecommendation.equals(user)) continue;
                if (areFriends(user, potentialRecommendation)) continue;

                int weight = Math.min(userFriendship.getStrength(), foFriendship.getStrength());
                recommendations.put(potentialRecommendation, recommendations.getOrDefault(potentialRecommendation, 0) + weight);
            }
        }

        ArrayList<FriendshipRecommendation> recommendationList = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : recommendations.entrySet()) {
            recommendationList.add(new FriendshipRecommendation(entry.getKey(), entry.getValue()));
        }
        //just sorting the list in descending order
        recommendationList.sort((r1, r2) -> Integer.compare(r2.getRecommendationStrength(), r1.getRecommendationStrength()));

        return recommendationList;
    }

    public boolean areFriends(String friend1, String friend2){
        if(exists(friend1) && exists(friend2)){
            ArrayList<String> lista = new ArrayList<>();
            for(Friendship friendship : adj.get(friend1)){
                if((friendship.getFirstFriend().equals(friend1) && friendship.getSecondFriend().equals(friend2)) || (friendship.getFirstFriend().equals(friend2) && friendship.getSecondFriend().equals(friend1))){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean exists(String user){
        return adj.containsKey(user);
    }

    public int totalNumberOfUsers(){
        return this.V;
    }

    public int totalNumberOfFriendships(){
        return this.E;
    }
}
