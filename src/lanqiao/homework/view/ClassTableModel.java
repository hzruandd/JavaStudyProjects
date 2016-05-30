package lanqiao.homework.view;

import javax.swing.table.AbstractTableModel;

import lanqiao.homework.bussiness.StuBussiness;
/**
 * 显示班级信息表格的Model
 * @author Doctor邓
 *
 */
public class ClassTableModel extends AbstractTableModel {

	private String[] columns = {"班级号", "班级名称", "班级描述"};
	private StuBussiness stuBussiness = new StuBussiness();
	private Object[][] classData = new Object[1][3];
	
	@Override
	public String getColumnName(int column) {
		return columns[column];
	}

	@Override
	public int getRowCount() {
		if (null != classData[0][0]) {
			return classData.length;
		}
		return 0;
	}

	@Override
	public int getColumnCount() {
		return columns.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		if (null != classData[0][0]) {
			return classData[rowIndex][columnIndex];
		}
		return null;
	}
	
	public void updateDate(int stu_id) {
		classData = stuBussiness.getStuClassTableData(stu_id);
		this.fireTableDataChanged();
	}
	
	public void clear() {
		classData = new Object[1][3];
		this.fireTableDataChanged();
	}

}
