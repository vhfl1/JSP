package kr.co.farmstory2.vo;

public class ArticleVO {
	private static int no;
	private static int parent;
	private static int comment;
	private static String cate;
	private static String title;
	private static String content;
	private static int file;
	private static int hit;
	private static String uid;
	private static String regip;
	private static String rdate;
	
	//추가필드
	private String nick;
	private int fno;
	private String oriName;
	private int download;
	private String fname;
	
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	public int getFno() {
		return fno;
	}
	public void setFno(int fno) {
		this.fno = fno;
	}
	public String getOriName() {
		return oriName;
	}
	public void setOriName(String oriName) {
		this.oriName = oriName;
	}
	public int getDownload() {
		return download;
	}
	public void setDownload(int download) {
		this.download = download;
	}
	public static int getNo() {
		return no;
	}
	public static void setNo(int no) {
		ArticleVO.no = no;
	}
	public static int getParent() {
		return parent;
	}
	public static void setParent(int parent) {
		ArticleVO.parent = parent;
	}
	public static int getComment() {
		return comment;
	}
	public static void setComment(int comment) {
		ArticleVO.comment = comment;
	}
	public static String getCate() {
		return cate;
	}
	public static void setCate(String cate) {
		ArticleVO.cate = cate;
	}
	public static String getTitle() {
		return title;
	}
	public static void setTitle(String title) {
		ArticleVO.title = title;
	}
	public static String getContent() {
		return content;
	}
	public static void setContent(String content) {
		ArticleVO.content = content;
	}
	public static int getFile() {
		return file;
	}
	public static void setFile(int file) {
		ArticleVO.file = file;
	}
	public static int getHit() {
		return hit;
	}
	public static void setHit(int hit) {
		ArticleVO.hit = hit;
	}
	public static String getUid() {
		return uid;
	}
	public static void setUid(String uid) {
		ArticleVO.uid = uid;
	}
	public static String getRegip() {
		return regip;
	}
	public static void setRegip(String regip) {
		ArticleVO.regip = regip;
	}
	public static String getRdate() {
		return rdate;
	}
	public static void setRdate(String rdate) {
		ArticleVO.rdate = rdate;
	}
}
