package tankWarCongGou.view;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import tankWarCongGou.entity.MyTank;

public class GamePanel extends JPanel{
	//窗体坐标
	private final int X;
	private final int Y;
	private final int WIDTH = 800;
	private final int HEIGHT = 700;
	private MyTank myTank = new MyTank();
	public GamePanel() {
		X = 0;
		Y = 0;
		init();
	}
	
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
		myTank.draw(g);
	}
	
	
}
