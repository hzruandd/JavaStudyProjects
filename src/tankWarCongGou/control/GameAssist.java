package tankWarCongGou.control;

import tankWarCongGou.entity.Prop;

public class GameAssist extends Thread {
	private DataAdmin admin;
	
	public GameAssist(DataAdmin admin) {
		this.admin = admin;
	}
	
	@Override
	public void run() {
		while(true) {
			try {
				Thread.sleep(5000);
				if (admin.getProps().size()==0) {
					int x=400;
					int y=400;
					admin.addProp(new Prop(x, y, 0));
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
