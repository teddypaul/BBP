package bbp.DTO;

public class UniversityDTO {
	private String universityname; 		//학교이름
	private String universityaddress;	//학교 주소
	private String universityshop;
	
	public String getUniversityshop() {
		return universityshop;
	}
	public void setUniversityshop(String universityshop) {
		this.universityshop = universityshop;
	}
	public String getUniversityname() {
		return universityname;
	}
	public void setUniversityname(String universityname) {
		this.universityname = universityname;
	}
	public String getUniversityaddress() {
		return universityaddress;
	}
	public void setUniversityaddress(String universityaddress) {
		this.universityaddress = universityaddress;
	}
}
