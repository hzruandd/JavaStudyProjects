package lanqiao.homework.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import lanqiao.homework.dao.VerifyUserDao;
import lanqiao.homework.util.SQLConn;

public class VerifyUserImpl implements VerifyUserDao{

	private Connection conn;
	private PreparedStatement ps;
	
	public VerifyUserImpl() {
		conn = SQLConn.getConn();
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
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			return false;
		}
	}

}
