package betaTankWar;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

public class MainView extends Frame {
	private static final long serialVersionUID = 5248857607736720286L;

    public static final int viewHeight = 600;
	public static final int viewWidth = 800;
	private final String viewName = "坦克大战";             //窗体名字
    private final int view_x;
    private final int view_y;
	private final int SCREEN_WIDTH = Toolkit.getDefaultToolkit().getScreenSize().width;
	private final int SCREEN_HEIGHT = Toolkit.getDefaultToolkit().getScreenSize().height;
	//坦克的位置
	int x = 50;
	int y = 50;
	private Blood blood = new Blood();
	
	//双缓冲引用图片
    Image offScreenImage = null;
    
    //坦克
    Tank myTank = new Tank(50, 50, true,Tank.Direction.STOP, this);
    //Tank enemyTank = new Tank(100, 100, false, this);
    //子弹
    Bullets bullet = null;
    //用于存放子弹的集合
  	List<Bullets> bullets = new ArrayList<Bullets>();
  	List<Explode> explodes = new ArrayList<Explode>();
  	List<Tank> tanks = new ArrayList<Tank>();
  	
  	Wall w1 = new Wall(100, 200, 20, 150, this);
  	Wall w2 = new Wall(300, 100, 300, 20, this);
  	
	public MainView() {
		view_x = (SCREEN_WIDTH - viewWidth)/2;
		view_y = (SCREEN_HEIGHT - viewHeight)/2;
	    for (int i=0; i<5; i++) {
	    	tanks.add(new Tank(50 + Tank.random.nextInt(viewWidth - 50), 50 + Tank.random.nextInt(viewHeight - 50), false,Tank.Direction.D, this));
	    }
	}
	
	public void paint(Graphics g) {
		if (tanks.size() <=0) {
			for (int i=0; i<5; i++) {
		    	tanks.add(new Tank(50 + Tank.random.nextInt(viewWidth - 50), 50 + Tank.random.nextInt(viewHeight - 50), false,Tank.Direction.D, this));
		    }
		}
		
		/**
		 * 动态显示游戏的数据
		 */
		g.drawString("子弹的数量: " + bullets.size(), 10,	50);
		g.drawString("爆炸的数量:" + explodes.size(), 10, 70);
		g.drawString("敌方坦克的数量: " + tanks.size(), 10,	90);
		g.drawString("我方坦克的血量: " + myTank.getLife(), 10, 110);
		for (int i = 0; i<bullets.size(); i++) {
			Bullets bullet = bullets.get(i);
			bullet.hitTanks(tanks);
			bullet.hitTank(myTank);
			bullet.hitWall(w1);
			bullet.hitWall(w2);
			bullet.draw(g);
		}
		
		for (int i=0; i<explodes.size(); i++) {
			Explode explode = explodes.get(i);
			explode.draw(g);
		}
		
		for (int i=0; i<tanks.size(); i++) {
			Tank tank = tanks.get(i);
			tank.impactWall(w1);
			tank.impactWall(w2);
			tank.impactTanks(tanks);
			tank.draw(g);
		}
		
		myTank.draw(g);  //画我方坦克
		w1.draw(g);
		w2.draw(g);
		myTank.eat(blood);
		blood.draw(g);
	}
	
	public void update(Graphics g) {
		if (offScreenImage == null ) {
			//创建一张图片
			offScreenImage = this.createImage(viewWidth, viewHeight);
		} 
		//获取图片的画笔
		Graphics gOffScreen = offScreenImage.getGraphics();
		//刷新屏幕，防止出现残影
		Color c = gOffScreen.getColor();
		gOffScreen.setColor(Color.GREEN);
		gOffScreen.fillRect(0, 0, viewWidth, viewHeight);
		gOffScreen.setColor(c);
		paint(gOffScreen);
		
		//调用屏幕的画笔画出图片
		g.drawImage(offScreenImage, 0, 0, null);
	}
	
	
	//界面初始化
	public void init() {
		this.setTitle(viewName);
		this.setSize(viewWidth, viewHeight);
		this.setLocation(view_x,view_y);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		
		});
		this.setResizable(false);
		this.setBackground(Color.GREEN);
		//this.setDefaultCloseOperation(EXIT_ON_CLOSE);		
		this.setVisible(true);
		new Thread(new PaintTank()).start();
		
		this.addKeyListener(new KeyMonitor());
	}
	
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		MainView view = new MainView();
		view.init();
	}
		    
	
	//使用内部类来一直不断重画坦克的位置
	private class PaintTank implements Runnable {
		public void run() {
			while(true) {
				repaint();
				try {
					Thread.sleep(30);
				} catch (InterruptedException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
			}
		}
	}
	
	//键盘监听，获取用户输入，控制坦克方向
	private class KeyMonitor extends KeyAdapter {
		//按键被按下的监听方法
		public void keyPressed(KeyEvent e) {
			myTank.keyPressed(e);
		}
		
		//按下的按键被抬起来后的监听方法
		public void keyReleased(KeyEvent e) {
			myTank.keyReleased(e);
		}
	}
}