package kr.co.jBoard1.db;

public class Sql {
	
	//user
	public static final String INSERT_USER 		 = "INSERT INTO `board_user` SET `uid`=?, `pass`=SHA2(?, 256), `name`=?, `nick`=?, `email`=?, `hp`=?,`zip`=?, `addr1`=?, `addr2`=?, `regip`=?, `rdate`=now()";
	public static final String SELECT_USER 		 = "select * from `board_user` where `uid`=? and `pass`=SHA2(?, 256)";
	public static final String SELECT_COUNT_UID  = "select count(`uid`) from `board_user` where `uid`=?";
	public static final String SELECT_COUNT_NICK = "select count(`nick`) from `board_user` where `nick`=?";
	public static final String SELECT_TERMS 	 = "select * from `board_terms`";
	
	//board
	public static final String INSERT_ARTICLE = "insert into `board_article` set "
												+"`title`=?,"
												+"`content`=?,"
												+"`file`=?,"
												+"`uid`=?,"
												+"`regip`=?,"
												+"`rdate`=NOW()";
	
	public static final String INSERT_FILE = "insert into `board_file` set "
											+"`parent`=?,"
											+"`newName`=?,"
											+"`oriName`=?,"
											+"`rdate`=NOW()";
	
	public static final String SELECT_MAX_NO = "select max(`no`) from `board_article`";
	public static final String SELECT_COUNT_TOTAL = "select count(`no`) from `board_article`";
	public static final String SELECT_ARTICLES = "SELECT a.*, b.`nick` FROM `board_article` AS a "
												+"JOIN `board_user` AS b ON a.uid = b.uid "
												+"ORDER BY `no` DESC "
												+"LIMIT ?, 10";
	public static final String SELECT_ARTICLE = "SELECT a.*, b.`fno`, b.`oriName`, b.`download` FROM `board_article` AS a "
												+ "left JOIN `board_file` AS b "
												+ "ON a.`no` = b.`parent` "
												+ "WHERE `no`=?";
	
	public static final String SELECT_FILE = "select * from `board_file` where `fno`=?";
	public static final String SELECT_FILE_WITH_PARENT = "select * from `board_file` where `parent`=?";
	
	public static final String UPDATE_ARTICLE = "update `board_article` set `title`=?, `content`=?, `rdate`=NOW() where `no`=?";
	public static final String UPDATE_ARTICLE_HIT = "UPDATE `board_article` SET `hit` = `hit` + 1 WHERE `no`=?";
	public static final String UPDATE_FILE_DOWNLOAD = "UPDATE `board_file` SET `download` = `download` + 1 WHERE `fno`=?";

	public static final String UPDATE_COMMENT = "update `board_article` set `content`=?, `rdate`=NOW() where `no`=?";

	public static final String DELETE_ARTICLE = "delete from `board_article` where `no`=? or `parent`=?";
	public static final String DELETE_COMMENT = "delete from `board_article` where `no`=?";
	public static final String DELETE_FILE = "delete from `board_file` where `parent`=?";
}