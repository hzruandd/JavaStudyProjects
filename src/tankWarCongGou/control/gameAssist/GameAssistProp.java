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
				Thread.sleep(15000);
				if (admin.getProps().size()==0) {
					int x=400;
					int y=400;
					admin.addProp(new Prop(x, y, 0));
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
