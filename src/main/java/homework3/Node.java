package homework3;

import java.util.ArrayList;

public class Node<Entry> {
    // implement the relevant properties, constructor and methods

    public String key; //customer name and surname
    public ArrayList<Entry> values; //array list of entry values, should be able to contain multiple entries associated with the same name
    public Node<Entry> left, right;
    public int size;
    public boolean color;

    public Node(String key, Entry value, boolean color){
        this.key = key;
        this.values = new ArrayList<>();
        this.values.add(value);
        this.color = color;
        this.size = 1;
    }

    public void addValue(Entry value) {
        this.values.add(value);
    }
}
