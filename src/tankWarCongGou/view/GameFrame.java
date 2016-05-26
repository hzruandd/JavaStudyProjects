package tankWarCongGou.view;

import java.awt.Toolkit;

import javax.swing.JFrame;

import tankWarCongGou.control.KeyMonitor;
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
	private GamePanel gamePanel;
	
	public GameFrame() {
		
		X = (ScreenWidth - GameWidth)/2;
		Y = (ScreenHeight - GameHeight)/2;
		gamePanel = new GamePanel();
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
		add(gamePanel);
		//该窗体添加监听器
		addKeyListener(new KeyMonitor());
		setVisible(true);
	}

	public GamePanel getGamePanel() {
		return gamePanel;
	}

//	public void setTankPanel(GamePanel gamePanel) {
//		this.gamePanel = gamePanel;
//	}
	

}
