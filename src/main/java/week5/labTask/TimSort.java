package week5.labTask;

public class TimSort {

    public static <Data extends Comparable<Data>> void sort(Data[] elements, int threshold) {
        // HINT: It is not possible to directly create a new generic array in Java,
        // so you can use this workaround - create a Comparable array and cast it
        // Data[] aux = (Data[]) new Comparable[elements.length];
        int sizeOfArray = elements.length;
        int runLength = calculateRunLength(sizeOfArray,threshold);
        Data[] aux = (Data[]) new Comparable[elements.length];
        sort(elements, aux, 0, sizeOfArray - 1);
        // your code here
    }

    private static <Data extends  Comparable<Data>> void sort (Data[] elements, Data[] aux, int low, int high) {
        if (high <= low) {
            return;
        }

        int mid = low + (high - low) / 2;
        sort(elements, aux, low, mid);
        sort(elements, aux, mid + 1, high);
        merge(elements, aux, low, mid, high);
    }

    public static <Data extends Comparable<Data>> void insertionSort(Data[] elements, int low, int high) {
        // your code here
        for (int i = low; i < high+1; i++) {
            for (int j = i; j > 0; j--) {
                if (elements[j].compareTo(elements[j-1]) < 0){
                    Data temp = elements[j];
                    elements[j]=elements[j-1];
                    elements[j-1]=temp;
                }else {
                    break;
                }
            }
        }
    }

    public static <Data extends Comparable<Data>> void merge(Data[] elements, Data[] aux, int low, int mid, int high) {
        // your code here
        for (int k = low; k <= high; k++) {
            aux[k] = elements[k];
        }

        int i = low;
        int j = mid + 1;
        for (int k = low; k <= high; k++) {
            if (i > mid) {
                elements[k] = aux[j++];
            } else if (j > high) {
                elements[k] = aux[i++];
            } else if (aux[j].compareTo(aux[i])<0) {
                elements[k] = aux[j++];
            } else {
                elements[k] = aux[i++];
            }
        }
    }

    public static int calculateRunLength(int initialLength, int threshold) {
        // your code here (next line is a placeholder)
        int runLength = initialLength;
        int remainder = 0;
        if (initialLength<threshold){
            return initialLength;
        }
        while(runLength > threshold){
            if (runLength%2!=0){
                remainder = 1;
            }
            runLength = runLength/2;
        }
        return runLength + remainder;
    }
}
