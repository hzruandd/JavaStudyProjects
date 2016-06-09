package tankWarCongGou.control;

import java.awt.Color;
import java.awt.Graphics;
import java.util.List;

import tankWarCongGou.entity.AICartoon;
import tankWarCongGou.entity.AITank;
import tankWarCongGou.entity.Boom;
import tankWarCongGou.entity.Bullet;
import tankWarCongGou.entity.GameHome;
import tankWarCongGou.entity.MyTank;
import tankWarCongGou.entity.Prop;
import tankWarCongGou.entity.Wall;
import tankWarCongGou.entity.WallEffects; 
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
	private GameHome home;              //家
	private WallEffects wallEffects;    //老家白墙切换到红墙特效
	private AICartoon aiCartoon;        //aiTank生成时动画
	private ImpactDetection impact;     //碰撞检测
	private DataAdmin admin;
	
	public GamePaint(DataAdmin admin) {
		this.admin = admin;
		impact = new ImpactDetection(admin);
		dataInit();
	}
	
	public void draw(Graphics g) {
		drawAICartoon(g);
		drawTank(g);
		drawBullet(g);
		drawWall(g);
		drawBoom(g);
		drawProp(g);
		drawHome(g);
		drawWallEffecits(g);
		drawData(g);
		/**
		 * 碰撞检测
		 */
		impact.impactCheck();
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
		walls = admin.getWalls();
		props = admin.getProps();
		home = admin.getGameHome();
		wallEffects = admin.getWallEffects();
		aiCartoon = admin.getAICartoon();
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
	
	private void drawBoom(Graphics g) {
		for(int i=0; i<booms.size(); i++) {
			booms.get(i).draw(g);
		}
	}
	
	private void drawWall(Graphics g) {
		for (int i=0; i<walls.size(); i++) {
			walls.get(i).draw(g);
		}
	}
	
	
	private void drawProp(Graphics g) {
		for(int i=0; i<props.size(); i++) {
			props.get(i).draw(g);
		}
	}
	
	private void drawHome(Graphics g) {
		home.draw(g);
	}
	
	private void drawWallEffecits(Graphics g) {
		wallEffects.draw(g);
	}
	
	private void drawAICartoon(Graphics g) {
		aiCartoon.draw(g);
	}
}
