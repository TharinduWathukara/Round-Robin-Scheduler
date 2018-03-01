/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sheduler;

/**
 *
 * @author Tharindu Gayan
 */
public class Process {                                        //This is the process class
    private static int processCount=0;                        //One process has process id, Arrival time, run time and left time
    private static int finishedCount=0;
    private String Process_id;
    private int Arrival_time;
    private int Run_time;
    private int Left_time;                                   //the amount of time needed for completion
    
    public static void setFinishedCount() {
        Process.finishedCount++;
    }

    public static int getProcessCount() {
        return processCount;
    }

    public static int getFinishedCount() {
        return finishedCount;
    }    

    public String getProcess_id() {
        return Process_id;
    }

    public int getLeft_time() {
        return Left_time;
    }

    public void setLeft_time(int Left_time) {
        this.Left_time = Left_time;
    }

    public Process(int Arrival_time, int Run_time) {
        this.Process_id ="P" + ++processCount;
        this.Arrival_time = Arrival_time;
        this.Run_time = Run_time;
        this.Left_time = Run_time;
    }

    public int getArrival_time() {
        return Arrival_time;
    }

    public void setArrival_time(int Arrival_time) {
        this.Arrival_time = Arrival_time;
    }

    public int getRun_time() {
        return Run_time;
    }

    public void setRun_time(int Run_time) {
        this.Run_time = Run_time;
    }
}
