package tankWarCongGou.cartoon;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import tankWarCongGou.gameRun.TankClient;
import tankWarCongGou.view.GamePanel;

public class GameEnd {
	private  int x =0;
	private  int y =0;
	private int width;
	private int height;
	int i = 1;
	int j= 0;
	
	private Image victory = Toolkit.getDefaultToolkit().getImage("image/end/gameVictory.png");
	private Image gameOver = Toolkit.getDefaultToolkit().getImage("image/end/gameOver.png");
	
	public void draw(Graphics g) {
		if (TankClient.victory == 1) {
			victoryCartoon();
			g.drawImage(victory, x, y, width, height,  null);
		} else {
			overCartoon();
			g.drawImage(gameOver, x, y, width, height,  null);
		}
	}
	
	/**
	 * 游戏失败时的动画
	 */
	public void overCartoon() {
		width = 338;
		height = 265;
		x=GamePanel.WIDTH/2 - width/2;
		y=GamePanel.HEIGHT - j*10;
		int temp = 52;
		if (j< temp) {
			j++;
		} else {
//			TankClient.stopStatus = true;
			TankClient.gameStatus = false;
		}
	
	}
	/**
	 * 游戏胜利时的动画
	 */
	public void victoryCartoon() {
		width = 20*i;
		height = 17*i;
		x = GamePanel.WIDTH/2 - width/2;
		y = GamePanel.HEIGHT/2 - height/2;
		if (i<40) {
			i++;
		} else {
//			TankClient.stopStatus = true;
			TankClient.gameStatus = false;
		}
	}
	
	public void dataInit() {
		i=1;
		j=0;
	}
}
