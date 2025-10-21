package app;

import java.util.List;

import model.Customer;
import repository.TableManager;
import repository.customer.CustomerDAO;
import repository.customer.CustomerDAOH2Impl;
import ui.PanelManager;

public class Main {
	
	private PanelManager manager;
	
	public static void main(String[] args) {
		
		Main main = new Main();
		
		// CREATES USERS, CUSTOMER AND EMPLOYEE TABLES IF THEY DO NOT EXIST
		TableManager tm = new TableManager();
        tm.createUserTables();
		
        // CREATES USER DAO
        CustomerDAO customerDAO = new CustomerDAOH2Impl();

        // CREATES TEST USERS
        Customer[] demoCustomers = new Customer[] {
            new Customer("hernansaa88", "Hernan", "Saavedra", 10925042, "hernansaa88@gmail.com", "Av. Córdoba 1234, CABA", "123456"),
            new Customer("maria98", "Maria", "Lopez", 20938475, "maria98@gmail.com", "Gurruchaga 210, CABA", "password1"),
            new Customer("juanperez", "Juan", "Perez", 30495820, "juanperez@gmail.com", "Independencia 45, CABA", "qwerty123"),
            new Customer("ana_gomez", "Ana", "Gomez", 40567821, "ana_gomez@gmail.com", "Santa Fe 980, CABA", "abc12345"),
            new Customer("carlos77", "Carlos", "Martinez", 50928374, "carlos77@gmail.com", "Av. Rivadavia 3000, CABA", "pass789"),
            new Customer("lucia_r", "Lucia", "Rodriguez", 61234567, "lucia_r@gmail.com", "Perón 150, CABA", "lucia2025"),
            new Customer("martin_f", "Martin", "Fernandez", 72345678, "martin_f@gmail.com", "Belgrano 520, CABA", "m4rtin123"),
            new Customer("sofia_garcia", "Sofia", "Garcia", 83456789, "sofia_garcia@gmail.com", "Dorrego 77, CABA", "sofiaPW"),
            new Customer("nicolas_t", "Nicolas", "Torres", 94567890, "nicolas_t@hotmail.com", "Jujuy 233, CABA", "nikoPass"),
            new Customer("valentina_d", "Valentina", "Diaz", 10567891, "valentina_d@yahoo.com", "Av. Libertador 200, CABA", "valen001"),
            new Customer("franco_m", "Franco", "Morales", 11678902, "franco_m@outlook.com", "Pueyrredón 410, CABA", "franco77"),
            new Customer("camila_p", "Camila", "Perez", 12789013, "camila_p@gmail.com", "Arenales 122, CABA", "camiPASS"),
            new Customer("sebastian_r", "Sebastian", "Ramos", 13890124, "sebastian_r@gmail.com", "Uruguay 98, CABA", "ramos321"),
            new Customer("julieta_v", "Julieta", "Vega", 14901235, "julieta_v@gmail.com", "Venezuela 305, CABA", "julie22"),
            new Customer("lautaro_b", "Lautaro", "Benitez", 15912346, "lautaro_b@gmail.com", "Corrientes 1500, CABA", "lautaro99"),
            new Customer("melina_s", "Melina", "Sosa", 16923457, "melina_s@gmail.com", "Callao 220, CABA", "meliPass"),
            new Customer("agustin_c", "Agustin", "Castro", 17934568, "agustin_c@gmail.com", "Montevideo 85, CABA", "agus007"),
            new Customer("belen_m", "Belen", "Martinez", 18945679, "belen_m@gmail.com", "Hipólito Yrigoyen 450, CABA", "belenpwd"),
            new Customer("tomas_f", "Tomas", "Flores", 19956780, "tomas_f@gmail.com", "Chile 120, CABA", "tomas999"),
            new Customer("carolina_g", "Carolina", "Gonzalez", 20967891, "carolina_g@gmail.com", "Perón 780, CABA", "caro2024")
        };

        // SAVES TEST USERS IN THE DB IF THEY DON'T EXIST
        for (Customer u : demoCustomers) {
            customerDAO.createCustomer(u);
        }
        
        // START THE SWING UI
        main.startManager();
		main.showFrame();
	}
	
    public void startManager() {
    	manager = new PanelManager();
    	manager.buildManager();
    	manager.showCustomerManagementPanel();
    }
    
    public void showFrame() {
    	manager.showFrame();
    }
}
