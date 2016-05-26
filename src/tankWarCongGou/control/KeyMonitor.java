package tankWarCongGou.control;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import tankWarCongGou.model.GameData;

/**
 * 键盘监听，获取用户输入，控制MyTank的方向
 * @author Doctor邓
 *
 */
public class KeyMonitor extends KeyAdapter {

	private GameAction gameAction = new GameAction(GameData.getMyTanks());
	//按键被按下的监听方法
	@Override
	public void keyPressed(KeyEvent e) {
		gameAction.keyPressed(e);
	}

	//按下的按键被抬起来后的监听方法
	@Override
	public void keyReleased(KeyEvent e) {

	}
	
}

	