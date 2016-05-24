package betaTankWar;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.List;

/**
 * 
 * @author Doctor邓
 * 子弹类
 */
public class Bullets {
	private static final int SPEED = 6; //子弹的速度
	private int x;
	private int y;
	private boolean camp;
	
	public static final int RADIUS = 15;  //子弹的半径
	
	//控制子弹存活
	private boolean live = true;
	
	public boolean isLive() {
		return live;
	}

	Tank.Direction dir;
	private MainView mv;
	
	public Bullets(int x, int y, Tank.Direction dir) {
		this.x = x;
		this.y = y;
		this.dir = dir;
	}
	public Bullets(int x, int y, boolean camp, Tank.Direction dir, MainView mv) {
		this(x, y, dir);
		this.mv = mv;
		this.camp = camp;
	}
	
	//子弹画自己
	public void draw(Graphics g) {
		//当子弹没有存活时，把它从子弹箱中移除，并且退出不画它了。
		if (!live) {
			mv.bullets.remove(this);
			return;
		}
		if (camp) {
			//设置前景色
			g.setColor(Color.BLUE);
		}
		else {
			g.setColor(Color.lightGray);
		}
		//获取前景色
		Color c = g.getColor();
		//画一个实心圆
		g.fillOval(x, y, RADIUS, RADIUS);
		g.setColor(c);
		move(dir);
	}
	//子弹移动的方法
	void move(Tank.Direction dir) {
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
		default :
			x += SPEED;
			y += SPEED;
			break;
		}
		
		//检测子弹是否出界
		if (x < 0 || y<0 || x > MainView.viewWidth || y > MainView.viewHeight) {
			live = false;
			mv.bullets.remove(this);
		}
	}
	
	public Rectangle getRect() {
		return new Rectangle(x, y, RADIUS, RADIUS);
	}
	
	public boolean hitTank(Tank t) {
		if (this.live && this.getRect().intersects(t.getRect()) && t.isLive() && this.camp != t.isCamp()) {
			if (t.isCamp()) {
				t.setLife(t.getLife() - 20);
				if (t.getLife() <=0 ) {
					t.setLive(false);
				}
			}
			else {
				t.setLive(false);
			}
			this.live = false;
			//t.setLive(false);
			Explode explode = new Explode(x, y, mv);
			mv.explodes.add(explode);
			return true;
		}
		return false;
	}
	
	public boolean hitTanks(List<Tank> tanks) {
		for (int i=0; i<tanks.size(); i++) {
			if (hitTank(tanks.get(i))) {
				//tanks.remove(tanks.get(i));
				return true;
			}
		}
		return false;
	}

	public boolean hitWall(Wall wall) {
		if (this.live && this.getRect().intersects(wall.getRec())) {
			this.live = false;
			return true;
		}
		return false;
	}
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
}
