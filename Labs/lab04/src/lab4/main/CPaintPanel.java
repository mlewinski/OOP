/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package lab4.main;

import javax.swing.*;
import java.awt.*;
//import java.awt.geom.*;

public class CPaintPanel extends JPanel {
    private int Width;
    private int Height;
    private Image rys;

    public CPaintPanel() {
        setBorder(BorderFactory.createLineBorder(Color.black));
        Width = 1280;
        Height = 800;
        rys = null;
    }

    public void AssignRys(Image xrys){
        rys = xrys;
    }

    @Override public Dimension getPreferredSize() {
        return new Dimension(1280,800);
    }

    @Override public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.white);
        g.fillRect(0, 0, Width, Height);
        if(rys!=null) g.drawImage(rys, 0, 0, this);
    }
}
