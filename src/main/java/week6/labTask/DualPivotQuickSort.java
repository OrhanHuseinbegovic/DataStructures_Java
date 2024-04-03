package week6.labTask;

import java.util.Random;

public class DualPivotQuickSort {

    /* Quick sort algorithm (public invocation) */
    public static <Data extends Comparable<Data>> void sort(Data[] elements) {
        // your code here
        shuffle(elements);
        sort(elements, 0, elements.length - 1);
    }

    /* Knuth shuffle (performance guarantee) */
    private static <Data extends Comparable<Data>> void shuffle(Data[] elements) {
        // your code here
        Random rand = new Random();
        for (int i = 0; i < elements.length; i++) {
            int r = i + rand.nextInt(elements.length - i);
            swap(elements, i, r);
        }
    }

    /* Recursive quick sort logic */
    private static <Data extends Comparable<Data>> void sort(Data[] elements, int low, int high) {
        // your code here
        if (high<=low) return;
        int[] j = partition(elements, low, high);
        sort(elements, low, j[0] - 1);
        sort(elements, j[0]+1, j[1]-1);
        sort(elements, j[1]+1, high);
    }

    /* Partition an array using the dual-pivot approach and return the pivot indices */
    public static <Data extends Comparable<Data>> int[] partition(Data[] elements, int low, int high) {
        if (high<=low) return new int[]{low,low};

        if (elements[high].compareTo(elements[low])<=0){
            swap(elements,low,high);
        }

        int i = low + 1; //LEFT PARTITION POINTER
        int j = high - 1; //RIGHT PARTITION POINTER
        int k = i; //ITERATOR

        while(k<=j){
            if (elements[k].compareTo(elements[low])<0){
                swap(elements,k++,i++);
            }
            else if(elements[k].compareTo(elements[high])>0){
                swap(elements,k,j--);
            }
            else{
                k++;
            }
        }

        swap(elements,--i,low);
        swap(elements,++j,high);

        return new int[]{i,j};
    }

    private static <Data extends Comparable<Data>> void swap(Data[] elements, int i, int j) {
        Data tmp = elements[i];
        elements[i] = elements[j];
        elements[j] = tmp;
    }
}
