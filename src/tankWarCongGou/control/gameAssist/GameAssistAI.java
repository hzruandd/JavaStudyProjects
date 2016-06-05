package tankWarCongGou.control.gameAssist;

import tankWarCongGou.control.DataAdmin;
import tankWarCongGou.control.GameListener;
import tankWarCongGou.entity.AITank;
import tankWarCongGou.model.GameFactory;

/**
 * 用于检测敌方坦克的数量，并当敌方坦克数量少于6时，动态生成敌方坦克。
 * @author Doctor邓
 *
 */
public class GameAssistAI extends Thread{
	private DataAdmin admin;
	private GameFactory factory;
	private GameListener listener;
	/**
	 * AI坦克总数
	 */
	private final int AITankValue = 20;
	/**
	 * AI坦克最大存在数量
	 */
	private final int AITankMaxValue = 6;
	
	public GameAssistAI(DataAdmin admin, GameFactory factory, GameListener listener) {
		this.admin = admin;
		this.factory = factory;
		this.listener = listener;
	}
	
	public void run() {
		try {
			while (true) {
				Thread.sleep(2000);
				if (admin.getAITanks().size() <AITankMaxValue) {
					AITank aiTank = factory.getAITank();
					aiTank.setListener(listener);
					//admin.getAITanks().add(aiTank);
					admin.addAITank(aiTank);
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
