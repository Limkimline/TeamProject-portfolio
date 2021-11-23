package model;

public class Member {
	private int userno;
	private String id;
	private String pwd;
	private String name;
	private String gender;
	private String phone;
	private String email;
	private String certification;
	private String imageName;
	private int int_no;
	private int int_no2;
	
	@Override
	public String toString() {
		return "Member [userno=" + userno + ", id=" + id + ", pwd=" + pwd + ", name=" + name + ", gender=" + gender
				+ ", phone=" + phone + ", email=" + email + ", certification=" + certification + ", imageName="
				+ imageName + ", int_no=" + int_no + ", int_no2=" + int_no2 + "]";
	}
	
	public Member() {}
	
	public Member(int userno, String id, String pwd, String name, String gender, String phone, String email,
			String certification, String imageName, int int_no, int int_no2) {
		super();
		this.userno = userno;
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.gender = gender;
		this.phone = phone;
		this.email = email;
		this.certification = certification;
		this.imageName = imageName;
		this.int_no = int_no;
		this.int_no2 = int_no2;
	}
	
	public Member(String id, String pwd, String name, String gender, String phone, String email, int int_no,
			int int_no2) {
		super();
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.gender = gender;
		this.phone = phone;
		this.email = email;
		this.int_no = int_no;
		this.int_no2 = int_no2;
	}
	
	public Member(String id, String pwd, String name, String gender, String phone, String email,String imageName, int int_no,
			int int_no2) {
		super();
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.gender = gender;
		this.phone = phone;
		this.email = email;
		this.imageName = imageName;
		this.int_no = int_no;
		this.int_no2 = int_no2;
	}
	

	public Member(String id, String pwd, String name, String gender, String phone, String email, String certification,
			String imageName, int int_no, int int_no2) {
		super();
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.gender = gender;
		this.phone = phone;
		this.email = email;
		this.certification = certification;
		this.imageName = imageName;
		this.int_no = int_no;
		this.int_no2 = int_no2;
	}

	public int getUserno() {
		return userno;
	}
	public void setUserno(int userno) {
		this.userno = userno;
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
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
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
	public String getCertification() {
		return certification;
	}
	public void setCertification(String certification) {
		this.certification = certification;
	}
	public String getImageName() {
		return imageName;
	}
	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
	public int getInt_no() {
		return int_no;
	}
	public void setInt_no(int int_no) {
		this.int_no = int_no;
	}
	public int getInt_no2() {
		return int_no2;
	}
	public void setInt_no2(int int_no2) {
		this.int_no2 = int_no2;
	}
}
