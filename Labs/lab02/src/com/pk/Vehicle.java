package com.pk;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mlewinski on 10/30/17.
 */
public class Vehicle {
    protected static String Company = "MPK Krakow";

    protected int Number;
    protected List<Stop> Route;

    public Vehicle(int number){
        this.Number = number;
        this.Route = new ArrayList<Stop>();
    }

    public void addStopToRoute(String name, String next, int meters, int minutes){
        Route.add(new Stop(name, next, meters, minutes));
    }

    public void addStopToRoute(String name, String next, int meters, int minutes, String... transfers){
        Route.add(new StopWithTransfer(name, next, meters, minutes, transfers));
    }

    public void addStopToRoute(String name){
        Route.add(new Stop(name));
    }

    public void addStopToRoute(String name, String... transfers){
        Route.add(new StopWithTransfer(name, transfers));
    }

    @Override
    public String toString(){
        String s = " ";
        for(Stop e : Route) s+= e.toString();
        return Company + ", Linia numer " + Number + s;
    }
}
