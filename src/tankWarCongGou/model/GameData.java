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
	
	private List<MyTank> myTanks;       //我方坦克集合
	private List<AITank> aiTanks;       //AI坦克集合
	private List<Bullet> bullets;       //子弹集合
	private List<Prop> props;           //道具集合
	private List<Wall> walls;           //墙集合
	private List<Boom> booms;           //爆炸集合
	
	public GameData() {
		myTanks = new ArrayList<MyTank>();
		aiTanks = new ArrayList<AITank>();
		bullets = new ArrayList<Bullet>();
		props = new ArrayList<Prop>();
		walls = new ArrayList<Wall>();
		booms = new ArrayList<Boom>();
		
	}
	
	public  List<Bullet> getBullets() {
		return bullets;
	}

	public  List<MyTank> getMyTanks() {
		return myTanks;
	}
	
	public void setMyTanks(List<MyTank> myTanks) {
		this.myTanks = myTanks;
	}

	public List<AITank> getAiTanks() {
		return aiTanks;
	}

	public void setAiTanks(List<AITank> aiTanks) {
		this.aiTanks = aiTanks;
	}

	public List<Wall> getWalls() {
		return walls;
	}

	public void setWalls(List<Wall> walls) {
		this.walls = walls;
	}
}
