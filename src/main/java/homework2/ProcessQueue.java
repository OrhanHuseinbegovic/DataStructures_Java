package homework2;


public class ProcessQueue {
    public Process[] pq = new Process[2];
    public int length = 0;

    public int totalTime = 0;
    /* Add a new process into the priority queue */
    public void addProcess(Process process) {
        // your code here
        if(pq.length == length + 1){
            resize(2*pq.length);
        }
        pq[++length] = process;
        swim(length);
        totalTime += process.getBurstTime();
    }

    /* Return and remove the next Process that should be run */
    public Process runNextProcess() {
        // your code here (next line is a placeholder)
        if (isEmpty()) {
            return null;
        }
        Process min = pq[1];
        swap(1, length--); // Swap the root with the last element
        pq[length + 1] = null; // Avoid loitering

        if (length > 0 && length == pq.length / 4) {    // 4
            resize(pq.length / 2);                      // 4
        }

        sink(1); // Restore the heap property
        totalTime -= min.getBurstTime(); // Update the total time
        return min;
    }

    /* Return the next Process that should be run (but do not delete it) */
    public Process peekNextProcess() {
        // your code here (next line is a placeholder)
        if(isEmpty()){
            return null;
        }
        return pq[1];
    }

    /* Implement any other helper methods, if you need them. */

    private void swim(int k) {
        while (k > 1 && more(k/2, k)) {     // 1
            swap(k, k/2);                   // 2
            k = k/2;                        // 3
        }
    }

    private void sink(int k){
        while(2*k<=length){
            int j = 2 * k;
            if(j <length && more(j, j+1)){
                j++;
            }
            if(more(k,j)){
                swap(k,j);
                k=j;
            }
            else{
                break;
            }
        }
    }

    public boolean isEmpty(){
        return length==0;
    }

    public int size(){
        return length;
    }

    private void resize(int capacity){
        //Process[] copy = (Process[]) new Comparable[capacity]; -> causes some casting issues
        Process[] copy = new Process[capacity];
        for (int i=1; i<=length; i++){
            copy[i] = pq[i];
        }
        pq = copy;
    }

    private void swap(int a, int b){
        Process temp = pq[a];
        pq[a] = pq[b];
        pq[b] = temp;
    }

    private boolean more(int a, int b){
        return pq[a].compareTo(pq[b]) > 0;
    }

    private int getTotalTime(){
        return this.totalTime;
    }
}
