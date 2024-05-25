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

        //Here for the Optional part 4, we make array for finish times and an array for original burst times
        //We fill the original burst times array immediately
        int[] finishTimes = new int[n];
        int[] originalBurstTimes = new int[n];
        for (int i = 0; i < n; i++) {
            originalBurstTimes[i] = processes.get(i).getBurstTime();
        }


        while (processIndex < n || !queue.isEmpty()) {

            while (processIndex < n && processes.get(processIndex).getArrivalTime() <= currentTime) {
                queue.addProcess(processes.get(processIndex));
                processIndex++;
            }

            Process nextProcess = queue.runNextProcess();

            if (nextProcess != null) {
                System.out.println("t: " + currentTime + " | " + nextProcess.getName());
                currentTime++;
                nextProcess.setBurstTime(nextProcess.getBurstTime()-1);
                if(nextProcess.getBurstTime()>0){
                    queue.addProcess(nextProcess);
                }
                else {
                    finishTimes[processes.indexOf(nextProcess)] = currentTime;
                }
            }
            else{
                System.out.println("t: " + currentTime + " | no process");
                currentTime++;
            }
        }

        /*
        //Failed attempt of performing ScheduleAndRun, could be fixed and implemented

        for(int t=0; t<totalBurstTime; t++){
            for(Process process : processes){
                if(process.getArrivalTime()==t) {
                    queue.addProcess(process);
                }
            }
            if(!queue.isEmpty()){
                currentProcess = queue.runNextProcess();
                System.out.println("t: " + t + " | " + currentProcess.getName());
                currentProcess.setBurstTime(currentProcess.getBurstTime()-1);
                t++;
            }
            else {
                System.out.println("t: "+t+" | no process");
            }
        }

         */

        //Here we calculate the total waiting time
        int totalWaitingTime = 0;
        for (int i = 0; i < n; i++) {
            //Formula is: finish time of the process - burst ime - arrival time
            int waitingTime = finishTimes[i] - originalBurstTimes[i] - processes.get(i).getArrivalTime();
            totalWaitingTime += waitingTime;
        }
        double averageWaitingTime = (double) totalWaitingTime / n;

        System.out.println("Total time: "+currentTime);
        System.out.println("Average waiting time: " + averageWaitingTime);
    }

    public static void main(String[] args) {
        // you can use the main method for testing
        ArrayList<Process> processes = new ArrayList<>();


        //Sample data from the document to try
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


        processes.add(new Process("P1", 2, 1, 0));
        processes.add(new Process("P2", 6, 7, 1));
        processes.add(new Process("P3", 3, 3, 2));
        processes.add(new Process("P4", 5, 6, 3));
        processes.add(new Process("P5", 4, 5, 4));
        processes.add(new Process("P6", 10, 15, 5));
        processes.add(new Process("P7", 9, 8, 15));


        /*
        processes.add(new Process("P1", 2, 4, 1));
        processes.add(new Process("P2", 1, 1, 2));
        processes.add(new Process("P3", 3, 2, 8));
        */


        scheduleAndRun(processes);
    }
}
