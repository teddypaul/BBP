package bbp.DTO;

public class UserprofileDTO {
	private String id;			//아이디
	private String pw;			//패스워드
	private String name;		//유저이름
	private int phonenumber;	//유저폰넘버
	private String email;		//유저메일
	private String university;	//유저 학교 
	private String address;		//유저 주 거래 인근 주소
	private int userclass;		//유저 신뢰도 등급
	private String mymail;		//유저 메일함
	
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
	public int getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(int phonenumber) {
		this.phonenumber = phonenumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUniversity() {
		return university;
	}
	public void setUniversity(String university) {
		this.university = university;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getUserclass() {
		return userclass;
	}
	public void setUserclass(int userclass) {
		this.userclass = userclass;
	}
	public String getMymail() {
		return mymail;
	}
	public void setMymail(String mymail) {
		this.mymail = mymail;
	}
}
