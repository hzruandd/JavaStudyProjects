package tankWarCongGou.control;

import java.util.List;

import tankWarCongGou.entity.AITank;
import tankWarCongGou.entity.Bullet;
import tankWarCongGou.entity.MyTank;

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
	
	public ImpactDetection(DataAdmin admin) {
		this.admin = admin;
	}
	
	/**
	 * 数据初始化，获取所有的游戏对象的数据，例如：坦克、子弹、墙、道具等。
	 */
	public void dataInit() {
		myTanks = admin.getMyTanks();
		aiTanks = admin.getAITanks();
		bullets = admin.getBullets();
	}
	
	public  void bulletTOtank() {
		List<AITank> aiTanks = admin.getAITanks();
		if (admin.getAITanks().size() >=1 ) {
			
		}
	}
}
