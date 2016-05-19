package betaTankWar;
import java.awt.Color;
import java.awt.Graphics;

/**
 * 
 * @author Doctor邓
 * 爆炸类
 */
public class Explode {
	private int x;
	private int y;
	private boolean live = true;
	
	//爆炸圆的直径
	private int[] diameter = {4, 7, 12, 18, 26, 32, 49, 30, 14, 6};
	private int step =0; //记录子弹画到第几步了
	
	private MainView mv;
	
	public Explode(int x, int y, MainView mv) {
		this.x = x;
		this.y = y;
		this.mv = mv;
	}
	
	public void draw (Graphics g) {
		if (!live) {
			mv.explodes.remove(this);
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
}
