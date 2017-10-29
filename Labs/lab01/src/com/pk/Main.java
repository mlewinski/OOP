package com.pk;

import java.util.Scanner;

import static java.lang.System.*;

/**
 * Program oblicza pole powierzchni kątownika
 * @author mlewinski
 * @version 1.0.0.0
 * @see CSection
 */

public class Main {

    public static void main(String[] args) {
	    CSection k50x50 = new CSection();
	    CSection k120x120 = new CSection("K120x120x12", 120, 120, 12, 13, 6.5);
	    CSection k90x60 = new CSection("K90x60x8", 90, 60, 8, 9, 4);

	    out.println("Norma : " + CSection.getStandard());

	    out.println(k50x50.getResult());
	    out.println(k50x50.getResult(5));

	    out.println(k90x60.getResult());
	    out.println(k90x60.getResult(5));

	    out.println(k120x120.getResult());
	    out.println(k120x120.getResult(5));


	    while(true){
            Scanner sc = new Scanner(in);
            sc.nextLine();
	        CSection nowy;
	        sc.reset();
	        out.println("Podaj nazwe : ");
	        String Name = sc.nextLine();
	        out.println("Podaj A : ");
	        double A = sc.nextDouble();
	        out.println("Podaj B : ");
	        double B = sc.nextDouble();
	        out.println("Podaj G : ");
	        double G = sc.nextDouble();
	        out.println("Podaj R : ");
	        double R = sc.nextDouble();
	        out.println("Podaj R1 : ");
	        double R1 = sc.nextDouble();
	        nowy = new CSection(Name, A, B, G, R, R1);
	        out.println(nowy.getResult(10));
	        out.println("Czy chcesz kontynuować? 0/1");
	        sc.reset();
	        int opcja = sc.nextInt();
	        if(opcja == 1) continue;
	        else break;
        }

    }
}
