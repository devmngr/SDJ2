package gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class LogInPanel extends JPanel {

	private ButtonHandler actionlistener;
	private MainGUI gui;
	

	private JButton  btnd;
	private JLabel lblUsername, lblPassword, lblLogo;
	private JTextField txfUserName, txfPassword;
	private ImageIcon logoIcon;

	public LogInPanel(MainGUI gui,ButtonHandler buttonHandler) {
		this.setLayout(null);
		this.gui = gui;
		this.actionlistener =buttonHandler;
		this.setBackground(new Color(180, 200, 240));
		
		ImageIcon logoIcon = new ImageIcon("workshoplogo2.jpg");
		JLabel lblLogo = new JLabel(logoIcon);
		lblLogo.setBounds(230,-140, 400, 400);
		lblLogo.setBackground(new Color(180, 200, 240));
		add(lblLogo);
		
		
		
		lblUsername = new JLabel("UserName: ");
		lblUsername.setBounds(300, 180, 220, 25);
		add(lblUsername);
				
		txfUserName = new JTextField();
		txfUserName.setBounds(300,200,240,25);
		txfUserName.setEditable(true);
		add(txfUserName);
		
		lblPassword = new JLabel("Password: ");
		lblPassword.setBounds(300, 240, 220, 25);
		add(lblPassword);
		
		txfPassword = new JTextField();
		txfPassword.setBounds(300,260,240,25);
		txfPassword.setEditable(true);
		add(txfPassword);
		
		btnd = new JButton("Log in");
		btnd.setBounds(350, 300, 120, 25);
		btnd.addActionListener(actionlistener);
		btnd.setBackground(Color.BLACK);
		btnd.setForeground(Color.WHITE);
		 add(btnd);
	
		 
	
	}
	public JButton getBtnd() {
		return btnd;
	}

	public void setBtnd(JButton btnd) {
		this.btnd = btnd;
	}

	public JTextField getTxfUserName() {
		return txfUserName;
	}

	public void setTxfUserName(JTextField txfUserName) {
		this.txfUserName = txfUserName;
	}

	public JTextField getTxfPassword() {
		return txfPassword;
	}

	public void setTxfPassword(JTextField txfPassword) {
		this.txfPassword = txfPassword;
	}
}
