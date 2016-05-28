package tankWarCongGou.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import tankWarCongGou.entity.AITank;
import tankWarCongGou.entity.MyTank;

/**
 * 
 * @author Doctor邓
 * 用于生成游戏的各个对象，例如：坦克，子弹，墙等。
 */
public class GameFactory {
//	private GameListener listener;
//	
//	public  GameFactory(GameListener listener) {
//		this.listener = listener;
//	}
	
//	public void setListerer(GameListener listener) {
//		this.listener = listener;
//	}
	public  List<MyTank> getMyTanks(int volume) {
		List<MyTank> myTanks = new ArrayList<MyTank>();
		for (int i=0; i<volume; i++) {
			MyTank myTank = new MyTank(100, 100);
			myTanks.add(myTank);
		} 
		return myTanks; 
	}
	
	public List<AITank> getAITanks(int volume) {
		List<AITank> aiTanks = new ArrayList<AITank>();
		Random random = new Random();
		for (int i=0; i<volume; i++) {
			AITank aiTank = new AITank(random.nextInt(600) + 50, random.nextInt(500) + 50);
			aiTanks.add(aiTank);
		}
		return aiTanks;
	}

}
