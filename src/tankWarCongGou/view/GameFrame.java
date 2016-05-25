package tankWarCongGou.view;

import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;

import tankWarCongGou.entity.MyTank;
/**
 * 
 * @author Doctor邓
 * 游戏主界面
 */
public class GameFrame extends JFrame {
	public static final int GameHeight = 700;
	public static final int GameWidth = 1100;
	private final String GameName = "坦克大战";
	private final int X;
	private final int Y;
	private final int ScreenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
	private final int ScreenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
	
	//游戏画面
	private GamePanel tankPanel;
	
	public GameFrame() {
		X = (ScreenWidth - GameWidth)/2;
		Y = (ScreenHeight - GameHeight)/2;
		tankPanel = new GamePanel();
		init();
	}
	
	/**
	 * 初始化界面
	 */
	private void init() {
		setTitle(GameName);
		setSize(GameWidth, GameHeight);
		setLocation(X, Y);
		setResizable(false);
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		add(tankPanel);
		setVisible(true);
	}
	
	//键盘监听，获取用户输入，控制MyTank的方向
	private class KeyMonitor extends KeyAdapter {
		
		//按键被按下的监听方法
		public void keyPressed(KeyEvent e) {
			
		}
		
		//按下的按键被抬起来后的监听方法
		public void keyReleased(KeyEvent e) {
			
		}
	}
	

}
