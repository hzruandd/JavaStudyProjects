import java.util.List;

import javax.swing.table.AbstractTableModel;

public class StuTableModel extends AbstractTableModel {
	//private List<Stu> stuList = StuControl.getStuControl().getStuList();
	private Object[][] stuDataList = StuControl.getStuControl().getTableData();
	
	@Override
	public int getRowCount() {
		// TODO 自动生成的方法存根
		if (null != stuDataList) {
			return stuDataList.length;
		}
		return 0;
	}
	
	public void updateDate() {
		stuDataList = StuControl.getStuControl().getTableData();
		this.fireTableDataChanged();
	}
	
	@Override
	public int getColumnCount() {
		// TODO 自动生成的方法存根
		if (null != stuDataList) {
			return stuDataList[0].length;
		}
		return  0;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		if (null != stuDataList) {
			return stuDataList[rowIndex][columnIndex];
		}
		else {
			return null;
		}
	}

}
