package kr.co.College.bean;

public class RegisterBean {
	private String regStdNo;
	private int regLecNo;
	private int regMidScore;
	private int regFinalScore;
	private int regTotalScore;
	private String regGrade;
	
	//추가
	private String stdNo;
	private String stdName;
	private String lecName;
	private String lecNo;
	
	
	public String getStdNo() {
		return stdNo;
	}
	public void setStdNo(String stdNo) {
		this.stdNo = stdNo;
	}
	public String getStdName() {
		return stdName;
	}
	public void setStdName(String stdName) {
		this.stdName = stdName;
	}
	public String getLecName() {
		return lecName;
	}
	public void setLecName(String lecName) {
		this.lecName = lecName;
	}
	public String getLecNo() {
		return lecNo;
	}
	public void setLecNo(String lecNo) {
		this.lecNo = lecNo;
	}
	public String getRegStdNo() {
		return regStdNo;
	}
	public void setRegStdNo(String regStdNo) {
		this.regStdNo = regStdNo;
	}
	public int getRegLecNo() {
		return regLecNo;
	}
	public void setRegLecNo(int regLecNo) {
		this.regLecNo = regLecNo;
	}
	public int getRegMidScore() {
		return regMidScore;
	}
	public void setRegMidScore(int regMidScore) {
		this.regMidScore = regMidScore;
	}
	public int getRegFinalScore() {
		return regFinalScore;
	}
	public void setRegFinalScore(int regFinalScore) {
		this.regFinalScore = regFinalScore;
	}
	public int getRegTotalScore() {
		return regTotalScore;
	}
	public void setRegTotalScore(int regTotalScore) {
		this.regTotalScore = regTotalScore;
	}
	public String getRegGrade() {
		return regGrade;
	}
	public void setRegGrade(String regGrade) {
		this.regGrade = regGrade;
	}
}
