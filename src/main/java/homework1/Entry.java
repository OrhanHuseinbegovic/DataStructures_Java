package homework1;

public class Entry implements Comparable<Entry> {
    // implement the relevant data attributes
    private String name;
    private String streetAddress;
    private String city;
    private String postcode;
    private String country;
    private String phoneNumber;

    public Entry(String name, String streetAddress, String city, String postcode, String country, String phoneNumber){
        this.name = name;
        this.streetAddress = streetAddress;
        this.city = city;
        this.postcode = postcode;
        this.country = country;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public int compareTo(Entry other) {
        // implement the actual compareTo logic (remove next line)
        String[] thisNameParts = this.getName().split(", ");
        String[] otherNameParts = other.getName().split(", ");

        String thisSurname = thisNameParts[0];
        String thisName = thisNameParts[1];

        String otherSurname = otherNameParts[0];
        String otherName = otherNameParts[1];

        int surnameComparison = thisSurname.compareTo(otherSurname);

        if(surnameComparison != 0){
            return  surnameComparison;
        }

        return thisName.compareTo(otherName);
    }


}