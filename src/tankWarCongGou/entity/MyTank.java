package tankWarCongGou.entity;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

public class MyTank extends Tank {

	private HPbar hpBar;
	
	public MyTank(int x, int y) {
		super();
		//初始化坦克的初始位置
		setX(x);
		setY(y);
	}
	
	@Override
	public void move() {
		// TODO 自动生成的方法存根
		setOldX(getX());
		setOldY(getY());
		
		//当坦克状态为可移动时，才能移动坦克
		if (isMotionStatus()) {
			//通过坦克方向来决定坦克的移动
			switch(getDir()) {
			case Up:
				setY(getY() - getSpeed());
				break;
			case Right:
				setX(getX() + getSpeed());
				break;
			case Down:
				setY(getY() + getSpeed());
				break;
			case Left:
				setX(getX() - getSpeed());
				break;
			}
		}
	}

	@Override
	public void fire() {
		// TODO 自动生成的方法存根

	}

	@Override
	public void draw(Graphics g) {
		// TODO 自动生成的方法存根
		//当坦克不存活时，直接退出
		if (!isLive()) {
			return ;
		} 
		
		Color c = g.getColor();
		g.setColor(Color.blue);
		g.fillRect(getX(), getY(), getWIDTH(), getHEIGHT());
		g.setColor(c);
		move();
		
	}
	
	class HPbar {
		
	}

}
