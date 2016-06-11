package tankWarCongGou.control;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.TitledBorder;

import tankWarCongGou.control.gameAssist.GameAssistAI;
import tankWarCongGou.control.gameAssist.GameAssistProp;
import tankWarCongGou.control.gameAssist.GameAssistWall;
import tankWarCongGou.entity.GameMap;
import tankWarCongGou.model.GameFactory;
import tankWarCongGou.view.GameFrame;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * 
 * @author Doctor邓
 * 游戏负责将游戏的界面和后台逻辑相连接
 * 游戏的主体类，控制游戏主题界面和运行
 */
public class TankClient {
	private GameFrame gameFrame;
	private GameFactory gameFactory;
	private DataAdmin admin;
	private GameListener listener ;
	private KeyMonitor keyMonitor;
	private GamePaint gamePaint;
	private GameAssistProp gameAssist;
	private GameAssistAI aiAssist;
	private GameAssistWall wallAssist;
	
	public TankClient() {
		dataInit();
		moduleInit();
		viewInit();
	}
	
	/**
	 * 游戏数据初始化
	 */
	private void dataInit() {
		admin = new DataAdmin();
		gameFactory = new GameFactory();
		admin.setMyTanks(gameFactory.getMyTanks(2));
		admin.setAITanks(gameFactory.getAITanks(3));
		admin.setWalls(gameFactory.getWalls(new GameMap()));
	}
	
	/**
	 * 游戏模块初始化
	 */
	private void moduleInit() {
		listener = new GameListener(admin);
		gamePaint = new GamePaint(admin);
		
		admin.dataAddListener(listener);
		/**
		 * 开启自动生成道具的线程
		 */
		gameAssist = new GameAssistProp(admin);
		gameAssist.start();
		/**
		 * 开启自动生成AItank的线程
		 */
		aiAssist = new GameAssistAI(admin, gameFactory, listener);
		aiAssist.start();
		/**
		 * 开启检测老家白墙是否存在，并让白墙自动消失的线程
		 */
		wallAssist = new GameAssistWall(admin);
		wallAssist.start();
	}
	
	/**
	 * 游戏界面初始化
	 */
	private void viewInit() {
		gameFrame = new GameFrame(gamePaint, listener);
		gameFrame.setBackground(new Color(255, 255, 255));
		
		JPanel inforPanel = new JPanel();
		inforPanel.setToolTipText("");
		inforPanel.setBackground(new Color(255, 255, 255));
		inforPanel.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, new Color(143, 188, 143), new Color(143, 188, 143), new Color(143, 188, 143), new Color(143, 188, 143)));
		inforPanel.setBounds(800, 0, 294, 172);
		gameFrame.getContentPane().add(inforPanel);
		inforPanel.setLayout(null);
		
		JLabel scoreLabel = new JLabel("SCORE");
		scoreLabel.setHorizontalAlignment(SwingConstants.CENTER);
		scoreLabel.setForeground(new Color(0, 128, 0));
		scoreLabel.setFont(new Font("楷体", Font.PLAIN, 18));
		scoreLabel.setBounds(10, 10, 89, 28);
		inforPanel.add(scoreLabel);
		
		JLabel lblNewLabel = new JLabel("Number of enemies");
		lblNewLabel.setForeground(new Color(153, 50, 204));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("楷体", Font.PLAIN, 18));
		lblNewLabel.setBounds(10, 90, 180, 28);
		inforPanel.add(lblNewLabel);
		
		JLabel score = new JLabel("50");
		score.setForeground(new Color(255, 0, 0));
		score.setFont(new Font("宋体", Font.PLAIN, 30));
		score.setHorizontalAlignment(SwingConstants.CENTER);
		score.setBounds(101, 48, 89, 37);
		inforPanel.add(score);
		
		JLabel enemyNum = new JLabel("20");
		enemyNum.setHorizontalAlignment(SwingConstants.CENTER);
		enemyNum.setForeground(Color.RED);
		enemyNum.setFont(new Font("宋体", Font.PLAIN, 30));
		enemyNum.setBounds(101, 128, 89, 37);
		inforPanel.add(enemyNum);
		
		JPanel setPanel = new JPanel();
		setPanel.setBorder(new TitledBorder(new LineBorder(new Color(128, 0, 128), 3), "\u6E38\u620F\u8BBE\u7F6E", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 191, 255)));
		setPanel.setBounds(800, 175, 294, 293);
		gameFrame.getContentPane().add(setPanel);
		setPanel.setLayout(null);
		
		JButton startGame = new JButton("开始游戏");
		
		startGame.setBounds(38, 60, 93, 23);
		setPanel.add(startGame);
		
		JButton stopGame = new JButton("停止(开始)游戏");
		stopGame.setBounds(163, 60, 121, 23);
		setPanel.add(stopGame);
		
		JButton restartGame = new JButton("重新开始");
		restartGame.setBounds(38, 158, 93, 23);
		setPanel.add(restartGame);
		
		JButton rankGame = new JButton("排行榜");
		rankGame.setBounds(163, 158, 93, 23);
		setPanel.add(rankGame);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(255, 255, 255)), "\u6E38\u620F\u5E2E\u52A9", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 255, 255)));
		panel.setBounds(800, 463, 294, 199);
		gameFrame.getContentPane().add(panel);
		panel.setLayout(null);
		/**
		 * 为每一个按钮都添加键盘监听事件，这样就不会再点击按钮后，
		 * jframe中的键盘事件失灵导致游戏中的坦克无法通过键盘控制移动
		 */
		startGame.addKeyListener(listener);
		stopGame.addKeyListener(listener);
		restartGame.addKeyListener(listener);
		rankGame.addKeyListener(listener);
		
		startGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gamePaint.setGameStatus(true);
			}
		});
		
		stopGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GameRepaint.status = false;
			}
		});
	}
	
	public static void main(String[] args) {
		TankClient gameRun = new TankClient();
		
	}

	public GameFrame getGameFrame() {
		return gameFrame;
	}

	public DataAdmin getAdmin() {
		return admin;
	}

	public void setGameFrame(GameFrame gameFrame) {
		this.gameFrame = gameFrame;
	}

	public void setAdmin(DataAdmin admin) {
		this.admin = admin;
	}
}
