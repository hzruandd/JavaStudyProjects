package tankWarCongGou.model;

import java.util.ArrayList;
import java.util.List;

import tankWarCongGou.entity.AITank;
import tankWarCongGou.entity.Boom;
import tankWarCongGou.entity.Bullet;
import tankWarCongGou.entity.GameHome;
import tankWarCongGou.entity.MyTank;
import tankWarCongGou.entity.Prop;
import tankWarCongGou.entity.Wall;
import tankWarCongGou.entity.WallEffects;

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
	private GameHome gameHome;          //家
	private WallEffects wallEffects;    //老家动画特效
	
	public GameData() {
		myTanks = new ArrayList<MyTank>();
		aiTanks = new ArrayList<AITank>();
		bullets = new ArrayList<Bullet>();
		props = new ArrayList<Prop>();
		walls = new ArrayList<Wall>();
		booms = new ArrayList<Boom>();
		gameHome = new GameHome();
		wallEffects = new WallEffects();
	}
	
	public WallEffects getWallEffects() {
		return wallEffects;
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

	public List<Prop> getProps() {
		return props;
	}

	public void setProps(List<Prop> props) {
		this.props = props;
	}

	public List<Boom> getBooms() {
		return booms;
	}

	public void setBooms(List<Boom> booms) {
		this.booms = booms;
	}

	public void setBullets(List<Bullet> bullets) {
		this.bullets = bullets;
	}

	public GameHome getGameHome() {
		return gameHome;
	}

	public void setGameHome(GameHome gameHome) {
		this.gameHome = gameHome;
	}
}
