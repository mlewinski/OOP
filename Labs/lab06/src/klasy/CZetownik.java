/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package klasy;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;

/**
 *
 * @author cad
 */
public class CZetownik implements IFigura  {
    protected int X0;
    //f = new CKsztaltDwa(100,30,200,600,160, Color.ORANGE);
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
    protected int G;
    protected int H;
    /** Liczba wierzchołków (dla trójkąta = 3). */
    protected int N;
    public CZetownik(int a, int g, int h, int x0, int y0, Color k){
        kolor = k;
        A = a; G = g; N = 8; H = h;
        X0 = x0; Y0 = y0;
    }
    @Override
    public boolean Zaznacz(int xk, int yk) {
        int ax[] = new int[N];
        int ay[] = new int[N];
        ax[0] = X0; ay[0] = Y0;
        ax[1] = X0+A; ay[1] = Y0;
        ax[2] = X0+A; ay[2] = Y0-H+this.G;
        ax[3] = X0+2*A-this.G; ay[3] = Y0-H+this.G;
        ax[4] = X0+2*A-this.G; ay[4] = Y0-H;
        ax[5] = X0+A-this.G; ay[5] = Y0-H;
        ax[6] = X0+A-this.G; ay[6] = Y0-this.G;
        ax[7] = X0; ay[7] = Y0-this.G;
        Polygon p = new Polygon(ax, ay, N);
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
        ax[0] = X0; ay[0] = Y0;
        ax[1] = X0+A; ay[1] = Y0;
        ax[2] = X0+A; ay[2] = Y0-H+this.G;
        ax[3] = X0+2*A-this.G; ay[3] = Y0-H+this.G;
        ax[4] = X0+2*A-this.G; ay[4] = Y0-H;
        ax[5] = X0+A-this.G; ay[5] = Y0-H;
        ax[6] = X0+A-this.G; ay[6] = Y0-this.G;
        ax[7] = X0; ay[7] = Y0-this.G;
        
        G.setColor(kolor);
        G.fillPolygon(ax, ay, N);
        G.setColor(Color.BLACK);
        G.drawPolygon(ax, ay, N);
    }
}
