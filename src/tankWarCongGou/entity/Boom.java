package tankWarCongGou.entity;

import java.awt.Color;
import java.awt.Graphics;

import tankWarCongGou.control.GameListener;

/**
 * 
 * @author Doctor邓
 * 爆炸类
 */
public class Boom {
	private int x;
	private int y;
	private boolean live = true;
	private GameListener listener;
	
	//爆炸圆的直径
	private int[] diameter = {4, 7, 12, 18, 26, 32, 49, 30, 14, 6};
	private int step =0; //记录子弹画到第几步了
	
	public Boom(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public void draw(Graphics g) {
		// TODO 自动生成的方法存根
		if (!live) {
			listener.boomEnd(this);
			return;
		}
		if (step == diameter.length) {
			live = false;
			step = 0;
			return;
		}
		Color c = g.getColor();
		g.setColor(Color.ORANGE);
		g.fillOval(x, y, diameter[step], diameter[step]);
		g.setColor(c);
		step ++;
	}

	public void setListener(GameListener listener) {
		this.listener = listener;
	}

}
