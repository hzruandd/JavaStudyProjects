package tankWarCongGou.control;

import java.util.List;

import tankWarCongGou.entity.AITank;
import tankWarCongGou.entity.Boom;
import tankWarCongGou.entity.Bullet;
import tankWarCongGou.entity.MyTank;
import tankWarCongGou.entity.Prop;
import tankWarCongGou.entity.Wall;
import tankWarCongGou.model.GameData;
/**
 * 
 * @author Doctor邓
 * 用于对Model中的存放游戏数据的GameData实现增、删、改、查的工作。
 */
public class DataAdmin {
	private GameData gameData;
	
	public DataAdmin() {
		gameData = new GameData();
	}
	
	public void addBullet(Bullet bullet) {
		gameData.getBullets().add(bullet);
	}
	
	public List<Bullet> getBullets() {
		return gameData.getBullets();
	}
	
	public void removeBullet(Bullet bullet) {
		if (gameData.getBullets().contains(bullet)) {
			gameData.getBullets().remove(bullet);
		}
	}
	
	public void addMyTank(MyTank myTank) {
		gameData.getMyTanks().add(myTank);
	}
	
	public List<MyTank> getMyTanks() {
		return gameData.getMyTanks();
	} 
	
	public void removeMyTank(MyTank myTank) {
		if (gameData.getMyTanks().contains(myTank)) {
			gameData.getMyTanks().remove(myTank);
		}
	}
	
	public void setMyTanks(List<MyTank> myTanks) {
		gameData.setMyTanks(myTanks);
	}
	
	public List<AITank> getAITanks() {
		return gameData.getAiTanks();
	}
	
	public void setAITanks(List<AITank> aiTanks)  {
		gameData.setAiTanks(aiTanks);
	}
	
	public void addAITank(AITank aiTank) {
		gameData.getAiTanks().add(aiTank);
	}
	
	public void dataAddListener(GameListener listener) {
		for (int i=0; i<getMyTanks().size(); i++) {
			getMyTanks().get(i).setGameListener(listener);
		}
//		for (int i=0; i<getAITanks().size(); i++) {
//			getAITanks().get(i).setGameListener(listener);
//		}
	}

	public void addBoom(Boom boom) {
		gameData.getBooms().add(boom);
	}
	
	public void removeBoom(Boom boom) {
		if (gameData.getBooms().contains(boom)) {
			gameData.getBooms().remove(boom);
		}
	}
	
	public List<Boom> getBooms() {
		return gameData.getBooms();
	}
	
	public List<Wall> getWalls() {
		return gameData.getWalls();
	}
	
	public void setWalls(List<Wall> walls) {
		gameData.setWalls(walls);
	}
	
    public void addProp(Prop prop) {
    	gameData.getProps().add(prop);
    }
    
    public List<Prop> getProps() {
    	return gameData.getProps();
    }
	
}
