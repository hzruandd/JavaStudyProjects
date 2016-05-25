package betaTankWar;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.Random;


/**
 * 
 * @author Doctor邓
 * 坦克类
 */
public class Tank {
	public static final int SPEED = 3;//坦克的速度
	
	private int x;  //坦克的X轴坐标(不是中心坐标)
	private int y;  //坦克的Y轴坐标
	private int radius = 30; //圆的直径
	private int oldX;   //坦克撞墙前的坐标
	private int oldY;   
	private int life = 100;
	private BloodBar bloodBar = new BloodBar();
	
	public int getLife() {
		return life;
	}
	public void setLife(int life) {
		this.life = life;
	}

	private boolean bL = false, bU = false, bR = false, bD = false;
	enum Direction {L, LU, U, RU, R, RD, D, LD, STOP};
	private Direction dir = Direction.STOP;
	//坦克炮筒的方向
	private Direction ptDir = Direction.D;
	
	//坦克存活标识
	private boolean live = true;
	MainView mv;
	
	//坦克的 子弹对象
	Bullets bullet = null;
	
	//标明坦克的阵营 camp:阵营
	private boolean camp;
	
	public boolean isCamp() {
		return camp;
	}
	
	//随机数产生器
	public static Random random = new Random();

	//用于存储每次改变方向最少移动敌方坦克移动步数
	private int step = random.nextInt(12) + 3;
	
	public Tank(int x, int y, boolean camp) {
		this.x = x;
		this.y = y;
		this.oldX = x;
		this.oldY = y;
		this.camp = camp;
	}
	public Tank(int x, int y, boolean camp,Direction dir, MainView mv) {
		this(x, y, camp);
		this.mv = mv;
		this.dir = dir;
	}
	
	
	//坦克移动方法，通过方向来移动
	void move() {
		
		this.oldX = x;
		this.oldY = y;
		
		switch(dir) {
		case L:
			x -= SPEED;
			break;
		case LU:
			x -= SPEED;
			y -= SPEED;
			break;
		case U:
			y -= SPEED;
			break;
		case RU:
			x += SPEED;
			y -= SPEED;
			break;
		case R:
			x += SPEED;
			break;
		case RD:
			x += SPEED;
			y += SPEED;
			break;
		case D:
			y += SPEED;
			break;
		case LD:
			x -= SPEED;
			y += SPEED;
			break;
		case STOP:
			break;
		}
		
		if ( x < 0) x = 0;
		if ( y < radius) y = radius;
		if (x + radius > MainView.viewWidth) x = MainView.viewWidth - radius;
		if (y + radius > MainView.viewHeight) y = MainView.viewHeight -radius;
		
		if (!camp) {
			Direction[] dirs = Direction.values();
			if (step == 0) {
				step = random.nextInt(12) + 3;
				int rn = random.nextInt(dirs.length);
				dir = dirs[rn];
			}
			step --;
			if (random.nextInt(100) < 3) {
				this.fire();
			}
		}
	}
	
	//坦克自己画自己
	public void draw(Graphics g) {
        //坦克如果不存活，则直接退出，不画自己
		if (!live) {
			if (!camp) {
				mv.tanks.remove(this);
			}
			return;
		}
		//获取前景色
		Color c = g.getColor();
		if (camp){
			//设置前景色
			g.setColor(Color.blue);
			//画出血条
			bloodBar.draw(g);
		} 
		else{
			g.setColor(Color.MAGENTA);
		}
		//画一个实心圆
		g.fillOval(x, y, radius, radius);
		g.setColor(c);
		
		move();
		
		//化炮筒的方向
		switch(ptDir) {
		case L:
			g.drawLine(x + radius/2, y + radius/2, x, y + radius/2);
			break;
		case LU:
			g.drawLine(x + radius/2, y + radius/2, x, y);
			break;
		case U:
			g.drawLine(x + radius/2, y + radius/2, x + radius/2, y);
			break;
		case RU:
			g.drawLine(x + radius/2, y + radius/2, x + radius, y);
			break;
		case R:
			g.drawLine(x + radius/2, y + radius/2, x + radius, y + radius/2);
			break;
		case RD:
			g.drawLine(x + radius/2, y + radius/2, x + radius, y + radius);
			break;
		case D:
			g.drawLine(x + radius/2, y + radius/2, x + radius/2, y + radius);
			break;
		case LD:
			g.drawLine(x + radius/2, y + radius/2, x, y + radius);
			break;
		case STOP:
			break;
		}
		if (this.dir != Direction.STOP) {
			this.ptDir = dir;
		}
		
	}
	
