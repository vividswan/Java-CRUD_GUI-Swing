package userService.gui;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import userService.serviceLayer.ServiceLayer;
import userService.vo.UserVO;

public class UserService {

	ServiceLayer serviceLayer = ServiceLayer.getInstance();
	private JFrame frame;
	private JTextField name;
	private JTextField email;
	private JTextField age;
	private JTextField findName;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserService window = new UserService();
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
	public UserService() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 784, 487);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel NameLabel = new JLabel("name :");
		NameLabel.setBounds(75, 27, 62, 18);
		frame.getContentPane().add(NameLabel);
		
		JLabel EamilLabel = new JLabel("email :");
		EamilLabel.setBounds(262, 27, 62, 18);
		frame.getContentPane().add(EamilLabel);
		
		JLabel AgeLabel = new JLabel("age :");
		AgeLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		AgeLabel.setBounds(419, 27, 62, 18);
		frame.getContentPane().add(AgeLabel);
		
		name = new JTextField();
		name.setBounds(124, 24, 124, 24);
		frame.getContentPane().add(name);
		name.setColumns(10);
		
		email = new JTextField();
		email.setBounds(311, 24, 116, 24);
		frame.getContentPane().add(email);
		email.setColumns(10);
		
		age = new JTextField();
		age.setBounds(490, 24, 116, 24);
		frame.getContentPane().add(age);
		age.setColumns(10);
		
		JButton save = new JButton("\uB4F1\uB85D");
		save.setBounds(620, 23, 105, 27);
		frame.getContentPane().add(save);
		
		JLabel FindNameLabel = new JLabel("Find Name :");
		FindNameLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		FindNameLabel.setBounds(167, 75, 138, 18);
		frame.getContentPane().add(FindNameLabel);
		
		findName = new JTextField();
		findName.setBounds(311, 72, 116, 24);
		frame.getContentPane().add(findName);
		findName.setColumns(10);
		
		JButton find = new JButton("\uC870\uD68C");
		find.setBounds(441, 71, 105, 27);
		frame.getContentPane().add(find);
		
		JButton findAll = new JButton("\uC804\uCCB4 \uD68C\uC6D0 \uBAA9\uB85D");
		findAll.setBounds(311, 126, 159, 27);
		frame.getContentPane().add(findAll);
		
		
		String[][] data = serviceLayer.userList();
		String[] header = new String[] {"회원번호","이름","이메일","나이"};
		JPanel findAllP = new JPanel();
		findAllP.setBounds(108, 165, 588, 251);
		JTable table = new JTable(data,header);
		table.setRowHeight(30);
		table.setAlignmentX(0);
		table.setSize(550,400);
		table.setPreferredScrollableViewportSize(new Dimension(550,400));
		
		findAllP.add(new JScrollPane(table));
		frame.getContentPane().add(findAllP);
		
		String[][] data2 = serviceLayer.findByName(findName.getText());
		String[] header2 = new String[] {"회원번호","이름","이메일","나이"};
		JPanel findNameP = new JPanel();
		findNameP.setBounds(108, 165, 588, 251);
		JTable table2 = new JTable(data2,header2);
		table2.setRowHeight(30);
		table2.setAlignmentX(0);
		table2.setSize(550,400);
		table2.setPreferredScrollableViewportSize(new Dimension(550,400));
		
		findNameP.add(new JScrollPane(table2));
		frame.getContentPane().add(findNameP);
		
		find.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				findAllP.setVisible(false);
				//findNameP.setVisible(true);
			}
		});
		
		save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String nameValue = name.getText();
				String emailValue = email.getText();
				String ageValue = age.getText();
				
				if( nameValue.isEmpty() || emailValue.isEmpty() || ageValue.isEmpty()) {
					JOptionPane.showMessageDialog(null, "모두 작성해주세요.");
				}
				else {
					findAllP.setVisible(false);
					UserVO user = new UserVO();
					user.setName(nameValue);
					user.setEmail(emailValue);
					user.setAge(Integer.parseInt(ageValue));
					
					ServiceLayer serviceLayer = ServiceLayer.getInstance();
					serviceLayer.userInsert(user);
					
					
					findAllP.setVisible(true);
				}
			}
		});
	}
}
