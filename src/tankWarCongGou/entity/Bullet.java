package tankWarCongGou.entity;

import java.awt.Color;
import java.awt.Graphics;

/**
 * 
 * @author Doctor邓
 * 子弹类
 */
public class Bullet {
	private int x;
	private int y;
	private final int WIDTH = 10;
	private final int HEIGHT = 10;
	private boolean live;
	private boolean camp;
	
	public Bullet(int x, int y, boolean camp) {
		this.x = x;
		this.y = y;
		this.camp = camp;
		this.live = true;
	}
	
	public void draw(Graphics g) {
		//当坦克的状态为死亡时，不画出坦克
		if (!live) return;
		
		Color c = g.getColor();
		g.setColor(Color.green);
		g.fillRect(x, y, WIDTH, HEIGHT);
		g.setColor(c);
	}

}
