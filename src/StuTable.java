import java.awt.Color;
import java.util.List;

import javax.swing.JTable;
import javax.swing.border.LineBorder;

public class StuTable extends JTable {
	public StuTable(Object[][] rowData, Object[] columnNames)  {
		super(rowData, columnNames);
		this.setToolTipText("doctor");
		this.setBorder(new LineBorder(new Color(255, 160, 122), 3));
		this.setBackground(new Color(60, 179, 113));
		this.setBounds(10, 238, 589, -234);
	}
}
