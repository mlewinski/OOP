/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab03.main;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Marek
 */
public class CProstopadloscian extends CBryla{
    protected int D;
    protected int W;
    
    public CProstopadloscian(int D, int W, int M){
        this.Masa = M;
        this.D = D;
        this.W = W;
    }
    
    @Override
    public double MomentBezwladnosci(){
        return 1./12*Masa*(D*D + W*W);
    }
    
    @Override
    public void PrzypiszDane(JTable tab){
        Masa = Integer.parseInt(tab.getValueAt(0,1).toString());
        D = Integer.parseInt(tab.getValueAt(1,1).toString());
        W = Integer.parseInt(tab.getValueAt(1,1).toString());
    }
    
    @Override
    public void PokazDane(JTable tab, DefaultTableModel model){
        model.setRowCount(2);
        tab.setValueAt("Masa", 0, 0);
        tab.setValueAt(Masa, 0, 1);
        tab.setValueAt("D", 1, 0);
        tab.setValueAt(D, 1, 1);
        tab.setValueAt("W", 2, 0);
        tab.setValueAt(W, 2, 1);
    }
}
