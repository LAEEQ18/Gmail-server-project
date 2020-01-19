import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.*;
import java.awt.event.*;

public class Register extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	
	public static void run() {
		Register frame = new Register();
		frame.setVisible(true);
	}
	
	public Register() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				MainUI.main(null);
			}
		});
		
		setSize(376, 219);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRegisterANew = new JLabel("Register a New Email");
		lblRegisterANew.setBounds(47, 11, 262, 37);
		lblRegisterANew.setFont(new Font("Arial Bold", Font.BOLD, 25));
		contentPane.add(lblRegisterANew);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setBounds(10, 59, 73, 14);
		contentPane.add(lblUsername);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(10, 84, 46, 14);
		contentPane.add(lblEmail);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(10, 109, 73, 14);
		contentPane.add(lblPassword);
		
		textField = new JTextField();
		textField.setBounds(93, 59, 252, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(93, 84, 252, 20);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(93, 109, 252, 20);
		contentPane.add(textField_2);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent eve) {
				Mail_Server.Account_Entry.add(new Mail_items(textField.getText(), textField_1.getText(), textField_2.getText()));
				JOptionPane.showMessageDialog(null, "New Email Registered!", "Register", JOptionPane.INFORMATION_MESSAGE);
				MainUI.main(null);
				dispose();
			}
		});
		btnRegister.setBounds(256, 140, 89, 23);
		contentPane.add(btnRegister);
		
	}
}
