package lanqiao.homework.test;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import lanqiao.homework.util.SqlUtil;
import lanqiao.homework.util.impl.DBCPUtil;

/**
 * 练习数据库连接池Dbcp的使用
 * @author Doctor邓
 *
 */
public class PracticeForDbcp {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
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

}
