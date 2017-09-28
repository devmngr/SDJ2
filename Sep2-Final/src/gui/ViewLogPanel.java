package gui;



import java.awt.Color;
import java.awt.Font;
import java.awt.TextArea;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import model.Log;
import model.Part;

/** Creates the "ViewLog" pannel with all the included elements
 * @author Tomas, Bogdan, Alexandru
 *
 */
public class ViewLogPanel extends JPanel {

	private ButtonHandler actionlistener;
	private MainGUI gui;

	private JButton btnLogOut, btnViewLog;
	private JLabel lblPartId, lblTime, lblNr, lblDescription;
	private JList<Log> jlistLog;
	private JScrollPane scrollPane;

	public ViewLogPanel(MainGUI gui, ButtonHandler buttonHandler) {
		this.setLayout(null);
		this.gui = gui;
		this.actionlistener = buttonHandler;
		this.setBackground(new Color(180, 200, 240));

		jlistLog = new JList<Log>();
		scrollPane = new JScrollPane(jlistLog);
		scrollPane
				.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(20, 85, 850, 410);
		jlistLog.setFont( new Font("monospaced", Font.ROMAN_BASELINE,11) );
		add(scrollPane);

		btnLogOut = new JButton("Logout");
		btnLogOut.setBounds(750, 500, 100, 25);
		btnLogOut.addActionListener(actionlistener);
		btnLogOut.setBackground(Color.BLACK);
		btnLogOut.setForeground(Color.WHITE);
		add(btnLogOut);
		
		btnViewLog = new JButton("Refresh");
		btnViewLog.setBounds(400, 20, 100, 25);
		btnViewLog.addActionListener(actionlistener);
		btnViewLog.setBackground(Color.BLACK);
		btnViewLog.setForeground(Color.WHITE);
		add(btnViewLog);
		
		
		lblTime = new JLabel("Time");
		lblTime.setBounds(20, 60, 100, 25);
		lblTime.setForeground(Color.BLACK);
		add(lblTime);
		
		lblNr = new JLabel("Nr.");
		lblNr.setBounds(175, 60, 100, 25);
		lblNr.setForeground(Color.BLACK);
		add(lblNr);
		
		lblDescription = new JLabel("Description");
		lblDescription.setBounds(210, 60, 100, 25);
		lblDescription.setForeground(Color.BLACK);
		add(lblDescription);
		


	}

	public JButton getBtnLogOut() {
		return btnLogOut;
	}

	public JList getJListLog() {
		return jlistLog;
	}
	
	public JButton getBtnViewLog() {
		return btnViewLog;
	}
	
}
