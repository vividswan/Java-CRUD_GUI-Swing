package userService.gui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import userService.serviceLayer.ServiceLayer;
import userService.vo.UserVO;

public class UserService {

	ServiceLayer serviceLayer = ServiceLayer.getInstance();
	private JFrame frame;
	private JTextField name;
	private JTextField birth;
	private JTextField number;
	private JTextField findName;
	private JTextField modifyNum;
	private JTextField modifyId;
	private JTextField deleteId;

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
		frame.setBounds(100, 100, 784, 615);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel NameLabel = new JLabel("name :");
		NameLabel.setBounds(75, 27, 62, 18);
		frame.getContentPane().add(NameLabel);
		
		JLabel BirthLabel = new JLabel("birth :");
		BirthLabel.setBounds(270, 27, 62, 18);
		frame.getContentPane().add(BirthLabel);
		
		JLabel NumberLabel = new JLabel("number :");
		NumberLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		NumberLabel.setBounds(444, 27, 62, 18);
		frame.getContentPane().add(NumberLabel);
		
		name = new JTextField();
		name.setBounds(124, 24, 124, 24);
		frame.getContentPane().add(name);
		name.setColumns(10);
		
		birth = new JTextField();
		birth.setBounds(311, 24, 116, 24);
		frame.getContentPane().add(birth);
		birth.setColumns(10);
		
		number = new JTextField();
		number.setBounds(510, 24, 116, 24);
		frame.getContentPane().add(number);
		number.setColumns(10);
		
		JButton save = new JButton("\uB4F1\uB85D");
		save.setBounds(640, 23, 105, 27);
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
		findAll.setBounds(311, 228, 159, 27);
		frame.getContentPane().add(findAll);
		
		JTextArea ta = new JTextArea();
		ta.setBounds(180, 267, 446, 301);
		frame.getContentPane().add(ta);
		
		ta.setText("");
		String[][] arr = serviceLayer.userList();
		
		ta.append("number"+"\t"+"name"+"\t"+"birth date"+"\t"+"phone number"+"\n");
		ta.append("--------------------------------------------------------------------------------------------------------------\n");
		
		for (int i = 0; i < arr.length; i++) {
			ta.append(arr[i][0]+" \t "+ arr[i][1]+" \t "+arr[i][2]+" \t "+arr[i][3]+" \t "+ "\n");
		}
		
		
		modifyNum = new JTextField();
		modifyNum.setBounds(401, 127, 116, 24);
		frame.getContentPane().add(modifyNum);
		modifyNum.setColumns(10);
		
		modifyId = new JTextField();
		modifyId.setBounds(180, 127, 116, 24);
		frame.getContentPane().add(modifyId);
		modifyId.setColumns(10);
		
		JLabel numberLabel2 = new JLabel("number :");
		numberLabel2.setHorizontalAlignment(SwingConstants.TRAILING);
		numberLabel2.setBounds(325, 130, 62, 18);
		frame.getContentPane().add(numberLabel2);
		
		JLabel idLabel = new JLabel("ID :");
		idLabel.setBounds(134, 130, 62, 18);
		frame.getContentPane().add(idLabel);
		
		JButton modifyBtn = new JButton("\uC218\uC815");
		modifyBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		modifyBtn.setBounds(559, 126, 105, 27);
		frame.getContentPane().add(modifyBtn);
		
		JLabel label = new JLabel("ID :");
		label.setBounds(292, 174, 62, 18);
		frame.getContentPane().add(label);
		
		deleteId = new JTextField();
		deleteId.setBounds(335, 171, 116, 24);
		frame.getContentPane().add(deleteId);
		deleteId.setColumns(10);
		
		JButton deleteBtn = new JButton("\uC0AD\uC81C");
		deleteBtn.setBounds(477, 170, 105, 27);
		frame.getContentPane().add(deleteBtn);
		
				

		

		

		
		findAll.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				ta.setText("");
				String[][] arr = serviceLayer.userList();
				
				ta.append("number"+"\t"+"name"+"\t"+"birth date"+"\t"+"phone number"+"\n");
				ta.append("--------------------------------------------------------------------------------------------------------------\n");
				
