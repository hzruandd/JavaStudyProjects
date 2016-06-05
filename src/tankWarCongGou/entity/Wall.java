package tankWarCongGou.entity;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;

/**
 * 
 * @author Doctor邓
 * 墙类
 */
public class Wall {
	private int x;
	private int y;
	private final int WIDTH = 50;
	private final int HEIGHT = 50;
	private int wallMark;
	private Image image = Toolkit.getDefaultToolkit().getImage("image/wall.png");
	Image[] images = {
			Toolkit.getDefaultToolkit().getImage("image/wall.png"),
		    Toolkit.getDefaultToolkit().getImage("image/wallWhite.png")
	};
	public Wall() {
		wallMark=0; //墙默认为红墙
	}
	
	public Wall(int x, int y, int wallMark) {
		this.x = x;
		this.y = y;
		this.wallMark = wallMark;
	}
	public void draw(Graphics g) {
		g.drawImage(images[wallMark], x, y, WIDTH, HEIGHT,	null);
	}
	
	/**
	 * 获得坦克在游戏中所在区域
	 * @return 坦克所占的游戏空间
	 */
	public Rectangle getRect() {
		return new Rectangle(x, y, WIDTH, HEIGHT);
	}

	public void setWallMark(int wallMark) {
		this.wallMark = wallMark;
	} 

}
