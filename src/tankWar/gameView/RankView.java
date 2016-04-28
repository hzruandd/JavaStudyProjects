package tankWar.gameView;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/*
 * Description:  选择游戏等级的窗口
 */
public class RankView extends AGameView{
	
	private static final long serialVersionUID = 1L;
	//private static JFrame rankView;     //游戏等级选择窗体
	private final int RANKVIEW_WIDTH = 100;
	private final int RANKVIEW_HEIGHT = 200;
	private final String RANKVIEW_NAME = "等级选择";
	
	JButton rankOne;     //游戏等级一 设置Button
	JButton rankTwo;     //游戏等级二 设置Button
	JButton rankThree;   //游戏等级三 设置Button
	JButton rankFour;    //游戏等级四 设置Button

	RankView(){
		this.setGameHight(RANKVIEW_HEIGHT);
		this.setGameWidth(RANKVIEW_WIDTH);
		this.setTitleName(RANKVIEW_NAME);
		initialization();
	}


	@Override
	public void initialization() {
		// TODO 自动生成的方法存根
		
		setTitle(getTitleName());
		setSize(getGameWidth(), getGameHight());
		setLocation((SCREEN_WIDTH - getGameHight())/2,(SCREEN_HEIGHT - getGameWidth())/2);
		setIconImage(setIco("gameImage/gameLogo.png"));
		setResizable(false);
		setLayout(new FlowLayout());
        setDefaultCloseOperation(HIDE_ON_CLOSE);       //点击关闭隐藏当前窗口
        
        rankOne = new JButton("等级一");
        rankTwo = new JButton("等级二");
        rankThree = new JButton("等级三");
        rankFour = new JButton("等级四");
        
        add(rankOne);
        add(rankTwo);
        add(rankThree);
        add(rankFour);
        
        //为每个Button添加监听事件
        addActionListener(rankOne);
        addActionListener(rankTwo);
        addActionListener(rankThree);
        addActionListener(rankFour);
        
        setVisible(true);
	}
	
	//为button添加监听事件
	public void addActionListener(JButton button){
		button.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO 自动生成的方法存根
				setVisible(false);
			}
        });
	}
}
