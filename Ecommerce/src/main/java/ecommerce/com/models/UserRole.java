package ecommerce.com.models;

public class UserRole {
	int user_role_id, user_id, role_id;

	public int getUser_role_id() {
		return user_role_id;
	}

	public void setUser_role_id(int user_role_id) {
		this.user_role_id = user_role_id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public int getRole_id() {
		return role_id;
	}

	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}

	public UserRole(int user_role_id, int user_id, int role_id) {
		super();
		this.user_role_id = user_role_id;
		this.user_id = user_id;
		this.role_id = role_id;
	}

	public UserRole() {
		super();
		// TODO Auto-generated constructor stub
	}

}
