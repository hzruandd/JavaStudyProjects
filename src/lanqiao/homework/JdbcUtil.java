package lanqiao.homework;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JdbcUtil {
	//private SQLConn sqlConn = new SQLConn();
	private Connection conn;
	private Statement sql;
	public JdbcUtil() {
		conn = SQLConn.getConn();
	}
	
	//验证用户名和密码
	public boolean verifyUser(String account, String pwd) throws SQLException {
		sql = conn.createStatement();
		String sqlQuery = "SELECT user_account,user_pwd FROM user_info  WHERE user_account = '" + account.trim()+ "' AND user_pwd = '" +  pwd.trim()+"'";
		ResultSet rs = sql.executeQuery(sqlQuery);
		if (rs.next()) {
			return true;
		}
		else {
			return false;
		}
	}
	
	//获取所有学生信息
	@SuppressWarnings("finally")
	public ArrayList<Stu> getStuList() {
		
		ArrayList<Stu> stuList = new ArrayList<Stu>();
		try {
			sql = conn.createStatement();
			String sqlQuery = "SELECT stu_id,stu.info_id as info_id, stu_name, stu_age, stu_sex, stu_address "
					+ "FROM stu INNER JOIN stu_info ON stu_id = stu_info.info_id ";
			ResultSet rs = sql.executeQuery(sqlQuery);
			while (rs.next()) {
				int stu_id = rs.getInt("stu_id");
				int info_id = rs.getInt("info_id");
				String stu_name = rs.getString("stu_name");
				int stu_age = rs.getInt("stu_age");
				String stu_sex = rs.getString("stu_sex"); 
				String stu_address = rs.getString("stu_address");
				stuList.add(new Stu(stu_id, info_id, stu_name, stu_age, stu_sex, stu_address));
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} finally {
			return stuList;
		}
		
	}
	
	//修改学生信息
	public boolean alterStuInfo(Stu stu) {
		try {
			sql = conn.createStatement();
			String sqlUpdate = "UPDATE stu_info SET "
					+ "stu_name = '" +stu.getStu_name()+ "', stu_age = " + stu.getStu_age()+ ","
					+ "stu_sex = '" + stu.getStu_sex()+ "', stu_address = '" +stu.getStu_address()+ "'"
							+ "WHERE info_id = '"+stu.getInfo_id()+ "'";
			sql.executeUpdate(sqlUpdate);
			return true;
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			//e.printStackTrace();
			System.out.println("修改学生信息出现错误");
			return false;
		}
		
	}
	
	//删除学生
	public boolean delStu(int stu_id) {
		try {
			sql = conn.createStatement();
			String sqlDelInfo = "DELETE FROM stu_info WHERE info_id = (SELECT info_id FROM stu WHERE stu_id = "
					+ stu_id +")";
			String sqlDelStu = "DELETE FROM stu WHERE stu_id = "+ stu_id+"";
			sql.executeUpdate(sqlDelInfo);
			sql.executeUpdate(sqlDelStu);	
			return true;
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			//e.printStackTrace();
			System.out.println("删除学生出现错误！");
			return false;
		}
		
	}
	
	//增加学生
	public boolean addStu(Stu stu) throws SQLException {
		if (!isStu(stu)) {
			sql = conn.createStatement();
			String sqlAddStu = "INSERT INTO stu (stu_id, info_id) VALUES(" + stu.getStu_id()+","+
			   stu.getInfo_id()+")";
			String sqlAddInfo = "INSERT INTO stu_info VALUES ("+stu.getInfo_id()+",'"+ stu.getStu_name()+"',"
					+ stu.getStu_age()+",'" +stu.getStu_sex()+"', '"+ stu.getStu_address()+"')";
			sql.executeUpdate(sqlAddStu);
			sql.executeUpdate(sqlAddInfo);
			//System.out.println("111");
			return true;
		}
		else {
			//System.out.println("222");
			return false;
		}
	}
	
	//判断数据库中是否有此学生
	public boolean isStu(Stu stu) throws SQLException {
		sql = conn.createStatement();
		String sqlIsStu = "SELECT stu_id FROM stu WHERE stu_id = " + stu.getStu_id()+ "";
		ResultSet rs = sql.executeQuery(sqlIsStu);
		if (rs.next()) {
			return true;
		}
		else {
			return false;
		}
	}
	
	//获取单个学生
	public Stu getStu(int stu_id) throws SQLException {
		Stu stu = null;
		sql = conn.createStatement();
		String sqlGetStu = "SELECT stu.info_id, stu_name, stu_age, stu_sex, stu_address FROM stu "
				+ "INNER JOIN stu_info ON stu_id = stu_info.info_id WHERE stu_id = " +stu_id+ "";
		ResultSet rs = sql.executeQuery(sqlGetStu);
		if (rs.next()) {
			int info_id = rs.getInt("info_id");
			String stu_name = rs.getString("stu_name");
			int stu_age = rs.getInt("stu_age");
			String stu_sex = rs.getString("stu_sex"); 
			String stu_address = rs.getString("stu_address");
			stu = new Stu(stu_id, info_id, stu_name, stu_age, stu_sex, stu_address);
			return stu;
		}
		else {
			return stu;
		}
	}
	
}
