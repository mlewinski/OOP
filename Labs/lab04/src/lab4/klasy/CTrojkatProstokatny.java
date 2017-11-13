/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4.klasy;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;

public class CTrojkatProstokatny implements IFigura {
    /** Współrzędna X punktu charakterystycznego. */
    protected int X0;
    /** Współrzędna Y punktu charakterystycznego. */
    protected int Y0;
    /** Odległość względem osi X od punktu kliknięcia do punktu charakterystycznego. 
     Parametr wykorzystywany przy przesuwaniu figury.
     */
    protected int offsetX;
    /** Odległość względem osi Y od punktu kliknięcia do punktu charakterystycznego. 
     Parametr wykorzystywany przy przesuwaniu figury.
     */
    protected int offsetY;
    /** Kolor wypełnienia. */
    protected Color kolor;
    /** Długość poziomego boku trójkąta. */
    protected int A;
    /** Długość pionowego boku trójkąta. */
    protected int B;
    /** Liczba wierzchołków (dla trójkąta = 3). */
    protected int N;
    /**
      Konstruktor
      @param a długość boku poziomego.
      @param b długość boku pionowego.
      @param x0 współrzędna X punktu charakterystycznego.
      @param y0 współrzędna Y punktu charakterystycznego.
      @k kolor wypełnienia.
    */    
    public CTrojkatProstokatny(int a, int b, int x0, int y0, Color k){
        kolor = k;
        A = a; B = b; N = 3;
        X0 = x0; Y0 = y0;
    }

    @Override
    public boolean Zaznacz(int xk, int yk) {
        int ax[] = new int[N];
        int ay[] = new int[N];
        ax[0] = X0; ax[1] = X0 + A; ax[2] = X0;
        ay[0] = Y0; ay[1] = Y0;     ay[2] = Y0 - B;
        Polygon p = new Polygon(ax, ay, 3);
        boolean res = p.contains(xk, yk);
        if(res==Boolean.TRUE){
            offsetX = xk-X0;
            offsetY = yk-Y0;
        }else{
            offsetX = 0;
            offsetY = 0;
        }
        return res;
    }

    @Override
    public void Przesun(int dx, int dy) {
        X0 += dx; Y0 += dy;
    }

    @Override
    public void Przenies(int x, int y) {
        X0 = x - offsetX; 
        Y0 = y - offsetY;
    }

    @Override
    public void Rysuj(Graphics G, boolean Zaznaczony) {
        Graphics2D g2 = (Graphics2D) G;
        if(!Zaznaczony){
            g2.setStroke(new BasicStroke(2));
        }else{
            g2.setStroke(new BasicStroke(5));
        }
        int ax[] = new int[N];
        int ay[] = new int[N];
        ax[0] = X0; ax[1] = X0 + A; ax[2] = X0;
        ay[0] = Y0; ay[1] = Y0;     ay[2] = Y0 - B;
        G.setColor(kolor);
        G.fillPolygon(ax, ay, N);
        G.setColor(Color.BLACK);
        G.drawPolygon(ax, ay, N);
    }
}
