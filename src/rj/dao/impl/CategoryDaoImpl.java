package rj.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import rj.dao.CategoryDao;
import rj.pojo.Category;
import rj.util.ConnectionFactory;

public class CategoryDaoImpl implements CategoryDao {

	@Override
	public Category getCategory(Category paramCategory) {
		Category category = new Category();

		Connection conn = null;

		Statement stmt = null;

		ResultSet rs = null;

		try {
			conn = ConnectionFactory.getConnection();
			stmt = conn.createStatement();

			String sql = "select * from category where categoryid ='"
					+ paramCategory.getCategoryid() + "'";

			rs = stmt.executeQuery(sql);

			if (rs.next()) {
				category.setCategoryid(rs.getString("categoryid"));
				category.setName(rs.getString("name"));
				category.setDescription(rs.getString("description"));
			} else {
				System.out.println("null");
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("error when querying Category ", e);
		} finally {
			try {
				rs.close();
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException("error when querying Category ", e);
			}
		}
		return category;
	}
}
