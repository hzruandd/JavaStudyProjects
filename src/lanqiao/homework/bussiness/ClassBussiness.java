package lanqiao.homework.bussiness;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import lanqiao.homework.dao.CommanCURD;
import lanqiao.homework.dao.impl.CommenCURDImpl;
import lanqiao.homework.vo.StuClass;

public class ClassBussiness {
	private CommanCURD commanCURD;
	
	public ClassBussiness() {
		commanCURD = new CommenCURDImpl();
	}
	
	public boolean addClass(StuClass stuClass) {
		String sql = "INSERT INTO stu_class (class_id, class_name, class_desc) VALUES("
				+ "?, ?, ?)";
		List<String> dataStr = new ArrayList<String>();
		dataStr.add(String.valueOf(stuClass.getClass_id()));
		dataStr.add(stuClass.getClass_name());
		dataStr.add(stuClass.getClass_desc());
		return commanCURD.add(sql, dataStr);
	}
	
	public boolean deleteClass(int class_id) {
		String sql = "DELETE FROM stu_class WHERE class_id = ?";
		List<String> dataStr = new ArrayList<String>();
		dataStr.add(String.valueOf(class_id));
		return commanCURD.delete(sql, dataStr);
	}
	
	public boolean updataClass(StuClass stuClass) {
		String sql = "UPDATE TABLE stu_class SET class_name = ?, class_desc = ?";
		List<String> dataStr = new ArrayList<String>();
		dataStr.add(stuClass.getClass_name());
		dataStr.add(stuClass.getClass_desc());
		return commanCURD.add(sql, dataStr);
	}
	
	public List<StuClass> searchClass() {
		String sql = "SELECT class_id, class_name, class_desc FROM stu_class";
		List<String> dataStr = new ArrayList<String>();
		List<StuClass> classList = new ArrayList<StuClass>();
		
		Vector<String[]> vector = commanCURD.search(sql, dataStr);
		if(vector.size()== 0) return classList;
		
		for (String[] str : vector) {
			if (str.length != 3) return classList;
			int class_id = Integer.parseInt(str[0]);
			String class_name = str[1];
			String class_desc = str[2];
			StuClass stu_class = new StuClass(class_id, class_name, class_desc);
			classList.add(stu_class);
		}
		return classList;
	}
	
	public StuClass searchClassById(int class_id) {
		String sql = "SELECT class_id, class_name, class_desc FROM stu_class WHERE class_id = ?";
		List<String> dataStr = new ArrayList<String>();
		dataStr.add(String.valueOf(class_id));
		Vector<String[]> vector = commanCURD.search(sql, dataStr);
		
		if (vector.size() != 1) return new StuClass();
		String[] str = vector.get(0);
		if (str.length != 3) return new StuClass();
		String class_name = str[1];
		String class_desc = str[2];
		return new StuClass(class_id, class_name, class_desc);
	}
}
