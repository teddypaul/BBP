package bbp.DTO;
import java.sql.Timestamp;

public class BookmanagementDTO {
	private String userId; 			//유저 아이디
	private String bookSeq;			//유저 책 시퀀스 (관리자가 관리하기 쉽게 하기 위해)
	private String title; 			//판매자 글 제목
	private String bookName;		//책이름
	private String bookNum;			//책 바코드
	private String bookIndex;		//책 분류 (콤보박스)
	private String bookExchange;	//책 교환 판매 분류 (콤보박스)
	private String bookQuality;		//책 상태 (콤보박스)
	private String bookAddress;		//책 교환할 인근지역 (콤보박스)
	private String bookUniversity;	//책 교환할 인근 학교 (콤보박스)
	private String bookPrice;		//책 가격 
	private int checkStat;			//등록한책(0), 진행중(1), 완료(2) 구분짓기용
	private Timestamp timeStamp;	//시간 담는 용
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getBookSeq() {
		return bookSeq;
	}
	public void setBookSeq(String bookSeq) {
		this.bookSeq = bookSeq;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getBookNum() {
		return bookNum;
	}
	public void setBookNum(String bookNum) {
		this.bookNum = bookNum;
	}
	public String getBookIndex() {
		return bookIndex;
	}
	public void setBookIndex(String bookIndex) {
		this.bookIndex = bookIndex;
	}
	public String getBookExchange() {
		return bookExchange;
	}
	public void setBookExchange(String bookExchange) {
		this.bookExchange = bookExchange;
	}
	public String getBookQuality() {
		return bookQuality;
	}
	public void setBookQuality(String bookQuality) {
		this.bookQuality = bookQuality;
	}
	public String getBookAddress() {
		return bookAddress;
	}
	public void setBookAddress(String bookAddress) {
		this.bookAddress = bookAddress;
	}
	public String getBookUniversity() {
		return bookUniversity;
	}
	public void setBookUniversity(String bookUniversity) {
		this.bookUniversity = bookUniversity;
	}
	public String getBookPrice() {
		return bookPrice;
	}
	public void setBookPrice(String bookPrice) {
		this.bookPrice = bookPrice;
	}
	public int getCheckStat() {
		return checkStat;
	}
	public void setCheckstat(int checkStat) {
		this.checkStat = checkStat;
	}
	public Timestamp getTimestamp() {
		return timeStamp;
	}
	public void setTimestamp(Timestamp timeStamp) {
		this.timeStamp = timeStamp;
	}

		
	
	
}
