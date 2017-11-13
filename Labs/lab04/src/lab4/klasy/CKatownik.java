/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4.klasy;

import java.awt.Color;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;

/**
 *
 * @author Marek
 */
public class CKatownik implements IFigura{
    protected int B;
    protected int G;
    protected int A;
    protected int X0;
    protected int Y0;
    protected int offsetX;
    protected int offsetY;
    protected Color kolor;
    
    public CKatownik(int a, int b, int g, int x, int y, Color kolor){
        A=a;
        B=b;
        G=g;
        X0=x;
        Y0=y;
        this.kolor = kolor;
    }        

    @Override
    public void Rysuj(Graphics g, boolean zaznaczony){
        Graphics2D g2 = (Graphics2D) g;
        if(!zaznaczony) g2.setStroke(new BasicStroke(2));
        else g2.setStroke(new BasicStroke(5));
        int ax[] = { X0, X0, X0+A, X0+A, X0+G, X0+G};
        int ay[] = { Y0, Y0+B, Y0+B, Y0+B-G, Y0+B-G, Y0};
        Polygon p = new Polygon(ax, ay, 6);
        g2.setColor(kolor);
        g2.fillPolygon(p);
        g2.setColor(Color.BLACK);
        g2.drawPolygon(p);
    }
    
    @Override
    public boolean Zaznacz(int xk, int yk) {
        int ax[] = { X0, X0, X0+A, X0+A, X0+G, X0+G};
        int ay[] = { Y0, Y0+B, Y0+B, Y0+B-G, Y0+B-G, Y0};
        Polygon p = new Polygon(ax, ay, 6);
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
