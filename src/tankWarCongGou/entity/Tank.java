package tankWarCongGou.entity;

import java.awt.Graphics;

import tankWarCongGou.control.GameListener;

/**
 * 
 * @author Doctor邓
 * 坦克的抽象类
 */
public abstract  class Tank {
	//坦克的速度
	private int speed;
	//坦克的x, y轴坐标
	private int x;
	private int y;
	//坦克的宽度和高度
	private final int WIDTH = 30;
	private final int HEIGHT = 30;
	//坦克在碰撞墙前的坐标
	private int oldX;
	private int oldY;
	//坦克的方向 
	private Direction dir;
	//坦克的运动状态,默认为false即不可移动状态，true为可移动状态
	private boolean motionStatus;
	//坦克的 存活标识,默认为true即为存活状态，false为死亡状态
	private boolean live;
	//坦克的阵营，true为我方阵营，false为敌方阵营
	private boolean camp;
	//坦克的子弹上限，决定了游戏最多能同时存在几个坦克发出的子弹
	private int bulletMax;
	
	//用于设置坦克具体方向的变量
	private boolean up;
	private boolean right;
	private boolean down;
	private boolean left;
	
	//坦克身上的监听器
	private GameListener gameListener;

	public Tank() {
		this.speed = 5;
		this.motionStatus = false;  
		this.live = true;
//		gameListener = new GameListener();
		up = true;
	}
	
	/**
	 * 坦克移动的方法
	 */
	public abstract void move();
	
	/**
	 * 坦克开火的方法
	 */
	public abstract void fire();
	
	/**
	 * 坦克画自己方法
	 */
	public abstract void draw(Graphics g);
	
	public abstract void hitWall();

	//设置坦克具体的方向
	public void setDirection () {
	
	}
	
	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
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

	public int getOldX() {
		return oldX;
	}

	public void setOldX(int oldX) {
		this.oldX = oldX;
	}

	public int getOldY() {
		return oldY;
	}

	public void setOldY(int oldY) {
		this.oldY = oldY;
	}

	public Direction getDir() {
		return dir;
	}

	public void setDir(Direction dir) {
		this.dir = dir;
	}

	public boolean isMotionStatus() {
		return motionStatus;
	}

	public void setMotionStatus(boolean motionStatus) {
		this.motionStatus = motionStatus;
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

	public int getWIDTH() {
		return WIDTH;
	}

	public int getHEIGHT() {
		return HEIGHT;
	}

	public int getBulletMax() {
		return bulletMax;
	}
	
	public GameListener getGameListener() {
		return gameListener;
	}

}
