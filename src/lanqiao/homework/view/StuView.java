package lanqiao.homework.view;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
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
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;

import lanqiao.homework.bussiness.ClassBussiness;
import lanqiao.homework.bussiness.StuBussiness;
import lanqiao.homework.unless.StuControl;
import lanqiao.homework.vo.Stu;
import lanqiao.homework.vo.StuClass;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class StuView extends JFrame {

	private JPanel contentPane;
	private JButton addStu;
	private JTextField stuName;
	private JTextField stuAge;
	private JTextField stuAddress;
	private JTextField stuId;
	private JTextField delStuText;
	private StuTableModel stuTableModel = new StuTableModel();
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JComboBox boxClass_id;
	private StuBussiness stuBussiness;
	private ClassBussiness classBussiness;
	private JTable deleteTable;
	private JTextField stu_idAlter;
	private JTextField stu_nameAlter;
	private JTextField stu_addressAlter;
	private JTextField stu_ageAlter;
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	private JTable classTable;
	private ClassTableModel classTableModel = new ClassTableModel();
	private JRadioButton stu_sexMenAlter;
	private JRadioButton stu_sexWomenAlter;
	private JComboBox class_idAlter;
	
	public StuView() {
		stuBussiness = new StuBussiness();
		classBussiness = new ClassBussiness();
		CardLayout menuLayout = new CardLayout();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 637, 629);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		addStu = new JButton("增加学生");
		addStu.setBounds(10, 522, 93, 23);
		contentPane.add(addStu);
		
		JButton delStu = new JButton("查找、修改、删除学生信息");
		
		delStu.setBounds(247, 522, 248, 23);
		contentPane.add(delStu);
		
		JPanel menu = new JPanel();
		menu.setBounds(0, 10, 609, 494);
		contentPane.add(menu);
		menu.setLayout(menuLayout);
		
		JPanel addPane = new JPanel();
		menu.add(addPane, "addPane");
		addPane.setLayout(null);
		
		JButton addStuButton = new JButton("添加");
		
		addStuButton.setBounds(237, 438, 93, 32);
		addPane.add(addStuButton);
		
		stuName = new JTextField();
		stuName.setBounds(320, 104, 143, 21);
		addPane.add(stuName);
		stuName.setColumns(10);
		
		stuAge = new JTextField();
		stuAge.setBounds(320, 213, 143, 21);
		addPane.add(stuAge);
		stuAge.setColumns(10);
		
		stuAddress = new JTextField();
		stuAddress.setBounds(19, 302, 143, 21);
		addPane.add(stuAddress);
		stuAddress.setColumns(10);
		
		JLabel label = new JLabel("姓名");
		label.setBounds(320, 79, 54, 15);
		addPane.add(label);
		
		stuId = new JTextField();
		stuId.setBounds(21, 104, 141, 21);
		addPane.add(stuId);
		stuId.setColumns(10);
		
		JLabel label_1 = new JLabel("学号");
		label_1.setBounds(21, 79, 54, 15);
		addPane.add(label_1);
		
		JLabel label_2 = new JLabel("年龄");
		label_2.setBounds(320, 181, 54, 15);
		addPane.add(label_2);
		
		JLabel label_3 = new JLabel("性别");
		label_3.setBounds(19, 181, 54, 15);
		addPane.add(label_3);
		
		JLabel label_4 = new JLabel("地址");
		label_4.setBounds(19, 277, 54, 15);
		addPane.add(label_4);
		
		boxClass_id = new JComboBox();
		boxClass_id.setBounds(320, 302, 143, 21);
		addPane.add(boxClass_id);
		
		JLabel label_8 = new JLabel("班级号");
		label_8.setBounds(320, 277, 103, 15);
		addPane.add(label_8);
		
		JRadioButton menRadioButton = new JRadioButton("男");
		buttonGroup.add(menRadioButton);
		menRadioButton.setSelected(true);
		menRadioButton.setBounds(21, 212, 48, 23);
		addPane.add(menRadioButton);
		
		JRadioButton womenRadioButton = new JRadioButton("女");
		buttonGroup.add(womenRadioButton);
		womenRadioButton.setBounds(85, 212, 61, 23);
		addPane.add(womenRadioButton);
		
		JPanel delPane = new JPanel();
		menu.add(delPane, "delPane");
		delPane.setLayout(null);
		
		JButton delStuButton = new JButton("删除表格中的所有学生");
		
		delStuButton.setBounds(10, 209, 168, 23);
		delPane.add(delStuButton);
		
		delStuText = new JTextField();
		delStuText.setBounds(212, 43, 156, 23);
		delPane.add(delStuText);
		delStuText.setColumns(10);
		
		JLabel label_5 = new JLabel("搜索");
		label_5.setBounds(276, 10, 36, 23);
		delPane.add(label_5);
		
		
		deleteTable = new JTable();
		deleteTable.setModel(stuTableModel);
		deleteTable.setSelectionBackground(Color.GREEN);
		deleteTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		deleteTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				updateClassTable();
				updateStuInfo();
			}
		});
		
		JScrollPane deleteScrollPane = new JScrollPane(deleteTable);
		deleteScrollPane.setBounds(10, 76, 589, 123);
		delPane.add(deleteScrollPane);
		
		JButton delSearchButton = new JButton("开始查询");
		
		delSearchButton.setBounds(434, 43, 93, 23);
		delPane.add(delSearchButton);
		
		stu_idAlter = new JTextField();
		stu_idAlter.setEditable(false);
		stu_idAlter.setBounds(232, 210, 127, 21);
		delPane.add(stu_idAlter);
		stu_idAlter.setColumns(10);
		
		stu_nameAlter = new JTextField();
		stu_nameAlter.setBounds(54, 263, 115, 21);
		delPane.add(stu_nameAlter);
		stu_nameAlter.setColumns(10);
		
		stu_sexMenAlter = new JRadioButton("男");
		buttonGroup_1.add(stu_sexMenAlter);
		stu_sexMenAlter.setSelected(true);
		stu_sexMenAlter.setBounds(457, 262, 54, 23);
		delPane.add(stu_sexMenAlter);
		
		stu_sexWomenAlter = new JRadioButton("女");
		buttonGroup_1.add(stu_sexWomenAlter);
		stu_sexWomenAlter.setBounds(531, 262, 43, 23);
		delPane.add(stu_sexWomenAlter);
		
		stu_addressAlter = new JTextField();
		stu_addressAlter.setBounds(54, 322, 115, 21);
		delPane.add(stu_addressAlter);
		stu_addressAlter.setColumns(10);
		
	    class_idAlter = new JComboBox();
		class_idAlter.setBounds(241, 322, 127, 21);
		delPane.add(class_idAlter);
		
		stu_ageAlter = new JTextField();
		stu_ageAlter.setBounds(232, 263, 127, 21);
		delPane.add(stu_ageAlter);
		stu_ageAlter.setColumns(10);
		
		JButton alterStuBotton = new JButton("修改学生的信息");
		
		alterStuBotton.setBounds(411, 209, 153, 23);
		delPane.add(alterStuBotton);
		
		JLabel lblNewLabel_3 = new JLabel("姓名：");
		lblNewLabel_3.setBounds(10, 266, 54, 15);
		delPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("年龄：");
		lblNewLabel_4.setBounds(179, 266, 48, 15);
		delPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("性别：");
		lblNewLabel_5.setBounds(389, 265, 54, 15);
		delPane.add(lblNewLabel_5);
		
		JLabel label_9 = new JLabel("地址：");
		label_9.setBounds(8, 325, 43, 15);
		delPane.add(label_9);
		
		JLabel label_10 = new JLabel("班级号：");
		label_10.setBounds(179, 325, 52, 15);
		delPane.add(label_10);
		
		JLabel lblNewLabel_6 = new JLabel("学号：");
		lblNewLabel_6.setBounds(188, 215, 40, 15);
		delPane.add(lblNewLabel_6);
		
		classTable = new JTable();
		classTable.setModel(classTableModel);
		JScrollPane classScrollPane = new JScrollPane(classTable);
		classScrollPane.setBounds(23, 410, 565, 54);
		delPane.add(classScrollPane);
		
		JLabel lblNewLabel_7 = new JLabel("学生的班级信息");
		lblNewLabel_7.setBounds(205, 382, 127, 15);
		delPane.add(lblNewLabel_7);
		
		updateClassSelect(boxClass_id);
		updateClassSelect(class_idAlter);
		
		addStu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				updateClassSelect(boxClass_id);
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
		
		delStuButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/**
				 * isDelete用于判断删除操作是否成功
				 */
				boolean isDelete = false;
				/**
				 * 用于存储删除失败的学生的id
				 */
				List<Integer> notDelStuId = new ArrayList<Integer>();
				
				int columnNum = deleteTable.getModel().getColumnCount();
				int rowNum = deleteTable.getModel().getRowCount();
				/**
				 * 创建一个学生ID数组，用于存放将要表格中要被删除的学生的id
				 */
				int[] stu_idList = new int[rowNum];
				for (int i=0; i<rowNum; i++) {
					stu_idList[i] = Integer.parseInt(deleteTable.getModel().getValueAt(i, 0).toString());
				}
				for (int i=0; i<stu_idList.length; i++) {
					if(!stuBussiness.deleteStu(stu_idList[i])){
						notDelStuId.add(stu_idList[i]);
						isDelete = false;
					} else {
						isDelete = true;
					}
				}
				/**
				 * 如果没有删除成功，则将没有删除成功的学生信息在表格显示出来
				 */
				if (!isDelete) {
					StringBuffer stu_idStr = new StringBuffer();
					for (int i=0; i<notDelStuId.size(); i++) {
						stu_idStr.append(notDelStuId.get(i));
					}
					stuTableModel.setData(stuBussiness.getSearchData(stu_idStr.toString()));
				}
			
			}
		});
		
		delSearchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String user_input = delStuText.getText();
				stuTableModel.setData(stuBussiness.getSearchData(user_input));
			}
		});
		
		alterStuBotton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if ("".equals(stu_idAlter.getText()) | null == stu_idAlter.getText()) return ;
				
				int stu_id = Integer.parseInt(stu_idAlter.getText());
				int class_id = Integer.parseInt(class_idAlter.getSelectedItem().toString());
				String stu_name = stu_nameAlter.getText();
				int stu_age = Integer.parseInt(stu_ageAlter.getText());
				String stu_sex;
				if (stu_sexMenAlter.isSelected()) {
					stu_sex= "男";
				} else {
					stu_sex="女";
				}
				String stu_address = stu_addressAlter.getText();
				Stu stu = new Stu(stu_id, stu_id, class_id, stu_name, stu_age, stu_sex, stu_address);
				stuBussiness.updataStu(stu);
				
				stuTableModel.updateDate();
				resetStuInfo();
			}
		});
	}
	
	/**
	 * 更新JComBox的选项信息，选项信息为班级的ID信息
	 * @param comBox   指定的JComBox组件
	 */
	public void updateClassSelect(JComboBox comBox) {
		comBox.removeAllItems();
		List<StuClass> stuClass = classBussiness.searchClass();
		for (int i=0; i<stuClass.size(); i++) {
			comBox.addItem(new String(String.valueOf(stuClass.get(i).getClass_id())));
		}
	}
	
	/**
	 * 鼠标选中deleteTable表格时，同时更新班级表格的信息
	 */
	public void updateClassTable() {
		int i = deleteTable.getSelectedRow();
		int stu_id = Integer.parseInt(deleteTable.getModel().getValueAt(i, 0).toString());
		classTableModel.updateDate(stu_id);
	}
	
	/**
	 * 鼠标选中deleteTable表格时，更新更改学生信息区域的学生的信息
	 */
	public void updateStuInfo() {
		int i = deleteTable.getSelectedRow();
		
		int stu_id = Integer.parseInt(deleteTable.getModel().getValueAt(i, 0).toString());
		String stu_name = deleteTable.getModel().getValueAt(i, 1).toString();
		int stu_age = Integer.parseInt(deleteTable.getModel().getValueAt(i, 2).toString());
		String stu_sex = deleteTable.getModel().getValueAt(i, 3).toString();
		String stu_address = deleteTable.getModel().getValueAt(i, 4).toString();
		int class_id = Integer.parseInt(deleteTable.getModel().getValueAt(i, 5).toString());
		
		stu_idAlter.setText(String.valueOf(stu_id));
		stu_nameAlter.setText(stu_name);
		stu_ageAlter.setText(String.valueOf(stu_age));
		if ("男".equals(stu_sex)) {
			stu_sexMenAlter.setSelected(true);
		} else {
			stu_sexWomenAlter.setSelected(true);
		}
		stu_addressAlter.setText(stu_address);
		int comBoxLength = class_idAlter.getItemCount();
//		System.out.println(comBoxLength);
		for (int j=0; j<comBoxLength; j++) {
			Object item = class_idAlter.getItemAt(j);
//			System.out.println(Integer.parseInt(item.toString()));
			if (class_id == Integer.parseInt(item.toString())) {
				class_idAlter.setSelectedIndex(j);
			}
		}
	}
	
	/**
	 * 重置学生信息区域的学生信息和class_idTable表格的信息
	 */
	public void resetStuInfo() {
		stu_idAlter.setText("");
		stu_nameAlter.setText("");
		stu_ageAlter.setText("");
		stu_sexMenAlter.setSelected(true);
		stu_addressAlter.setText("");
		
		classTableModel.clear();
	}
}
