package tankWarCongGou.control;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import tankWarCongGou.entity.Bullet;
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
	
	public void fireAction(Bullet bullet) {
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
