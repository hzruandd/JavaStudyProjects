package tankWarCongGou.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import tankWarCongGou.entity.AITank;
import tankWarCongGou.entity.GameMap;
import tankWarCongGou.entity.MyTank;
import tankWarCongGou.entity.Tank;
import tankWarCongGou.entity.Wall;
import tankWarCongGou.view.GamePanel;

/**
 * 
 * @author Doctor邓
 * 用于生成游戏的各个对象，例如：坦克，子弹，墙等。
 */
public class GameFactory {

	private final Random random = new Random();
	/**
	 * AiTank的初始三个位置
	 */
	private final int[][] aiPosition = {{Tank.WIDTH/2, 0},
									{GamePanel.WIDTH/2 - Tank.WIDTH/2, 0},
									{GamePanel.WIDTH - Tank.WIDTH*3/2, 0}};
	/**
	 * MyTank的两个初始位置
	 */
	private final int[][] myPosition = {{GamePanel.WIDTH/2- Tank.WIDTH*2, GamePanel.HEIGHT - Tank.HEIGHT},
			{GamePanel.WIDTH/2 + Tank.WIDTH*2, GamePanel.HEIGHT - Tank.HEIGHT}};
	
	/**
	 * 初始化一个或两个我方坦克。
	 * @param volume  要初始化我方坦克的数量
	 * @return        返回我方坦克的集合
	 */
	public List<MyTank> getMyTanks(int volume) {
		List<MyTank> myTanks = new ArrayList<>();
		if (volume == 1) {
				int x = myPosition[0][0];
				int y = myPosition[0][1];
				MyTank  myTank = new MyTank(x, y);
				myTanks.add(myTank);
		} else {
			int x1 = myPosition[0][0];
			int y1 = myPosition[0][1];
			MyTank  myTank1 = new MyTank(x1, y1);
			myTanks.add(myTank1);
			int x2 = myPosition[1][0];
			int y2 = myPosition[1][1];
			MyTank myTank2 = new MyTank(x2, y2);
			myTanks.add(myTank2);
		}
		return myTanks;
	}
	
	public List<AITank> getAITanks(int volume) {
		List<AITank> aiTanks = new ArrayList<AITank>();
		
		for(int i=0; i<volume; i++) {
			int j = random.nextInt(3);
			int x = aiPosition[j][0];
			int y = aiPosition[j][1];
			AITank aiTank = new AITank(x, y);
			aiTanks.add(aiTank);
		}
		return aiTanks;
	}
	
	public AITank getAITank() {
		int j = random.nextInt(3);
		int x = aiPosition[j][0];
		int y = aiPosition[j][1];
		AITank aiTank = new AITank(x, y);
		return aiTank;
	}
	
	public List<Wall> getWalls(GameMap map) {
		List<Wall> wallList = new ArrayList<>();
		int[][] gameMap = map.getMap1();
		for (int i=0; i<gameMap.length; i++) {
			Wall wall = new Wall(gameMap[i][0], gameMap[i][1], gameMap[i][2]);
			wallList.add(wall);
		}
		return wallList;
	}
}
