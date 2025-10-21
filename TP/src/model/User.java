package model;

public abstract class User {

	protected int id;
	protected String username;
	protected String firstName;
	protected String lastName;
	protected int nationalId;
	protected String email;
	protected String address;
	protected String password;

	public User() {
	}

	public User(String username, String firstName, String lastName, int nationalId, String email, String address,
			String password) {
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
		this.nationalId = nationalId;
		this.email = email;
		this.address = address;
		this.password = password;
	}
	
	public abstract boolean authenticate(String username, String password);

	// Getters y Setters
	public int getId() {
		return this.id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getNationalId() {
		return this.nationalId;
	}

	public void setNationalId(int nationalId) {
		this.nationalId = nationalId;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
