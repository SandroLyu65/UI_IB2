package ChartTable;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

public class MyRenderer extends DefaultTableCellRenderer {

    /* 重写getTableCellRendererComponent方法，
     * @see TableCellRenderer#getTableCellRendererComponent(JTable, Object, boolean, boolean, int, int)
     */
    public Component getTableCellRendererComponent(JTable table, Object value,
                                                   boolean isSelected, boolean hasFocus,
                                                   int row, int column) {
        setIcon(null); // 一定要这句，不然会出现Icon不断改变的现象
        setBorder(null); // 去掉边框
        if(value instanceof ImageIcon) {
            setIcon((Icon) value);// 因为DefaultTableCellRenderer是extends JLabel的
        }
        else if(value instanceof String)
            setText((String) value);
        else
            setText("");
        return this;
    }
}