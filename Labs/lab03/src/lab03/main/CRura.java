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
public class CRura extends CBryla{
    protected int R1;
    protected int R2;
    
    public CRura(int R1, int R2, int M){
        this.Masa = M;
        this.R1 = R1;
        this.R2 = R2;
    }
    
    @Override
    public double MomentBezwladnosci(){
        return 1./2*Masa*(R1*R1 + R2*R2);
    }
    
    @Override
    public void PrzypiszDane(JTable tab){
        Masa = Integer.parseInt(tab.getValueAt(0,1).toString());
        R1 = Integer.parseInt(tab.getValueAt(1,1).toString());
        R2 = Integer.parseInt(tab.getValueAt(1,1).toString());
    }
    
    @Override
    public void PokazDane(JTable tab, DefaultTableModel model){
        model.setRowCount(2);
        tab.setValueAt("Masa", 0, 0);
        tab.setValueAt(Masa, 0, 1);
        tab.setValueAt("R1", 1, 0);
        tab.setValueAt(R1, 1, 1);
        tab.setValueAt("R2", 2, 0);
        tab.setValueAt(R2, 2, 1);
    }
}
