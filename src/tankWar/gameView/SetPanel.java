package tankWar.gameView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/*
 * Description:   游戏设置Panel布局
 */
@SuppressWarnings("serial")
public class SetPanel extends JPanel{
	
	private boolean musicBlock = true;  //用于判断游戏音乐是否开启
	
	JButton startGame;    //开始游戏按钮
	JButton stopGame;     //暂停游戏按钮
	JButton rankGame;     //调整游戏等级(难度)按钮
	JButton musicSwitch;  //游戏音乐开关按钮
	private RankView rankView;   //游戏等级设置窗体
	
    private final ImageIcon START_ICO = new ImageIcon("gameImage/gameStart1.png");  //开始游戏图标
    private final ImageIcon STOP_ICO = new ImageIcon("gameImage/gameStop1.png");    //暂停游戏图标
    private final ImageIcon RANK_ICO = new ImageIcon("gameImage/rankGame.png");     //游戏等级(难度)图标
    private final ImageIcon MUSIC_ICO = new ImageIcon("gameImage/music.png");       //游戏音乐开关图标
	
    private final int PANEL_WIDTH = 150;    //setPanel的宽度
    private final int PANEL_HEITH = 500;    //setPanel的高度
    private final int PANEL_X = 0;          //setPanel在游戏界面中的X轴坐标
    private final int PANEL_Y = 0;          //setPanel在游戏界面中的Y轴坐标
    
    private boolean rankBlock = true;       //控制是否弹出等级选择窗口,防止多次弹出等级选择窗口
	SetPanel(){
	        setBackground(Color.white);
	        
	        startGame = new JButton("开始游戏", START_ICO);
	        stopGame = new JButton("暂停游戏", STOP_ICO);
	        rankGame = new JButton("游戏级别", RANK_ICO);
	        musicSwitch = new JButton("关闭音乐", MUSIC_ICO);
	        
	        //rankGame.setFont(new Font("宋体", 2, 20)); 
	        //--------设置Panel在JFrame中的大小位置,还有其布局--------------//
	        setLocation(PANEL_X, PANEL_Y);
	        setSize(PANEL_WIDTH, PANEL_HEITH);
	        setLayout(new GridLayout(4,1,0,25));
	        
	        add(startGame);
	        startGame.setContentAreaFilled(false);  //设置button为透明
	        startGame.setBorderPainted(false);      //设置button无边框
	        startGame.setBackground(Color.white);   //设置button背景色为白色,使其能够与图标相称
	        
	        add(stopGame);
	        stopGame.setContentAreaFilled(false);
	        stopGame.setBorderPainted(false);
	        stopGame.setBackground(Color.white);
	        
	        add(rankGame);
	        rankGame.setBorderPainted(false);
	        rankGame.setBackground(Color.white);
	        rankGame.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO 自动生成的方法存根
					if(rankBlock == true){
						
						rankView = new RankView();
						rankView.setVisible(true);
						rankBlock = false;
					}
					else{
					    	rankView.setVisible(true);
					}
					
				}	
	        });
	        
	        add(musicSwitch);
	        musicSwitch.setContentAreaFilled(false);
	        musicSwitch.setBorderPainted(false);
	        musicActionListener(musicSwitch);      //为音乐开关添加监听事件
	}
	
	public boolean isMusicBlock() {
		return musicBlock;
	}

	public void setMusicBlock(boolean musicBlock) {
		this.musicBlock = musicBlock;
	}
	
	//为音乐button添加监听事件
		public void musicActionListener(JButton button){
			button.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO 自动生成的方法存根
					if(isMusicBlock()){
						JOptionPane.showMessageDialog(null,"音乐已关闭(示范！)");
						setMusicBlock(false);
					}
					else{
						JOptionPane.showMessageDialog(null,"音乐已开启(示范！)");
						setMusicBlock(true);
					}
				}
		        	
		    });
		}

}
