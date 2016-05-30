package lanqiao.homework.util;
/**
 * 用于检查各种用户输入的统一的接口
 * @author Doctor邓
 *
 */
public interface InputCheckUp {
	/**
	 * 
	 * @return 输入合法，返回true。输入不合法返回false
	 */
	public boolean checkInput(String input);
}