	public void keyPressed(KeyEvent e) {
			switch(e.getKeyCode()) {
			
			case KeyEvent.VK_UP:
				bU = true; 
				//bD = false;
				break;
			case KeyEvent.VK_DOWN:
				bD = true;
				//bU = false;
				break;
			case KeyEvent.VK_LEFT:
				bL = true;
				//bR = false;
				break;
			case KeyEvent.VK_RIGHT:
				bR = true;
				//bL = false;
				break;
			}
			//重新定位坦克的方向
			locateDirection();
	}
	
	//设置坦克具体的方向
	void locateDirection () {
		if (bL && !bU && !bR && !bD) dir = Direction.L;
		else if (bL && bU && !bR && !bD) dir = Direction.LU;
		else if (!bL && bU && !bR && !bD) dir = Direction.U;
		else if (!bL && bU && bR && !bD) dir = Direction.RU;
		else if (!bL && !bU && bR && !bD) dir = Direction.R;
		else if (!bL && !bU && bR && bD) dir = Direction.RD;
		else if (!bL && !bU && !bR && bD) dir = Direction.D;
		else if (bL && !bU && !bR && bD) dir = Direction.LD;
		else if (!bL && !bU && !bR && !bD) dir = Direction.STOP;
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
	
	//对键盘的按键按下而被释放后处理的方法
	public void keyReleased(KeyEvent e) {
		// TODO 自动生成的方法存根
		switch(e.getKeyCode()) {
		
		case KeyEvent.VK_UP:
			bU = false;
			break;
		case KeyEvent.VK_DOWN:
			bD = false;
			break;
		case KeyEvent.VK_LEFT:
			bL = false;
			break;
		case KeyEvent.VK_RIGHT:
			bR = false;
			break;
		case KeyEvent.VK_F2:
			if (!this.live) {
				this.live = true;
				this.life = 100;
			} 
			
			break;
		//抬起空格键发一发炮弹，这样就不会按着空格键一直发炮弹。
		case KeyEvent.VK_SPACE:
//			//当子弹存在时，不在打子弹
//			if (mv.bullet == null) {
//				mv.bullet = fire();
//			}	
			fire();
			break;
		case KeyEvent.VK_R:
			superFire();
			break;
		}
	}
	
	//打出一发子弹
	public Bullets fire() {
		if (!live) {
			return null;
		}
		//将子弹的设置为坦克的圆心
		int x = this.x + radius/2 - Bullets.RADIUS/2;
		int y = this.y + radius/2 - Bullets.RADIUS/2;
		bullet = new Bullets(x , y, camp, ptDir, this.mv);
		mv.bullets.add(bullet);
		return bullet;
	}
	
	//坦克开火，
	public Bullets fire(Direction dir) {
		if (!live) {
			return null;
		}
		//将子弹的设置为坦克的圆心
		int x = this.x + radius/2 - Bullets.RADIUS/2;
		int y = this.y + radius/2 - Bullets.RADIUS/2;
		bullet = new Bullets(x , y, camp, dir, this.mv);
		mv.bullets.add(bullet);
		return bullet;
	}
	
	private void stay() {
		x = oldX;
		y = oldY;
	}
	
	/**
	 * 
	 * @param wall ：被坦克撞的墙
	 * @return 坦克是否撞到墙，撞到了返回ture
	 */
	//判断坦克是否撞到墙了
	public boolean impactWall(Wall wall) {
		if (this.live && this.getRect().intersects(wall.getRec())) {
			this.stay();
			return true;
		}
		return false;
	}
	
	//判断坦克是否撞到坦克
	public boolean impactTanks(List<Tank> tanks) {
		for (int i=0; i<tanks.size(); i++) {
			Tank tank = tanks.get(i);
			if (this != tank) {
				if (this.live && tank.isLive() &&this.getRect().intersects(tank.getRect())) {
					this.stay();
					tank.stay();
					return true;
				}
			}
		}
		return false;
	}
	
	//自己坦克作弊方法，发射大的子弹
	private void superFire() {
		Direction[] dirs = Direction.values();
		for (int i=0; i<8; i++) {
			fire(dirs[i]);
		}
	}
	public boolean isLive() {
		return live;
	}
	public void setLive(boolean live) {
		this.live = live;
	}
	
	public Rectangle getRect() {
		return new Rectangle(x, y, radius, radius);
	}
	
	//坦克的血条类
	private class BloodBar {
		public void draw(Graphics g) {
			Color c = g.getColor();
			g.setColor(Color.RED);
			g.drawRect(x, y-10, radius, 10);
			int width = radius * life /100;
			g.fillRect(x, y-10, width, 10);
			g.setColor(c);
		}
	}
	
	//坦克吃血的方法
	public boolean eat(Blood blood) {
		if (this.live && blood.isLive() && this.getRect().intersects(blood.getRect())) {
			blood.setLive(false);
			this.life = 100;
			return true;
		}
		return false;
	}
	
}
