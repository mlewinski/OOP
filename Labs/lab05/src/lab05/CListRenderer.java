package lab05;

import java.awt.Component;
import javax.swing.DefaultListCellRenderer;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;

public class CListRenderer extends DefaultListCellRenderer {
    private Icon getIcon(CListaLaczona<ImageIcon> l, int idx){
        return l.get(idx);
    }
    @Override
    public Component getListCellRendererComponent(
            JList list, Object value, int index,
            boolean isSelected, boolean cellHasFocus) {
        JLabel label = (JLabel) super.getListCellRendererComponent(
                list, value, index, isSelected, cellHasFocus);
        //Icon icon = getIcon(CfmMain.formRef.listaImg, index);
        //label.setIcon(icon);
        return label;
    }   
}
