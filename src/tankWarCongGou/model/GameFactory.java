package tankWarCongGou.model;

import java.util.ArrayList;
import java.util.List;
import tankWarCongGou.entity.MyTank;

/**
 * 
 * @author Administrator
 * 用于生成游戏的各个对象，例如：坦克，子弹，墙等。
 */
public class GameFactory {
	public  List<MyTank> getMyTanks(int volume) {
		List<MyTank> myTanks = new ArrayList<MyTank>();
		for (int i=0; i<volume; i++) {
			MyTank myTank = new MyTank(100,100);
			myTanks.add(myTank);
		} 
		return myTanks; 
	}
	
//	private 
}
