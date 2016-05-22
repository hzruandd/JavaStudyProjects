import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class TestView extends JFrame {

	private JPanel contentPane;
	/**
	 * Launch the application.
	 */
	private JButton addStu;
	private JTextField stuName;
	private JTextField stuAge;
	private JTextField stuSex;
	private JTextField stuAddress;
	private JTextField stuId;
	private JTextField delStuText;
	private JTextField stuIdAlter;
	private JTextField stuNameAlter;
	private JTextField stuAgeAlter;
	private JTextField stuSexAlter;
	private JTextField stuAddressAlter;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TestView frame = new TestView();
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
	public TestView() {
		CardLayout menuLayout = new CardLayout();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 635, 473);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		addStu = new JButton("增加学生");
		addStu.setBounds(10, 389, 93, 23);
		contentPane.add(addStu);
		
		JButton delStu = new JButton("删除学生");
		
		delStu.setBounds(143, 389, 93, 23);
		contentPane.add(delStu);
		
		JButton alterStu = new JButton("修改学生信息");
		
		alterStu.setBounds(297, 389, 119, 23);
		contentPane.add(alterStu);
		
		JButton searchStu = new JButton("查找学生信息");
		
		searchStu.setBounds(453, 389, 119, 23);
		contentPane.add(searchStu);
		
		JPanel menu = new JPanel();
		menu.setBounds(0, 10, 609, 308);
		contentPane.add(menu);
		menu.setLayout(menuLayout);
		
		JPanel addPane = new JPanel();
		menu.add(addPane, "addPane");
		addPane.setLayout(null);
		
		JButton addStuButton = new JButton("添加");
		
		addStuButton.setBounds(21, 255, 93, 23);
		addPane.add(addStuButton);
		
		stuName = new JTextField();
		stuName.setBounds(108, 104, 66, 21);
		addPane.add(stuName);
		stuName.setColumns(10);
		
		stuAge = new JTextField();
		stuAge.setBounds(190, 104, 66, 21);
		addPane.add(stuAge);
		stuAge.setColumns(10);
		
		stuSex = new JTextField();
		stuSex.setBounds(288, 104, 66, 21);
		addPane.add(stuSex);
		stuSex.setColumns(10);
		
		stuAddress = new JTextField();
		stuAddress.setBounds(400, 104, 66, 21);
		addPane.add(stuAddress);
		stuAddress.setColumns(10);
		
		JLabel label = new JLabel("姓名");
		label.setBounds(108, 79, 54, 15);
		addPane.add(label);
		
		stuId = new JTextField();
		stuId.setBounds(21, 104, 66, 21);
		addPane.add(stuId);
		stuId.setColumns(10);
		
		JLabel label_1 = new JLabel("学号");
		label_1.setBounds(21, 79, 54, 15);
		addPane.add(label_1);
		
		JLabel label_2 = new JLabel("年龄");
		label_2.setBounds(170, 79, 54, 15);
		addPane.add(label_2);
		
		JLabel label_3 = new JLabel("性别");
		label_3.setBounds(300, 79, 54, 15);
		addPane.add(label_3);
		
		JLabel label_4 = new JLabel("地址");
		label_4.setBounds(412, 79, 54, 15);
		addPane.add(label_4);
		
		JPanel delPane = new JPanel();
		menu.add(delPane, "delPane");
		delPane.setLayout(null);
		
		JButton delStuButton = new JButton("删除");
		
		delStuButton.setBounds(76, 232, 93, 23);
		delPane.add(delStuButton);
		
		delStuText = new JTextField();
		delStuText.setBounds(103, 174, 66, 21);
		delPane.add(delStuText);
		delStuText.setColumns(10);
		
		JLabel label_5 = new JLabel("请输入要删除的学生的学号");
		label_5.setBounds(74, 121, 216, 23);
		delPane.add(label_5);
		
		JPanel alterPane = new JPanel();
		menu.add(alterPane, "alterPane");
		alterPane.setLayout(null);
		
		stuIdAlter = new JTextField();
		stuIdAlter.setBounds(92, 143, 172, 21);
		alterPane.add(stuIdAlter);
		stuIdAlter.setColumns(10);
		
		JLabel label_6 = new JLabel("请输入要修改的学生的学号");
		label_6.setBounds(92, 102, 172, 31);
		alterPane.add(label_6);
		
		JLabel lblNewLabel = new JLabel("姓名");
		lblNewLabel.setBounds(10, 181, 54, 15);
		alterPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("年龄");
		lblNewLabel_1.setBounds(115, 181, 54, 15);
		alterPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("性别");
		lblNewLabel_2.setBounds(220, 181, 54, 15);
		alterPane.add(lblNewLabel_2);
		
		stuNameAlter = new JTextField();
		stuNameAlter.setBounds(10, 229, 66, 21);
		alterPane.add(stuNameAlter);
		stuNameAlter.setColumns(10);
		
		JLabel label_7 = new JLabel("地址");
		label_7.setBounds(317, 181, 54, 15);
		alterPane.add(label_7);
		
		stuAgeAlter = new JTextField();
		stuAgeAlter.setBounds(91, 229, 66, 21);
		alterPane.add(stuAgeAlter);
		stuAgeAlter.setColumns(10);
		
		stuSexAlter = new JTextField();
		stuSexAlter.setBounds(198, 229, 66, 21);
		alterPane.add(stuSexAlter);
		stuSexAlter.setColumns(10);
		
		stuAddressAlter = new JTextField();
		stuAddressAlter.setBounds(303, 229, 66, 21);
		alterPane.add(stuAddressAlter);
		stuAddressAlter.setColumns(10);
		
		JButton button = new JButton("开始修改");
		
		button.setBounds(303, 142, 93, 23);
		alterPane.add(button);
		
		JButton button_1 = new JButton("提交修改");
		button_1.setBounds(429, 142, 93, 23);
		alterPane.add(button_1);
		
		JPanel searchPane = new JPanel();
		menu.add(searchPane, "searchPane");
		searchPane.setLayout(null);
		
		addStu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				menuLayout.show(menu, "addPane");
			}
		});
		
		delStu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menuLayout.show(menu, "delPane");
				
			}
		});
		
		addStuButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int stu_id = Integer.parseInt(stuId.getText());
				String stu_name = stuName.getText();
				int stu_age = Integer.parseInt(stuAge.getText());
				String stu_sex = stuSex.getText();
				String stu_address = stuAddress.getText();
				StuControl.getStuControl().addStu(stu_id, stu_name, stu_age, stu_sex, stu_address);
			}
		});
		
		alterStu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menuLayout.show(menu, "alterPane");
			}
		});
		
		searchStu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menuLayout.show(menu, "searchPane");
			}
		});
		
		delStuButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int stu_id = Integer.parseInt(delStuText.getText());
				StuControl.getStuControl().delStu(stu_id);
			}
		});
		
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int stu_id = Integer.parseInt(stuIdAlter.getText());
				Stu stu = StuControl.getStuControl().getStuOne(stu_id);
				if (stu != null) {
					stuNameAlter.setText(stu.getStu_name());
					stuAgeAlter.setText(String.valueOf(stu.getStu_age()));
					stuSexAlter.setText(stu.getStu_sex());
					stuAddressAlter.setText(stu.getStu_address());
					
				}
				else {
					JOptionPane.showMessageDialog(null, "没有此学生!");
				}
			}
		});
	}

}
