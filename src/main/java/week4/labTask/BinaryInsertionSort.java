package week4.labTask;

public class BinaryInsertionSort {

    public static <Data extends Comparable<Data>> void sort(LinkedList<Data> ll) {
        for (int i=0; i<ll.count(); i++){
            for (int j = i; j > 0; j--) {
                if (ll.get(j).compareTo(ll.get(j-1)) < 0) {
                    int insertionPoint = findInsertionPoint(ll,j-1,ll.get(j));
                    ll.add(insertionPoint,ll.get(j));
                    ll.remove(j+1);
                } else {
                    break;
                }
            }
        }
    }

    public static <Data extends Comparable<Data>> int findInsertionPoint(LinkedList<Data> ll, int high, Data key) {
        int low = 0;
        while(low <= high){
            int mid = low + (high-low)/2;
            if (key.compareTo(ll.get(mid)) < 0){
                high = mid - 1;
            }
            else if(key.compareTo(ll.get(mid)) > 0){
                low = mid + 1;
            }
            else{
                return mid;
            }
        }
        return low;
    }
}
