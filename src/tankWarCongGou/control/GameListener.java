package tankWarCongGou.control;

import java.awt.event.KeyEvent;
import java.util.List;

import tankWarCongGou.entity.Direction;
import tankWarCongGou.entity.MyTank;

/**
 * 
 * @author Doctor邓
 *	游戏监听类，用于监听用户的操作
 */
public class GameListener {
	private List<MyTank> myTanks;
	private MyTank myTank1;   //玩家一
	private MyTank myTank2;   //玩家二
	
	public GameListener(List<MyTank> myTanks) {
		this.myTanks = myTanks;
	} 
	
	public void setListener() {
		switch(myTanks.size()) {
		case 1:
			break;
		case 2:
			break;
		}
		
	}
	
//	public void keyPressed(KeyEvent e) {
//		switch(e.getKeyCode()) {
//		case KeyEvent.VK_UP:
//			setMotionStatus(true);
//			setDir(Direction.Up);
//			break;
//		case KeyEvent.VK_LEFT:
//			setMotionStatus(true);
//			setDir(Direction.Left);
//			break;
//		case KeyEvent.VK_DOWN:
//			setMotionStatus(true);
//			setDir(Direction.Down);
//			break;
//		case KeyEvent.VK_RIGHT:
//			setMotionStatus(true);
//			setDir(Direction.Right);
//			break;
//		}
//	}
//	
//	public void keyReleased(KeyEvent e) {
//		
//	}
	
	
}
