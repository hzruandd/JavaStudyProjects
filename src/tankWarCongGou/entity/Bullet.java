package tankWarCongGou.entity;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;

import tankWar.gameView.GamePanel;
import tankWarCongGou.control.GameListener;

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
	private final int SPEED = 10;
	private Direction dir;
	
	private GameListener listener;
	private Image redWall = Toolkit.getDefaultToolkit().getImage("image/bullet.png");
	
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
		
		g.drawImage(redWall, getX(), getY(), WIDTH, HEIGHT, null);
		move();
		overBorder();
	}
	
	/**
	 * 判断子弹是否出界，出界则告诉监听器
	 */
	public void overBorder() {
		if (x > tankWarCongGou.view.GamePanel.WIDTH | x < 0 | y < 0 | 
				y >  tankWarCongGou.view.GamePanel.HEIGHT) {
			listener.bulletOverBorder(this);
		} 
	}
	
	public void bulletBoom() {
		int boomX = x + WIDTH;
		int boomY = y + HEIGHT;
		listener.boomAction(boomX, boomY);
	}
	
	/**
	 * 获得子弹游戏中的所占空间
	 * @return
	 */
	public Rectangle getRect() {
		return new Rectangle(x, y, WIDTH, HEIGHT);
	}
	
	public void setListener(GameListener listener) {
		this.listener = listener;
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
