package bbp.DTO;
import java.sql.Timestamp;

public class BookmanagementDTO {
	private String userId; 			//���� ���̵�
	private String bookSeq;			//���� å ������ (�����ڰ� �����ϱ� ���� �ϱ� ����)
	private String title; 			//�Ǹ��� �� ����
	private String bookName;		//å�̸�
	private String bookNum;			//å ���ڵ�
	private String bookIndex;		//å �з� (�޺��ڽ�)
	private String bookExchange;	//å ��ȯ �Ǹ� �з� (�޺��ڽ�)
	private String bookQuality;		//å ���� (�޺��ڽ�)
	private String bookAddress;		//å ��ȯ�� �α����� (�޺��ڽ�)
	private String bookUniversity;	//å ��ȯ�� �α� �б� (�޺��ڽ�)
	private String bookPrice;		//å ���� 
	private int checkStat;			//�����å(0), ������(1), �Ϸ�(2) ���������
	private Timestamp timeStamp;	//�ð� ��� ��
	
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
