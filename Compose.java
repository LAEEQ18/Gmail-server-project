import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.*;
import java.awt.event.*;

public class Compose extends JFrame {

	private JPanel contentPane;
	private JTextField tfFrom;
	private JTextField tfSubject;
	private JTextField tfTo;

	public static void run() {

		Compose frame = new Compose();
		frame.setVisible(true);
		
	}

	public Compose() {
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				MainUI.main(null);
			}
		});
		setSize(403, 282);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JTextPane textPane = new JTextPane();
		textPane.setText("");
		textPane.setEnabled(true);
		textPane.setBounds(99, 134, 268, 64);
		contentPane.add(textPane);

		JLabel label = new JLabel("Message:");
		label.setBounds(10, 135, 79, 14);
		contentPane.add(label);

		JLabel Subject = new JLabel("Subject:");
		Subject.setBounds(10, 106, 79, 14);
		contentPane.add(Subject);

		JLabel label_2 = new JLabel("From:   ");
		label_2.setBounds(10, 75, 79, 14);
		contentPane.add(label_2);

		tfFrom = new JTextField();
		tfFrom.setColumns(10);
		tfFrom.setBounds(99, 72, 268, 20);
		contentPane.add(tfFrom);

		tfSubject = new JTextField();
		tfSubject.setColumns(10);
		tfSubject.setBounds(99, 103, 268, 20);
		contentPane.add(tfSubject);

		JLabel lblTo = new JLabel("To:   ");
		lblTo.setBounds(10, 47, 79, 14);
		contentPane.add(lblTo);

		tfTo = new JTextField();
		tfTo.setColumns(10);
		tfTo.setBounds(99, 44, 268, 20);
		contentPane.add(tfTo);

		JLabel labelTitle = new JLabel("Compose Email");
		labelTitle.setHorizontalAlignment(SwingConstants.CENTER);
		labelTitle.setBounds(109, 11, 163, 22);
		labelTitle.setFont(new Font("Arial Bold", Font.BOLD, 20));
		contentPane.add(labelTitle);

		JButton btnSend = new JButton("Send");
		btnSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Mail_Server.AllMessages
						.add(new Mail_items(tfFrom.getText(), tfTo.getText(), tfSubject.getText(), textPane.getText()));
				JOptionPane.showMessageDialog(null, "Email Sent Successfully!", "Compose Email",
						JOptionPane.INFORMATION_MESSAGE);
				InboxUI.run();
				dispose();
			}
		});
		btnSend.setBounds(278, 209, 89, 23);
		contentPane.add(btnSend);
		tfFrom.setText(Mail_Server.currentEmail);
	}

}
