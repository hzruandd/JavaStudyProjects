package tankWarCongGou.view;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import tankWarCongGou.control.GamePaint;
import tankWarCongGou.control.GameRepaint;

public class GamePanel extends JPanel{
	//Panel坐标
	private final int X;
	private final int Y;
	public  static final int WIDTH = 800;
	public  static final int HEIGHT = GameFrame.GameHeight;
	private GamePaint gamePaint;
	
//	private List<MyTank> myTanks;       //我方坦克集合
//	private List<AITank> aiTanks;       //AI坦克集合
//	private List<Bullet> bullets;       //子弹集合
//	private List<Prop> props;           //道具集合
//	private List<Wall> walls;           //墙集合
//	private List<Boom> booms;           //爆炸集合
	
	public GamePanel() {
		X = 0;
		Y = 0;
		gamePaint = new GamePaint();
//		this.myTanks = myTanks;
//		this.bullets = bullets;
//		this.props = props;
//		this.walls = walls;
//		this.booms = booms;
		init();
	}
	
	//GamePanel初始化
	public void init() {
		setSize(WIDTH, HEIGHT);
		setLocation(X, Y);
		setBackground(Color.BLACK);
		new Thread(new GameRepaint(this)).start();
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
    	update(g);
	}
	
	public void update(Graphics g) {
		g.setColor(Color.black);
		gamePaint.draw(g);
		
	}

//	public List<MyTank> getMyTanks() {
//		return myTanks;
//	}
//
//	public void setMyTanks(List<MyTank> myTanks) {
//		this.myTanks = myTanks;
//	}
//
//	public List<AITank> getAiTanks() {
//		return aiTanks;
//	}
//
//	public void setAiTanks(List<AITank> aiTanks) {
//		this.aiTanks = aiTanks;
//	}
//
//	public List<Bullet> getBullets() {
//		return bullets;
//	}
//
//	public void setBullets(List<Bullet> bullets) {
//		this.bullets = bullets;
//	}
//
//	public List<Prop> getProps() {
//		return props;
//	}
//
//	public void setProps(List<Prop> props) {
//		this.props = props;
//	}
//
//	public List<Wall> getWalls() {
//		return walls;
//	}
//
//	public void setWalls(List<Wall> walls) {
//		this.walls = walls;
//	}
//
//	public List<Boom> getBooms() {
//		return booms;
//	}
//
//	public void setBooms(List<Boom> booms) {
//		this.booms = booms;
//	}
	
	
}
