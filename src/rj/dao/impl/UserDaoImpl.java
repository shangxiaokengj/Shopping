package rj.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import rj.dao.UserDao;
import rj.pojo.User;
import rj.util.ConnectionFactory;

public class UserDaoImpl implements UserDao {

	public List<User> getUserList() {

		List<User> userlist = new ArrayList<User>();

		Connection conn = null;

		Statement stmt = null;

		ResultSet rs = null;

		try {
			conn = ConnectionFactory.getConnection();

			stmt = conn.createStatement();

			rs = stmt.executeQuery("select * from users");

			while (rs.next()) {
				User userm = new User();
				userm.setUserid(rs.getString("userid"));
				userm.setPassword(rs.getString("password"));
				userlist.add(userm);
			}
		} catch (SQLException e) {

			throw new RuntimeException("error when querying users ", e);

		} finally {

			try {

				if(rs != null){
					rs.close();	
				}
				if(stmt!= null){
					
					stmt.close();
				}
				if(conn != null){
					
					conn.close();
				}

			} catch (Exception e) {

				throw new RuntimeException("error when querying users ", e);

			}
		}
		return userlist;
	}

	public User getUser(User paramUser) {

		User user = new User();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			conn = ConnectionFactory.getConnection();
			stmt = conn.createStatement();
			System.out.println(paramUser.getUserid());

			String sql = "select * from users where userid ='"
					+ paramUser.getUserid() + "' and password = '"
					+ paramUser.getPassword() + "' ";
			

			rs = stmt.executeQuery(sql);

			if (rs.next()) {
				user.setUserid(rs.getString("userid"));
				user.setPassword(rs.getString("password"));
				return user;
			} else {
				System.out.println("Has no users");
			}

		} catch (Exception e) {
			throw new RuntimeException("error when querying users ", e);
		} finally {
			try {
				if(rs != null){
					rs.close();	
				}
				if(stmt!= null){
					
					stmt.close();
				}
				if(conn != null){
					
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException("error when querying users ", e);
			}
		}

		return null;
	}

	public User getUserByUserid(String userid) {

		User user = new User();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			conn = ConnectionFactory.getConnection();
			stmt = conn.createStatement();
System.out.println(userid + " userDao");
			String sql = "select * from users where userid ='" + userid + "'";

			rs = stmt.executeQuery(sql);

			if (rs.next()) {
				user.setUserid(rs.getString("userid"));
				user.setPassword(rs.getString("password"));
				return user;
			} else {
				System.out.println("Has no users");
			}

		} catch (Exception e) {
			throw new RuntimeException("error when querying users ", e);
		} finally {
			try {
				if(rs != null){
					rs.close();	
				}
				if(stmt!= null){
					
					stmt.close();
				}
				if(conn != null){
					
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException("error when querying users ", e);
			}
		}

		return null;
	}

}
