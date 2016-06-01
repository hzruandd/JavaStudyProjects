package lanqiao.homework.test;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import lanqiao.homework.util.SqlUtil;
import lanqiao.homework.util.impl.DBCPUtil;
import lanqiao.homework.util.impl.DBUtil;

/**
 * 练习数据库连接池Dbcp的使用
 * @author Doctor邓
 *
 */
public class PracticeForDbcp {

	public static void main(String[] args) {

		//1.通过不同方式操作数据库
		Date a = new Date();
		test();
		Date b = new Date();
		System.out.println(b.getTime() - a.getTime());
		
		//2.通过DBCP连接池方式操作数据库
		Date c = new Date();
		testByDBCP();
		Date d = new Date();
		System.out.println(d.getTime() - c.getTime());
	}
	
	public static void testByDBCP() {
		SqlUtil sqlUtil = new DBCPUtil();
		Connection conn = sqlUtil.getConn();
		try {
			CallableStatement cs = conn.prepareCall("BEGIN testStu(?); END;");
			cs.registerOutParameter(1, -10);
			cs.execute();
			ResultSet rs = (ResultSet) cs.getObject(1);
			while (rs.next()) {
				System.out.println(rs.getString("stu_name"));
			}
			rs.close();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	
	public static void test() {
		SqlUtil sqlUtil = new DBUtil();
		Connection conn = sqlUtil.getConn();
		try {
			CallableStatement cs = conn.prepareCall("BEGIN testStu(?); END;");
			cs.registerOutParameter(1, -10);
			cs.execute();
			ResultSet rs = (ResultSet) cs.getObject(1);
			while (rs.next()) {
				System.out.println(rs.getString("stu_name"));
			}
			rs.close();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}

}
