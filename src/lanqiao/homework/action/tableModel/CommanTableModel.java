package lanqiao.homework.action.tableModel;

import javax.swing.table.AbstractTableModel;
/**
 * 通用的表格模型
 * @author Doctor邓
 *
 */
public class CommanTableModel extends AbstractTableModel {
	/**
	 * 表格列名集合
	 */
	private String[] columnNames;
	/**
	 * 表格数据集合
	 */
	private Object[][] tableData;
	
	
	/**
	 * 默认的表格模型没有列名和数据
	 */
	public CommanTableModel(){
		columnNames = new String[0];
		tableData = new Object[0][];
	}
	/**
	 * 通过给定的表格信息集合和列名集合创建表格模型
	 * @param tableData      表格信息集合
	 * @param columnNames    表格列名集合
	 */
	public CommanTableModel(Object[][] tableData, String[] columnNames) {
		this.tableData = tableData;
		this.columnNames = columnNames;
	}
	
	@Override
	public int getColumnCount() {
		if (tableData.length >=1) {
			return tableData[0].length;
		}
		else {
			return 0;
		}
	}

	@Override
	public int getRowCount() {
		return tableData.length;
	}

	@Override
	public Object getValueAt(int arg0, int arg1) {
		if (tableData.length >=1) {
			return tableData[arg0][arg1];
		}
		return null;
	}
	/**
	 * 设置表格模型显示的信息
	 * @param tableData   要显示的信息的集合
	 */
	public void setModelData(Object[][] tableData) {
		this.tableData = tableData;
		fireTableDataChanged();
	}
	/**
	 * 设置表格模型的列名
	 * @param columnNames 要显示的列名的集合
	 */
	public void setColumnName(String[] columnNames) {
		this.columnNames = columnNames;
		fireTableDataChanged();
	}

	@Override
	public String getColumnName(int arg0) {
		return columnNames[arg0];
	}

}
