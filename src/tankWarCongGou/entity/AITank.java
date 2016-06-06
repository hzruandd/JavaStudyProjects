package tankWarCongGou.entity;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.Random;

import javax.swing.ImageIcon;

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
	/**
	 * 用来表示为何种AI坦克的标识
	 */
	private int symbol;
	
	private final Image UP = Toolkit.getDefaultToolkit().createImage("image/aiTankUp.gif");
	private final Image LEFT = Toolkit.getDefaultToolkit().createImage("image/aiTankLeft.gif");
	private final Image DOWN = Toolkit.getDefaultToolkit().createImage("image/aiTankDown.gif");
	private final Image RIGHT = Toolkit.getDefaultToolkit().createImage("image/aiTankRight.gif");
	private final Image[][] imags = {
			{Toolkit.getDefaultToolkit().createImage("image/aiTank/aiTank1Up.gif"),
				Toolkit.getDefaultToolkit().createImage("image/aiTank/aiTank1Down.gif"),
				Toolkit.getDefaultToolkit().createImage("image/aiTank/aiTank1Left.gif"),
				Toolkit.getDefaultToolkit().createImage("image/aiTank/aiTank1Right.gif")
			},
			{Toolkit.getDefaultToolkit().createImage("image/aiTank/aiTank2Up.gif"),
				Toolkit.getDefaultToolkit().createImage("image/aiTank/aiTank2Down.gif"),
				Toolkit.getDefaultToolkit().createImage("image/aiTank/aiTank2Left.gif"),
				Toolkit.getDefaultToolkit().createImage("image/aiTank/aiTank2Right.gif")
			},
			{Toolkit.getDefaultToolkit().createImage("image/aiTank/aiTankRight.gif"),
				Toolkit.getDefaultToolkit().createImage("image/aiTank/aiTankRight.gif"),
				Toolkit.getDefaultToolkit().createImage("image/aiTank/aiTankRight.gif"),
				Toolkit.getDefaultToolkit().createImage("image/aiTank/aiTankRight.gif")
			}
	};
	
	public AITank() {
		
	}
	public AITank(int x, int y) {
		super();
		setX(x);
		setY(y);
		setCamp(false);
		setMotionStatus(true);
		setDir(Direction.Down);
		setSpeed(3);
		symbol = random.nextInt(3);
	}
	
	@Override
	public void draw(Graphics g) {
		
		g.drawImage(selectImage(), getX(), getY(),  null);
		move();
		aiMove();
		aiFire();
	}
	
	public Image selectImage(){
		switch(getDir()) {
		case Up: 
			return UP;
		case Down: 
			return DOWN;
		case Left: 
			return LEFT;
		case Right: 
			return RIGHT;
		default:
			return UP;
		}
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
			fire();
		}
	}
}
