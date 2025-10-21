package repository;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TableManager {

	public void createUserTables() {

		// H2 compatible SQL
		String createCustomerTable = """
				CREATE TABLE IF NOT EXISTS customer (
				       id INT PRIMARY KEY AUTO_INCREMENT,
				       username VARCHAR(256) NOT NULL UNIQUE,
				       first_name VARCHAR(256) NOT NULL,
				       last_name VARCHAR(256) NOT NULL,
				       national_id INT UNIQUE NOT NULL,
				       email VARCHAR(256),
				       address VARCHAR(512),
				       password VARCHAR(256) NOT NULL
				  )
				  """;

		String createEmployeeTable = """
				CREATE TABLE IF NOT EXISTS employee (
				          id INT PRIMARY KEY AUTO_INCREMENT,
				          username VARCHAR(256) NOT NULL UNIQUE,
				          first_name VARCHAR(256) NOT NULL,
				          last_name VARCHAR(256) NOT NULL,
				          national_id INT UNIQUE NOT NULL,
				          email VARCHAR(256),
				          address VARCHAR(512),
				          password VARCHAR(256) NOT NULL
				      )
				      """;

		try (Connection c = DBManager.getConnection(); Statement stmt = c.createStatement()) {

			stmt.execute(createCustomerTable);
			stmt.execute(createEmployeeTable);

			System.out.println("User, Customer, and Employee tables created successfully.");

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Error creating tables.");
		}
	}
	
	public void dropUserTables() {
        String dropCustomer = "DROP TABLE IF EXISTS customer";
        String dropEmployee = "DROP TABLE IF EXISTS employee";

        try (Connection c = DBManager.getConnection(); Statement stmt = c.createStatement()) {

            stmt.execute(dropCustomer);
            stmt.execute(dropEmployee);

            System.out.println("Customer and Employee tables dropped successfully.");

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error dropping tables.");
        }
    }
}
