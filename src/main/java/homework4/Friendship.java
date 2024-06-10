package homework4;


public class Friendship {
    // implement the relevant properties, constructor and methods
    private String firstFriend;
    private String secondFriend;
    private int strength;

    public Friendship(String firstFriend, String secondFriend, int strength){
        this.firstFriend = firstFriend;
        this.secondFriend = secondFriend;
        this.strength = strength;
    }

    public String getFirstFriend() {
        return firstFriend;
    }

    public void setFirstFriend(String firstFriend) {
        this.firstFriend = firstFriend;
    }

    public String getSecondFriend() {
        return secondFriend;
    }

    public void setSecondFriend(String secondFriend) {
        this.secondFriend = secondFriend;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }


}
