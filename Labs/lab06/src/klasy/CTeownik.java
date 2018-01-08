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
public class CTeownik implements IFigura{
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
    protected int A;
    protected int G;
    protected int H;
    protected int N;
    
    public CTeownik(int a, int g, int h, int x0, int y0, Color k)
    {
        kolor = k;
        A = a; G = g; H = h; N=8;
        X0 = x0; Y0 = y0;
    }
    @Override
    public boolean Zaznacz(int xk, int yk) {
        int ax[] = new int[N];
        int ay[] = new int[N];
        ax[0] = X0; ax[1] = X0; ax[2] = ax[1]+A;
        ay[0] = Y0;
        ay[1] = Y0 - this.G;
        ay[2] = ay[1];
        ax[3] = ax[2];
        ay[3] = ay[2] + this.G;
        ax[4] = ax[3] - (A-this.G)/2;
        ay[4] = ay[3];
        ax[5] = ax[4];
        ay[5] = ay[4] + (H-this.G);
        ax[6] = ax[5] - this.G;
        ay[6] = ay[5];
        ax[7] = ax[6];
        ay[7] = ay[6] - (H-this.G);
        Polygon p = new Polygon(ax, ay, 8);
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
        ax[0] = X0; ax[1] = X0; ax[2] = ax[1]+A;
        ay[0] = Y0;
        ay[1] = Y0 - this.G;
        ay[2] = ay[1];
        ax[3] = ax[2];
        ay[3] = ay[2] + this.G;
        ax[4] = ax[3] - (A-this.G)/2;
        ay[4] = ay[3];
        ax[5] = ax[4];
        ay[5] = ay[4] + (H-this.G);
        ax[6] = ax[5] - this.G;
        ay[6] = ay[5];
        ax[7] = ax[6];
        ay[7] = ay[6] - (H-this.G);
        G.setColor(kolor);
        G.fillPolygon(ax, ay, N);
        G.setColor(Color.BLACK);
        G.drawPolygon(ax, ay, N);
    }
    
}
