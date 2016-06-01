package lanqiao.homework.util;

import java.sql.Connection;

/**
 * 得到各种数据库连接的统一的接口
 * @author Doctor邓
 *
 */
public interface SqlUtil {
	/**
	 * 
	 * @return 返回一个数据库的连接对象
	 */
	public Connection getConn();
}
