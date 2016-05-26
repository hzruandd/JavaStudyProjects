package tankWarCongGou.model;

import java.util.ArrayList;
import java.util.List;
import tankWarCongGou.entity.AITank;
import tankWarCongGou.entity.Boom;
import tankWarCongGou.entity.Bullet;
import tankWarCongGou.entity.MyTank;
import tankWarCongGou.entity.Prop;
import tankWarCongGou.entity.Wall;

/**
 * 
 * @author Doctor邓
 *	存储游戏的数据，并对游戏的数据初始化
 */
public class GameData {
	
	private static List<MyTank> myTanks;       //我方坦克集合
	private static List<AITank> aiTanks;       //AI坦克集合
	private static List<Bullet> bullets;       //子弹集合
	private static List<Prop> props;           //道具集合
	private static List<Wall> walls;           //墙集合
	private static List<Boom> booms;           //爆炸集合
	
	public static List<Bullet> getBullets() {
		return bullets;
	}

	public static List<MyTank> getMyTanks() {
		return myTanks;
	}
	
	public void setMyTanks(List<MyTank> myTanks) {
		this.myTanks = myTanks;
	}
	
	
}
