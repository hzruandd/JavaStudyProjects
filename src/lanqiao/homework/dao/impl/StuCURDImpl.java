package lanqiao.homework.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Vector;

import lanqiao.homework.dao.SqlCURD;
import lanqiao.homework.util.SQLConn;
import lanqiao.homework.vo.Stu;
/**
 * 对学生信息实现增、删、改、查操作的具体实现类
 * @author Doctor邓
 *
 */
public class StuCURDImpl implements SqlCURD{
	
	private SQLConn sqlConn;
	private Connection conn;
	private PreparedStatement ps;
	
	public StuCURDImpl() {
		sqlConn = new SQLConn();
		conn = sqlConn.getConn();
	}

//	//判断数据库中是否有此学生
//	public boolean isStu(Stu stu) throws SQLException {
//		sql = conn.createStatement();
//		String sqlIsStu = "SELECT stu_id FROM stu WHERE stu_id = " + stu.getStu_id()+ "";
//		ResultSet rs = sql.executeQuery(sqlIsStu);
//		if (rs.next()) {
//			return true;
//		}
//		else {
//			return false;
//		}
//	}
	/**
	 * 添加学生的信息
	 */
	@Override
	public boolean add(Object obj) {
		Stu stu = null;
		
		if (obj instanceof Stu) {
			stu = (Stu) obj;
			String sqlAddStu = "INSERT INTO stu (stu_id, info_id, class_id) VALUES(?, ?, ?)";
			String sqlAddInfo = "INSERT INTO stu_info VALUES (?, ?, ?, ?, ?)";
			
			try {
				ps = conn.prepareStatement(sqlAddStu);
				ps.setInt(1, stu.getStu_id());
				ps.setInt(2, stu.getInfo_id());
				ps.setInt(3, stu.getClass_id());
				ps.executeUpdate(sqlAddStu);
				
				ps = conn.prepareStatement(sqlAddInfo);
				ps.setInt(1,)
				
//				String sqlAddInfo = "INSERT INTO stu_info VALUES ("+stu.getInfo_id()+",'"+ stu.getStu_name()+"',"
//							+ stu.getStu_age()+",'" +stu.getStu_sex()+"', '"+ stu.getStu_address()+"')";
				
				ps.executeUpdate(sqlAddInfo);
				//System.out.println("111");
				return true;
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
				return false;
			}
		}
		else {			
			return false;
		}
	}

	@Override
	public boolean delete(Object obj) {
		return false;
	}

	@Override
	public boolean update(Object obj) {
		return false;
	}

	@Override
	public Vector search(Object obj) {
		return new Vector();
	}

}
