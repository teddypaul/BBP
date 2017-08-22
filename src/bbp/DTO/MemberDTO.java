package bbp.DTO;


public class MemberDTO {
   private String userseq; //유저 시퀀스
   private String userid;      //아이디 
   private String userpw;      //패스워드
   private String username;   //유저이름
   private int userphonenumber;//유저폰넘버
   private String useremail;   //유저메일
   private String useruniversity; //유저 학교 
   private String useraddress; //유저 주 거래 인근 주소   
   private int userclass;  //유저 신뢰도 등급  
   private String usermail;  //유저 메일함
   private String userbirth;   //생일 
   
   public String getUserseq() {
      return userseq;
   }
   public void setUserseq(String userseq) {
      this.userseq = userseq;
   }
   public String getUserid() {
      return userid;
   }
   public void setUserid(String userid) {
      this.userid = userid;
   }
   public String getUserpw() {
      return userpw;
   }
   public void setUserpw(String userpw) {
      this.userpw = userpw;
   }
   public String getUsername() {
      return username;
   }
   public void setUsername(String username) {
      this.username = username;
   }
   public int getUserphonenumber() {
      return userphonenumber;
   }
   public void setUserphonenumber(int userphonenumber) {
      this.userphonenumber = userphonenumber;
   }
   public String getUseremail() {
      return useremail;
   }
   public void setUseremail(String useremail) {
      this.useremail = useremail;
   }
   public String getUseruniversity() {
      return useruniversity;
   }
   public void setUseruniversity(String useruniversity) {
      this.useruniversity = useruniversity;
   }
   public String getUseraddress() {
      return useraddress;
   }
   public void setUseraddress(String useraddress) {
      this.useraddress = useraddress;
   }
   public int getUserclass() {
      return userclass;
   }
   public void setUserclass(int userclass) {
      this.userclass = userclass;
   }
   public String getUsermail() {
      return usermail;
   }
   public void setUsermail(String usermail) {
      this.usermail = usermail;
   }
   public String getUserbirth() {
      return userbirth;
   }
   public void setUserbirth(String userbirth) {
      this.userbirth = userbirth;
   }
   
}