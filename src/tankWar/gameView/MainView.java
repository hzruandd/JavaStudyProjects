package tankWar.gameView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

//----------游戏主界面---------------------//
public class MainView extends AGameView{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame mainView;      //游戏窗体
	private SetPanel setPanel;    //游戏设置模块
	private GamePanel gamePanel;  //游戏模块
	private JPanel inforPanel;    //游戏信息模块
	private JPanel helpPanel;     //游戏提示模块界面
	
    
	private final int GAME_WIDTH = 800;   //游戏主界面宽度
	private final int GAME_HEIGHT = 600;  //游戏主界面高度
	private final String TITLE_NAME = "坦克大战"; 
	
	MainView(){
		this.setGameHight(GAME_HEIGHT);
		this.setGameWidth(GAME_WIDTH);
		this.setTitleName(TITLE_NAME);
		initialization();
	}
	
	//---------初始化界面方法--------------//
	public void initialization(){
		
		//-----------------构建主界面窗体-------------------//
		mainView = new JFrame(this.getTitleName());
	    mainView.setSize(this.getGameWidth(),this.getGameHight());
	    mainView.setLocation((SCREEN_WIDTH - this.getGameHight())/2,(SCREEN_HEIGHT - this.getGameWidth())/2+70);
        mainView.setIconImage(this.setIco("gameImage/gameLogo.png"));
        mainView.setResizable(false);
        mainView.setLayout(null);
        mainView.getContentPane().setBackground(Color.white);
        mainView.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   //点击窗体关闭图标,直接结束窗体所在的应用程序
        windowClose(mainView);                           //为主窗体添加关闭监听事件
        
        //--------------添加游戏设置布局模块-----------------------//
        setPanel = new SetPanel();
        mainView.add(setPanel);
        
        //给setPanel的开始游戏按钮添加监听器,使其可以控制游戏的开始
        setPanel.startGame.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				gamePanel.selectImage = Toolkit.getDefaultToolkit().createImage("gameImage/selectTank.png");
				gamePanel.gameMenu = Toolkit.getDefaultToolkit().createImage("gameImage/gameMenu.gif");
				gamePanel.repaint();
				mainView.setVisible(true);
				gamePanel.requestFocus();  //使游戏模块获得窗体焦点,使游戏模块的键盘监听可以正常运行
			}
        	
        });
    
        //--------------------游戏界面模块------------------------------//
        gamePanel = new GamePanel();
        mainView.add(gamePanel);
        
        //为游戏界面模块添加鼠标监听事件,使用户用鼠标点击游戏模块时,模块获得窗体焦点
        gamePanel.addMouseListener(new MouseAdapter(){
        	public void mouseClicked(MouseEvent e){
        		mainView.setVisible(true);
        		gamePanel.requestFocus();
        	}
        });
        
        //------------游戏信息模块:剩余坦克数量、玩家分数、玩家生命值(待完成！！！)---------------------//
        inforPanel = new InforPanel();
        mainView.add(inforPanel);
        
        //--------------------------游戏帮助模块布局----------------------//
        helpPanel = new HelpPanel();
        mainView.add(helpPanel);
     
        mainView.setVisible(true);
	}

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
        new MainView();   
	}
	
	//窗口关闭监听事件,在主窗体关闭时,其他窗体全部关闭
	public void windowClose(JFrame jframe){
		jframe.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e)
			{
				//RankView.dispose();
				System.exit(0);
			}
		});
	}
	
}
