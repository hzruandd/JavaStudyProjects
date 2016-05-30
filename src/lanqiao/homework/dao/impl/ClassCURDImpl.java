package lanqiao.homework.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.Vector;
import lanqiao.homework.dao.CommanCURD;
import lanqiao.homework.util.impl.SQLConn;

/**
 * 对班级信息实现增、删、改、查的实现类
 * @author Doctor邓
 *
 */
public class ClassCURDImpl implements CommanCURD{
	private Connection conn;
	private PreparedStatement ps;
	
	public ClassCURDImpl() {
		conn = SQLConn.getConn();
	}
	
	@Override
	public boolean add(String sql, List<String> str) {

		return false;
	}

	@Override
	public boolean delete(String sql, List<String> str) {
		// TODO 自动生成的方法存根
		return false;
	}

	@Override
	public boolean update(String sql, List<String> str) {
		// TODO 自动生成的方法存根
		return false;
	}

	@Override
	public Vector search(String sql, List<String> str) {
		// TODO 自动生成的方法存根
		return null;
	}



}
