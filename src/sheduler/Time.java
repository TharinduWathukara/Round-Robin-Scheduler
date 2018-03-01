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
public class Time {
    private int Time;                                //this is the time frame for scheduler

    public Time() {
        this.Time = 0;
    }

    public int getTime() {
        return Time;
    }

    public void setTime(int Time) {
        this.Time = Time+1;
    }
    
}
