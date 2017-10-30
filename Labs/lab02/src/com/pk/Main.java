package com.pk;

import static java.lang.System.*;

public class Main {

    public static void main(String[] args) {
	    Vehicle P1 = new Vehicle(4);
	    Vehicle P2 = new Vehicle(129);
	    P1.addStopToRoute("Bieżanowksa");
	    P1.addStopToRoute("Dauna", "Piaski Nowe", "Kurdwanów");
	    P1.addStopToRoute("Witosa", "Malborska", 1000, 2);
	    P1.addStopToRoute("Halszki", "Myślenicka", 2000, 500, "Kurdwanów");
	    out.println(P1);
    }
}
