package rj.service.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import rj.pojo.Product;
import rj.pojo.User;
import rj.service.UserService;

public class UserServiceImpl implements UserService {

	@Override
	public List getUserList() {
		List userlist = new ArrayList();
		Connection conn = null;
		// System.out.println("ok");
		Statement stmt = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/gwap", "root", "");
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from users");

			while (rs.next()) {

				User userm = new User();
				userm.setUserid(rs.getString("userid"));
				userm.setPassword(rs.getString("password"));
				userlist.add(userm);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("error when querying users ", e);
		} finally {
			try {
				rs.close();
				stmt.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();

				throw new RuntimeException("error when querying users ", e);
			}
		}
		return userlist;
	}

	@Override
	public User getUser(String userid) {

		User user = new User();

		Connection conn = null;

		Statement stmt = null;

		ResultSet rs = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/gwap", "root", "");
			stmt = conn.createStatement();

			String sql = "select * from users where userid ='" + userid + "'";

			rs = stmt.executeQuery(sql);
			System.out.println(sql);

			if (rs.next()) {
				user.setUserid(rs.getString("userid"));
				user.setPassword(rs.getString("password"));
			} else {
				System.out.println("null");
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("error when querying users ", e);
		} finally {
			try {
				rs.close();
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException("error when querying users ", e);
			}
		}

		return user;
	}

}
