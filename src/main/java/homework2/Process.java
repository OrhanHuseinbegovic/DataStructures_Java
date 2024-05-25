package homework2;

public class Process implements Comparable<Process> {
    // Implement the required attributes and constructor
    private String processName;
    private int priority; //we make it comparable by priority, since we are implementing preemptive, and we need to compare processes by this.
    private int burstTime;
    private int arrivalTime;

    public Process(String processName, int priority, int burstTime, int arrivalTime){
        this.processName = processName;
        this.priority = priority;
        this.burstTime = burstTime;
        this.arrivalTime = arrivalTime;
    }


    @Override
    public int compareTo(Process other) {
        // implement the correct logic
        if(this.priority > other.priority){
            return 1;
        }
        else if(this.priority < other.priority){
            return -1;
        }
        else{
            return 0;
        }
    }

    public String getName(){
        return this.processName;
    }

    public int getArrivalTime(){
        return this.arrivalTime;
    }

    public int getPriority(){
        return this.priority;
    }

    public int getBurstTime(){
        return burstTime;
    }

    public void setBurstTime(int burstTime) {
        this.burstTime = burstTime;
    }
}
