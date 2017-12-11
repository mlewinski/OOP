/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab05;

public class CDaneOsob {
    
    private String Imie, Nazwisko;
    private int RokUr;

    public CDaneOsob(String Imie, String Nazwisko, int RokUr) {
        this.Imie = Imie;
        this.Nazwisko = Nazwisko;
        this.RokUr = RokUr;
    }

    @Override
    public String toString() {
        return "CDaneOsob{" + "Imie=" + Imie + ", Nazwisko=" + Nazwisko + ", RokUr=" + RokUr + '}';
    }
    
    
}
