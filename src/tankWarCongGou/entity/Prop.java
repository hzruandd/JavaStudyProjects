package tankWarCongGou.entity;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.util.Random;

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
	
	private Image[] images = {
			Toolkit.getDefaultToolkit().createImage("image/prop/lifeProp.png"),
			Toolkit.getDefaultToolkit().createImage("image/prop/wallProp.png"),
			Toolkit.getDefaultToolkit().createImage("image/prop/bombProp.png")
	};
	
	public Prop(int symbol) {
		x = random.nextInt(700) + 50;
		y = random.nextInt(550) + 50;
		this.symbol = symbol;
	}
	
	public void draw(Graphics g) {
		g.drawImage(images[symbol], x, y, null);
	}
	
	public void function(MyTank myTank) {
		if (symbol==0) {
			myTank.setLife(myTank.getMAX_LIFE());
		}
	}

	public Rectangle getRect() {
		return new Rectangle(x, y, WIDTH, HEIGHT);
	}

}
