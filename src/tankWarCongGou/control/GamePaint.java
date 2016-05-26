package tankWarCongGou.control;

import java.awt.Graphics;
import java.util.List;

import tankWarCongGou.entity.AITank;
import tankWarCongGou.entity.Boom;
import tankWarCongGou.entity.Bullet;
import tankWarCongGou.entity.MyTank;
import tankWarCongGou.entity.Prop;
import tankWarCongGou.entity.Wall;
import tankWarCongGou.model.GameData;
import tankWarCongGou.model.GameFactory;

/**
 * 
 * @author Administrator
 * 画出游戏的各种对象，如坦克，子弹，爆炸、墙等
 */
public class GamePaint {
	
	private List<MyTank> myTanks;       //我方坦克集合
	private List<AITank> aiTanks;       //AI坦克集合
	private List<Bullet> bullets;       //子弹集合
	private List<Prop> props;           //道具集合
	private List<Wall> walls;           //墙集合
	private List<Boom> booms;           //爆炸集合
	
	public GamePaint() {
		dataInit();
	}
	
	public void draw(Graphics g) {
		drawTank(g);
//		drawBullet(g);
//		drawWall(g);
//		drawBoom(g);
//		drawProp(g);
	}
	
	//游戏数据初始化
	public void dataInit() {
		myTanks = GameData.getMyTanks();
	}
	
	private void drawTank(Graphics g) {
		for(MyTank myTank : myTanks) {
			myTank.draw(g);
		}
		
//		for(AITank aiTank : aiTanks) {
//			aiTank.draw(g);
//		}
	}
	
//	private void drawBullet(Graphics g) {
//		for(Bullet bullet : bullets) {
//			bullet.draw(g);
//		}
//	}
//	
//	private void drawWall(Graphics g) {
//		for(Wall wall : walls) {
//			wall.draw(g);
//		}
//	}
//	
//	private void drawBoom(Graphics g) {
//		for(Boom boom : booms) {
//			boom.draw(g);
//		}
//	}
//	
//	private void drawProp(Graphics g) {
//		for(Prop prop : props) {
//			prop.draw(g);
//		}
//	}


//	public void setMyTanks(List<MyTank> myTanks) {
//		this.myTanks = myTanks;
//	}
//
//	public void setAiTanks(List<AITank> aiTanks) {
//		this.aiTanks = aiTanks;
//	}
//
//	public void setBullets(List<Bullet> bullets) {
//		this.bullets = bullets;
//	}
//
//	public void setProps(List<Prop> props) {
//		this.props = props;
//	}
//
//	public void setWalls(List<Wall> walls) {
//		this.walls = walls;
//	}
//
//	public void setBooms(List<Boom> booms) {
//		this.booms = booms;
//	}
	
}
