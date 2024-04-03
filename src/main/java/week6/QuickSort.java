package week6;

import week4.AbstractSort;

import java.util.Random;

public class QuickSort extends AbstractSort {

    /* Quick sort algorithm (public invocation) */
    public static void sort(int[] elements) {
        shuffle(elements);                              // 1
        sort(elements, 0, elements.length - 1);         // 2
    }

    /* Knuth shuffle (performance guarantee) */
    private static void shuffle(int[] elements) {
        Random rand = new Random();                             // 1
        for (int i = 0; i < elements.length; i++) {             // 2
            int r = i + rand.nextInt(elements.length - i);      // 2
            swap(elements, i, r);                               // 3
        }
    }

    /* Recursive quick sort logic */
    private static void sort(int[] elements, int low, int high) {
        if (high <= low) {                              // 1
            return;                                     // 1
        }
        int j = partition(elements, low, high);         // 2
        sort(elements, low, j - 1);                     // 3
        sort(elements, j + 1, high);                    // 3
    }

    /* Partition an array and return the pivot index */
    private static int partition(int[] elements, int low, int high) {
        int i = low;                                            // 1
        int j = high + 1;                                       // 1
        while (true) {                                          // 2
            while (less(elements[++i], elements[low])) {        // 3
                if (i == high) {                                // 3
                    break;                                      // 3
                }
            }
            while (less(elements[low], elements[--j])) {        // 4
                if (j == low) {                                 // 4
                    break;                                      // 4
                }
            }
            if (i >= j) {                                       // 5
                break;                                          // 5
            }
            swap(elements, i, j);                               // 6
        }
        swap(elements, low, j);                                 // 7
        return j;                                               // 7
    }
}