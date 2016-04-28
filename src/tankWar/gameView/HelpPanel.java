package tankWar.gameView;
/*
 * Description:   游戏帮助信息模块
 */
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JPanel;

public class HelpPanel extends JPanel{
    
	private final int PANEL_WIDTH = 800;           //helpPanel宽度
	private final int PANEL_HEIGHT = 100;          //helpPanel长度
	private final int PANEL_X = 0;                 //helpPanel在JFrame中的X坐标
	private final int PANEL_Y = 500;               //helpPanel在JFrame中的Y坐标
	private final Image  helpImage =  
			Toolkit.getDefaultToolkit().createImage("gameImage/gameHelp.PNG"); //游戏帮助信息图片
	private final int HELP_X = 280;                //帮助信息图片在helpPanel中的X坐标
	private final int HELP_Y = 0;                  //帮助信息图片在helpPanel中的Y坐标
	
	private static final long serialVersionUID = 1L;
	/*public void paintComponent(Graphics g){
		//super.paintComponent(g);
		g.drawImage(helpImage, 280, 0, 257, 80, this);
	}                注意：这种绘图方法,会有残影,不推荐,用下面的好一点
	*/
	public void paintComponent(Graphics g) {
	    super.paintComponent(g);
	    update(g);
	}

	public void update(Graphics g) {
	    g.drawImage(helpImage, HELP_X, HELP_Y, helpImage.getWidth(null), helpImage.getHeight(null), this);  
	}
	
	HelpPanel(){
		setSize(PANEL_WIDTH, PANEL_HEIGHT);
		setLocation(PANEL_X, PANEL_Y);
	}	
}
