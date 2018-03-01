/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sheduler;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import static sheduler.Scheduler.processes;
import static sheduler.Scheduler.processesCorrectOrder;
import static sheduler.Scheduler.prograsbar;
import static sheduler.Scheduler.runningProcesses;
import static sheduler.Scheduler.time;
/**
 *
 * @author Tharindu Gayan
 */
public class Runn extends Thread{
    public int TimeQuantum;
    public DefaultTableModel model1;

    public Runn(int TimeQuantum, DefaultTableModel model1) {
        this.TimeQuantum = TimeQuantum;
        this.model1 = model1;
    }

    @Override                                                  //this is the main thread for run the programs
    public void run(){
        while(Process.getFinishedCount()<=Process.getProcessCount()){
                checkProcesses();
                try {
                    runProcesses(TimeQuantum,model1);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Scheduler.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
    }
    
    
    public  void checkProcesses(){
        int arrivaltime_max=0;
        for(Process p : processes){                           //we use this for loop to calculate the maximum arrival time
            if (arrivaltime_max<p.getArrival_time()){
                arrivaltime_max=p.getArrival_time();
            }
        }
        for (int i = 0;i<=arrivaltime_max;i++){               //in this for loop we add process in to another array list by arrival time
            for (Process p :processes){
                if(p.getArrival_time()==i){
                    processesCorrectOrder.add(p);
                }
            }
        }
        for(Process p : processesCorrectOrder){              //in this for loop we add process in to the running process array list
            if (p.getArrival_time()>=time.getTime()){
                runningProcesses.add(p);
            }
        }
    }
    
    public void runProcesses(int TimeQuantum,DefaultTableModel model1) throws InterruptedException{
        for (Process p : runningProcesses){                 // we use this method to run the processes one by one from runningProcesses array list
            runProcess(p,time,TimeQuantum,model1);
        }
    }
    
    public void runProcess(Process p,Time time,int timePeriod,DefaultTableModel model1) throws InterruptedException{
        for (int i=0;i<timePeriod;i++){
            if(p.getLeft_time()>0){                                        //in this method we run the process round robinly
                sleep(1000);
                model1.addColumn(p.getProcess_id());
                System.out.println(p.getProcess_id());
                p.setLeft_time(p.getLeft_time()-1);
                time.setTime(time.getTime());
                UpdatePrograssBar();
            }
            else if(p.getLeft_time()==0){
                Process.setFinishedCount();
                break;
            }
        }
    }
    
    public void UpdatePrograssBar(){                     //this is the method for update the prograss bars
        
        for (Process p : runningProcesses){
            int index = processes.indexOf(p)+1;
        int percentage = (int) ((((p.getRun_time()*1.0)-(p.getLeft_time()*1.0))*100/p.getRun_time())/1);
        
        switch (index){
            case 1: prograsbar.get(0).setValue(percentage);
            break;
            case 2: prograsbar.get(1).setValue(percentage);
            break;
            case 3: prograsbar.get(2).setValue(percentage);
            break;
            case 4: prograsbar.get(3).setValue(percentage);
            break;
            case 5: prograsbar.get(4).setValue(percentage);
            break;
            case 6: prograsbar.get(5).setValue(percentage);
            break;
            case 7: prograsbar.get(6).setValue(percentage);
            break;
            case 8: prograsbar.get(7).setValue(percentage);
            break;
            case 9: prograsbar.get(8).setValue(percentage);
            break;
            case 10: prograsbar.get(9).setValue(percentage);
            break;
            default: break;
        }
        }
    }
    
}
