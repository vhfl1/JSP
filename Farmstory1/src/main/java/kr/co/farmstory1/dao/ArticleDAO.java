package kr.co.farmstory1.dao;

import org.slf4j.LoggerFactory;

import kr.co.farmstory1.bean.ArticleBean;
import kr.co.farmstory1.db.DBCP;
import kr.co.farmstory1.db.Sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
	
	public void selectArticle() {}
	
	public void selectArticles() {}
	
	public void selectFile() {}
	
	public void selectComments() {}
	
	public void updateArticle() {}
	
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
