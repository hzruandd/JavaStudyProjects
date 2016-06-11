package tankWarCongGou.entity;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.Random;

import javax.swing.ImageIcon;

import tankWarCongGou.control.GameListener;
import tankWarCongGou.view.GamePanel;

public class AITank extends Tank {
	
	//随机数产生器
	public static Random random = new Random();
	//用于存储每次改变方向最少移动敌方坦克移动步数
	private int step = random.nextInt(12) + 3;
	//AI坦克每次移动步数的范围限制
	private final int MINSTEP = 3;
	private final int MAXSTEP = 20;
	/**
	 * 坦克的生命值
	 */
	private int life;
	/**
	 * 用来表示为何种AI坦克的标识
	 */
	private int symbol;
	/**
	 * 表示AI坦克是否可以进行正常开火的标识
	 */
	private boolean stopStatus;
	private final Image[][] images = {
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
			{Toolkit.getDefaultToolkit().createImage("image/aiTank/aiTank3Up.gif"),
				Toolkit.getDefaultToolkit().createImage("image/aiTank/aiTank3Down.gif"),
				Toolkit.getDefaultToolkit().createImage("image/aiTank/aiTank3Left.gif"),
				Toolkit.getDefaultToolkit().createImage("image/aiTank/aiTank3Right.gif")
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
		symbol = random.nextInt(images.length);
		stopStatus = true;
		dataInitBySymbol(symbol);
	}
	/**
	 * 通过AI坦克的标识（所属种类），来对AI坦克的数据进行初始化
	 * @param symbol
	 */
	public void dataInitBySymbol(int symbol) {
		switch (symbol) {
		case 0:
			life = 2;
			setSpeed(3);
			break;
		case 1:
			life = 3;
			setSpeed(1);
			setDps(2);
			break;
		case 2:
			life = 1;
			setSpeed(4);
			setBulletMax(2);
			break;
		}
	}
	
	
	@Override
	public void draw(Graphics g) {
		g.drawImage(selectImage(), getX(), getY(),  null);
		/**
		 * 当坦克的移动开火状态为true时，AI坦克才可以移动和开火
		 */
		if (stopStatus) {
			move();
			aiMove();
			aiFire();
			if (symbol == 2) {
				aiFire();
			}
		}
	}
	
	public Image selectImage(){
		switch(getDir()) {
		case Up: 
			return images[symbol][0];
		case Down: 
			return images[symbol][1];
		case Left: 
			return images[symbol][2];
		case Right: 
			return images[symbol][3];
		default:
			return images[symbol][0];
		}
	}

	/**
	 * 自动为坦克随机生成移动路径
	 */
	public void aiMove() {
			Direction[] dirs = Direction.values();
			if (step == 0) {
				step = random.nextInt(MAXSTEP - MINSTEP) + MINSTEP;
				/**
				 * 随机设定坦克方向
				 */
				int i = random.nextInt(6);
				if (i <3) {
					setDir(Direction.Down);
				} else if (i ==3) {
					setDir(Direction.Up);
				} else if (i ==4) {
					setDir(Direction.Left);
				} else if (i == 5) {
					setDir(Direction.Right);
				} 
				
				if (getY() >= GamePanel.HEIGHT - 20 - GameHome.HEIGHT - 20) {
					int j = getX() - GamePanel.WIDTH/2;
					if (j <= 0) {
						int m = random.nextInt(6);
						if (i <3) {
							setDir(Direction.Right);
						} else if (i ==3) {
							setDir(Direction.Up);
						} else if (i ==4) {
							setDir(Direction.Left);
						} else if (i == 5) {
							setDir(Direction.Down);
						} 
					}
					if (j > 0) {
						int m = random.nextInt(6);
						if (i <3) {
							setDir(Direction.Left);
						} else if (i ==3) {
							setDir(Direction.Up);
						} else if (i ==4) {
							setDir(Direction.Right);
						} else if (i == 5) {
							setDir(Direction.Down);
						} 
					}
				}
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
		if (getY() >= GamePanel.HEIGHT - 20 - GameHome.HEIGHT) {
			if (random.nextInt(10) < 5) {
				fire();
			}
		} else {
			if (random.nextInt(100) < 4) {
				fire();
			}
		}
	}
	
	/**
	 * 坦克自己爆炸
	 */
	public void boom() {
		getGameListener().boomAction(getX(), getY());
	}
	public boolean isStopStatus() {
		return stopStatus;
	}
	public void setStopStatus(boolean stopStatus) {
		this.stopStatus = stopStatus;
	}
	public int getLife() {
		return life;
	}
	public void setLife(int life) {
		this.life = life;
	}
}
