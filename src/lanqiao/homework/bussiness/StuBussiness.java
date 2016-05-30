package lanqiao.homework.bussiness;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import lanqiao.homework.control.StuControl;
import lanqiao.homework.dao.CommanCURD;
import lanqiao.homework.dao.impl.CommenCURDImpl;
import lanqiao.homework.vo.Stu;

/**
 * 对学生信息实现更、删、改、查做出相应反应的业务类
 * @author Doctor邓
 *
 */
public class StuBussiness {
	private CommanCURD commanCURD;
	
	public StuBussiness() {
		commanCURD = new CommenCURDImpl();
	}
	
	public boolean addStu(Stu stu) {
		String addStuSql = "INSERT INTO stu (stu_id, info_id, class_id) VALUES("
		+ "?, ?, ?)";
		String addStuInfoSql = "INSERT INTO stu_info (info_id, stu_name, stu_age, stu_sex, stu_address) "
				+ "VALUES(?, ?, ?, ?, ?)";
		List<String> stuStr = new ArrayList<String>();
		List<String> stuInfoStr = new ArrayList<String>();
		
		stuStr.add(String.valueOf(stu.getStu_id()));
		stuStr.add(String.valueOf(stu.getStu_id()));
		stuStr.add(String.valueOf(stu.getClass_id()));
		
		stuInfoStr.add(String.valueOf(stu.getStu_id()));
		stuInfoStr.add(stu.getStu_name());
		stuInfoStr.add(String.valueOf(stu.getStu_age()));
		stuInfoStr.add(stu.getStu_sex());
		stuInfoStr.add(stu.getStu_address());
		if (commanCURD.add(addStuInfoSql, stuInfoStr) && commanCURD.add(addStuSql, stuStr)) {
			return true;
		}
		return false;
		
	}
	
	public boolean deleteStu(int stu_id) {
		String stuSql = "DELETE FROM stu WHERE stu_id = ?";
		String stuInfoSql = "DELETE FROM stu_info WHERE info_id = ?";
		List<String> dataStr = new ArrayList<String>();
		dataStr.add(String.valueOf(stu_id));
		return commanCURD.delete(stuSql, dataStr) && commanCURD.delete(stuInfoSql, dataStr);
	}
	
	public boolean updataStu(Stu stu) {
		String stuInfoSql = "UPDATE TABLE stu_info SET stu_name = ?, stu_age = ?, stu_sex = ?, stu_address = ?";
		String stuSql = "UPDATE TABLE stu SET class_id = ?";
		List<String> stuInfoStr = new ArrayList<String>();
		List<String> stuStr = new ArrayList<String>();
		
		stuInfoStr.add(stu.getStu_name());
		stuInfoStr.add(String.valueOf(stu.getStu_age()));
		stuInfoStr.add(stu.getStu_sex());
		stuInfoStr.add(stu.getStu_address());
		
		stuStr.add(String.valueOf(stu.getClass_id()));
		return commanCURD.add(stuInfoSql, stuInfoStr) && commanCURD.add(stuSql, stuStr);
	}
	
	public List<Stu> searchStu() {
		String sql = "SELECT stu.stu_id, stu.class_id, stu_name, stu_age, stu_sex, stu_address FROM stu"
				+ " INNER JOIN stu_info ON stu.info_id = stu_info.info_id";
		
		List<String> dataStr = new ArrayList<String>();
		List<Stu> stuList = new ArrayList<Stu>();
		
		Vector<String[]> vector = commanCURD.search(sql, dataStr);
		if(vector.size()== 0) return stuList;
		
		for (String[] str : vector) {
			int stu_id = Integer.parseInt(str[0]);
			int class_id = Integer.parseInt(str[1]);
			String stu_name = str[2];
			int stu_age = Integer.parseInt(str[3]);
			String stu_sex = str[4];
			String stu_address = str[5];
			Stu stu = new Stu(stu_id, stu_id, class_id, stu_name, stu_age, stu_sex, stu_address);
			stuList.add(stu);
		}
		return stuList;
	}
	
	public Stu searchStuById(int stu_id) {
		
		String sql = "SELECT stu.class_id, stu_name, stu_age, stu_sex, stu_address FROM stu"
				+ " INNER JOIN stu_info ON stu.info_id = stu_info.info_id WHERE stu.stu_id = ?";
		List<String> dataStr = new ArrayList<String>();
		dataStr.add(String.valueOf(stu_id));
		Vector<String[]> vector = commanCURD.search(sql, dataStr);
		
		if (vector.size() != 1) return new Stu();
		String[] str = vector.get(0);
		
		int class_id = Integer.parseInt(str[1]);
		String stu_name = str[2];
		int stu_age = Integer.parseInt(str[3]);
		String stu_sex = str[4];
		String stu_address = str[5];
		return new Stu(stu_id, stu_id, class_id, stu_name, stu_age, stu_sex, stu_address);
	}
	
	/**
	 * 学生表格信息初始化
	 * @return 返回显示一个包含所有学生信息的二维对象数组
	 */
	public Object[][] getTableData() {
		Object[][] stuDataList;
		List<Stu> stuList = searchStu();
		
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
	
	/**
	 * 通过用户输入的信息来动态生成学生信息
	 * @param user_input 用户输入的信息
	 * @return 返回包含动态生成的学生信息的二维对象数组
	 */
	public Object[][] getSearchData(String user_input) {
		List<Stu> stuList = searchStu();
		List<Stu> temp = new ArrayList<Stu>();
		Object[][] stuDataList;
		if(stuList.size() == 0) return stuDataList = new Object[0][];
		String[] input = user_input.split(",");
		for (int i=0; i<stuList.size(); i++) {
			Stu stu = stuList.get(i);
			for (int j=0; j<input.length; j++) {
				boolean t = false;
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
