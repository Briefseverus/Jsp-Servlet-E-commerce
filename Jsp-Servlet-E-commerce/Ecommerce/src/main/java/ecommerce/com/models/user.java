package ecommerce.com.models;

public class user {
	int user_id;
	String username, password, full_name, email, phone_number;

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFull_name() {
		return full_name;
	}

	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	public user(int user_id, String username, String password, String full_name, String email, String phone_number) {
		super();
		this.user_id = user_id;
		this.username = username;
		this.password = password;
		this.full_name = full_name;
		this.email = email;
		this.phone_number = phone_number;
	}

	public user() {
		super();
		// TODO Auto-generated constructor stub
	}

}
