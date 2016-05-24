package betaTankWar;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

/**
 * 
 * @author Doctor邓
 *	血类，坦克吃了会增加血量
 */
public class Blood {
	private int x;
	private int y;
	private int width;
	private int height;
	private MainView mv;
	private int step = 0;
	private boolean live = true;
	
	public Blood() {
		x = bloodXY[0][0];
		y = bloodXY[0][1];
		width = height = 30;
	}
	
	private int[][] bloodXY= {
			{240,250},
			{243,250},
			{246,250},
			{249,250},
			{252,250},
			{252,247},
			{245,243},
			{248,246},
			{248,249},
			{245,246},
			{242,246},
			{243,250},
	};
	
	public void draw(Graphics g) {
		if (!live) return;
		Color c = g.getColor();
		g.setColor(Color.darkGray);
		g.fillRect(x, y, width, height);
		g.setColor(c);
		move();
	}
	
	public boolean isLive() {
		return live;
	}

	public void setLive(boolean live) {
		this.live = live;
	}

	public void move() {
		step++;
		if(step == bloodXY.length) {
			step = 0;
		}
		x = bloodXY[step][0];
		y = bloodXY[step][1];
	}
	
	public Rectangle getRect() {
		return new  Rectangle(x, y, width, height);
	}
}
