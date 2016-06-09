package tankWarCongGou.control;

import javax.swing.JPanel;

/**
 * 
 * @author Doctor邓
 * 生成游戏画面类
 */
public class GameRepaint implements Runnable{
	private JPanel gamePanel;
	/**
	 * 确定游戏是否进行的变量
	 * true：游戏正在进行，false游戏暂停
	 */
	public static boolean status = true;
	
	public GameRepaint(JPanel gamePanel) {
		this.gamePanel = gamePanel;
	}
	
	@Override
	public void run() {
		while(true) {
			try {
				if(!status) continue;
				gamePanel.repaint();
				Thread.sleep(45);
			} catch (InterruptedException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
	}

}
