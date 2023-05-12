package kr.co.farmstory2.dao;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.farmstory2.db.DBHelper;
import kr.co.farmstory2.db.Sql;
import kr.co.farmstory2.vo.ArticleVO;

public class ArticleDAO extends DBHelper{

	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	private static ArticleDAO instance = new ArticleDAO();
	public static ArticleDAO getInstance() {
		return instance;
	}
	private ArticleDAO() {}
	
	public int insertArticle(ArticleVO article) {
		int parent = 0;
		
		try {
			logger.info("insertAtricle...");
			conn = getConnection();
			
			conn.setAutoCommit(false);
			
			stmt = conn.createStatement();
			psmt = conn.prepareStatement(Sql.INSERT_ARTICLE);
			psmt.setString(1, article.getTitle());
			psmt.setString(2, article.getContent());
			psmt.setInt(3, article.getFname() == null ? 0:1);
			psmt.setString(4, article.getUid());
			psmt.setString(5, article.getRegip());
			
			psmt.executeUpdate();
			rs = stmt.executeQuery(Sql.SELECT_MAX_NO);
			
			conn.commit();
			
			if(rs.next()) {
				parent = rs.getInt(1);
			}
			
			close();
			
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
		
		return parent;
	}
	
	public void insertFile(int parent, String newName, String fName) {
		try {
			logger.info("insertFile...");
			
			conn = getConnection();
			psmt = conn.prepareStatement(Sql.INSERT_FILE);
			psmt.setInt(1, parent);
			psmt.setString(1, newName);
			psmt.setString(1, fName);
			psmt.executeUpdate();
			close();
			
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
	}
	
	public ArticleVO insertComment(ArticleVO comment) {
		ArticleVO article = null;
		
		try {
			logger.info("inserComment...");
			
			conn = getConnection();
			conn.setAutoCommit(false);
			psmt = conn.prepareStatement(Sql.INSERT_COMMENT);
			stmt = conn.createStatement();
			psmt.setInt(1, comment.getParent());
			psmt.setString(2, comment.getContent());
			psmt.setString(3, comment.getUid());
			psmt.setString(4, comment.getRegip());
			psmt.executeUpdate();
			rs = stmt.executeQuery(Sql.SELECT_COMMENT_LATEST);
			conn.commit();
			
			if(rs.next()) {
				article = new ArticleVO();
				article.setNo(rs.getInt(1));
				article.setParent(rs.getInt(2));
				article.setContent(rs.getString(6));
				article.setRdate(rs.getString(11).substring(2, 10));
				article.setNick(rs.getString(12));
			}
			
			close();
			
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
		
		return article;
	}
	
	public ArticleVO selectArticle(String no) {
		
		ArticleVO article = null;
		
		try {
			logger.info("selectArticle...");
			
			conn = getConnection();
			psmt = conn.prepareStatement(Sql.SELECT_ARTICLE);
			psmt.setString(1, no);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				article = new ArticleVO();
				article.setNo(rs.getString(1));
				article.setParent(rs.getInt(2));
				article.setComment(rs.getInt(3));
				article.setCate(rs.getString(4));
				article.setTitle(rs.getString(5));
				article.setContent(rs.getString(6));
				article.setFile(rs.getInt(7));
				article.setHit(rs.getInt(8));
				article.setUid(rs.getString(9));
				article.setRegip(rs.getString(10));
				article.setRdate(rs.getString(11));
				article.setFno(rs.getInt(12));
				article.setOriName(rs.getString(13));
				article.setDownload(rs.getInt(14));
			}
			close();
			
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
		
		return article;
	}
	
	public List<ArticleVO> selectArticles(int start) {
		
		List<ArticleVO> articles = new ArrayList<>();
		
		try {
			logger.info("selectArticles...");
			
			conn = getConnection();
			psmt = conn.prepareStatement(Sql.SELECT_ARTICLES);
			psmt.setInt(1, start);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				ArticleVO article = new ArticleVO();
				article.setNo(rs.getInt(1));
				article.setParent(rs.getInt(2));
				article.setComment(rs.getInt(3));
				article.setCate(rs.getString(4));
				article.setTitle(rs.getString(5));
				article.setContent(rs.getString(6));
				article.setFile(rs.getInt(7));
				article.setHit(rs.getInt(8));
				article.setUid(rs.getString(9));
				article.setRegip(rs.getString(10));
				article.setRdate(rs.getString(11));
				article.setNick(rs.getString(12));
				
				articles.add(article);
			}
			close();
			
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
		
		return articles;
	}
	
	public List<ArticleVO> selectArticleByKeyword(String keyword, int start) {
		
		List<ArticleVO> articles = new ArrayList<>();
		
		try {
			logger.info("selectArticles...");
			
			conn = getConnection();
			psmt = conn.prepareStatement(Sql.SELECT_ARTICLE_BY_KEYWORD);
			psmt.setString(1, "%"+keyword+"%");
			psmt.setString(2, "%"+keyword+"%");
			psmt.setInt(3, start);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				ArticleVO article = new ArticleVO();
				article.setNo(rs.getInt(1));
				article.setParent(rs.getInt(2));
				article.setComment(rs.getInt(3));
				article.setCate(rs.getString(4));
				article.setTitle(rs.getString(5));
				article.setContent(rs.getString(6));
				article.setFile(rs.getInt(7));
				article.setHit(rs.getInt(8));
				article.setUid(rs.getString(9));
				article.setRegip(rs.getString(10));
				article.setRdate(rs.getString(11));
				article.setNick(rs.getString(12));
				
				articles.add(article);
			}
			close();
			
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
		
		return articles;
	}
	
	//전체 게시물 카운트
	public int selectCountTotal() {
		int total = 0;
		
		try {
			logger.info("selectCountTotal...");
			
			conn = getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(Sql.SELECT_COUNT_TOTAL);
			
			if(rs.next()) {
				total = rs.getInt(1);
			}
			close();
			
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
		
		return total;
	}
	
	public int selectCountTotalForSearch(String keyword) {
		int total = 0;
		
		try {
			logger.info("selectCountTotalForSearch...");
			
			conn = getConnection();
			psmt = conn.prepareStatement(Sql.SELECT_COUNT_TOTAL_FOR_SEARCH);
			psmt.setString(1, "%"+keyword+"%");
			psmt.setString(2, "%"+keyword+"%");
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				total = rs.getInt(1);
			}
			close();
			
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
		
		return total;
	}
	
	public List<ArticleVO> selectComments(String parent) {
		
		List<ArticleVO> comments = new ArrayList<>();
		
		try {
			logger.info("selectComments...");
			
			conn = getConnection();
			psmt = conn.prepareStatement(Sql.SELECT_COMMENTS);
			psmt.setString(1, parent);
			
			while(rs.next()) {
				ArticleVO comment = new ArticleVO();
				comment.setNo(rs.getInt(1));
				comment.setParent(rs.getInt(2));
				comment.setComment(rs.getInt(3));
				comment.setCate(rs.getString(4));
				comment.setTitle(rs.getString(5));
				comment.setContent(rs.getString(6));
				comment.setFile(rs.getInt(7));
				comment.setHit(rs.getInt(8));
				comment.setUid(rs.getString(9));
				comment.setRegip(rs.getString(10));
				comment.setRdate(rs.getString(11).substring(2, 10));
				comment.setNick(rs.getString(12));
				comments.add(comment);
			}
			close();
			
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
		
		return comments;
	}
	
	public void updateArticleHit(String no) {
		try{
			logger.info("updateArticleHit...");

			conn = getConnection();
			psmt = conn.prepareStatement(Sql.UPDATE_ARTICLE_HIT);
			psmt.setString(1, no);
			psmt.executeUpdate();

			close();
		}catch(Exception e){
			 logger.error(e.getMessage());
		}
	}
	
	public void updateArticle(String no, String title, String content) {
		
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(Sql.UPDATE_ARTICLE);
			psmt.setString(1, title);
			psmt.setString(2, content);
			psmt.setString(3, no);
			
			psmt.executeUpdate();
			
			close();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void updateFileDownload(String fno) {
		try{
			conn = getConnection();
			psmt = conn.prepareStatement(Sql.UPDATE_FILE_DOWNLOAD);
			psmt.setString(1, fno);
			psmt.executeUpdate();

			close();
		}catch(Exception e){
			 e.printStackTrace();
		}
	}
	
	public int updateComment(String no, String content) {
		
		int result = 0;
		
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(Sql.UPDATE_COMMENT);
			psmt.setString(1, content);
			psmt.setString(2, no);
			
			result = psmt.executeUpdate();
			
			close();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return result;
	}
	
	public void deleteArticle(String no) {
		try{
			logger.info("deleteArticle...");

			conn = getConnection();
			psmt = conn.prepareStatement(Sql.DELETE_ARTICLE);
			psmt.setString(1, no);
			psmt.setString(2, no);
			psmt.executeUpdate();
			
			close();
		}catch(Exception e){
			 logger.error(e.getMessage());
		}
	}
	
	public String deleteFile(String parent) {
		String newName = null;
		
		try{
			logger.info("deleteFile...");
			
			conn = getConnection();
			conn.setAutoCommit(false);
			
			PreparedStatement psmt1 = conn.prepareStatement(Sql.SELECT_FILE_WITH_PARENT);
			PreparedStatement psmt2 = conn.prepareStatement(Sql.DELETE_FILE);
			psmt1.setString(1, parent);
			psmt2.setString(1, parent);
			
			rs = psmt1.executeQuery();
			psmt2.executeUpdate();
			
			conn.commit();
			
			if(rs.next()) {
				newName = rs.getString(3);
			}
			close();
		}catch(Exception e){
			logger.error(e.getMessage());
		}
		
		return newName;
	}
	
	public int deleteComment(String no) {
		int result = 0;
		
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(Sql.DELETE_COMMENT);
			psmt.setString(1, no);
			
			result = psmt.executeUpdate();
			psmt.close();
			conn.close();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return result;
	}
}
