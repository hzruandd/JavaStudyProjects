package tankWarCongGou.view;

import java.awt.Color;
import java.awt.Graphics;
import java.util.List;

import javax.swing.JPanel;

import tankWarCongGou.entity.AITank;
import tankWarCongGou.entity.Boom;
import tankWarCongGou.entity.Bullet;
import tankWarCongGou.entity.MyTank;
import tankWarCongGou.entity.Prop;
import tankWarCongGou.entity.Wall;

public class GamePanel extends JPanel{
	//Panel坐标
	private final int X;
	private final int Y;
	private final int WIDTH = 800;
	private final int HEIGHT = 700;
	
	private List<MyTank> myTanks;       //我方坦克集合
	private List<AITank> aiTanks;       //AI坦克集合
	private List<Bullet> bullets;       //子弹集合
	private List<Prop> props;           //道具集合
	private List<Wall> walls;           //墙集合
	private List<Boom> booms;           //爆炸集合
	
	public GamePanel(List<MyTank> myTanks, List<Bullet> bullets, 
			         List<Prop> props, List<Wall> walls, List<Boom> booms) {
		X = 0;
		Y = 0;
		this.myTanks = myTanks;
		this.bullets = bullets;
		this.props = props;
		this.walls = walls;
		this.booms = booms;
		init();
	}
	
	//GamePanel初始化
	public void init() {
		setSize(WIDTH, HEIGHT);
		setLocation(X, Y);
		setBackground(Color.BLACK);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
    	update(g);
	}
	
	public void update(Graphics g) {
		g.setColor(Color.black);
		
	}
	
	
}
