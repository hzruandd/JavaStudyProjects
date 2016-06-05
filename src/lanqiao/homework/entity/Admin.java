package lanqiao.homework.entity;
/**
 * 管理员实体类
 * @author Doctor邓
 *
 */
public class Admin {
	private String user_account;
	private String user_pwd;
	
	public Admin(String user_account, String user_pwd) {
		this.user_account = user_account;
		this.user_pwd = user_pwd;
	}

	public String getUser_account() {
		return user_account;
	}

	public void setUser_account(String user_account) {
		this.user_account = user_account;
	}

	public String getUser_pwd() {
		return user_pwd;
	}

	public void setUser_pwd(String user_pwd) {
		this.user_pwd = user_pwd;
	}
}
