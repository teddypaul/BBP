package bbp.DTO;

public class BookmanagementDTO {
	private String bookname;		//책이름
	private int booknum;			//책 바코드
	private String bookindex;		//책 분류
	private String exchange;		//책 교환 판매 분류
	private String bookquality;		//책 상태
	private String bookaddress;		//책 교환할 인근지역
	private String bookuniversity;	//책 교환할 인근 학교

	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public int getBooknum() {
		return booknum;
	}
	public void setBooknum(int booknum) {
		this.booknum = booknum;
	}
	public String getBookindex() {
		return bookindex;
	}
	public void setBookindex(String bookindex) {
		this.bookindex = bookindex;
	}
	public String getExchange() {
		return exchange;
	}
	public void setExchange(String exchange) {
		this.exchange = exchange;
	}
	public String getBookquality() {
		return bookquality;
	}
	public void setBookquality(String bookquality) {
		this.bookquality = bookquality;
	}
	public String getBookaddress() {
		return bookaddress;
	}
	public void setBookaddress(String bookaddress) {
		this.bookaddress = bookaddress;
	}
	public String getBookuniversity() {
		return bookuniversity;
	}
	public void setBookuniversity(String bookuniversity) {
		this.bookuniversity = bookuniversity;
	}


}
