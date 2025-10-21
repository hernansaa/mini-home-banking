package ui;

import javax.swing.JFrame;

import ui.customer.CustomerFormPanel;
import ui.customer.CustomerManagementPanel;

public class PanelManager {
	
	private JFrame frame;
	private CustomerManagementPanel customerManagementPanel;
	private CustomerFormPanel customerFormPanel;
	
	public PanelManager() {
	}
	
	public void buildManager( ) {
		frame = new JFrame("Mini Home Banking");
		frame.setBounds(1000, 1000, 1000, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		customerManagementPanel = new CustomerManagementPanel(this);
		customerManagementPanel.buildPanel();
		
		customerFormPanel = new CustomerFormPanel(this);
		customerFormPanel.buildPanel();
	}
	
	public void showFrame() {
		frame.setVisible(true);
	}
	
	public void showCustomerManagementPanel() {
		frame.getContentPane().removeAll();
		frame.getContentPane().add(customerManagementPanel);
		frame.getContentPane().validate();
		frame.getContentPane().repaint();
	}
	
	public void showCustomerFormPanel() {
		frame.getContentPane().removeAll();
		frame.getContentPane().add(customerFormPanel);
		frame.getContentPane().validate();
		frame.getContentPane().repaint();
	}
	
}
