package tankWar.gameView;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;

public class SelectPaint extends JFrame {

    private static final long serialVersionUID = 1L;
    
    //单人游戏选择,选择坦克的坐标
    private final int ONE_WIDTH = 140;
    private final int ONE_HEIGHT = 250;
    
    //双人游戏选择,选择坦克的坐标
    private static final int TWO_WIDTH = 140;
    private static final int TWO_HEIGHT = 280;
    
    //选择坦克的实际坐标
    private int imageWidth;
    private int imageHeight;

    // 用于存储图片
    private Image act;
    private final Image gameMenu = Toolkit.getDefaultToolkit().createImage("gameImage/gameMenu.gif");

    Canvas canvas = new Canvas() {

        private static final long serialVersionUID = 1L;

        public void paint(Graphics g) {
        	update(g);
        }

        public void update(Graphics g) {
        	g.drawImage(gameMenu, 0, 0, 512, 448, this);
            g.drawImage(act, imageWidth, imageHeight, 29, 31, this);         
        }
    };

    public SelectPaint() {
        setTitle("图像变换");
        setSize(512, 448);
        // 设定背景为黑色
        setBackground(Color.BLACK);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);           //点击窗体关闭图标,直接结束窗体所在的应用程序
        act = Toolkit.getDefaultToolkit().createImage("gameImage/selectTank.png");
        imageWidth = ONE_WIDTH;
        imageHeight = ONE_HEIGHT;
        
        addKeyListener(canvas);
        // 加载帆布作为背景
        add(canvas);
    }


    public static void main(String[] args) {
        // 实例化本类
    	SelectPaint sa = new SelectPaint();
        // 显示窗体
        sa.setVisible(true);
    }
    
    //给画布添加键盘监听事件
    public void addKeyListener(Canvas canvas){
    	canvas.addKeyListener(new KeyAdapter(){
    		public void keyPressed(KeyEvent e){
    			
    			switch(e.getKeyCode())
    			{
    				case KeyEvent.VK_W :
    					imageWidth = ONE_WIDTH;
    			        imageHeight = ONE_HEIGHT;
    			        canvas.repaint();
    			        break;
    			        
    				case KeyEvent.VK_S :
    					imageWidth = TWO_WIDTH;
    			        imageHeight = TWO_HEIGHT;
    			        canvas.repaint();
    			        break;
    			}
    		}
    	});
    }
}

