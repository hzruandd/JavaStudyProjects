package lanqiao.homework.bussiness;

import lanqiao.homework.dao.VerifyUserDao;
import lanqiao.homework.dao.impl.VerifyUserDaoImpl;

/**
 * 验证用户名和密码是否正确的业务类
 * @author Doctor邓
 *
 */
public class VerifyUserAction {
	private VerifyUserDao verify;
	
	public boolean verify(String account, String pwd) {
		verify = new VerifyUserDaoImpl();
		return verify.verify(account, pwd);
	}
}
