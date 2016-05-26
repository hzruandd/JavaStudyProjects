package tankWarCongGou.control;

import tankWarCongGou.entity.Bullet;

/**
 * 
 * @author Doctor邓
 * 游戏的监听类，用于监听游戏的各种事件
 */
public class GameListener {
	private DataAdmin admin;
	
	public GameListener() {
		admin = new DataAdmin();
	}
	
	public void fireAction(Bullet bullet) {
		admin.addBullet(bullet);
	}
}
