package tankWarCongGou.entity;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.util.List;
import java.util.Random;

import tankWarCongGou.control.DataAdmin;
import tankWarCongGou.model.GameFactory;

/**
 * 
 * @author Doctor邓
 * 道具类
 */
public class Prop {
	
	private final int WIDTH = 30;
	private final int HEIGHT = 30;
	private int x;
	private int y;
	private int symbol;
	private Random random = new Random();
	private DataAdmin admin;
	
	private Image[] images = {
			Toolkit.getDefaultToolkit().createImage("image/prop/lifeProp.png"),
			Toolkit.getDefaultToolkit().createImage("image/prop/wallProp.png"),
			Toolkit.getDefaultToolkit().createImage("image/prop/bombProp.png")
	};
	
	public Prop(DataAdmin admin) {
		this.admin = admin;
		x = random.nextInt(700) + 50;
		y = random.nextInt(550) + 50;
//		this.symbol = 1;
		this.symbol = random.nextInt(3);
	}
	
	public void draw(Graphics g) {
		g.drawImage(images[symbol], x, y, null);
	}
	
	public void function(MyTank myTank) {
		if (symbol==0) {
			myTank.setLife(myTank.getMAX_LIFE());
		}
		if (symbol==1) {
			int[][] whiteHomeMap = new GameMap().getWhiteHomeMap();
			List<Wall> wallList = new GameFactory().getWalls(whiteHomeMap);
			admin.getWalls().addAll(wallList);
		}
		if (symbol ==2) {
			/**
			 * 所有ai坦克发生爆炸
			 */
			 for(int i=0; i<admin.getAITanks().size(); i++) {
				 admin.getAITanks().get(i).boom();
			 }
			 /**
			  * 清空所有ai坦克
			  */
			 admin.getAITanks().clear();
		}
	}

	public Rectangle getRect() {
		return new Rectangle(x, y, WIDTH, HEIGHT);
	}

}
