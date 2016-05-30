package lanqiao.homework.view;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import lanqiao.homework.bussiness.ClassBussiness;
import lanqiao.homework.bussiness.StuBussiness;
import lanqiao.homework.control.StuControl;
import lanqiao.homework.vo.Stu;
import lanqiao.homework.vo.StuClass;

public class StuView extends JFrame {

	private JPanel contentPane;
	private JButton addStu;
	private JTextField stuName;
	private JTextField stuAge;
	private JTextField stuAddress;
	private JTextField stuId;
	private JTextField delStuText;
	private JTextField stuIdAlter;
	private JTextField stuNameAlter;
	private JTextField stuAgeAlter;
	private JTextField stuSexAlter;
	private JTextField stuAddressAlter;
	private JTable table;
	private JTextField pageNo;
	private StuTableModel stuTableModel = new StuTableModel();
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JComboBox boxClass_id;
	private StuBussiness stuBussiness;
	private ClassBussiness classBussiness;
	private JTable deleteTable;
	
	public StuView() {
		stuBussiness = new StuBussiness();
		classBussiness = new ClassBussiness();
		CardLayout menuLayout = new CardLayout();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 637, 474);
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
		menu.setBounds(0, 10, 609, 355);
		contentPane.add(menu);
		menu.setLayout(menuLayout);
		
		JPanel addPane = new JPanel();
		menu.add(addPane, "addPane");
		addPane.setLayout(null);
		
		JButton addStuButton = new JButton("添加");
		
		addStuButton.setBounds(21, 255, 93, 23);
		addPane.add(addStuButton);
		
		stuName = new JTextField();
		stuName.setBounds(172, 104, 115, 21);
		addPane.add(stuName);
		stuName.setColumns(10);
		
		stuAge = new JTextField();
		stuAge.setBounds(333, 104, 66, 21);
		addPane.add(stuAge);
		stuAge.setColumns(10);
		
		stuAddress = new JTextField();
		stuAddress.setBounds(21, 193, 143, 21);
		addPane.add(stuAddress);
		stuAddress.setColumns(10);
		
		JLabel label = new JLabel("姓名");
		label.setBounds(172, 79, 54, 15);
		addPane.add(label);
		
		stuId = new JTextField();
		stuId.setBounds(21, 104, 141, 21);
		addPane.add(stuId);
		stuId.setColumns(10);
		
		JLabel label_1 = new JLabel("学号");
		label_1.setBounds(21, 79, 54, 15);
		addPane.add(label_1);
		
		JLabel label_2 = new JLabel("年龄");
		label_2.setBounds(345, 79, 54, 15);
		addPane.add(label_2);
		
		JLabel label_3 = new JLabel("性别");
		label_3.setBounds(452, 79, 54, 15);
		addPane.add(label_3);
		
		JLabel label_4 = new JLabel("地址");
		label_4.setBounds(32, 161, 54, 15);
		addPane.add(label_4);
		
		boxClass_id = new JComboBox();
		boxClass_id.setBounds(213, 193, 74, 21);
		addPane.add(boxClass_id);
		
		JLabel label_8 = new JLabel("班级号");
		label_8.setBounds(213, 161, 103, 15);
		addPane.add(label_8);
		
		JRadioButton menRadioButton = new JRadioButton("男");
		buttonGroup.add(menRadioButton);
		menRadioButton.setSelected(true);
		menRadioButton.setBounds(424, 103, 48, 23);
		addPane.add(menRadioButton);
		
		JRadioButton womenRadioButton = new JRadioButton("女");
		buttonGroup.add(womenRadioButton);
		womenRadioButton.setBounds(474, 103, 61, 23);
		addPane.add(womenRadioButton);
		
		JPanel delPane = new JPanel();
		menu.add(delPane, "delPane");
		delPane.setLayout(null);
		
		JButton delStuButton = new JButton("删除表格中的所有学生");
		
		delStuButton.setBounds(212, 322, 153, 23);
		delPane.add(delStuButton);
		
		delStuText = new JTextField();
		delStuText.setBounds(212, 43, 156, 23);
		delPane.add(delStuText);
		delStuText.setColumns(10);
		
		JLabel label_5 = new JLabel("搜索");
		label_5.setBounds(276, 10, 36, 23);
		delPane.add(label_5);
		
		
		deleteTable = new JTable();
		//deleteTable.setBounds(10, 76, 589, 163);
		deleteTable.setModel(stuTableModel);
		//delPane.add(deleteTable);
		
		JScrollPane deleteScrollPane = new JScrollPane(deleteTable);
		deleteScrollPane.setBounds(10, 76, 589, 198);
		delPane.add(deleteScrollPane);
		
		JButton delSearchButton = new JButton("开始查询");
		
		delSearchButton.setBounds(434, 43, 93, 23);
		delPane.add(delSearchButton);
		
