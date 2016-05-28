package tankWarCongGou.entity;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import tankWarCongGou.control.GameListener;

public class AITank extends Tank {
	private GameListener listener;
	
	//随机数产生器
	public static Random random = new Random();
	//用于存储每次改变方向最少移动敌方坦克移动步数
	private int step = random.nextInt(12) + 3;
	//AI坦克每次移动步数的范围限制
	private final int MINSTEP = 3;
	private final int MAXSTEP = 20;
	
	public AITank(int x, int y) {
		super();
		setX(x);
		setY(y);
		setCamp(false);
		setMotionStatus(true);
		setDir(Direction.Down);
	}
	
	@Override
	public void draw(Graphics g) {
		//获取前景色
		Color c = g.getColor();
		g.setColor(Color.MAGENTA);
		g.fillOval(getX(), getY(), getWIDTH(), getHEIGHT());
		g.setColor(c);
		move();
		aiMove();
		aiFire();
	}

	/**
	 * 自动为坦克随机生成移动路径
	 */
	public void aiMove() {
			Direction[] dirs = Direction.values();
			if (step == 0) {
				step = random.nextInt(MAXSTEP - MINSTEP) + MINSTEP;
				int rn = random.nextInt(dirs.length);
				setDir(dirs[rn]);
				if (random.nextInt(20) < 3) {
					setMotionStatus(false);
				}
				else {
					setMotionStatus(true);
				}
			}
			step--;
	}
	
	/**
	 * 自动为坦克随机开火
	 */
	public void aiFire() {
		if (random.nextInt(100) < 5) {
			this.fire();
		}
	}


	public void setListener(GameListener listener) {
		this.listener = listener;
	}
}
