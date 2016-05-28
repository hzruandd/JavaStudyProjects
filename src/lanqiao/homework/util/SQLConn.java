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
	
	private SQLConn() {
		
	}
	
	@SuppressWarnings("finally")
	public  static Connection getConn() {
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(URL, USER, PWD);
			//System.out.println("连接成功");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} finally {
			return conn;
		}
	}
}
