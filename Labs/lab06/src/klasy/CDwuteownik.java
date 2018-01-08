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
public class CDwuteownik implements IFigura {
    
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
    
    protected int N;
    /** Ilosc wierzcholkow. */
    
    protected int A;
    
    protected int H;
    
    protected int G;
    
    public CDwuteownik(int a, int h, int g, int x0, int y0, Color k)
    {
        kolor = k;
        A = a; H = h; G = g;
        N = 12;
        X0 = x0; Y0 = y0;
    }

    @Override
    public boolean Zaznacz(int xk, int yk) {
        int ax[] = new int[N];
        int ay[] = new int[N];
        ax[0] = X0; ax[1] = X0 + A; ax[2] = ax[1];
        ax[3] = ax[2] - (A-this.G)/2; ax[4] = ax[3]; ax[5] = ax[4] + (A-this.G)/2;
        ax[6] = ax[5]; ax[7] = ax[6] - A; ax[8] = ax[7];
        ax[9] = ax[8] + (A-this.G)/2; ax[10] = ax[9]; ax[11] = ax[10] - (A-this.G)/2;
        
        ay[0] = Y0; ay[1] = ay[0]; ay[2] = ay[1] + this.G;
        ay[3] = ay[2]; ay[4] = ay[3] + (H-2*this.G); ay[5] = ay[4];
        ay[6] = ay[5] + this.G; ay[7] = ay[6]; ay[8] = ay[7] - this.G;
        ay[9] = ay[8]; ay[10] = ay[9] - (H-2*this.G); ay[11] = ay[10];
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
        
        ax[0] = X0; ax[1] = X0 + A; ax[2] = ax[1];
        ax[3] = ax[2] - (A-this.G)/2; ax[4] = ax[3]; ax[5] = ax[4] + (A-this.G)/2;
        ax[6] = ax[5]; ax[7] = ax[6] - A; ax[8] = ax[7];
        ax[9] = ax[8] + (A-this.G)/2; ax[10] = ax[9]; ax[11] = ax[10] - (A-this.G)/2;
        
        ay[0] = Y0; ay[1] = ay[0]; ay[2] = ay[1] + this.G;
        ay[3] = ay[2]; ay[4] = ay[3] + (H-2*this.G); ay[5] = ay[4];
        ay[6] = ay[5] + this.G; ay[7] = ay[6]; ay[8] = ay[7] - this.G;
        ay[9] = ay[8]; ay[10] = ay[9] - (H-2*this.G); ay[11] = ay[10];
        G.setColor(kolor);
        G.fillPolygon(ax, ay, N);
        G.setColor(Color.BLACK);
        G.drawPolygon(ax, ay, N);
    }
    
}
