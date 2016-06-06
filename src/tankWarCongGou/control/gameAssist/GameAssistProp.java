package tankWarCongGou.control.gameAssist;

import tankWarCongGou.control.DataAdmin;
import tankWarCongGou.entity.Prop;
/**
 * 游戏辅助工具类
 * @author Administrator
 *
 */
public class GameAssistProp extends Thread {
	private DataAdmin admin;
	
	public GameAssistProp(DataAdmin admin) {
		this.admin = admin;
	}
	
	public void run() {
		while(true) {
			try {
				sleep(2000);
				if (admin.getProps().size()==0) {
					admin.getProps().add(new Prop(0));
					sleep(10000);
				}
				if (admin.getProps().size() > 0) {
					admin.getProps().clear();
				}
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
