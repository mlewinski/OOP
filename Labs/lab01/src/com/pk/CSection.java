package com.pk;

/**
 * Klasa modelująca C-kształtownik
 */

public class CSection {

    private static String Standard;
    static{
        Standard = "PN-EN 10056-1:2000";}
    public static String getStandard(){
        return Standard;
    }

    protected double A;
    protected double B;
    protected double G;
    protected double R;
    protected double R1;
    private String Name;

    CSection(){
        AssignValues("K50x50", 50, 50, 5, 7, 3.5);
    }

    CSection(String Name, double A, double B, double G, double R, double R1){
        AssignValues(Name, A,B,G,R,R1);
    }

    public boolean AssignValues(String Nazwa, double A, double B, double G, double R, double R1){
        if(A<=0 || B<=0 || G<=0 || R<=0 || R1<=0) return false;
        this.Name = Nazwa;
        this.A = A;
        this.B = B;
        this.G = G;
        this.R = R;
        this.R1 = R1;
        return true;
    }

    public double Area(){
        return A*G + B*(B-G)+(1- (Math.PI/4))*(R*R-2*R1*R1);
    }

    /** Zwraca pole powierzchni
     *
     * @return pole powierzchni
     */
    public double getResult(){
        return Area();
    }

    /**
     * Zwraca sformatowane pole powierzchni
     * @param prec Precyzja wyniku
     * @return Sformatowany łańcuch tekstowy
     */
    public String getResult(int prec){
        return new String("Name= \""+ Name +"\" + , A="+ A + ", B="+B+", G="+G+", R="+R+", R1="+R1+", Area = "+String.format("%."+Integer.toString(prec)+"f", Area()));
    }

}
