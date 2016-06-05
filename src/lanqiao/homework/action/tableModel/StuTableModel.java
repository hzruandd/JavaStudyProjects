package lanqiao.homework.action.tableModel;
import java.util.List;

import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableColumnModel;

import lanqiao.homework.bussiness.StuAction;
import lanqiao.homework.unless.StuControl;

public class StuTableModel extends AbstractTableModel {
	
	private String[] columns = {"学号", "姓名", "年龄", "性别", "地址", "班级号"};
	private StuAction stuBussiness = new StuAction();
	private Object[][] stuDataList = stuBussiness.getTableData();
	
	@Override
	public String getColumnName(int arg0) {
		return columns[arg0];
	}

	@Override
	public int getRowCount() {
		// TODO 自动生成的方法存根
		if (null != stuDataList) {
			return stuDataList.length;
		}
		return 0;
	}
	
	public void updateDate() {
		stuDataList = stuBussiness.getTableData();
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
	
	public void setData(Object[][] object) {
		stuDataList = object;
		this.fireTableDataChanged();
	}

}
