package tankWar.gameView;

import java.awt.Image;

/*
 * Description:  坦克大战游戏界面的抽象父类
 * Function:     
 * Version:      1.0beta
 * Author:       Doctor邓
 */

import java.awt.Toolkit;

import javax.swing.JFrame;

public abstract class AGameView extends JFrame {
	
	private static final long serialVersionUID = -3822476372124096241L;
	final int SCREEN_HEIGHT = Toolkit.getDefaultToolkit().getScreenSize().height;  //获取显示器高度
	final int SCREEN_WIDTH = Toolkit.getDefaultToolkit().getScreenSize().width;    //获取显示器宽度
	
	private int gameWidth;      //界面宽度
	private int gameHight;      //界面高度
	private String titleName;   //界面名字
	
	//初始化界面方法
	public abstract void initialization();
	
	//设置图标方法
	public Image setIco(String icoPath){
		return Toolkit.getDefaultToolkit().createImage(icoPath);
	}
	
	public void setGameWidth(int gameWidth) {
		this.gameWidth = gameWidth;
	}

	public void setGameHight(int gameHight) {
		this.gameHight = gameHight;
	}

	public void setTitleName(String titleName) {
		this.titleName = titleName;
	}

	public int getGameWidth() {
		return gameWidth;
	}
	public int getGameHight() {
		return gameHight;
	}
	public String getTitleName() {
		return titleName;
	}
	
}

