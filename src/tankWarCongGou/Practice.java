package tankWarCongGou;

import tankWarCongGou.control.DataAdmin;
import tankWarCongGou.control.GameListener;
import tankWarCongGou.entity.AITank;
import tankWarCongGou.entity.MyTank;

public class Practice {
	public static void main(String[] args) {
	DataAdmin admin = new DataAdmin();
	GameListener listener = new GameListener(admin);
	AITank aiTank = new AITank();
	MyTank myTank = new MyTank(1,1);
	System.out.println(listener);
	aiTank.setGameListener(listener);
	System.out.println(aiTank.getGameListener());
	myTank.setGameListener(listener);
	System.out.println(myTank.getGameListener());
	}
}
