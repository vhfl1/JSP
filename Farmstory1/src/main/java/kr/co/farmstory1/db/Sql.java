package kr.co.farmstory1.db;

public class Sql {
	//user
	public static final String INSERT_USER
	public static final String SELECT_USER = "select * from `board_user` where `uid`=? and `pass`=SHA2(?, 256)";
	public static final String SELECT_COUNT_UID
	public static final String SELECT_COUNT_NICK
	public static final String SELECT_TERMS = "select * from `board_terms`";

	//board
	public static final String SELECT_COUNT_TOTAL = "select count(`no`) from `board_article` where `parent`=0 and `cate`=?";
	
	public static final String SELECT_FILE_WITH_PARENT = "select * from `board_file` where `parent`=?";
	
	public static final String DELETE_ARTICLE = "delete * from `board_article` where `no`=? or `parent`=?";
	public static final String DELETE_COMMENT = "delete from `board_article` where `no`=?";
	public static final String DELETE_FILE = "SELECT_FILE_WITH_PARENT";

}
