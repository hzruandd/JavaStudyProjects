package tankWarCongGou.control;

import java.awt.Color;
import java.awt.Graphics;
import java.util.List;

import tankWarCongGou.entity.AITank;
import tankWarCongGou.entity.Boom;
import tankWarCongGou.entity.Bullet;
import tankWarCongGou.entity.MyTank;
import tankWarCongGou.entity.Prop;
import tankWarCongGou.entity.Wall;
import tankWarCongGou.model.GameData; 
/**
 * 画出游戏的各种对象，如坦克，子弹，爆炸、墙等
 */
public class GamePaint {
	
	private List<MyTank> myTanks;       //我方坦克集合
	private List<AITank> aiTanks;       //AI坦克集合
	private List<Bullet> bullets;       //子弹集合
	private List<Prop> props;           //道具集合
	private List<Wall> walls;           //墙集合
	private List<Boom> booms;           //爆炸集合
	private ImpactDetection impact;
	
	private DataAdmin admin;
	
	public GamePaint(DataAdmin admin) {
		this.admin = admin;
		impact = new ImpactDetection(admin);
	}
	
	public void draw(Graphics g) {
		dataInit();
		drawTank(g);
		drawBullet(g);
		drawData(g);
//		drawWall(g);
		drawBoom(g);
//		drawProp(g);
		impact.bulletTOtank();
	}
	
	public void drawData(Graphics g) {
		Color c = g.getColor();
		g.setColor(Color.WHITE);
		g.drawString("子弹有：" + bullets.size() , 50, 50);
		g.setColor(c);
	}
	
	/**
	 * 画图数据初始化
	 */
	public void dataInit() {
		myTanks = admin.getMyTanks();
		aiTanks = admin.getAITanks();
		bullets = admin.getBullets();
		booms = admin.getBooms();
		
	}
	
	private void drawTank(Graphics g) {
		for(int i=0; i<myTanks.size(); i++) {
			myTanks.get(i).draw(g);
		}
		
		for(int i=0; i<aiTanks.size(); i++) {
			aiTanks.get(i).draw(g);
		}
	}
	
	private void drawBullet(Graphics g) {
		for(int i=0; i<bullets.size(); i++) {
			bullets.get(i).draw(g);
		}
	}
	
//	private void drawWall(Graphics g) {
//		for(Wall wall : walls) {
//			wall.draw(g);
//		}
//	}
//	
	private void drawBoom(Graphics g) {
		for(int i=0; i<booms.size(); i++) {
			booms.get(i).draw(g);
		}
	}
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
