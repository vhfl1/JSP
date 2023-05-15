package dao;

import java.util.ArrayList;
import java.util.List;

import db.DBHelper;
import vo.User5Vo;

public class User5Dao extends DBHelper {

	private static User5Dao instance = new User5Dao();
	public static User5Dao getInstance() {
		return instance;
	}
	
	private User5Dao() {}
	
	public void insertUser(User5Vo vo) {
		
		try {
			conn = getConnection();
			psmt = conn.prepareStatement("insert into `user5` values (?,?,?,?,?,?)");
			psmt.setString(1, vo.getUid());
			psmt.setString(2, vo.getName());
			psmt.setString(3, vo.getBirth());
			psmt.setInt(4, vo.getAge());
			psmt.setString(5, vo.getAddress());
			psmt.setString(6, vo.getHp());
			
			psmt.executeUpdate();
			close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public User5Vo selectUser(String uid) {
		
		User5Vo vo = new User5Vo();
		
		try {
			conn =getConnection();
			psmt = conn.prepareStatement("select * from `user5` where `uid`=?");
			psmt.setString(1, uid);
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				vo.setUid(rs.getString(1));
				vo.setName(rs.getString(2));
				vo.setBirth(rs.getString(3));
				vo.setAge(rs.getInt(4));
				vo.setAddress(rs.getString(5));
				vo.setHp(rs.getString(6));
				
			}
			close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return vo;
	}
	
	public List<User5Vo> selectUsers() {

		List<User5Vo> users = new ArrayList<>();
		
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from `user5`");
			
			while(rs.next()) {
				User5Vo vo = new User5Vo();
				vo.setUid(rs.getString(1));
				vo.setName(rs.getString(2));
				vo.setBirth(rs.getString(3));
				vo.setAge(rs.getInt(4));
				vo.setAddress(rs.getString(5));
				vo.setHp(rs.getString(6));
				users.add(vo);
			}
			close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return users;
	}
	public void updateUser(User5Vo vo) {
		try {
			conn = getConnection();
			psmt = conn.prepareStatement("update `user5` set `name`=?, `birth`=?, `age`=?, `address`=?, `hp`=? where `uid`=?");
			psmt.setString(1, vo.getName());
			psmt.setString(2, vo.getBirth());
			psmt.setInt(3, vo.getAge());
			psmt.setString(4, vo.getAddress());
			psmt.setString(5, vo.getHp());
			psmt.setString(6, vo.getUid());
			psmt.executeUpdate();
			close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	public void deleteUser(String uid) {
		try {
			conn = getConnection();
			psmt = conn.prepareStatement("delete from `user5` where `uid`=?");
			psmt.setString(1, uid);
			psmt.executeUpdate();
			close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
