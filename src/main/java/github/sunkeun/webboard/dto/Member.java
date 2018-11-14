package github.sunkeun.webboard.dto;

public class Member {
	
	String id;
	String pw;
	String name;
	String address;
	String eMail;
	String rDate;
	
	
	
	public Member() {
		super();
	}
	
	public Member(String name, String address, String eMail, String rDate) {
		super();
		this.name = name;
		this.address = address;
		this.eMail = eMail;
		this.rDate = rDate;
	}
	
	
	
	public Member(String id, String pw, String name, String address, String eMail, String rDate) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.address = address;
		this.eMail = eMail;
		this.rDate = rDate;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String geteMail() {
		return eMail;
	}
	public void seteMail(String eMail) {
		this.eMail = eMail;
	}
	public String getrDate() {
		return rDate;
	}
	public void setrDate(String rDate) {
		this.rDate = rDate;
	}

	@Override
	public String toString() {
		return "Member [id=" + id + ", pw=" + pw + ", name=" + name + ", address=" + address + ", eMail=" + eMail
				+ ", rDate=" + rDate + "]";
	}
	
	

}
