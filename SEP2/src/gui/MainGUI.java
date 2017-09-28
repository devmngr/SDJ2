package gui;
import java.rmi.RemoteException;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import rmi.RmiClient;

public class MainGUI extends JFrame {

	private ButtonHandler buttonHandler;

	private static JTabbedPane tabPane;
	private RmiClient rmiClient;

	private LogInPanel logInPanel;
	private SearchPanel searchPanel;
	private ViewPanel viewPanel;
	private CreatePanel createPanel;
	private EditPanel editPanel;
	private ViewLogPanel viewLogPanel;

	private MyTabListener tabListener;

	public MainGUI() throws RemoteException {
		super("Main GUI");
		this.rmiClient = new RmiClient();
		buttonHandler = new ButtonHandler(this, rmiClient);
		
		tabListener = new MyTabListener();
	
		createPanel = new CreatePanel(this, buttonHandler);
		logInPanel = new LogInPanel(this, buttonHandler);
		searchPanel = new SearchPanel(this, buttonHandler);
		viewPanel = new ViewPanel(this, buttonHandler);
		editPanel = new EditPanel(this, buttonHandler);
		viewLogPanel = new ViewLogPanel(this, buttonHandler);
	
		tabPane = new JTabbedPane();
	
		tabPane.addTab("Log In panel", logInPanel);
		
	
		// tabPane.setVisible(false);
		editPanel.setVisible(false);
		tabPane.addChangeListener(tabListener);
	
		add(tabPane);
		setSize(900, 600);
		setVisible(true);
		setResizable(false);
	
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}


	public void changeTab(int index) {
		tabPane.setSelectedIndex(index);
	}


	public void showAllPanels() {
		tabPane.addTab("Search panel", searchPanel);
		tabPane.addTab("View panel", viewPanel);
		tabPane.addTab("Create panel", createPanel);
		tabPane.addTab("Edit panel", editPanel);
		tabPane.addTab("View Log panel", viewLogPanel);
		tabPane.repaint();
	}


	public LogInPanel getLogInPanel() {
		return logInPanel;
	}

	public void setLogInPanel(LogInPanel logInPanel) {
		this.logInPanel = logInPanel;
	}

	public SearchPanel getSearchPanel() {
		return searchPanel;
	}

	public void setSearchPanel(SearchPanel searchPanel) {
		this.searchPanel = searchPanel;
	}

	public ViewPanel getViewPanel() {
		return viewPanel;
	}

	public void setViewPanel(ViewPanel viewPanel) {
		this.viewPanel = viewPanel;
	}

	public CreatePanel getCreatePanel() {
		return createPanel;
	}

	public void setCreatePanel(CreatePanel createPanel) {
		this.createPanel = createPanel;
	}

	public EditPanel getEditPanel() {
		return editPanel;
	}

	public void setEditPanel(EditPanel editPanel) {
		this.editPanel = editPanel;
	}

	public ViewLogPanel getViewLogPanel() {
		return viewLogPanel;
	}

	public void setViewLogPanel(ViewLogPanel viewLogPanel) {
		this.viewLogPanel = viewLogPanel;
	}

	private class MyTabListener implements ChangeListener {
		@Override
		public void stateChanged(ChangeEvent e) {
	
		}
	}


	public static void main(String[] args) throws RemoteException {
		MainGUI gui = new MainGUI();
	}
}
