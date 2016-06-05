package lanqiao.homework.action.tableModel;

import javax.swing.table.AbstractTableModel;

import lanqiao.homework.bussiness.StuAction;
import lanqiao.homework.bussiness.StuClassAction;
/**
 * 显示班级信息表格的Model
 * @author Doctor邓
 *
 */
public class ClassTableModel extends AbstractTableModel {

	private String[] columns = {"班级号", "班级名称", "班级描述"};
	private StuAction stuBussiness = new StuAction();
	private StuClassAction classBussiness = new StuClassAction();
	private Object[][] classData = new Object[1][3];
	
	@Override
	public String getColumnName(int column) {
		return columns[column];
	}

	@Override
	public int getRowCount() {
		if (classData.length != 0) {
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
	/**
	 * 通过制定id更新表格信息
	 * @param stu_id   要显示的学生信息的id
	 */
	public void updateDate(int stu_id) {
		classData = stuBussiness.getStuClassTableData(stu_id);
		this.fireTableDataChanged();
	}
	/**
	 * 清空表格信息
	 */
	public void clear() {
		classData = new Object[1][3];
		this.fireTableDataChanged();
	}
	/**
	 * 更新表格信息
	 */
	public void update() {
		classData  = classBussiness.getClassTableData();
		this.fireTableDataChanged();
	}

}
