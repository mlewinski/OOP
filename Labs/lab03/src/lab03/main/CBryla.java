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
public abstract class CBryla {
    protected int Masa;
    public abstract double MomentBezwladnosci();
    public abstract void PrzypiszDane(JTable table);
    public abstract void PokazDane(JTable tab, DefaultTableModel mod);
}
