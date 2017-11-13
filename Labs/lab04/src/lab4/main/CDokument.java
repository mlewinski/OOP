/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4.main;

import java.awt.Color;
import java.awt.Graphics;
import java.util.List;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.ListIterator;
import lab4.klasy.*;

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
        gg.setColor(Color.WHITE);
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
        ClearImg();
        for(IFigura F: lista)
            if((Zaznaczony==null)||(F!=Zaznaczony))
                F.Rysuj(image.getGraphics(), false);
        if(Zaznaczony!=null)Zaznaczony.Rysuj(image.getGraphics(), true);
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
    
}
