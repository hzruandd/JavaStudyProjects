package lanqiao.homework.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import lanqiao.homework.action.StuClassAction;
import lanqiao.homework.action.tableModel.ClassTableModel;
import lanqiao.homework.vo.StuClass;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class StuClassAdministrateView {

	private JFrame frame;
	private JTextField class_idAlter;
	private JTextField class_nameAlter;
	private StuClassAction classBussiness;
	private boolean blockDelete = true;
	private boolean blockAdd = true;
	private boolean blockUpdate = true;
	private JTextArea class_descAlter;
	private JTable classTable;
	private ClassTableModel classTableModel = new ClassTableModel();

	/**
	 * Create the application.
	 */
	public StuClassAdministrateView() {
		classBussiness = new StuClassAction();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setFrame(new JFrame());
		getFrame().setTitle("班级信息管理");
		getFrame().setBounds(100, 100, 375, 534);
//		getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getFrame().getContentPane().setLayout(null);
		
		JButton addClassButton = new JButton("添加");
		
		addClassButton.setBounds(35, 439, 93, 23);
		getFrame().getContentPane().add(addClassButton);
		
		class_idAlter = new JTextField();
		class_idAlter.setBounds(35, 239, 93, 21);
		getFrame().getContentPane().add(class_idAlter);
		class_idAlter.setColumns(10);
		class_idAlter.setEditable(false);
		
		JLabel lblNewLabel = new JLabel("班级ID");
		lblNewLabel.setBounds(35, 206, 66, 23);
		getFrame().getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("班级名字");
		lblNewLabel_1.setBounds(214, 210, 54, 15);
		getFrame().getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("班级描述");
		lblNewLabel_2.setBounds(34, 284, 54, 26);
		getFrame().getContentPane().add(lblNewLabel_2);
		
		class_nameAlter = new JTextField();
		class_nameAlter.setBounds(190, 239, 129, 21);
		getFrame().getContentPane().add(class_nameAlter);
		class_nameAlter.setColumns(10);
		class_nameAlter.setEditable(false);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(519, 142, 4, 24);
		getFrame().getContentPane().add(textArea);
		
		class_descAlter = new JTextArea();
		class_descAlter.setBounds(31, 320, 288, 93);
		class_descAlter.setEditable(false);
		getFrame().getContentPane().add(class_descAlter);
		
		JButton deleteClassButton = new JButton("删除");
		
		deleteClassButton.setBounds(138, 439, 93, 23);
		getFrame().getContentPane().add(deleteClassButton);
		
		JButton updateClassButton = new JButton("修改");
		
		updateClassButton.setBounds(241, 439, 93, 23);
		getFrame().getContentPane().add(updateClassButton);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 10, 339, 186);
		getFrame().getContentPane().add(panel);
		panel.setLayout(null);
		
		classTable = new JTable();
		classTable.setModel(classTableModel);
		classTableModel.update();
		classTable.setSelectionBackground(Color.GREEN);
		classTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		
		JScrollPane classPane = new JScrollPane(classTable);
		classPane.setBounds(0, 0, 326, 170);
		panel.add(classPane);
		
		addClassButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (blockAdd) {
					setBlock(true, true, true);
					clear(true, true, true);
					blockAdd = false;
				}
				else {
					int class_id = Integer.parseInt(class_idAlter.getText());
					String class_name = class_nameAlter.getText();
					String class_desc = class_descAlter.getText();
					classBussiness.addClass(new StuClass(class_id, class_name, class_desc));
					setBlock(false, false, false);
					clear(true, true, true);
					blockAdd= true;
				}
				/**
				 * 添加班级后更新表格信息
				 */
				classTableModel.update();
		
			}
		});
		
		
		deleteClassButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (blockDelete) {
					setBlock(true, false, false);
					clear(true, true, true);
					blockDelete = false;
				}
				else {					
					if (!class_idAlter.getText().equals("")) {
						int class_id = Integer.parseInt(class_idAlter.getText());
						classBussiness.deleteClass(class_id);
						clear(true, true, true);
						setBlock(false, false, false);
						blockDelete = true;
					}
				}
				/**
				 * 添加班级后更新表格信息
				 */
				classTableModel.update();
			}
		});
		
		updateClassButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/**
				 * 当class_idAlter的内容为空时，直接退出
				 */
				if (class_idAlter.getText().equals("") && null == class_idAlter.getText() )  return;
				
				if (blockUpdate) {
					setBlock(false, true, true);
					blockUpdate = false;
				}
				else {					
					if (!class_idAlter.getText().equals("") && null != class_idAlter.getText() ) {
						int class_id = Integer.parseInt(class_idAlter.getText());
						String class_name = class_nameAlter.getText();
						String class_desc = class_descAlter.getText();
						StuClass stuClass = new StuClass(class_id, class_name, class_desc);
						classBussiness.updataClass(stuClass);
						clear(true, true, true);
						setBlock(false, false, false);
						blockUpdate = true;
					}
				}
				/**
				 * 添加班级后更新表格信息
				 */
				classTableModel.update();
			}
		});
		
		classTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				updateClassInfo();
			}
		});
	}
	
	public void setBlock(boolean id, boolean name, boolean desc) {
		class_idAlter.setEditable(id);
		class_nameAlter.setEditable(name);
		class_descAlter.setEditable(desc);
	}
	
	public void clear(boolean id, boolean name, boolean desc) {
		class_idAlter.setText("");
		class_nameAlter.setText("");
		class_descAlter.setText("");
	}
	

	/**
	 * 鼠标选中classable表格时，更新显示单个班级信息区域的学生的信息
	 */
	public void updateClassInfo() {
		int i = classTable.getSelectedRow();
		
		int class_id = Integer.parseInt(classTable.getModel().getValueAt(i, 0).toString());
		String class_name = classTable.getModel().getValueAt(i, 1).toString();
		String class_desc = classTable.getModel().getValueAt(i, 2).toString();

		class_idAlter.setText(String.valueOf(class_id));
		class_nameAlter.setText(class_name);
		class_descAlter.setText(class_desc);
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
}
