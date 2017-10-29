package com.pk;

/**
 * Created by mlewinski on 10/29/17.
 */
public class Stop {
    protected String Name = null;
    protected String Next = null;
    protected int metersTo = 0;
    protected int minutesTo = 0;

    Stop(){ }

    Stop(String name){
        this.Name = name;
    }

    Stop(String name, String next, int meters, int minutes){
        this.Name = name;
        this.Next = next;
        this.metersTo = meters;
        this.minutesTo = minutes;
    }

    public String toString(){
        return "Stop : "+Name+", next : "+(Next==null?"-none-":Next);
    }
}
