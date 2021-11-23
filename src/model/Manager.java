package model;

public class Manager {
	private int managerno;
	private String id;
	private String pwd;
	private String name;
	private String phone;
	private String email;
	
	
	
	
	
	@Override
	public String toString() {
		return "Manager [managerno=" + managerno + ", id=" + id + ", pwd=" + pwd + ", name=" + name + ", phone=" + phone
				+ ", email=" + email + "]";
	}
	public int getManagerno() {
		return managerno;
	}
	public void setManagerno(int managerno) {
		this.managerno = managerno;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
}
