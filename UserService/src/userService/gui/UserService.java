package userService.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UserService {

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
		save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String nameValue = name.getText();
				String emailValue = email.getText();
				String ageValue = age.getText();
			}
		});
		
		JLabel FindNameLabel = new JLabel("Find Name :");
		FindNameLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		FindNameLabel.setBounds(167, 75, 138, 18);
		frame.getContentPane().add(FindNameLabel);
		
		findName = new JTextField();
		findName.setBounds(311, 72, 116, 24);
		frame.getContentPane().add(findName);
		findName.setColumns(10);
		
		JButton find = new JButton("\uC870\uD68C");
		find.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		find.setBounds(441, 71, 105, 27);
		frame.getContentPane().add(find);
	}
}
