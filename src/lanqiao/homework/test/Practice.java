package lanqiao.homework.test;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import lanqiao.homework.util.SqlUtil;
import lanqiao.homework.util.impl.DBCPUtil;
import lanqiao.homework.util.impl.DBUtil;

public class Practice {
	private static SqlUtil sqlUtil = new DBCPUtil();
	public static void main(String[] args) {
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
		System.out.println(countStu());
		
	}
	
	public static Integer countStu() {
		Connection conn = sqlUtil.getConn();
		int stuNum = 0;
		try {
			CallableStatement cs = conn.prepareCall("call stuCount(?)");
			/**
			 * 注册输出参数
			 */
			cs.registerOutParameter(1, Types.INTEGER);
			cs.execute();
			/**
			 * 获得结果
			 */
			stuNum = cs.getInt(1);
			return stuNum;
			
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			return stuNum;
		}
	}

}
