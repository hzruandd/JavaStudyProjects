package lanqiao.homework.bussiness;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import lanqiao.homework.dao.CommanCURD;
import lanqiao.homework.dao.impl.CommenCURDImpl;
import lanqiao.homework.unless.StuControl;
import lanqiao.homework.vo.Stu;
import lanqiao.homework.vo.StuClass;

/**
 * 对学生信息实现更、删、改、查做出相应反应的业务类
 * @author Doctor邓
 *
 */
public class StuAction {
	private CommanCURD commanCURD;
	
	public StuAction() {
		commanCURD = new CommenCURDImpl();
	}
	
	/**
	 * 添加单个学生信息
	 * @param stu 要添加的学生对象
	 * @return 返回true添加成功，false添加失败
	 */
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
	
	/**
	 * 通过学生的ID来删除学生
	 * @param stu_id
	 * @return
	 */
	public boolean deleteStu(int stu_id) {
		String stuSql = "DELETE FROM stu WHERE stu_id = ?";
		String stuInfoSql = "DELETE FROM stu_info WHERE info_id = ?";
		List<String> dataStr = new ArrayList<String>();
		dataStr.add(String.valueOf(stu_id));
		return commanCURD.delete(stuSql, dataStr) && commanCURD.delete(stuInfoSql, dataStr);
	}
	
	/**
	 * 更新单个学生信息
	 * @param stu  要更新的学生对象
	 * @return     返回true更新成功，false更新失败
	 */
	public boolean updataStu(Stu stu) {
		String stuInfoSql = "UPDATE stu_info SET stu_name = ?, stu_age = ?, stu_sex = ?, stu_address = ?"
				+ " WHERE info_id = ?";
		String stuSql = "UPDATE stu SET class_id = ? WHERE stu_id = ?";
		List<String> stuInfoStr = new ArrayList<String>();
		List<String> stuStr = new ArrayList<String>();
		
		stuInfoStr.add(stu.getStu_name());
		stuInfoStr.add(String.valueOf(stu.getStu_age()));
		stuInfoStr.add(stu.getStu_sex());
		stuInfoStr.add(stu.getStu_address());
		stuInfoStr.add(String.valueOf(stu.getInfo_id()));
		
		stuStr.add(String.valueOf(stu.getClass_id()));
		stuStr.add(String.valueOf(stu.getStu_id()));
		return commanCURD.update(stuInfoSql, stuInfoStr) && commanCURD.update(stuSql, stuStr);
	}
	
	/**
	 * 查找数据库中的所有学生信息
	 * @return   返回所有学生信息的对象的集合
	 */
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
	
	
	/**
	 * 通过学生的ID来查找学生
	 * @param  stu_id  要查找的学生的ID
	 * @return 返回查找到的学生信息，如果没有查找到，将返回一个没有任何属性的学生对象
	 */
	public Stu searchStuById(int stu_id) {
		
		String sql = "SELECT stu.class_id, stu_name, stu_age, stu_sex, stu_address FROM stu"
				+ " INNER JOIN stu_info ON stu.info_id = stu_info.info_id WHERE stu.stu_id = ?";
		List<String> dataStr = new ArrayList<String>();
		dataStr.add(String.valueOf(stu_id));
		Vector<String[]> vector = commanCURD.search(sql, dataStr);
		
		if (vector.size() != 1) return new Stu();
		String[] str = vector.get(0);

		int class_id = Integer.parseInt(str[0]);
		String stu_name = str[1];
		int stu_age = Integer.parseInt(str[2]);
		String stu_sex = str[3];
		String stu_address = str[4];
		return new Stu(stu_id, stu_id, class_id, stu_name, stu_age, stu_sex, stu_address);
	}
	
	/**
	 * 获取所有学生信息得二维数组对象的表现形式
	 * @return 返回显示一个包含所有学生信息的二维对象数组
	 */
	public Object[][] getTableData() {
		Object[][] stuDataList;
		List<Stu> stuList = searchStu();
		/**
		 * 当查找的学生列表不为空，即里面有对象时，将列表中的对象的信息逐个添加到对象数组中
		 */
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
	
	/**
	 * 显示指定学生的班级信息的表格的信息的初始化
	 * @param stu_id   指定学生的ID
	 * @return  返回包含指定学生的班级信息的二维对象数组
	 */
	public Object[][] getStuClassTableData(int stu_id) {
		Object[][] stuClassData;
		Stu stu = searchStuById(stu_id);
		int class_id = stu.getClass_id();
		StuClass stuClass = new StuClassAction().searchClassById(class_id);
		if (0 != stuClass.getClass_id()) {
			stuClassData = new Object[1][];
			stuClassData[0] = stuClass.classToArray();
			return stuClassData;
		}
		return stuClassData = new Object[0][];
	}
}
