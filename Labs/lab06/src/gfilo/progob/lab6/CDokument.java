/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gfilo.progob.lab6;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.List;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.ListIterator;
import klasy.*;

/**
 *
 * @author Grzegorz
 */
public class CDokument {
    private List<IFigura> lista;
    private BufferedImage image;
    private CPaintPanel paintPanel;
    private IFigura Zaznaczony;
    private void AssignImg(){
        paintPanel.AssignRys(image);
        paintPanel.repaint();     
    }
    private void ClearImg(){
        Graphics gg = image.getGraphics();
        gg.setColor(paintPanel.getBackground());
        gg.fillRect(0, 0, image.getWidth(), image.getHeight()); 
    }
    public CDokument(CPaintPanel pp){
        paintPanel = pp;
        image = new BufferedImage(pp.getWidth(), pp.getHeight(), 
                BufferedImage.TYPE_INT_RGB);
        lista = new ArrayList<>();
    }
    public void Czysc(){
        lista.clear();
        ClearImg();
        AssignImg();
    }
    public void Odrysuj(){
        Graphics g = image.getGraphics();
        ((Graphics2D)g).setRenderingHint(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        ClearImg();
        for(IFigura F: lista)
            if((Zaznaczony==null)||(F!=Zaznaczony))
                F.Rysuj(g, false);
        if(Zaznaczony!=null){
            ((Graphics2D)g).setComposite(
                    AlphaComposite.getInstance(
                    AlphaComposite.SRC_OVER, (float)0.4));
            Zaznaczony.Rysuj(g, true);
        }
        AssignImg();
    }
    public boolean Zaznacz(int ax, int ay){
        ListIterator<IFigura> it = lista.listIterator(lista.size());
        for(;it.hasPrevious();){
            IFigura F = it.previous();
            if(F.Zaznacz(ax, ay)){
                Zaznaczony = F;
                Odrysuj();
                return true;
            }
        }
        return false;
    }
    public void Odznacz(){
        Zaznaczony = null;
        Odrysuj();
    }
    public void Dodaj(IFigura F){
        lista.add(F);
    }
    public void Przesun(int dox, int doy){
        if(Zaznaczony!=null){
            Zaznaczony.Przenies(dox, doy);
            Odrysuj();
        }
    }
    public void setBackground(Color c){
        paintPanel.setBackground(c);
    }
}
