package model;

public class User {
	

	private int user_id;
	private String user_name;
	private String user_pass;
	private String first_name;
	private String last_name;
	private String user_email;
	private int user_role_id;
	private String signature;
	
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_pass() {
		return user_pass;
	}
	public void setUser_pass(String user_pass) {
		this.user_pass = user_pass;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getUser_email() {
		return user_email;
	}
	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}
	public int getUser_role_id() {
		return user_role_id;
	}
	public void setUser_role_id(int user_role_id) {
		this.user_role_id = user_role_id;
	}
	public String getSignature() {
		return signature;
	}
	public void setSignature(String signature) {
		this.signature = signature;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((first_name == null) ? 0 : first_name.hashCode());
		result = prime * result + ((last_name == null) ? 0 : last_name.hashCode());
		result = prime * result + ((signature == null) ? 0 : signature.hashCode());
		result = prime * result + ((user_email == null) ? 0 : user_email.hashCode());
		result = prime * result + user_id;
		result = prime * result + ((user_name == null) ? 0 : user_name.hashCode());
		result = prime * result + ((user_pass == null) ? 0 : user_pass.hashCode());
		result = prime * result + user_role_id;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (first_name == null) {
			if (other.first_name != null)
				return false;
		} else if (!first_name.equals(other.first_name))
			return false;
		if (last_name == null) {
			if (other.last_name != null)
				return false;
		} else if (!last_name.equals(other.last_name))
			return false;
		if (signature == null) {
			if (other.signature != null)
				return false;
		} else if (!signature.equals(other.signature))
			return false;
		if (user_email == null) {
			if (other.user_email != null)
				return false;
		} else if (!user_email.equals(other.user_email))
			return false;
		if (user_id != other.user_id)
			return false;
		if (user_name == null) {
			if (other.user_name != null)
				return false;
		} else if (!user_name.equals(other.user_name))
			return false;
		if (user_pass == null) {
			if (other.user_pass != null)
				return false;
		} else if (!user_pass.equals(other.user_pass))
			return false;
		if (user_role_id != other.user_role_id)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", user_name=" + user_name + ", user_pass=" + user_pass + ", first_name="
				+ first_name + ", last_name=" + last_name + ", user_email=" + user_email + ", user_role_id="
				+ user_role_id + ", signature=" + signature + "]";
	}
	public User(int user_id, String user_name, String user_pass, String first_name, String last_name, String user_email,
			int user_role_id, String signature) {
		super();
		this.user_id = user_id;
		this.user_name = user_name;
		this.user_pass = user_pass;
		this.first_name = first_name;
		this.last_name = last_name;
		this.user_email = user_email;
		this.user_role_id = user_role_id;
		this.signature = signature;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	

}
	
	
	