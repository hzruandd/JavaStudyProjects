package lanqiao.homework.unless;

import java.util.Vector;
/**
 * 对数据库进行CURD操作的通用接口
 * @author Doctor邓
 *
 */
public interface SqlCURDDao {
	/**
	 * 向数据库添加信息
	 * @return 添加成功，返回true，添加失败，返回false
	 */
	public boolean add(Object obj);
	/**
	 * 从数据库删除信息
	 * @return 删除成功，返回true，删除失败，返回false
	 */
	public boolean delete(Object obj);
	/**
	 * 更新数据库信息（修改）
	 * @return 更新成功，返回true，更新失败，返回false
	 */
	public boolean update(Object obj);
	/**
	 * 查询数据库中的信息
	 * @return 返回一个对象数组,如果查找失败返回的对象数组为null
	 */
	public Vector search(Object obj );
}
