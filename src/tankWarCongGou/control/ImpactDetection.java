package tankWarCongGou.control;

import java.util.List;

import tankWarCongGou.entity.AITank;
import tankWarCongGou.entity.Bullet;
import tankWarCongGou.entity.GameHome;
import tankWarCongGou.entity.MyTank;
import tankWarCongGou.entity.Prop;
import tankWarCongGou.entity.Wall;

/**
 * 
 * @author Doctor邓
 * 游戏的碰撞检测类,检测坦克和墙，坦克和子弹，子弹和墙等对象的碰撞
 */
public class ImpactDetection {
	private DataAdmin admin;
	private List<MyTank> myTanks;
	private List<AITank> aiTanks;
	private List<Bullet> bullets;
	private List<Wall> walls;
	private List<Prop> props;
	private GameHome home;
	
	public ImpactDetection(DataAdmin admin) {
		this.admin = admin;
		dataInit();
	}
	
	/**
	 * 数据初始化，获取所有的游戏对象的数据，例如：坦克、子弹、墙、道具等。
	 */
	public void dataInit() {
		myTanks = admin.getMyTanks();
		aiTanks = admin.getAITanks();
		bullets = admin.getBullets();
		walls = admin.getWalls();
		props = admin.getProps();
		home = admin.getGameHome();
	}
	
	/**
	 * 碰撞检测方法集合
	 */
	public void impactCheck() {
		bulletTOtank();
		bulletTOWall();
		tankTOWall();
		tankTOProp();
		bulletTObullet();
		bulletTOhome();
	}
	
	
	/**
	 * 子弹和坦克之间的碰撞检测
	 */
	public void bulletTOtank() {
		//当游戏中坦克和子弹都存在时开始子弹和坦克的碰撞检测
		if (aiTanks.size() >= 1 && bullets.size() >=1 ) {
			for (int i=0; i< aiTanks.size(); i++) {
				AITank aiTank = aiTanks.get(i);
				
				for (int j=0; j< bullets.size(); j++) {
					Bullet bullet = bullets.get(j);
					//当子弹和坦克阵营相同时退出此次循环，不开始碰撞检测
					if (aiTank.isCamp() == bullet.isCamp()) continue;
					//检测是否发生碰撞
					if (aiTank.getRect().intersects(bullet.getRect())) {
						aiTank.setLive(false);
						bullet.setLive(false);
						bullet.bulletBoom();
						aiTanks.remove(aiTank);
						bullets.remove(bullet);
					}
				}
			}
		}
		
		if (myTanks.size() >= 1 && bullets.size() >=1 ) {
			for (int i=0; i< myTanks.size(); i++) {
				MyTank myTank = myTanks.get(i);
				
				for (int j=0; j< bullets.size(); j++) {
					Bullet bullet = bullets.get(j);
					//当子弹和坦克阵营相同时退出此次循环，不开始碰撞检测
					if (myTank.isCamp() == bullet.isCamp()) continue;
					//检测是否发生碰撞
					if (myTank.getRect().intersects(bullet.getRect())) {
						
						myTank.setLife(myTank.getLife() - 1);
						if (myTank.getLife() ==0) {
							myTank.setLive(false);
							myTanks.remove(myTank);
						}
						bullet.setLive(false);
						bullet.bulletBoom();
						bullets.remove(bullet);
					}
				}
			}
		}
	}
	
	/**
	 * 子弹和墙之间的碰撞检测
	 */
	public void bulletTOWall() {
		for (int i=0; i<walls.size(); i++) {
			Wall wall = walls.get(i);
			
			for (int j=0; j<bullets.size(); j++) {
				Bullet bullet = bullets.get(j);
				
				if(bullet.getRect().intersects(wall.getRect())) {
					/**
					 * 当子弹的Dps大于或等于墙的Armor时墙会消失,并产生爆炸
					 */
					if (bullet.getDps() > wall.getArmor()) {
						walls.remove(wall);
					}
					bullet.bulletBoom();
					bullets.remove(bullet);
				}
			}
		}
	}
	
	/**
	 * 坦克和墙之间的碰撞检测
	 */
	public void tankTOWall() {
		for (int i=0; i<myTanks.size(); i++) {
			MyTank myTank = myTanks.get(i);
			for (int j=0; j<walls.size(); j++) {
				Wall wall = walls.get(j);
				
				if (myTank.getRect().intersects(wall.getRect())) {
					myTank.setX(myTank.getOldX());
					myTank.setY(myTank.getOldY());
				}
			}
		}
		
		for (int i=0; i<aiTanks.size(); i++) {
			AITank aiTank = aiTanks.get(i);
			for (int j=0; j<walls.size(); j++) {
				Wall wall = walls.get(j);
				
				if (aiTank.getRect().intersects(wall.getRect())) {
					aiTank.setX(aiTank.getOldX());
					aiTank.setY(aiTank.getOldY());
				}
			}
		}
	}

	/**
	 * 坦克和道具间的碰撞检测
	 */
	public void tankTOProp() {
		for (int i=0; i<myTanks.size(); i++) {
			MyTank myTank = myTanks.get(i);
			for (int j=0; j<props.size(); j++) {
				Prop prop = props.get(j);
				
				if (myTank.getRect().intersects(prop.getRect())) {
					prop.function(myTank);
					props.remove(prop);
				}
			}
		}
	}
	/**
	 * 子弹和子弹间的碰撞检测
	 */
	public void bulletTObullet() {
		for (int i=0; i<bullets.size(); i++) {
			Bullet bullet1 = bullets.get(i);
			for (int j=0; j<bullets.size(); j++) {
				Bullet bullet2 = bullets.get(j);
				
				/**
				 * 当坦克阵营不同时才进行碰撞检测
				 */
				if (bullet1.isCamp() != bullet2.isCamp()) {
					if (bullet1.getRect().intersects(bullet2.getRect())) {
						bullet1.bulletBoom();
						bullet2.bulletBoom();
					}
				}
			}
		}
	}
	/**
	 * 子弹和老家间的碰撞检测
	 */
	public void bulletTOhome() {
		for (int i=0; i<bullets.size(); i++) {
			Bullet bullet = bullets.get(i);
			if (bullet.getRect().intersects(home.getRect())) {
				home.setLive(false);
				bullet.bulletBoom();
				bullets.remove(bullet);
			}
		}
	}
	
}
