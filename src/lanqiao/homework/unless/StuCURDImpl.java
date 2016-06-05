package lanqiao.homework.unless;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Vector;

import lanqiao.homework.entity.Stu;
import lanqiao.homework.util.SqlUtil;
import lanqiao.homework.util.impl.DBUtil;
/**
 * 对学生信息实现增、删、改、查操作的具体实现类
 * @author Doctor邓
 *
 */
public class StuCURDImpl implements SqlCURDDao {
	
	private Connection conn;
	private PreparedStatement ps;
	private SqlUtil sqlUtil = new DBUtil();
	
	public StuCURDImpl() {
		conn = sqlUtil.getConn();
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
			String sqlAddInfo = "INSERT INTO stu_info (info_id, stu_name, stu_age, "
					+ "stu_sex, stu_address) VALUES (?, ?, ?, ?, ?)";
			
			try {
				ps = conn.prepareStatement(sqlAddStu);
				ps.setInt(1, stu.getStu_id());
				ps.setInt(2, stu.getInfo_id());
				ps.setInt(3, stu.getClass_id());
				int i = ps.executeUpdate(sqlAddStu);
				if (i==0) return false;
				ps = conn.prepareStatement(sqlAddInfo);
				ps.setInt(1, stu.getStu_id());
				ps.setString(2, stu.getStu_name());
				ps.setInt(3, stu.getStu_age());
				ps.setString(4,	stu.getStu_sex());
				ps.setString(5, stu.getStu_address());
				int j = ps.executeUpdate(sqlAddInfo);
				if (j==0) return false;
				
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
