package week10;

public class Main {

    public static void main(String[] args) {
        BinaryHeap<Integer> heap = new BinaryHeap<>();

        heap.insert(4);
        heap.insert(10);
        heap.insert(-5);
        heap.insert(7);

        System.out.println("current max: " + heap.delMax());
        System.out.println("current max: " + heap.delMax());
        System.out.println("current max: " + heap.delMax());
        System.out.println("heap size: " + heap.size());
        System.out.println("current max: " + heap.delMax());
    }
}
