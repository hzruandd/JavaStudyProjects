package tankWarCongGou.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

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
	
	public GamePanel(GamePaint gamePaint) {
		X = 0;
		Y = 0;
		this.gamePaint = gamePaint;
		init();
	}
	
	/**
	 * GamePanel初始化
	 */
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
