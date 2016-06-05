package tankWarCongGou.control;

import tankWarCongGou.control.gameAssist.GameAssistAI;
import tankWarCongGou.control.gameAssist.GameAssistProp;
import tankWarCongGou.entity.GameMap;
import tankWarCongGou.model.GameFactory;
import tankWarCongGou.view.GameFrame;

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
	private GameAssistProp gameAssist;
	private GameAssistAI aiAssist;
	
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
		gameFactory = new GameFactory();
		admin.setMyTanks(gameFactory.getMyTanks(2));
		admin.setWalls(gameFactory.getWalls(new GameMap()));
	}
	
	/**
	 * 游戏模块初始化
	 */
	private void moduleInit() {
		listener = new GameListener(admin);
//		keyMonitor = new KeyMonitor(admin);
		gamePaint = new GamePaint(admin);
		gameAssist = new GameAssistProp(admin);
		//aiAssist = new GameAssistAI(admin, gameFactory, listener);
		admin.dataAddListener(listener);
		//aiAssist.start();
		gameAssist.start();
	}
	
	/**
	 * 游戏界面初始化
	 */
	private void viewInit() {
		gameFrame = new GameFrame(gamePaint, listener);
	}
	
	public static void main(String[] args) {
		TankClient gameRun = new TankClient();
	}

}
