package lanqiao.homework.view;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import lanqiao.homework.action.VerifyUserAction;
import lanqiao.homework.unless.JdbcUtil;

public class LoginView {

	private JFrame frame;
	private JTextField user_account;
	private JPasswordField user_pwd;
	private VerifyUserAction verifyUser;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginView window = new LoginView();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LoginView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 578, 436);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.getContentPane().setLayout(null);
		
		user_account = new JTextField();
		user_account.setBounds(223, 139, 146, 23);
		frame.getContentPane().add(user_account);
		user_account.setColumns(10);
		
		JButton login = new JButton("登陆");
		
		login.setBounds(121, 308, 93, 23);
		frame.getContentPane().add(login);
		
		JButton resetting = new JButton("重置");
		
		resetting.setBounds(301, 308, 93, 23);
		frame.getContentPane().add(resetting);
		
		JLabel label = new JLabel("账号：");
		label.setFont(new Font("宋体", Font.PLAIN, 16));
		label.setBounds(135, 138, 66, 33);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("密码：");
		label_1.setFont(new Font("宋体", Font.PLAIN, 16));
		label_1.setBounds(135, 223, 54, 33);
		frame.getContentPane().add(label_1);
		
		user_pwd = new JPasswordField();
		user_pwd.setBounds(224, 233, 155, 23);
		frame.getContentPane().add(user_pwd);
		
		JLabel error_login = new JLabel("");
		error_login.setBounds(368, 184, 184, 39);
		frame.getContentPane().add(error_login);
		
		resetting.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				user_account.setText("");
				user_pwd.setText("");
				error_login.setText("");
			}
		});
		
		login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				verifyUser = new VerifyUserAction();
				if (verifyUser.verify(user_account.getText(), user_pwd.getText())) {
					
					EventQueue.invokeLater(new Runnable() {
						public void run() {
							try {
								StuAdministrateView frame = new StuAdministrateView();
								frame.setVisible(true);
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					});
					
					frame.dispose();
				}
				else {
					error_login.setText("用户名或密码错误请重新输入！");
				}
			}
		});
	}
}
