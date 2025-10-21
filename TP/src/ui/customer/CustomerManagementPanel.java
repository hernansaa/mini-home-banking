package ui.customer;

import java.awt.*;
import java.awt.event.*;
import java.util.List;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import model.Customer;
import repository.customer.CustomerDAO;
import repository.customer.CustomerDAOH2Impl;
import ui.PanelManager;

public class CustomerManagementPanel extends JPanel implements ActionListener {

    private PanelManager panelManager;

    private JTable usersTable;
    private CustomerTableModel model;

    private JButton addButton;
    private JButton deleteButton;

    private CustomerFormPanel customerFormPanel;

    private CustomerDAO customerDAO;

    public CustomerManagementPanel(PanelManager panelManager) {
        this.panelManager = panelManager;
        buildPanel();
    }

    public void buildPanel() {
        setLayout(new BorderLayout(10, 10));
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // === LEFT SIDE ===
        JPanel leftPanel = new JPanel(new BorderLayout(10, 10));

        model = new CustomerTableModel();
        usersTable = new JTable(model);
        JScrollPane scrollPanelForTable = new JScrollPane(usersTable);
        leftPanel.add(scrollPanelForTable, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        deleteButton = new JButton("Delete");
        addButton = new JButton("Add New");

        deleteButton.addActionListener(this);
        addButton.addActionListener(this);
        buttonPanel.add(deleteButton);
        buttonPanel.add(addButton);

        leftPanel.add(buttonPanel, BorderLayout.SOUTH);

        // === RIGHT SIDE ===
        customerFormPanel = new CustomerFormPanel(panelManager);
        customerFormPanel.setPreferredSize(new Dimension(400, 0));
        customerFormPanel.setSaveListener(() -> refreshTable());

        // === SPLIT PANE ===
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, leftPanel, customerFormPanel);
        splitPane.setDividerLocation(550);
        splitPane.setResizeWeight(0.6);
        splitPane.setContinuousLayout(true);
        splitPane.setOneTouchExpandable(true);
        add(splitPane, BorderLayout.CENTER);

        // === DATA LOADING ===
        customerDAO = new CustomerDAOH2Impl();
        refreshTable();

        // === TABLE ROW CLICK ===
        usersTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        usersTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    int selectedRow = usersTable.getSelectedRow();
                    if (selectedRow >= 0) {
                        Customer selectedCustomer = model.getCustomerAt(selectedRow);
                        customerFormPanel.loadCustomer(selectedCustomer);
                    }
                }
            }
        });
    }

    private void refreshTable() {
        List<Customer> customersList = customerDAO.listAllCustomers();
        model.setContent(customersList);
        model.fireTableDataChanged();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == deleteButton) {
            int selectedRow = usersTable.getSelectedRow();
            if (selectedRow >= 0) {
                Customer selected = model.getCustomerAt(selectedRow);
                int confirm = JOptionPane.showConfirmDialog(this,
                        "Are you sure you want to delete " + selected.getFirstName() + "?", "Confirm",
                        JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    customerDAO.deleteCustomer(selected.getId());
                    refreshTable();
                    customerFormPanel.clearForm();
                }
            }
        }
        if (e.getSource() == addButton) {
            customerFormPanel.clearForm();
            usersTable.clearSelection();
        }
    }
}


