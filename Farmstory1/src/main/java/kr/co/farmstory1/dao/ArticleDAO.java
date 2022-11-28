package kr.co.farmstory1.dao;

import org.slf4j.LoggerFactory;

import kr.co.farmstory1.bean.ArticleBean;
import kr.co.farmstory1.db.DBCP;
import kr.co.farmstory1.db.Sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;

public class ArticleDAO {
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	private static ArticleDAO instance = new ArticleDAO();
	public static ArticleDAO getInstance() {
		return instance;
	}
	private ArticleDAO() {}
	
	public void insertArticle() {
		
		
	}
	
	public void insertFile() {}
	
	public void insertComment() {}
	
	public int selectCountTotal(String cate) {
		int total = 0;
		
		try {
			Connection conn = DBCP.getConnection();
			PreparedStatement psmt = conn.prepareStatement(Sql.SELECT_COUNT_TOTAL);
			psmt.setString(1, cate);
			
			ResultSet rs = psmt.executeQuery();
			
			if(rs.next()) {
				total = rs.getInt(1);
			}
			rs.close();
			psmt.close();
			conn.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return total;
	}
	
	public ArticleBean selectArticle(String no) {
		ArticleBean article = null;
		
		try{
			Connection conn = DBCP.getConnection();
			PreparedStatement psmt = conn.prepareStatement(Sql.SELECT_ARTICLE);
			psmt.setString(1, no);
			
			ResultSet rs = psmt.executeQuery();
			
			if(rs.next()){
				article = new ArticleBean();
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
				article.setFno(rs.getInt(12));
				article.setOriName(rs.getString(13));
				article.setDownload(rs.getInt(14));
			}
			
			rs.close();
			psmt.close();
			conn.close();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return article;
	}
	public void selectArticles() {}
	
	public List<ArticleBean> selectLatest() {
		
		List<ArticleBean> latests = new ArrayList<>();
		
		try {
			logger.debug("selectLatest...");
			
			Connection conn = DBCP.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(Sql.SELECT_LATESTS);
			
			while(rs.next()) {
				ArticleBean ab = new ArticleBean();
				ab.setNo(rs.getInt(1));
				ab.setTitle(rs.getString(2));
				ab.setRdate(rs.getString(3).substring(2, 10));
				latests.add(ab);
			}
			
			rs.close();
			stmt.close();
			conn.close();		
			
		}catch (Exception e) {
			logger.error(e.getMessage());
		}
		
		logger.debug("latests size : " + latests.size());
		return latests;
	}
	
	
	
	public void selectFile() {}
	
	public void selectComments() {}
	
	public void updateArticle(String no, String title, String content) {
		try {
			Connection conn = DBCP.getConnection();
			PreparedStatement psmt = conn.prepareStatement(Sql.UPDATE_ARTICLE);
			psmt.setString(1, title);
			psmt.setString(2, content);
			psmt.setString(3, no);
			
			psmt.executeUpdate();
			psmt.close();
			conn.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void updateArticleHit(){}
	
	public void updateFileDownload() {}
	
	public void updateComment() {}
	
	public void deleteArticle(String no) {
		try {
			Connection conn = DBCP.getConnection();
			PreparedStatement psmt = conn.prepareStatement(Sql.DELETE_ARTICLE);
			psmt.setString(1, no);
			psmt.setString(2, no);
			
			psmt.executeUpdate();
			psmt.close();
			conn.close();
		
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public String deleteFile(String parent) {
		
		String newName = null;
		
		try {
			Connection conn = DBCP.getConnection();
			conn.setAutoCommit(false);
			
			PreparedStatement psmt1 = conn.prepareStatement(Sql.SELECT_FILE_WITH_PARENT);
			PreparedStatement psmt2 = conn.prepareStatement(Sql.DELETE_FILE);
			psmt1.setString(1, parent);
			psmt2.setString(1, parent);
			
			ResultSet rs = psmt1.executeQuery();
			psmt2.executeUpdate();
			
			conn.commit();
			
			if(rs.next()) {
				newName = rs.getString(3);
			}
			
			psmt1.close();
			psmt2.close();
			conn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return newName;
	}
	
	public int deleteComment(String no) {
		int result = 0;
		
		try {
			Connection conn = DBCP.getConnection();
			PreparedStatement psmt = PreparedStatement = conn.prepareStatement(Sql.DELETE_COMMENT);
			psmt.setString(1, no);
			
			result = psmt.excuteUpdate();
			psmt.close();
			conn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	
	
}
