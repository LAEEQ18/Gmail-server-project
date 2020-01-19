import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.*;
import java.awt.event.*;

public class MainUI extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField textField;
	private JLabel lblNewLabel_1;
	private JButton btnRegister;
	private JButton btnLogin;
	private JPasswordField passwordField;

	public static void main(String[] args) {
		MainUI frame = new MainUI();
		frame.setVisible(true);
		System.out.println(Mail_Server.Account_Entry.size());
	}

	/**
	 * Create the frame.
	 */
	public MainUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(383, 179);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblTitle = new JLabel("Welcome! Login or Register.");
		lblTitle.setBounds(10, 10, 335, 29);
		lblTitle.setFont(new Font("Arial Bold", Font.BOLD, 25));
		contentPane.add(lblTitle);

		JLabel lblNewLabel = new JLabel("Username/Email:");
		lblNewLabel.setBounds(10, 47, 107, 14);
		contentPane.add(lblNewLabel);

		textField = new JTextField();
		textField.setBounds(127, 44, 218, 20);
		contentPane.add(textField);
		textField.setColumns(20);

		lblNewLabel_1 = new JLabel("Password: ");
		lblNewLabel_1.setBounds(10, 78, 107, 14);
		contentPane.add(lblNewLabel_1);

		btnLogin = new JButton("Login");
		btnLogin.addActionListener(this);
		btnLogin.setBounds(256, 106, 89, 23);
		contentPane.add(btnLogin);

		btnRegister = new JButton("Register");
		btnRegister.addActionListener(this);
		btnRegister.setBounds(10, 106, 89, 23);
		contentPane.add(btnRegister);

		passwordField = new JPasswordField();
		passwordField.setBounds(127, 75, 218, 20);
		contentPane.add(passwordField);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnRegister) {
			Register.run();
			this.setVisible(false);
		} else if (e.getSource() == btnLogin) {
			loginMethod();
			
		}
	}

	private void loginMethod() {
		for (Mail_items email : Mail_Server.Account_Entry) {
			
			if (((textField.getText().equals(email.getEmail())) || (textField.getText().equals(email.getUserName())))
					&& String.valueOf(passwordField.getPassword()).equals(email.getPassword())) {
				//JOptionPane.showMessageDialog(this, "Correct", "Lets See!", JOptionPane.INFORMATION_MESSAGE);
				this.setVisible(false);
				Mail_Server.currentEmail = email.getEmail();
				
				InboxUI.run();
				
			}
		}
	}
}
