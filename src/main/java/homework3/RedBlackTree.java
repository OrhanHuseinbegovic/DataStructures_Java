package homework3;

import java.util.ArrayList;

public class RedBlackTree<Entry> {
    private Node<Entry> root;
    private static final boolean RED = true;
    private static final boolean BLACK = false;

    public ArrayList<Entry> get(String searchableName) {
        // implement the actual logic (remove next line)
        Node<Entry> x = root;
        int redCount = 0;
        int blackCount = 0;

        while (x != null) {
            int cmp = searchableName.compareTo(x.key);
            if (cmp < 0) {
                if (!isRed(x.left)) blackCount++;
                x = x.left;
            } else if (cmp > 0) {
                if (!isRed(x.right)) blackCount++;
                x = x.right;
            } else {
                System.out.println("Red edges: " + redCount + ", Black edges: " + blackCount);
                return x.values;
            }
            if (isRed(x)) redCount++;
            else blackCount++;
        }
        System.out.println("Red edges: " + redCount + ", Black edges: " + blackCount);
        return null;
    }


    public void put(String searchableName, Entry entry) {
        // implement the actual logic
        root = put(root, searchableName, entry);
        root.color = BLACK;
    }

    private Node<Entry> put(Node<Entry> h, String key, Entry entry){
        if(h==null){
            return new Node<Entry>(key,entry,RED);
        }

        int cmp = key.compareTo(h.key);

        if(cmp<0){
            h.left = put(h.left, key, entry);
        }
        else if(cmp>0){
            h.right = put(h.right, key, entry);
        }
        else{
            h.addValue(entry);
        }

        if(isRed(h.right) && !isRed(h.left)){
            h = rotateLeft(h);
        }
        if(isRed(h.left) && isRed(h.left.left)){
            h = rotateRight(h);
        }
        if(isRed(h.left) && isRed(h.right)){
            flipColors(h);
        }

        h.size = 1 + size(h.left) + size(h.right);
        return h;
    }

    public int[] countRedAndBlackEdges() {
        // implement the actual logic (remove next line)
        int[] counts = new int[2]; // counts[0] for black, counts[1] for red
        countEdges(root, counts);
        return counts;
    }

    private void countEdges(Node<Entry> x, int[] counts) {
        if (x == null) return;

        if (x.left != null) {
            counts[x.left.color == BLACK ? 0 : 1]++;
            countEdges(x.left, counts);
        }

        if (x.right != null) {
            counts[x.right.color == BLACK ? 0 : 1]++;
            countEdges(x.right, counts);
        }
    }

    private boolean isRed(Node<Entry> x){
        if(x == null){
            return false;
        }
        return x.color == RED;
    }

    private void flipColors(Node<Entry> h){
        h.color = RED;
        h.left.color = BLACK;
        h.right.color = BLACK;
    }

    private Node<Entry> rotateRight(Node<Entry> h){
        Node<Entry> x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = h.color;
        h.color = RED;
        h.size = 1 + size(h.left) + size(h.right);
        return x;
    }

    private Node<Entry> rotateLeft(Node<Entry> h){
        Node<Entry> x = h.right;
        h.right = x.left;
        x.left = h;
        x.color = h.color;
        h.color = RED;
        h.size = 1 + size(h.left) + size(h.right);
        return x;
    }

    private int size(Node<Entry> x) {
        if (x == null) {
            return 0;
        }
        return x.size;
    }
}
