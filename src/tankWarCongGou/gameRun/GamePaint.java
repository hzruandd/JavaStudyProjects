package tankWarCongGou.gameRun;

import java.awt.Graphics;
import java.util.List;

import tankWarCongGou.cartoon.AICartoon;
import tankWarCongGou.cartoon.GameEnd;
import tankWarCongGou.cartoon.WallEffects;
import tankWarCongGou.dataEntity.AITank;
import tankWarCongGou.dataEntity.Boom;
import tankWarCongGou.dataEntity.Bullet;
import tankWarCongGou.dataEntity.GameHome;
import tankWarCongGou.dataEntity.GameMenu;
import tankWarCongGou.dataEntity.MyTank;
import tankWarCongGou.dataEntity.Prop;
import tankWarCongGou.dataEntity.Wall;
import tankWarCongGou.model.GameJudge; 
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
	private DataAdmin admin;            //游戏数据管理员
	private GameMenu gameMenu;          //游戏菜单
	private GameEnd gameEnd;            //游戏结束类
	private GameJudge gameJudge;        //判定游戏胜负
	
	public GamePaint(DataAdmin admin) {
		this.admin = admin;
		impact = new ImpactDetection(admin);
		gameJudge = new GameJudge(admin);
		dataInit();
	}
	
	public void draw(Graphics g) {
		/**
		 * 当游戏没有开始时，进行游戏菜单画图方法
		 */
		if (!TankClient.gameStatus) {
			gameMenuDraw(g);
		}
		
		/**
		 * 当游戏开始时，进行游戏运行时画图方法
		 */
		if (TankClient.gameStatus && TankClient.victory ==0) {
			gameRunDraw(g);
			/**
			 * 当游戏开始后才开始判定游戏是否成功或失败
			 */
			gameJudge.judge();
		}
		
		/**
		 * 当游戏结束时，开始游戏结束画图方法
		 */
		if (TankClient.victory != 0 && TankClient.gameStatus) {
			gameRunDraw(g);
			gameEndDraw(g);
		}
		
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
		gameMenu = admin.getGameMenu();
		gameEnd = admin.getGameEnd();
	}
	
	/**
	 * 游戏运行时的画图方法
	 * @param g JPanel的画笔
	 */
	public void gameRunDraw(Graphics g) {
		drawAICartoon(g);
		drawTank(g);
		drawBullet(g);
		drawWall(g);
		drawBoom(g);
		drawProp(g);
		drawHome(g);
		drawWallEffecits(g);
		/**
		 * 碰撞检测
		 */
		impact.impactCheck();
	}
	
	/**
	 * 游戏开始菜单画图方法
	 * @param g	JPanel的画笔
	 */
	public void gameMenuDraw(Graphics g) {
		gameMenu.draw(g);
	}
	
	/**
	 * 游戏结束时画图方法
	 * @param g	JPanel的画笔
	 */
	public void gameEndDraw(Graphics g) {
		gameEnd.draw(g);
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