				for (int i = 0; i < arr.length; i++) {
					ta.append(arr[i][0]+" \t "+ arr[i][1]+" \t "+arr[i][2]+" \t "+arr[i][3]+" \t "+ "\n");
				}
				
			}
		});
		
		
		
		
		find.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String val = findName.getText();
				
				ta.setText("");
				String[][] arr = serviceLayer.findByName(val);
				if(arr.length==0) JOptionPane.showMessageDialog(null, "해당되는 사용자가 없습니다.");
				
				ta.append("number"+"\t"+"name"+"\t"+"birth date"+"\t"+"phone number"+"\n");
				ta.append("--------------------------------------------------------------------------------------------------------------\n");
				
				for (int i = 0; i < arr.length; i++) {
					ta.append(arr[i][0]+" \t "+ arr[i][1]+" \t "+arr[i][2]+" \t "+arr[i][3]+" \t "+ "\n");
				}
			}
		});
		
		save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String nameValue = name.getText();
				String birthValue = birth.getText();
				String numberValue = number.getText();
				
				if( nameValue.isEmpty() || birthValue.isEmpty() || numberValue.isEmpty()) {
					JOptionPane.showMessageDialog(null, "모두 작성해주세요.");
				}
				else {
					UserVO user = new UserVO();
					user.setName(nameValue);
					user.setBirth(Integer.parseInt(birthValue));
					user.setNumber(numberValue);
					
					ServiceLayer serviceLayer = ServiceLayer.getInstance();
					serviceLayer.userInsert(user);
					
					JOptionPane.showMessageDialog(null, "등록되었습니다.");
					
					ta.setText("");
					String[][] arr = serviceLayer.userList();
					
					ta.append("number"+"\t"+"name"+"\t"+"birth date"+"\t"+"phone number"+"\n");
					ta.append("----------------------------------------------------------------------------------------------------------\n");
					
					for (int i = 0; i < arr.length; i++) {
						ta.append(arr[i][0]+" \t "+ arr[i][1]+" \t "+arr[i][2]+" \t "+arr[i][3]+" \t "+ "\n");
					}
									
				}
			}
		});
		
		modifyBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String idValue = modifyId.getText();
				String numberValue = modifyNum.getText();
				
				if( idValue.isEmpty() || numberValue.isEmpty()) {
					JOptionPane.showMessageDialog(null, "모두 작성해주세요.");
				}
				else {
					ServiceLayer serviceLayer = ServiceLayer.getInstance();
					serviceLayer.update(Integer.parseInt(idValue), numberValue);
					
					JOptionPane.showMessageDialog(null, "수정이 완료되었습니다.");
					
					ta.setText("");
					String[][] arr = serviceLayer.userList();
					
					ta.append("number"+"\t"+"name"+"\t"+"birth date"+"\t"+"phone number"+"\n");
					ta.append("--------------------------------------------------------------------------------------------------------------\n");
					
					for (int i = 0; i < arr.length; i++) {
						ta.append(arr[i][0]+" \t "+ arr[i][1]+" \t "+arr[i][2]+" \t "+arr[i][3]+" \t "+ "\n");
					}
					
				}
			}
		});
		
		deleteBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String idValue = deleteId.getText();
				
				if( idValue.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Id를 작성해주세요.");
				}
				else {
					ServiceLayer serviceLayer = ServiceLayer.getInstance();
					serviceLayer.delete(Integer.parseInt(idValue));
					
					JOptionPane.showMessageDialog(null, "삭제가 완료되었습니다.");
					
					ta.setText("");
					String[][] arr = serviceLayer.userList();
					
					ta.append("number"+"\t"+"name"+"\t"+"birth date"+"\t"+"phone number"+"\n");
					ta.append("--------------------------------------------------------------------------------------------------------------\n");
					
					for (int i = 0; i < arr.length; i++) {
						ta.append(arr[i][0]+" \t "+ arr[i][1]+" \t "+arr[i][2]+" \t "+arr[i][3]+" \t "+ "\n");
					}
				}
			}
		});
	}
}
