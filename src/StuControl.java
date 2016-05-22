import java.sql.SQLException;
import java.util.List;

public class StuControl {
	private List<Stu> stuList;
	private static StuControl stuControl;
	JdbcUtil jdbc = new JdbcUtil();
	
	public List<Stu> getStuList() {
		jdbc.getStuList(stuList);
		return stuList;
	}
	public static void main(String[] args) {
		// TODO 自动生成的方法存根

	}
	
	public void addStu(int stu_id, String stu_name, int stu_age, String stu_sex, String stu_address) {
		int info_id = 5;
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
			System.out.println("获取单个学生信息失败!");
			return stu;
			
		} 
	}
	public static StuControl  getStuControl() {
		stuControl = new StuControl();
		return stuControl;
	}

}
