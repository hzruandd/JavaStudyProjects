import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JLayeredPane;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class MainViewTest extends JFrame {

	private JLayeredPane contentPane;
	private JLayeredPane menuPane;
	private JPanel addInfoPane;
	private JPanel showInfoPane;
	private JPanel alterInfoPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainViewTest frame = new MainViewTest();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainViewTest() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 762, 500);
		contentPane = new JLayeredPane();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton showStuInfo = new JButton("查看学生信息");
		showStuInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		showStuInfo.setHorizontalAlignment(SwingConstants.LEFT);
		showStuInfo.setBounds(23, 27, 122, 23);
		contentPane.add(showStuInfo);
		
		JButton alterStuInfo = new JButton("修改学生信息");
		alterStuInfo.setBounds(194, 27, 122, 23);
		contentPane.add(alterStuInfo);
		
		JButton addStuInfo = new JButton("添加学生");
		addStuInfo.setBounds(375, 27, 122, 23);
		contentPane.add(addStuInfo);
		
		JButton delStuInfo = new JButton("删除学生");
		delStuInfo.setBounds(549, 27, 93, 23);
		contentPane.add(delStuInfo);
		
		JLabel label = new JLabel("姓名");
		label.setBounds(76, 92, 54, 15);
		contentPane.add(label);
		
		JLabel lblNewLabel = new JLabel("年龄");
		lblNewLabel.setBounds(170, 92, 54, 15);
		contentPane.add(lblNewLabel);
		
		JLabel label_1 = new JLabel("性别");
		label_1.setBounds(262, 92, 54, 15);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("地址");
		label_2.setBounds(351, 92, 54, 15);
		contentPane.add(label_2);
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
	
	private void initMenuPane() {
		menuPane = new JLayeredPane();
		menuPane.setBounds(20, 20, 400, 400);
		contentPane.add(menuPane);
		menuPane.add(showInfoPane, JLayeredPane.PALETTE_LAYER);
		menuPane.add(alterInfoPane, JLayeredPane.MODAL_LAYER);
		menuPane.add(addInfoPane, JLayeredPane.POPUP_LAYER);
	}
	
	private void initAddPane() {
		
	}
	
	private void initShowPane() {
		
	}
	
	private void initAlterPane() {
		
	}
}
