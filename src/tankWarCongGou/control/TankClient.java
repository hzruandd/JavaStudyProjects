package tankWarCongGou.control;

import tankWarCongGou.model.GameData;
import tankWarCongGou.model.GameFactory;
import tankWarCongGou.view.GameFrame;

/**
 * 
 * @author Doctor邓
 * 游戏负责将游戏的界面和后台逻辑相连接
 * 游戏的主体类，控制游戏主题界面和运行
 */

public class TankClient {
	private GameFactory gameFactory = new GameFactory();
	private GameData gameData = new GameData();
	
	private void dataInit() {
		gameData.setMyTanks(gameFactory.getMyTanks(2));
	}
	
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		TankClient gameRun = new TankClient();
		gameRun.dataInit();
		GameFrame gameMain = new GameFrame();
	}

}
