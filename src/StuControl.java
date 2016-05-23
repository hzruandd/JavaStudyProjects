import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTable;

public class StuControl {
	//private List<Stu> stuList;
	private static StuControl stuControl;
	JdbcUtil jdbc = new JdbcUtil();
	
	public ArrayList<Stu> getStuList() {
		return jdbc.getStuList();
	}
	
	//学生表格信息初始化
	public Object[][] getTableData() {
		Object[][] stuDataList;
		List<Stu> stuList = StuControl.getStuControl().getStuList();
		
		if (!stuList.isEmpty()) {
			stuDataList = new Object[stuList.size()][];
			for (int i=0; i< stuList.size(); i++) {
				stuDataList[i] = stuList.get(i).stuToArray();
			}
			return stuDataList;
		}
		else {
			return  stuDataList = null;
		}
	}
	//学生表格列的信息初始化
	public Object[] getTableRow() {
		Object[] name = {"学号", "姓名", "年龄", "性别", "地址"};
		return name;
	}
	
	public void addStu(int stu_id, String stu_name, int stu_age, String stu_sex, String stu_address) {
		int info_id = stu_id;
		Stu stu = new Stu(stu_id, info_id, stu_name, stu_age, stu_sex, stu_address);
		try {
			jdbc.addStu(stu);
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	
	public void delStu(int stu_id) {
		jdbc.delStu(stu_id);
	}
	
	public Stu getStuOne(int stu_id) {
		Stu stu = null;
		try {
			stu = jdbc.getStu(stu_id);
			return stu;
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			//e.printStackTrace();
			//System.out.println("获取单个学生信息失败!");
			return stu;
		} 
	}
	
	//修改学生
	public boolean alterStu(Stu stu) {
		if (jdbc.alterStuInfo(stu)) {
			return true;
		};
		return false;
	}
	
	public static StuControl  getStuControl() {
		stuControl = new StuControl();
		return stuControl;
	}

}
