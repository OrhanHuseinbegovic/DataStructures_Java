package homework4;

public class FriendshipRecommendation implements Comparable<FriendshipRecommendation> {
    // implement the relevant properties, constructor and methods
    private String recommendedUser;
    private int recommendationStrength;

    public FriendshipRecommendation(String recommendedUser, int recommendationStrength){
        this.recommendedUser = recommendedUser;
        this.recommendationStrength = recommendationStrength;
    }

    public String getRecommendedUser() {
        return recommendedUser;
    }

    public void setRecommendedUser(String recommendedUser) {
        this.recommendedUser = recommendedUser;
    }

    public int getRecommendationStrength() {
        return recommendationStrength;
    }

    public void setRecommendationStrength(int recommendationStrength) {
        this.recommendationStrength = recommendationStrength;
    }

    @Override
    public int compareTo(FriendshipRecommendation o) {
        if(this.recommendationStrength>o.recommendationStrength){
            return 1;
        }
        else if(this.recommendationStrength<o.recommendationStrength){
            return -1;
        }
        else{
            return 0;
        }
    }
}
