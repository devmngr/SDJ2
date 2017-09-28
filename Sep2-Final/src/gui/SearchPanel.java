package gui;

import java.awt.*;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import model.Part;

/**Creates the "Search" pannel with all the included elements
 * @author Tomas, Bogdan
 *
 */
public class SearchPanel extends JPanel {

	private ButtonHandler actionlistener;
	private ButtonGroup group;
	private JRadioButton radioPartId, radioName, radioCategory, radioAll;
	private JButton btnSearch, btnLogOut, btnRemoveFromStock;
	private JTextField txfSearch;
	private JLabel lblPartId, lblName, lblMake, lblDescription, lblCategory, lblNrOfParts, lblShelf, lblBox;
	private JList<Part> jlistParts;
	private JScrollPane scrollPaneParts;

	public SearchPanel(MainGUI gui, ButtonHandler buttonHandler) {
		this.setLayout(null);
		this.actionlistener = buttonHandler;
		this.setBackground(new Color(180, 200, 240));

		radioPartId = new JRadioButton("Part ID");
		radioPartId.setBounds(20, 20, 75, 25);
		radioPartId.setForeground(Color.BLACK);
		radioPartId.setBackground(new Color(180, 200, 240));
		radioName = new JRadioButton("Part name");
		radioName.setBounds(95, 20, 110, 25);
		radioName.setForeground(Color.BLACK);
		radioName.setBackground(new Color(180, 200, 240));
		radioCategory = new JRadioButton("Category");
		radioCategory.setBounds(205, 20, 110, 25);
		radioCategory.setForeground(Color.BLACK);
		radioCategory.setBackground(new Color(180, 200, 240));
		radioAll = new JRadioButton("All parts");
		radioAll.setBounds(315, 20, 75, 25);
		radioAll.setForeground(Color.BLACK);
		radioAll.setBackground(new Color(180, 200, 240));

		group = new ButtonGroup();
		group.add(radioPartId);
		group.add(radioName);
		group.add(radioCategory);
		group.add(radioAll);
		add(radioPartId);
		add(radioName);
		add(radioCategory);
		add(radioAll);

		txfSearch = new JTextField();
		txfSearch.setBounds(450, 20, 100, 25);
		add(txfSearch);

		btnSearch = new JButton("Search");
		btnSearch.setBounds(600, 20, 100, 25);
		btnSearch.addActionListener(actionlistener);
		btnSearch.setBackground(Color.BLACK);
		btnSearch.setForeground(Color.WHITE);
		add(btnSearch);

		btnRemoveFromStock = new JButton("Use part(s)");
		btnRemoveFromStock.setBounds(730, 20, 140, 25);
		btnRemoveFromStock.addActionListener(actionlistener);
		btnRemoveFromStock.setBackground(Color.BLACK);
		btnRemoveFromStock.setForeground(Color.WHITE);
		add(btnRemoveFromStock);

		btnLogOut = new JButton("Logout");
		btnLogOut.setBounds(750, 500, 100, 25);
		btnLogOut.addActionListener(actionlistener);
		btnLogOut.setBackground(Color.BLACK);
		btnLogOut.setForeground(Color.WHITE);
		add(btnLogOut);

		jlistParts = new JList<Part>();

		jlistParts.addListSelectionListener(new SelectedPartAction());

		scrollPaneParts = new JScrollPane(jlistParts);
		scrollPaneParts
				.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPaneParts.setBounds(20, 85, 850, 410);
		jlistParts.setFont( new Font("monospaced", Font.ROMAN_BASELINE,11) );
		add(scrollPaneParts);
		
		
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

	public ButtonGroup getGroup() {
		return group;
	}

	public JRadioButton getRadioPartId() {
		return radioPartId;
	}

	public JRadioButton getRadioName() {
		return radioName;
	}

	public JRadioButton getRadioCategory() {
		return radioCategory;
	}

	public JRadioButton getRadioAll() {
		return radioAll;
	}

	public JButton getBtnSearch() {
		return btnSearch;
	}

	public JButton getBtnLogOut() {
		return btnLogOut;
	}

	public JButton getBtnRemoveFromStock() {
		return btnRemoveFromStock;
	}

	public JTextField getTxfSearch() {
		return txfSearch;
	}

	public JList<Part> getJlistParts() {
		return jlistParts;
	}

	public JScrollPane getScrollPaneParts() {
		return scrollPaneParts;
	}

	private class SelectedPartAction implements ListSelectionListener {

		@Override
		public void valueChanged(ListSelectionEvent e) {
			if (e.getSource() == jlistParts) {
				jlistParts.getSelectedValue();
			}
		}
	}
}
