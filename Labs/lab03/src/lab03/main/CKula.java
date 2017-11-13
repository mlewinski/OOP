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
public class CKula extends CBryla {
    protected int R;
    
    public CKula(int R, int M){
        this.Masa = M;
        this.R = R;
    }
    
    @Override
    public double MomentBezwladnosci(){
        return 2./5*Masa*R*R;
    }
    
    @Override
    public void PrzypiszDane(JTable tab){
        Masa = Integer.parseInt(tab.getValueAt(0,1).toString());
        R = Integer.parseInt(tab.getValueAt(1,1).toString());
    }
    
    @Override
    public void PokazDane(JTable tab, DefaultTableModel model){
        model.setRowCount(2);
        tab.setValueAt("Masa", 0, 0);
        tab.setValueAt(Masa, 0, 1);
        tab.setValueAt("R", 1, 0);
        tab.setValueAt(R, 1, 1);
    }
}
