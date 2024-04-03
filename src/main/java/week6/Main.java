package week6;

import week6.labTask.DualPivotQuickSort;

public class Main {

    public static void main(String[] args) {
        System.out.println("Quick sort:");
        int[] elements = { 20, 8, 30, 5, 18, 35, 15, 41, 10 };

        QuickSort.sort(elements);

        /* Print the elements */
        for (int i: elements) {
            System.out.println(i);
        }
    }
}
