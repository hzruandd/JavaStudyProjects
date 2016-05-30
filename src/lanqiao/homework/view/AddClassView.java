package lanqiao.homework.view;

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

import lanqiao.homework.bussiness.ClassBussiness;
import lanqiao.homework.vo.StuClass;

public class AddClassView {

	private JFrame frame;
	private JTextField addClass_id;
	private JTextField addClass_name;
	private ClassBussiness classBussiness;
	private boolean blockDelete = true;
	private boolean blockAdd = true;
	private boolean blockUpdate = true;
	private JTextArea addClass_desc;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddClassView window = new AddClassView();
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
	public AddClassView() {
		classBussiness = new ClassBussiness();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 375, 534);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton addClassButton = new JButton("添加");
		
		addClassButton.setBounds(35, 439, 93, 23);
		frame.getContentPane().add(addClassButton);
		
		addClass_id = new JTextField();
		addClass_id.setBounds(35, 239, 93, 21);
		frame.getContentPane().add(addClass_id);
		addClass_id.setColumns(10);
		addClass_id.setEditable(false);
		
		JLabel lblNewLabel = new JLabel("班级ID");
		lblNewLabel.setBounds(35, 206, 66, 23);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("班级名字");
		lblNewLabel_1.setBounds(214, 210, 54, 15);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("班级描述");
		lblNewLabel_2.setBounds(34, 284, 54, 26);
		frame.getContentPane().add(lblNewLabel_2);
		
		addClass_name = new JTextField();
		addClass_name.setBounds(190, 239, 129, 21);
		frame.getContentPane().add(addClass_name);
		addClass_name.setColumns(10);
		addClass_name.setEditable(false);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(519, 142, 4, 24);
		frame.getContentPane().add(textArea);
		
		addClass_desc = new JTextArea();
		addClass_desc.setBounds(31, 320, 288, 93);
		addClass_desc.setEditable(false);
		frame.getContentPane().add(addClass_desc);
		
		JButton deleteClassButton = new JButton("删除");
		
		deleteClassButton.setBounds(138, 439, 93, 23);
		frame.getContentPane().add(deleteClassButton);
		
		JButton updateClassButton = new JButton("修改");
		
		updateClassButton.setBounds(241, 439, 93, 23);
		frame.getContentPane().add(updateClassButton);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 10, 339, 186);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 326, 170);
		panel.add(scrollPane);
		
		addClassButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (blockAdd) {
					setBlock(true, true, true);
					clear(true, true, true);
					blockAdd = false;
				}
				else {
					int class_id = Integer.parseInt(addClass_id.getText());
					String class_name = addClass_name.getText();
					String class_desc = addClass_desc.getText();
					classBussiness.addClass(new StuClass(class_id, class_name, class_desc));
					setBlock(false, false, false);
					clear(true, true, true);
					blockAdd= true;
				}
		
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
					if (!addClass_id.getText().equals("")) {
						int class_id = Integer.parseInt(addClass_id.getText());
						classBussiness.deleteClass(class_id);
						clear(true, true, true);
						setBlock(false, false, false);
						blockDelete = true;
					}
				}
			}
		});
		
		updateClassButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (blockUpdate) {
					setBlock(true, false, false);
					clear(true, true, true);
					blockUpdate = false;
				}
				else {					
					if (!addClass_id.getText().equals("") && null != addClass_id.getText() ) {
						int class_id = Integer.parseInt(addClass_id.getText());
						classBussiness.deleteClass(class_id);
						clear(true, true, true);
						setBlock(false, false, false);
						blockUpdate = true;
					}
				}
			}
		});
	}
	
	public void setBlock(boolean id, boolean name, boolean desc) {
		addClass_id.setEditable(id);
		addClass_name.setEditable(name);
		addClass_desc.setEditable(desc);
	}
	
	public void clear(boolean id, boolean name, boolean desc) {
		addClass_id.setText("");
		addClass_name.setText("");
		addClass_desc.setText("");
	}
}
