package tankWarCongGou.control;

import java.util.List;

import tankWarCongGou.entity.AITank;
import tankWarCongGou.entity.Bullet;
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
	}
	
	public void impactCheck() {
		bulletTOtank();
		bulletTOWall();
		tankTOWall();
		tankTOProp();
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
						
						myTank.setLife(myTank.getLife() - 20);
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
}
