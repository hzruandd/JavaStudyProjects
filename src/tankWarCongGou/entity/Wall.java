package tankWarCongGou.entity;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

/**
 * 
 * @author Doctor邓
 * 墙类
 */
public class Wall {
	private int x;
	private int y;
	private final int WIDTH = 60;
	private final int HEIGHT = 40;
	
	public Wall() {
		
	}
	
	public Wall(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public void draw(Graphics g) {
		Color c = g.getColor();
		g.setColor(Color.WHITE);
		g.fillRect(x, y, WIDTH, HEIGHT);
		g.setColor(c);
	}
	
	/**
	 * 获得坦克在游戏中所在区域
	 * @return 坦克所占的游戏空间
	 */
	public Rectangle getRect() {
		return new Rectangle(x, y, WIDTH, HEIGHT);
	} 

}
