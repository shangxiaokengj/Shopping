package rj.service.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import rj.pojo.Category;
import rj.pojo.Product;
import rj.service.CategoryService;

public class CategoryServerImpl implements CategoryService{

	public Category getCategory(String categoryid) {
		Category category = new Category();

        Connection conn = null;
		
		Statement stmt = null;
		
		ResultSet rs = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/gwap","root","");
			stmt = conn.createStatement();
			
			String sql = "select * from category where categoryid ='"+ categoryid +"'";
			
			rs = stmt.executeQuery(sql);		
			
			if(rs.next()){
				category.setCategoryid(rs.getString("categoryid"));
				category.setName(rs.getString("name"));
				category.setDescription(rs.getString("description"));
			}else{
				System.out.println("null");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("error when querying Category ",e);
		} finally{
			try {
				rs.close();
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException("error when querying Category ",e);
			}
		}
		return category;
	}
	
	

}
