package gui;

import java.awt.Color;
import java.awt.TextArea;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

public class ViewLogPanel extends JPanel {

	private ButtonHandler actionlistener;
	private MainGUI gui;

	private JButton btnLogOut, btnGetLogs;
	private TextArea txfLog;
	private JScrollPane scrollPane;

	public ViewLogPanel(MainGUI gui, ButtonHandler buttonHandler) {
		this.setLayout(null);
		this.gui = gui;
		this.actionlistener = buttonHandler;
		this.setBackground(new Color(180, 200, 240));

		txfLog = new TextArea();
		txfLog.setEditable(false);
		scrollPane = new JScrollPane(txfLog);
		scrollPane
				.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(20, 50, 830, 440);
		add(scrollPane);

		btnGetLogs = new JButton("View logs");
		btnGetLogs.setBounds(400, 20, 100, 25);
		btnGetLogs.addActionListener(actionlistener);
		btnGetLogs.setBackground(Color.BLACK);
		btnGetLogs.setForeground(Color.WHITE);
		add(btnGetLogs);

		btnLogOut = new JButton("Logout");
		btnLogOut.setBounds(750, 500, 100, 25);
		btnLogOut.addActionListener(actionlistener);
		btnLogOut.setBackground(Color.BLACK);
		btnLogOut.setForeground(Color.WHITE);
		add(btnLogOut);

	}

	public JButton getBtnLogOut() {
		return btnLogOut;
	}

	public JButton getBtnGetLogs() {
		return btnGetLogs;
	}

	public TextArea getTxfLog() {
		return txfLog;
	}
}
