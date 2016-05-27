package tankWarCongGou.control;

import tankWarCongGou.model.GameData;
import tankWarCongGou.model.GameFactory;
import tankWarCongGou.view.GameFrame;
import tankWarCongGou.view.GamePanel;

/**
 * 
 * @author Doctor邓
 * 游戏负责将游戏的界面和后台逻辑相连接
 * 游戏的主体类，控制游戏主题界面和运行
 */
public class TankClient {
	private GameFrame gameFrame;
	
	private GameFactory gameFactory;
	private DataAdmin admin;
	private GameListener listener ;
	private KeyMonitor keyMonitor;
	private GamePaint gamePaint;
	
	public TankClient() {
		dataInit();
		moduleInit();
		viewInit();
	}
	
	/**
	 * 游戏数据初始化
	 */
	private void dataInit() {
		admin = new DataAdmin();
		listener = new GameListener(admin);
		gameFactory = new GameFactory(listener);
		admin.setMyTanks(gameFactory.getMyTanks(2));
	}
	
	/**
	 * 游戏模块初始化
	 */
	private void moduleInit() {
		
		keyMonitor = new KeyMonitor(admin);
		gamePaint = new GamePaint(admin);
	}
	
	/**
	 * 游戏界面初始化
	 */
	private void viewInit() {
		gameFrame = new GameFrame(gamePaint, listener);
	}
	
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		TankClient gameRun = new TankClient();
	}

}
