package tankWar.gameView;
/*
 * Description:   游戏模块
 */
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JPanel;

/*
 * Description:   游戏模块
 */
public class GamePanel extends JPanel{
	
	//GamePanel的宽度、高度
	private final int gamePanelWidth = 650;
	private final int gamePanelHeight = 500;
	
	//GamePanel在主界面中的位置
	private final int gamePanelX = 150;
	private final int gamePanelY = 0;
	
    //单人游戏选择,选择坦克的坐标
    private final int ONE_WIDTH = 180;
    private final int ONE_HEIGHT = 280;
    
    //双人游戏选择,选择坦克的坐标
    private final int TWO_WIDTH = 180;
    private final int TWO_HEIGHT = 315;
    
    //选择坦克的实际坐标
    private int imageWidth;
    private int imageHeight;

    Image selectImage = null;            //选择坦克图片对象
	Image gameMenu = null;               //游戏界面的背景
	
    //-------------------------------画图--------------------------------------//
    private static final long serialVersionUID = 1L;
    
    public void paintComponent(Graphics g) {
    	super.paintComponent(g);
    	update(g);
    }

    public void update(Graphics g) {
    	g.drawImage(gameMenu, 0, 0, gamePanelWidth, gamePanelHeight, this);
        g.drawImage(selectImage, imageWidth, imageHeight, 29, 31, this);         
    }
	
	GamePanel(){
		setSize(gamePanelWidth,gamePanelHeight);
		setLocation(gamePanelX,gamePanelY);
		
		gameMenu = Toolkit.getDefaultToolkit().createImage("gameImage/tankStart.png");
		//selectImage = Toolkit.getDefaultToolkit().createImage("gameImage/selectTank.png");
        imageWidth = ONE_WIDTH;
        imageHeight = ONE_HEIGHT;
        
        addKeyListener(this);
	}
  
	public void setSelectImage(Image selectImage) {
		this.selectImage = selectImage;
	}

	public void setGameMenu(Image gameMenu) {
		this.gameMenu = gameMenu;
	}

	//给setPanel添加键盘监听事件
    public void addKeyListener(JPanel jpanel){
    	jpanel.addKeyListener(new KeyAdapter(){
    		public void keyPressed(KeyEvent e){
    			
    			switch(e.getKeyCode())
    			{
    				case KeyEvent.VK_W :
    					imageWidth = ONE_WIDTH;
    			        imageHeight = ONE_HEIGHT;
    			        jpanel.repaint();
    			        break;
    			        
    				case KeyEvent.VK_S :
    					imageWidth = TWO_WIDTH;
    			        imageHeight = TWO_HEIGHT;   
    			        jpanel.repaint();
    			        break; 
    				case KeyEvent.VK_ENTER :
    					gameMenu= Toolkit.getDefaultToolkit().createImage("gameImage/gamePlay.png");
    					selectImage = null;
    					//Toolkit.getDefaultToolkit().createImage("gameImage/selectTankTop.png");
    					jpanel.repaint();
    					break;
    			}
    		}
    	});
    }
    
    //setPanel添加在游戏中的监听器
    public void gameKeyListener(JPanel jpanel){
    	jpanel.addKeyListener(new KeyAdapter(){
    		public void keyPressed(KeyEvent e){
    			
    		}
    	});
    }
}

