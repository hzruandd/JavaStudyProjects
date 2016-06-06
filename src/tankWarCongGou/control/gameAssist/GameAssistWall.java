package tankWarCongGou.control.gameAssist;

import java.util.List;
import tankWarCongGou.control.DataAdmin;
import tankWarCongGou.entity.GameMap;
import tankWarCongGou.entity.Wall;
import tankWarCongGou.model.GameFactory;
/**
 * 用于每隔一段时间就将老家的白墙转换为红墙
 * @author Doctor邓
 *
 */
public class GameAssistWall extends Thread {
	private DataAdmin admin;
	private GameMap map;
	private GameFactory factory;
	private List<Wall> homeWalls;
	private List<Wall> homeWhiteWalls;
	
	public GameAssistWall(DataAdmin admin) {
		this.admin = admin;
		map = new GameMap();
		factory = new GameFactory();
		homeWalls = factory.getWalls(map.getHomeMap());
		homeWhiteWalls = factory.getWalls(map.getWhiteHomeMap());
	}
	
	public void run() {
		 try {
			while(true) {
				sleep(2000);
				/**
				 * 用于判断老家的墙是否有白色的墙存在，默认为false，不存在
				 */
				boolean temp = false;
				/**
				 * 当老家的墙只要一一堵白色的墙，temp 为true
				 */
				for (int i=0; i<homeWalls.size(); i++) {
					if (admin.getWalls().contains(homeWalls.get(i))) {
						temp = true;
						break;
					}
				}
				if (temp) {
					sleep(6000);
					
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
