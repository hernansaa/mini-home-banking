package ui.customer;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import excepciones.EmailInvalidoException;
import excepciones.PasswordInvalidoException;
import excepciones.TextoVacioException;
import excepciones.Validador;
import model.Customer;
import repository.customer.CustomerDAO;
import repository.customer.CustomerDAOH2Impl;
import ui.PanelManager;
import ui.listeners.SaveListener;

public class CustomerFormPanel extends JPanel implements ActionListener {
	
    private PanelManager panelManager;
    private SaveListener saveListener;

    private JTextField usernameField;
    private JTextField firstNameField;
    private JTextField lastNameField;
    private JTextField nationalIdField;
    private JTextField emailField;
    private JTextField addressField;
    private JPasswordField passwordField;

    private JButton saveButton;
    private JButton cancelButton;
    
    private Customer currentCustomer = null; // To track editing state

    public CustomerFormPanel(PanelManager panelManager) {
        this.panelManager = panelManager;
        buildPanel();
    }
    
    public void setSaveListener(SaveListener listener) {
    	this.saveListener = listener;
    }

    public void buildPanel() {
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));

        // TITLE
        JLabel titleLabel = new JLabel("New/Update Customer");
        titleLabel.setFont(new Font("SansSerif", Font.BOLD, 20));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(titleLabel, BorderLayout.NORTH);

        // FORM PANEL (CENTER)
        JPanel formPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.WEST;

        usernameField = new JTextField(20);
        firstNameField = new JTextField(20);
        lastNameField = new JTextField(20);
        nationalIdField = new JTextField(20);
        emailField = new JTextField(20);
        addressField = new JTextField(20);
        passwordField = new JPasswordField(20);

        int y = 0;
        addField(formPanel, gbc, y++, "Username:", usernameField);
        addField(formPanel, gbc, y++, "First Name:", firstNameField);
        addField(formPanel, gbc, y++, "Last Name:", lastNameField);
        addField(formPanel, gbc, y++, "National ID:", nationalIdField);
        addField(formPanel, gbc, y++, "E-mail:", emailField);
        addField(formPanel, gbc, y++, "Address:", addressField);
        addField(formPanel, gbc, y++, "Password:", passwordField);

        add(formPanel, BorderLayout.CENTER);

        // BUTTON PANEL (SOUTH)
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        saveButton = new JButton("Save");
        cancelButton = new JButton("Cancel");

        saveButton.setBackground(new Color(66, 133, 244));
        saveButton.setForeground(Color.WHITE);
        cancelButton.setBackground(new Color(234, 67, 53));
        cancelButton.setForeground(Color.WHITE);

        saveButton.setFocusPainted(false);
        cancelButton.setFocusPainted(false);

        saveButton.addActionListener(this);
        cancelButton.addActionListener(this);

        buttonPanel.add(cancelButton);
        buttonPanel.add(saveButton);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    private void addField(JPanel panel, GridBagConstraints gbc, int y, String labelText, JComponent field) {
        gbc.gridx = 0;
        gbc.gridy = y;
        gbc.weightx = 0.3;
        panel.add(new JLabel(labelText), gbc);

        gbc.gridx = 1;
        gbc.weightx = 0.7;
        panel.add(field, gbc);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == cancelButton) {
            clearForm();
        }
        if (e.getSource() == saveButton) {
        	saveCustomer();
        }
    }

    private void saveCustomer() {
        String username = usernameField.getText().trim();
        String firstName = firstNameField.getText().trim();
        String lastName = lastNameField.getText().trim();
        String nationalIdText = nationalIdField.getText().trim();
        String email = emailField.getText().trim();
        String address = addressField.getText().trim();
        String password = new String(passwordField.getPassword());

        try {
            Validador.validarTextoNoVacio(username);
            Validador.validarTextoNoVacio(firstName);
            Validador.validarTextoNoVacio(lastName);
            Validador.validarTextoNoVacio(nationalIdText);
            Validador.validarTextoNoVacio(email);
            Validador.validarTextoNoVacio(address);
            Validador.validarEmail(email);
            Validador.validarPassword(password);
        } catch (TextoVacioException | EmailInvalidoException | PasswordInvalidoException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // TEXT TO INT NATIONAL ID
        int nationalId;
        try {
            nationalId = Integer.parseInt(nationalIdText);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "National ID must be a valid number.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        CustomerDAO customerDAO = new CustomerDAOH2Impl();
        
        if (currentCustomer == null) {
            // CREATE NEW
            Customer newCustomer = new Customer(username, firstName, lastName, nationalId, email, address, password);
            customerDAO.createCustomer(newCustomer);
            JOptionPane.showMessageDialog(this, "Cliente creado satisfactoriamente!");
        } else {
            // UPDATE EXISTING
            currentCustomer.setUsername(username);
            currentCustomer.setFirstName(firstName);
            currentCustomer.setLastName(lastName);
            currentCustomer.setNationalId(nationalId);
            currentCustomer.setEmail(email);
            currentCustomer.setAddress(address);
            currentCustomer.setPassword(password);
            customerDAO.updateCustomer(currentCustomer);
            JOptionPane.showMessageDialog(this, "Cliente actualizado satisfactoriamente!");
        }
                
        if (saveListener != null) {
        	saveListener.onSaved(); // Notifies the rest of the App that the save operation succeeded.
        	clearForm();
        }
    }
    
    // Loads customer data into form for editing
    public void loadCustomer(Customer customer) {
        this.currentCustomer = customer;
        usernameField.setText(customer.getUsername());
        firstNameField.setText(customer.getFirstName());
        lastNameField.setText(customer.getLastName());
        nationalIdField.setText(String.valueOf(customer.getNationalId()));
        emailField.setText(customer.getEmail());
        addressField.setText(customer.getAddress());
        passwordField.setText(customer.getPassword());
    }

    //Clears all form inputs
    public void clearForm() {
        usernameField.setText("");
        firstNameField.setText("");
        lastNameField.setText("");
        nationalIdField.setText("");
        emailField.setText("");
        addressField.setText("");
        passwordField.setText("");
        currentCustomer = null;
    }
}
