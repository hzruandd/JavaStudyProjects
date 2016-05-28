package tankWarCongGou.entity;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

import tankWarCongGou.control.GameListener;
import tankWarCongGou.view.GamePanel;

public class MyTank extends Tank {

	private HPbar hpBar;
	
	public MyTank(int x, int y) {
		//super(listener);
		//初始化坦克的初始位置
		setX(x);
		setY(y);
		setCamp(true);
		setDir(Direction.Up);
	}

	@Override
	public void draw(Graphics g) {
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

//	@Override
//	public void hitWall() {
//
//		if (getX() < 0) {
//			setX(0);
//		}
//		
//		if (getX() + getWIDTH() > GamePanel.WIDTH) {
//			setX(GamePanel.WIDTH - getWIDTH());
//		}
//		
//		if (getY() < 0) {
//			setY(0);
//		} 
//		
//		if (getY() + 2*getHEIGHT()> GamePanel.HEIGHT) {
//			setY(GamePanel.HEIGHT - 2*getHEIGHT());
//		}
//	}
}
