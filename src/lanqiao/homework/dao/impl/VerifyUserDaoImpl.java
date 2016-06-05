package lanqiao.homework.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import lanqiao.homework.dao.VerifyUserDao;
import lanqiao.homework.util.SqlUtil;
import lanqiao.homework.util.impl.DBCPUtil;
import lanqiao.homework.util.impl.DBUtil;
/**
 * 验证用户名和密码
 * @author Doctor邓
 *
 */
public class VerifyUserDaoImpl implements VerifyUserDao{

	private Connection conn;
	private PreparedStatement ps;
	private SqlUtil sqlUtil;
	
	public VerifyUserDaoImpl() {
		sqlUtil = new DBCPUtil();
		conn = sqlUtil.getConn();
	}
	
	@Override
	public boolean verify(String account, String pwd) {
		String sql = "SELECT user_id FROM user_info WHERE user_account = ? and "
				+ "user_pwd = ?";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, account);
			ps.setString(2, pwd);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				return true;
			}
			return false;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

}
