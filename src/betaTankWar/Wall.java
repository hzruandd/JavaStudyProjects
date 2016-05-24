package betaTankWar;
import java.awt.Graphics;
import java.awt.Rectangle;

/**
 * 墙类
 */

public class Wall {
	private int x;
	private int y;
	private int width;
	private int height;
	
	public Wall(int x, int y, int width, int height,MainView mv) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	public void draw(Graphics g) {
		g.fill3DRect(x, y, width, height, true);
	}
	
	public Rectangle getRec() {
		return new Rectangle(x, y, width, height);
	}
}