		JPanel alterPane = new JPanel();
		menu.add(alterPane, "alterPane");
		alterPane.setLayout(null);
		
		stuIdAlter = new JTextField();
		stuIdAlter.setBounds(193, 46, 172, 21);
		alterPane.add(stuIdAlter);
		stuIdAlter.setColumns(10);
		
		JLabel label_6 = new JLabel("请输入要修改的学生的学号");
		label_6.setBounds(193, 5, 172, 31);
		alterPane.add(label_6);
		
		JLabel lblNewLabel = new JLabel("姓名");
		lblNewLabel.setBounds(28, 181, 54, 15);
		alterPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("年龄");
		lblNewLabel_1.setBounds(146, 181, 54, 15);
		alterPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("性别");
		lblNewLabel_2.setBounds(277, 181, 54, 15);
		alterPane.add(lblNewLabel_2);
		
		stuNameAlter = new JTextField();
		stuNameAlter.setBounds(10, 229, 124, 21);
		alterPane.add(stuNameAlter);
		stuNameAlter.setColumns(10);
		
		JLabel label_7 = new JLabel("地址");
		label_7.setBounds(451, 181, 54, 15);
		alterPane.add(label_7);
		
		stuAgeAlter = new JTextField();
		stuAgeAlter.setBounds(144, 229, 66, 21);
		alterPane.add(stuAgeAlter);
		stuAgeAlter.setColumns(10);
		
		stuSexAlter = new JTextField();
		stuSexAlter.setBounds(277, 229, 66, 21);
		alterPane.add(stuSexAlter);
		stuSexAlter.setColumns(10);
		
		stuAddressAlter = new JTextField();
		stuAddressAlter.setBounds(439, 229, 149, 21);
		alterPane.add(stuAddressAlter);
		stuAddressAlter.setColumns(10);
		
		JButton button = new JButton("开始修改");
		
		button.setBounds(412, 302, 93, 23);
		alterPane.add(button);
		
		JButton button_1 = new JButton("提交修改");
		
		button_1.setBounds(289, 302, 93, 23);
		alterPane.add(button_1);
		
		JPanel searchPane = new JPanel();
		menu.add(searchPane, "searchPane");
		searchPane.setLayout(null);
		
		JButton upPage = new JButton("上一页");
		upPage.setBounds(62, 275, 93, 23);
		searchPane.add(upPage);
		
		JButton nextPage = new JButton("下一页");
		nextPage.setBounds(363, 275, 93, 23);
		searchPane.add(nextPage);
		
		pageNo = new JTextField();
		pageNo.setBounds(231, 276, 66, 21);
		searchPane.add(pageNo);
		pageNo.setColumns(10);
		
		table = new JTable();
		table.setModel(stuTableModel);
		
		JScrollPane searchScrollPane = new JScrollPane(table);
		searchScrollPane.setBounds(40, 10, 550, 250);
		searchPane.add(searchScrollPane);
		
		updateClassSelect();
		
		addStu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				updateClassSelect();
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
				int class_id = Integer.parseInt(boxClass_id.getSelectedItem().toString());
				String stu_name = stuName.getText();
				int stu_age = Integer.parseInt(stuAge.getText());
				String stu_sex  = menRadioButton.isSelected()?"男":"女";
				String stu_address = stuAddress.getText();
				Stu stu = new Stu(stu_id, stu_id, class_id, stu_name, stu_age, stu_sex, stu_address);
				stuBussiness.addStu(stu);
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
				stuTableModel.updateDate();
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
				int stu_id = Integer.parseInt(stuIdAlter.getText().trim());
				//System.out.println(stu_id);
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
		
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Stu stu = null;
				int stu_id = Integer.parseInt(stuIdAlter.getText());
				String stu_name = stuNameAlter.getText();
				int stu_age = Integer.parseInt(stuAgeAlter.getText());
				String stu_sex = stuSexAlter.getText();
				String stu_address = stuAddressAlter.getText();
				System.out.println(stu_address);
				stu = new Stu(stu_id, stu_id,stu_id, stu_name, stu_age, stu_sex, stu_address);
				if (StuControl.getStuControl().alterStu(stu)) {
					JOptionPane.showMessageDialog(null, "修改成功!");
				}
				else {
					JOptionPane.showMessageDialog(null, "修改失败，请重新输入!");
				}
			}
		});
		
		delSearchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String user_input = delStuText.getText();
				stuTableModel.setData(stuBussiness.getSearchData(user_input));
			}
		});
	}
	
	public void updateClassSelect() {
		boxClass_id.removeAllItems();
		List<StuClass> stuClass = classBussiness.searchClass();
		for (int i=0; i<stuClass.size(); i++) {
			boxClass_id.addItem(new String(String.valueOf(stuClass.get(i).getClass_id())));
		}
	}
}
