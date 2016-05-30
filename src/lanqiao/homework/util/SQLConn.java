package lanqiao.homework.util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLConn {
	private static final String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";
	private static final String URL = "jdbc:oracle:thin:@119.29.223.16:1521:orcl";
	private static final String USER = "hr";
	private static final String PWD = "123456";
	private static Connection conn = null;
	
	/**
	 * 建立JDBC-ORACLE的桥接器
	 */
	static {
		try {
			Class.forName(JDBC_DRIVER);
		} catch (ClassNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	
	/**
	 * 获取数据库的链接
	 * @return 返回数据库的连接对象
	 */
	@SuppressWarnings("finally")
	public static Connection getConn() {
		try {
			conn = DriverManager.getConnection(URL, USER, PWD);
			//System.out.println("连接成功");
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} finally {
			return conn;
		}
	}
	
	/**
	 * 关闭数据库的连接
	 */
	public void close() {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
	}
}
