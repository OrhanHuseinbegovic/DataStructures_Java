package homework2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Scheduler {

    public static void scheduleAndRun(ArrayList<Process> processes) {
        processes.sort(Comparator.comparingInt(Process::getArrivalTime));

        ProcessQueue queue = new ProcessQueue();
        int currentTime = 0;
        int processIndex = 0;
        int n = processes.size();

        Process currentProcess = null;
        int remainingBurstTime = 0;
        int totalBurstTime = 0;

        for(Process process : processes){
            queue.addProcess(process);
            totalBurstTime += process.getBurstTime();
        }

        int t = 0;
        for(Process process : queue.pq){

        }

    }

    public static void main(String[] args) {
        // you can use the main method for testing
        ArrayList<Process> processes = new ArrayList<>();
        /*
        processes.add(new Process("P1", 1, 4, 0));
        processes.add(new Process("P2", 2, 3, 0));
        processes.add(new Process("P3", 1, 7, 6));
        processes.add(new Process("P4", 3, 4, 11));
        processes.add(new Process("P5", 2, 2, 12));
         */

        /*
        processes.add(new Process("P1", 3, 3, 0));
        processes.add(new Process("P2", 2, 4, 1));
        processes.add(new Process("P3", 4, 6, 2));
        processes.add(new Process("P4", 6, 4, 3));
        processes.add(new Process("P5", 10, 2, 5));
         */

        /*
        processes.add(new Process("P1", 2, 1, 0));
        processes.add(new Process("P2", 6, 7, 1));
        processes.add(new Process("P3", 3, 3, 2));
        processes.add(new Process("P4", 5, 6, 3));
        processes.add(new Process("P5", 4, 5, 4));
        processes.add(new Process("P6", 10, 15, 5));
        processes.add(new Process("P7", 9, 8, 15));
         */


        processes.add(new Process("P1", 2, 4, 1));
        processes.add(new Process("P2", 1, 1, 2));
        processes.add(new Process("P3", 3, 2, 8));


        scheduleAndRun(processes);
    }
}
