package tankWarCongGou.control;

import tankWarCongGou.entity.Bullet;
import tankWarCongGou.model.GameData;
/**
 * 
 * @author Doctor邓
 * 用于对Model中的存放游戏数据的GameData实现增、删、改、查的工作。
 */
public class DataAdmin {
	private GameData gameData;
	
	public void addBullet(Bullet bullet) {
		gameData.getBullets().add(bullet);
	}
}
