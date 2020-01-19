import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.*;
import java.awt.event.*;

public class InboxUI extends JFrame {

	private JPanel contentPane;
	private JTextField msgFrom;
	private JList<String> msgs;
	private JComboBox comboBox;
	DefaultListModel<String> dlm;
	
	public static void run() {
		
		InboxUI frame = new InboxUI();
		frame.setVisible(true);
		//System.out.println("AllMsgs 0 Unread: "+ Mail_Server.AllMessages.get(0).getUnRead());
		//System.out.println("AllMsgs: "+ Mail_Server.AllMessages.size());
	}

	public InboxUI() {
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
		
		JLabel lblTitle = new JLabel("Inbox");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setBounds(147, 11, 83, 29);
		lblTitle.setFont(new Font("Arial Bold", Font.BOLD, 25));
		contentPane.add(lblTitle);
		
		JButton btnCompose = new JButton("Compose");
		btnCompose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Compose.run();
				setVisible(false);
			}
		});
		btnCompose.setBounds(10, 39, 89, 23);
		contentPane.add(btnCompose);
		DefaultComboBoxModel<String> dcbm = new DefaultComboBoxModel<String>();
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Un-Read", "Read"}));
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				if(arg0.getStateChange() == ItemEvent.SELECTED) {
					if(arg0.getItem() == "Un-Read")
					{
						//JOptionPane.showMessageDialog(null, "Unread", "Register", JOptionPane.INFORMATION_MESSAGE);
						loadMails(true);
					}else if(arg0.getItem() == "Read"){
						//JOptionPane.showMessageDialog(null, "Read", "Register", JOptionPane.INFORMATION_MESSAGE);
						loadMails(false);
					}
				}
			}
		});
		comboBox.setBounds(109, 40, 166, 20);
		contentPane.add(comboBox);
		
		dlm = new DefaultListModel<>();
		dlm.addElement("You have 0 Mail");
		
		msgFrom = new JTextField();
		msgFrom.setEditable(false);
		msgFrom.setBounds(216, 71, 161, 20);
		contentPane.add(msgFrom);
		msgFrom.setColumns(10);
		
		JTextPane msgBody = new JTextPane();
		msgBody.setEditable(false);
		msgBody.setBounds(216, 102, 161, 130);
		contentPane.add(msgBody);
		
		JLabel msgFromLabel = new JLabel("From:");
		msgFromLabel.setVerticalAlignment(SwingConstants.BOTTOM);
		msgFromLabel.setBounds(147, 74, 59, 14);
		contentPane.add(msgFromLabel);
		
		JLabel msgBodyLabel = new JLabel("Message:");
		msgBodyLabel.setBounds(147, 102, 59, 14);
		contentPane.add(msgBodyLabel);
		 
		 JScrollPane scrollPane = new JScrollPane();
		 scrollPane.setBounds(10, 73, 127, 159);
		 contentPane.add(scrollPane);
		 
		  msgs = new JList<>();
		  scrollPane.setViewportView(msgs);
		  msgs.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				if(e.getValueIsAdjusting() == false)
				{
					for (Mail_items mi : Mail_Server.AllMessages) {
						if(mi.getTitle() == msgs.getSelectedValue())
						{
							msgFrom.setText(mi.getFrom());
							msgBody.setText(mi.getMessage());
							mi.setUnRead(1);
						}
					}
				}
			}
		});
		 msgs.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		JButton btnRefresh = new JButton("Refresh");
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				refreshInbox();
			}
		});
		btnRefresh.setBounds(288, 39, 89, 23);
		contentPane.add(btnRefresh);
		
		JButton btnNewButton = new JButton("Del");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(msgs.getSelectedIndex() != -1)
				{
					int count = 0;
					for (Mail_items mi : Mail_Server.AllMessages) {
						if(mi.getTitle().equals(msgs.getSelectedValue()) && mi.getFrom().equals(msgFrom.getText()) && mi.getMessage().equals(msgBody.getText()))
						{
							System.out.println("It Matched at: " + count);
							Mail_Server.AllMessages.remove(count);
							refreshInbox();
						}
						count++;
					}
				}
			}

			
		});
		btnNewButton.setBounds(147, 155, 59, 23);
		contentPane.add(btnNewButton);
		
		loadMails(true);
	}
	
	private void loadMails(boolean doUnread) {
		dlm = new DefaultListModel<>();
		for (Mail_items mi : Mail_Server.AllMessages) {
			if(doUnread)
			{
				if(mi.getTo().equals(Mail_Server.currentEmail) && mi.getUnRead() == 0)
				{
					System.out.println("Match Found");
					dlm.addElement(mi.getTitle());
					
				}	
			}else {
				System.out.println("No Is Read");
				if(mi.getTo().equals(Mail_Server.currentEmail) && mi.getUnRead() == 1)
				{
					System.out.println("Read Match Found");
					dlm.addElement(mi.getTitle());	
				}
			}
		}
		msgs.setModel(dlm);
	}
	private void refreshInbox() {
		if(comboBox.getSelectedIndex() == 0)
		{
			loadMails(true);
		}else {
			loadMails(false);
		}
	}
}
