package lanqiao.homework.test;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

import lanqiao.homework.util.SqlUtil;
import lanqiao.homework.util.impl.C3P0Util;

/**
 * 测试C3p0的使用
 * @author Doctor邓
 *
 */
public class PracticeC3P0Util {

	public static void main(String[] args) {
		SqlUtil sqlUtil = new C3P0Util();
		Connection conn = sqlUtil.getConn();
		try {
			CallableStatement cs = conn.prepareCall("call stuCount(?)");
			cs.registerOutParameter(1, Types.INTEGER);
			cs.execute();
			int i = cs.getInt(1);
			System.out.println(i);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
