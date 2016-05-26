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
	private final int SPEED = 8;
	private Direction dir = Direction.Down;
	
	public Bullet(int x, int y, boolean camp, Direction dir) {
		this.x = x;
		this.y = y;
		this.camp = camp;
		this.live = true;
		this.dir = dir;
	}
	
	public void move() {
		if (live) {
			switch(dir) {
			case Up:
				setY(y - SPEED);
				break;
			case Right:
				setX(x + SPEED);
				break;
			case Down:
				setY(y + SPEED);
				break;
			case Left:
				setX(x - SPEED);
				break;
			}
		}
	}
	
	public void draw(Graphics g) {
		
		if (!live) return;
		
		Color c = g.getColor();
		g.setColor(Color.green);
		g.fillRect(x, y, WIDTH, HEIGHT);
		g.setColor(c);
		move();
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public boolean isLive() {
		return live;
	}

	public void setLive(boolean live) {
		this.live = live;
	}

	public boolean isCamp() {
		return camp;
	}

	public void setCamp(boolean camp) {
		this.camp = camp;
	}

	public Direction getDir() {
		return dir;
	}

	public int getSPEED() {
		return SPEED;
	}

}
