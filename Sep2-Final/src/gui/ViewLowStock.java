package gui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import model.Part;

/**Creates the "ViewLowStock" pannel with all the included elements
 * @author Tomas, Marian
 *
 */
public class ViewLowStock extends JPanel {

	private ButtonHandler actionlistener;
	private MainGUI gui;

	private JButton btnUpdateStock, btnLogOut;
	private JList<Part> jlistLowStock;
	private JTextField txfStockField;
	private JScrollPane scrollDisplay;
	private JLabel lblRuningLow;
	private JButton btnRefresh;
	private JLabel lblPartId, lblName, lblMake, lblDescription, lblCategory, lblNrOfParts, lblShelf, lblBox;

	public ViewLowStock(MainGUI mainGUI, ButtonHandler buttonHandler) {

		this.setLayout(null);
		this.gui = gui;
		this.actionlistener = buttonHandler;
		this.setBackground(new Color(180, 200, 240));

		txfStockField = new JTextField();
		txfStockField.setBounds(480, 20, 100, 25);
		add(txfStockField);

		
		btnUpdateStock = new JButton("Update stock");
		btnUpdateStock.setBounds(600, 20, 120, 25);
		btnUpdateStock.addActionListener(actionlistener);
		btnUpdateStock.setBackground(Color.BLACK);
		btnUpdateStock.setForeground(Color.WHITE);
		add(btnUpdateStock);
		
		btnRefresh = new JButton("Refresh");
		btnRefresh.setBounds(750, 20, 100, 25);
		btnRefresh.addActionListener(actionlistener);
		btnRefresh.setBackground(Color.BLACK);
		btnRefresh.setForeground(Color.WHITE);
		add(btnRefresh);

		
		btnLogOut = new JButton("Logout");
		btnLogOut.setBounds(750, 500, 100, 25);
		btnLogOut.addActionListener(actionlistener);
		btnLogOut.setBackground(Color.BLACK);
		btnLogOut.setForeground(Color.WHITE);
		add(btnLogOut);

		jlistLowStock = new JList<Part>();
		jlistLowStock.addListSelectionListener(new SelectedObjAction());
		scrollDisplay = new JScrollPane(jlistLowStock);
		scrollDisplay
				.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollDisplay.setBounds(20, 85, 850, 410);
		jlistLowStock.setFont( new Font("monospaced", Font.ROMAN_BASELINE,11) );
		add(scrollDisplay);

		lblPartId = new JLabel("Part ID");
		lblPartId.setBounds(20, 60, 100, 25);
		lblPartId.setForeground(Color.BLACK);
		add(lblPartId);
		
		lblName = new JLabel("Name");
		lblName.setBounds(180, 60, 100, 25);
		lblName.setForeground(Color.BLACK);
		add(lblName);
		
		lblMake = new JLabel("Make");
		lblMake.setBounds(330, 60, 100, 25);
		lblMake.setForeground(Color.BLACK);
		add(lblMake);
		
		lblDescription = new JLabel("Description");
		lblDescription.setBounds(410, 60, 100, 25);
		lblDescription.setForeground(Color.BLACK);
		add(lblDescription);
		
		lblCategory = new JLabel("Category");
		lblCategory.setBounds(565, 60, 100, 25);
		lblCategory.setForeground(Color.BLACK);
		add(lblCategory);
		
		lblNrOfParts = new JLabel("Nr of parts");
		lblNrOfParts.setBounds(685, 60, 80, 25);
		lblNrOfParts.setForeground(Color.BLACK);
		add(lblNrOfParts);
		
		lblShelf = new JLabel("Shelf");
		lblShelf.setBounds(775, 60, 50, 25);
		lblShelf.setForeground(Color.BLACK);
		add(lblShelf);
		
		lblBox = new JLabel("Box");
		lblBox.setBounds(825, 60, 50, 25);
		lblBox.setForeground(Color.BLACK);
		add(lblBox);
		
		
	}
	
	
	
	public JButton getBtnUpdateStock() {
		return btnUpdateStock;
	}

	public JButton getBtnRefresh() {
		return btnRefresh;
	}

	public JButton getBtnLogOut() {
		return btnLogOut;
	}

	public JList<Part> getJlistLowStock() {
		return jlistLowStock;
	}

	public JTextField getTxfStockField() {
		return txfStockField;
	}

	public JScrollPane getScrollDisplay() {
		return scrollDisplay;
	}

	private class SelectedObjAction implements ListSelectionListener {

		@Override
		public void valueChanged(ListSelectionEvent e) {

		}

	}
}
