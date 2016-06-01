package lanqiao.homework.action;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JTable;

import lanqiao.homework.action.tableModel.CommanTableModel;
import lanqiao.homework.vo.Stu;
import lanqiao.homework.vo.StuClass;

/**
 * 对表格模型进行操作的业务类
 * @author Doctor邓
 *
 */
public class TableModelAction {
	
	private StuAction stuAction;
	private StuClassAction stuClassAction;
	
	public TableModelAction() {
		stuAction = new StuAction();
		stuClassAction = new StuClassAction();
	}
	
	/**
	 * 初始化指定表格为显示学生班级信息的表格
	 * @param stuClassTable   要初始化的表格
	 */
	public void stuClassModelInit(JTable stuClassTable) {
		String[] columnNames = {"班级号", "班级名称", "班级描述"};
		Object[][] classData = stuClassAction.getClassTableData();
		stuClassTable.setModel(new CommanTableModel(classData, columnNames));
	}
	
	/**
	 * 初始化指定表格为显示学生信息的表格
	 * @param stuTable  要初始化的表格
	 */
	public void stuModelInit(JTable stuTable) {
		String[] columnNames = {"学号", "姓名", "年龄", "性别", "地址", "班级号"};
		Object[][] stuData = stuAction.getTableData();
		stuTable.setModel(new CommanTableModel(stuData, columnNames));
	}
	
	/**
	 * 显示指定学生的班级信息的表格的信息的初始化
	 * @param stu_id   指定学生的ID
	 * @return  返回包含指定学生的班级信息的二维对象数组
	 */
	public Object[][] getStuClassTableData(JTable stutable, int stu_id) {
		Object[][] stuClassData;
		Stu stu = stuAction.searchStuById(stu_id);
		int class_id = stu.getClass_id();
		StuClass stuClass = new StuClassAction().searchClassById(class_id);
		if (0 != stuClass.getClass_id()) {
			stuClassData = new Object[1][];
			stuClassData[0] = stuClass.classToArray();
			return stuClassData;
		}
		return stuClassData = new Object[0][];
	}
	
	/**
	 * 通过用户输入的信息来动态生成学生信息
	 * @param user_input 用户输入的信息
	 * @return 返回包含动态生成的学生信息的二维对象数组
	 */
	public Object[][] getSearchData(String user_input) {
		List<Stu> stuList = stuAction.searchStu();
		List<Stu> temp = new ArrayList<Stu>();
		Object[][] stuDataList;
		if(stuList.size() == 0) return stuDataList = new Object[0][];
		String[] input = user_input.split(",");
		for (int i=0; i<stuList.size(); i++) {
			Stu stu = stuList.get(i);
			for (int j=0; j<input.length; j++) {
				boolean t = false;
				/**
				 * 将用户输入的字符串信息分解后，逐个与数据空的学生信息做对比，只要有一个对比上，则将对比上的学生信息添加到对象数组中
				 */
				if (String.valueOf(stu.getStu_id()).contains(input[j])) {
					t = true;
				} else if (String.valueOf(stu.getClass_id()).contains(input[j])) {
					t = true;
				} else if (stu.getStu_name().contains(input[j])) {
					t = true;
				} else if (String.valueOf(stu.getStu_age()).contains(input[j])) {
					t = true;
				} else if(stu.getStu_sex().contains(input[j])) {
					t= true;
				} else if(stu.getStu_address().contains(input[j])) {
					t = true;
				}
				
				if (t == true) {
					temp.add(stu);
				}
			}
		}
		stuDataList = new Object[temp.size()][];
		for (int i=0; i<stuDataList.length; i++) {
			stuDataList[i] = temp.get(i).stuToArray();
		}
		return stuDataList;
	}
}
