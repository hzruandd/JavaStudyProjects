package tankWarCongGou.control;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import tankWarCongGou.entity.Bullet;
import tankWarCongGou.entity.Direction;
import tankWarCongGou.model.GameAction;

/**
 * 
 * @author Doctor邓
 * 游戏的监听类，用于监听游戏的各种事件
 */
public class GameListener implements KeyListener {
	private DataAdmin admin;
	private GameAction gameAction;
	
	public GameListener(DataAdmin admin) {
		this.admin = admin;
		gameAction = new GameAction(admin);
	}
	
	/**
	 * 坦克开火后生成一颗子弹
	 * @param x
	 * @param y
	 * @param camp
	 * @param dir
	 */
	public void fireAction(int x, int y, boolean camp, Direction dir) {
		Bullet bullet = new Bullet(x, y, camp, dir);
		bullet.setListener(this);
		admin.addBullet(bullet);
	}
	
	public void bulletOverBorder(Bullet bullet) {
		admin.removeBullet(bullet);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO 自动生成的方法存根
		gameAction.keyPressed(e);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO 自动生成的方法存根
		gameAction.keyReleased(e);
	}
}
