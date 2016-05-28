package tankWarCongGou.model;

import java.awt.event.KeyEvent;
import java.util.List;

import tankWarCongGou.control.DataAdmin;
import tankWarCongGou.entity.Direction;
import tankWarCongGou.entity.MyTank;

/**
 * 
 * @author Doctor邓
 *	游戏监听类，用于监听用户的操作，
 */
public class KeyAction {
	private List<MyTank> myTanks;
	private MyTank myTank1 = null;   //玩家一
	private MyTank myTank2 = null;   //玩家二
	
	public KeyAction(DataAdmin admin) {
		this.myTanks = admin.getMyTanks();

		if (myTanks.size()!= 0 && myTanks.size() == 1) {
			myTank1 = myTanks.get(0);
		} 
		else if (myTanks.size()!= 0 && myTanks.size() == 2) {
			myTank1 = myTanks.get(0);
			myTank2 = myTanks.get(1);
		} 
	} 
	
	
	public  void keyPressed(KeyEvent e) {

		if (myTank1 != null) {
			
			switch(e.getKeyCode()) {
			case KeyEvent.VK_W:
				myTank1.setMotionStatus(true);
				myTank1.setDir(Direction.Up);
				break;
			case KeyEvent.VK_A:
				myTank1.setMotionStatus(true);
				myTank1.setDir(Direction.Left);
				break;
			case KeyEvent.VK_S:
				myTank1.setMotionStatus(true);
				myTank1.setDir(Direction.Down);
				break;
			case KeyEvent.VK_D:
				myTank1.setMotionStatus(true);
				myTank1.setDir(Direction.Right);
				break;
			case KeyEvent.VK_SPACE:
				myTank1.fire();
				break;
			}
		}
		
		if (myTank2 != null) {
			switch(e.getKeyCode()) {
			case KeyEvent.VK_UP:
				myTank2.setMotionStatus(true);
				myTank2.setDir(Direction.Up);
				break;
			case KeyEvent.VK_LEFT:
				myTank2.setMotionStatus(true);
				myTank2.setDir(Direction.Left);
				break;
			case KeyEvent.VK_DOWN:
				myTank2.setMotionStatus(true);
				myTank2.setDir(Direction.Down);
				break;
			case KeyEvent.VK_RIGHT:
				myTank2.setMotionStatus(true);
				myTank2.setDir(Direction.Right);
				break;
			case KeyEvent.VK_ENTER:
				myTank2.fire();
				break;
			}
		}
	}
	
	public void keyReleased(KeyEvent e) {
		
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
