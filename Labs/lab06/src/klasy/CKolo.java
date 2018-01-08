/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package klasy;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

/**
 *
 * @author Grzegorz
 */
public class CKolo implements IFigura {
    protected int R;
    protected int X0;
    protected int Y0;
    protected int offsetX;
    protected int offsetY;
    protected Color kolor;
    
    public CKolo(int R, int x, int y, Color kolor) {
        this.R = R;
        X0 = x; Y0 = y;
        this.kolor = kolor;
    }

    @Override
    public void Rysuj(Graphics G, boolean Zaznaczony) {
        Graphics2D g2 = (Graphics2D) G;
        if(!Zaznaczony){
            g2.setStroke(new BasicStroke(2));
        }else{
            g2.setStroke(new BasicStroke(5));
        }
        G.setColor(kolor);
        G.fillOval(X0-R, Y0-R, 2*R, 2*R);
        G.setColor(Color.BLACK);
        G.drawOval(X0-R, Y0-R, 2*R, 2*R);
    }

    @Override
    public boolean Zaznacz(int xk, int yk) {
        boolean res = Math.sqrt((xk-X0)*(xk-X0)+(yk-Y0)*(yk-Y0))<=R;
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
    public void Przenies(int x, int y) {
        X0 = x-offsetX; 
        Y0 = y-offsetY;
    }

    @Override
    public void Przesun(int dx, int dy) {
        X0 += dx-offsetX;
        Y0 += dy-offsetY;
    }
    
}
