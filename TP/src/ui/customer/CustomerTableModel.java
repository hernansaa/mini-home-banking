package ui.customer;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.Customer;

public class CustomerTableModel extends AbstractTableModel {

	// COLUMN INDICES
	private static final int COLUMN_USERNAME = 0;
	private static final int COLUMN_FIRSTNAME = 1;
	private static final int COLUMN_LASTNAME = 2;
	private static final int COLUMN_NATIONALID = 3;
	private static final int COLUMN_EMAIL = 4;
	private static final int COLUMN_ADDRESS = 5;
	private static final int COLUMN_PASSWORD = 6;

	// HEADERS NAMES
	private String[] columnNames = {
			"Username", 
			"First Name", 
			"Last Name", 
			"National ID",
			"E-Mail",
			"Address",
			"Password"
	};
	
	// COLUMN TYPES
	private Class[] columnTypes = {
			String.class, 
			String.class,
			String.class,
			Integer.class,
			String.class,
			String.class,
			String.class
	};
	
	private List<Customer> content;
	
	// CONSTRUCTOR VACIO
	public CustomerTableModel() {
		content = new ArrayList<Customer>();
	}
	
	// CONSTRUCTOR SOBRECARGADO CON CONTENIDO INICIAL
	public CustomerTableModel(List<Customer> initialContent) {
		content = initialContent;
	}
	
	@Override
	public int getColumnCount() {
		return this.columnNames.length;
	}
		
	@Override
	public int getRowCount() {
		return this.content.size();
	}
	
	@Override
	public String getColumnName(int col) {
		return columnNames[col];
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		
		Customer u = this.content.get(rowIndex);
		
		Object result = null;
		
		switch(columnIndex) {
		case COLUMN_USERNAME:
			result = u.getUsername();
			break;
		case COLUMN_FIRSTNAME:
			result = u.getFirstName();
			break;
		case COLUMN_LASTNAME:
			result = u.getLastName();
			break;
		case COLUMN_NATIONALID:
			result = u.getNationalId();
			break;
		case COLUMN_EMAIL:
			result = u.getEmail();
			break;
		case COLUMN_ADDRESS:
			result = u.getAddress();
			break;
		case COLUMN_PASSWORD:
			result = u.getPassword();
			break;
		}
			
		return result;
	}
	
	// ROW GETTERS
	public List<Customer> getContent() {
		return this.content;
	}
	
	// ROW SETTERS
	public void setContent(List<Customer> content) {
		this.content = content;
	}
	
	public Customer getCustomerAt(int rowIndex) {
	    if (rowIndex >= 0 && rowIndex < content.size()) {
	        return content.get(rowIndex);
	    }
	    return null;
	}
}