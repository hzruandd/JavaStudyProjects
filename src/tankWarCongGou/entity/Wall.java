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
	/**
	 * 墙的护甲
	 */
	private int armor;
	private Image image = Toolkit.getDefaultToolkit().getImage("image/wall.png");
	Image[] images = {
			Toolkit.getDefaultToolkit().getImage("image/wall/wall.png"),
		    Toolkit.getDefaultToolkit().getImage("image/wall/wallWhite.png")
	};
	public Wall() {
		wallMark=0;      //墙默认为红墙
		setArmor(0);    //墙的护甲默认为0
	}
	
	public Wall(int x, int y, int wallMark) {
		this.x = x;
		this.y = y;
		this.wallMark = wallMark;
		setArmor(wallMark);
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

	public int getArmor() {
		return armor;
	}

	public void setArmor(int armor) {
		this.armor = armor;
	} 

}
