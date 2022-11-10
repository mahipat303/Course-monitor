package course_monitor.model;

public class Faculty {

	private int facultyid;
	private String facultyname;
	private String facultyaddress;
	private String mobile;
	private String email;
	private String password;

	public Faculty() {
	}

	public Faculty(int facultyid, String facultyname, String facultyaddress, String mobile, String email,
			String password) {
		super();
		this.facultyid = facultyid;
		this.facultyname = facultyname;
		this.facultyaddress = facultyaddress;
		this.mobile = mobile;
		this.email = email;
		this.password = password;
	}

	public int getFacultyid() {
		return facultyid;
	}

	public void setFacultyid(int facultyid) {
		this.facultyid = facultyid;
	}

	public String getFacultyname() {
		return facultyname;
	}

	public void setFacultyname(String facultyname) {
		this.facultyname = facultyname;
	}

	public String getFacultyaddress() {
		return facultyaddress;
	}

	public void setFacultyaddress(String facultyaddress) {
		this.facultyaddress = facultyaddress;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Faculty [facultyid=" + facultyid + ", facultyname=" + facultyname + ", facultyaddress=" + facultyaddress
				+ ", mobile=" + mobile + ", email=" + email + ", password=" + password + "]";
	}

}
