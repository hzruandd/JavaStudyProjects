package tankWarCongGou.control;

import tankWarCongGou.control.gameAssist.GameAssistAI;
import tankWarCongGou.control.gameAssist.GameAssistProp;
import tankWarCongGou.control.gameAssist.GameAssistWall;
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
	private GameAssistWall wallAssist;
	
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
		admin.setAITanks(gameFactory.getAITanks(3));
		admin.setWalls(gameFactory.getWalls(new GameMap()));
	}
	
	/**
	 * 游戏模块初始化
	 */
	private void moduleInit() {
		listener = new GameListener(admin);
		gamePaint = new GamePaint(admin);
		
		admin.dataAddListener(listener);
		/**
		 * 开启自动生成道具的线程
		 */
		gameAssist = new GameAssistProp(admin);
		gameAssist.start();
		/**
		 * 开启自动生成AItank的线程
		 */
		aiAssist = new GameAssistAI(admin, gameFactory, listener);
		aiAssist.start();
		/**
		 * 开启检测老家白墙是否存在，并让白墙自动消失的线程
		 */
		wallAssist = new GameAssistWall(admin);
		wallAssist.start();
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

	public GameFrame getGameFrame() {
		return gameFrame;
	}

	public DataAdmin getAdmin() {
		return admin;
	}

	public void setGameFrame(GameFrame gameFrame) {
		this.gameFrame = gameFrame;
	}

	public void setAdmin(DataAdmin admin) {
		this.admin = admin;
	}

}
