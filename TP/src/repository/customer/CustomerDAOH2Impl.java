package repository.customer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Customer;
import repository.DBManager;

public class CustomerDAOH2Impl implements CustomerDAO {

	@Override
	public void createCustomer(Customer user) {

		String username = user.getUsername();
		String first_name = user.getFirstName();
		String last_name = user.getLastName();
		int nationalId = user.getNationalId();
		String email = user.getEmail();
		String address = user.getAddress();
		String password = user.getPassword();

		Connection c = DBManager.getConnection();
		System.out.println("Conexion para crear usuario establecida con exito.");

		try {
			Statement s = c.createStatement();
			String sql = "INSERT INTO customer (username, first_name, last_name, national_id, email, address, password) "
				  + "SELECT '" + username + "', '" + first_name + "', '" + last_name + "', '" + nationalId + "', '"
				  + email + "', '" + address + "', '" + password + "' "
				  + "WHERE NOT EXISTS (SELECT 1 FROM customer WHERE national_id = '" + nationalId + "');";
			s.executeUpdate(sql);
			c.commit();
			
			// Retrieve generated ID
	        try (ResultSet keys = s.getGeneratedKeys()) {
	            if (keys.next()) {
	                user.setId(keys.getInt(1)); // assign the DB generated id to customer object in memory
	            }
	        }
			
		} catch (SQLException e) {
			try {
				c.rollback();
				e.printStackTrace();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				c.close();
				System.out.println("Conexion para crear usuario cerrada correctamente.");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	@Override
	public void deleteCustomer(int customerID) {

		Connection c = DBManager.getConnection();
		System.out.println("Conexion para borrar usuario establecida con exito.");

		try {
			System.out.println(customerID);
			Statement s = c.createStatement();
			String sql = "DELETE FROM customer WHERE id = " + customerID;
			s.executeUpdate(sql);
			c.commit();
		} catch (SQLException e) {
			try {
				c.rollback();
				e.printStackTrace();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				c.close();
				System.out.println("Conexion para borrar usuario cerrada correctamente.");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	@Override
	public void updateCustomer(Customer customer) {
	    Connection c = DBManager.getConnection();
	    System.out.println("Conexion para actualizar usuario establecida con exito.");

	    try {
	        Statement s = c.createStatement();
	        String sql = "UPDATE customer SET "
	                   + "username = '" + customer.getUsername() + "', "
	                   + "first_name = '" + customer.getFirstName() + "', "
	                   + "last_name = '" + customer.getLastName() + "', "
	                   + "national_id = '" + customer.getNationalId() + "', "
	                   + "email = '" + customer.getEmail() + "', "
	                   + "address = '" + customer.getAddress() + "', "
	                   + "password = '" + customer.getPassword() + "' "
	                   + "WHERE id = " + customer.getId() + ";";

	        int rows = s.executeUpdate(sql);
	        System.out.println("Filas actualizadas: " + rows);
	        c.commit();

	    } catch (SQLException e) {
	        try {
	            c.rollback();
	            e.printStackTrace();
	        } catch (SQLException e1) {
	            e1.printStackTrace();
	        }
	    } finally {
	        try {
	            c.close();
	            System.out.println("Conexion para actualizar usuario cerrada correctamente.");
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	}

	@Override
	public Customer readCustomer(String username) {
	    Connection c = DBManager.getConnection();
	    System.out.println("Conexion para leer usuario establecida con exito.");

	    Customer customer = null;

	    try {
	        Statement s = c.createStatement();
	        String sql = "SELECT id, username, first_name, last_name, national_id, email, address, password "
	                   + "FROM customer WHERE username = '" + username + "';";

	        ResultSet rs = s.executeQuery(sql);

	        if (rs.next()) {
	            customer = new Customer(
	                rs.getString("username"),
	                rs.getString("first_name"),
	                rs.getString("last_name"),
	                rs.getInt("national_id"),
	                rs.getString("email"),
	                rs.getString("address"),
	                rs.getString("password")
	            );
	            customer.setId(rs.getInt("id"));
	        }

	        rs.close();
	        s.close();
	        c.commit();

	    } catch (SQLException e) {
	        try {
	            c.rollback();
	            e.printStackTrace();
	        } catch (SQLException e1) {
	            e1.printStackTrace();
	        }
	    } finally {
	        try {
	            c.close();
	            System.out.println("Conexion para leer usuario cerrada correctamente.");
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    return customer;
	}


	@Override
	public List<Customer> listAllCustomers() {
		List<Customer> customers = new ArrayList<>();
		String sql = "SELECT id, username, first_name, last_name, national_id, email, address, password FROM customer";

		try (Connection c = DBManager.getConnection();
				Statement s = c.createStatement();
				var rs = s.executeQuery(sql)) {

			while (rs.next()) {
				Customer u = new Customer(
						rs.getString("username"), 
						rs.getString("first_name"), 
						rs.getString("last_name"),
						rs.getInt("national_id"),
						rs.getString("email"),
						rs.getString("address"),
						rs.getString("password")
				);
				u.setId(rs.getInt("id"));
				customers.add(u);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return customers;

	}

}
