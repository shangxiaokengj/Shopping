package rj.service.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import rj.pojo.Product;
import rj.service.ProductDetailService;

public class ProductDetailServiceImpl implements ProductDetailService{

	public Product getProduct(String productid){
		Product product = new Product();
        Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/gwap","root","");
			stmt = conn.createStatement();
			String sql = "select * from product where productid ='"+ productid +"'";
			rs = stmt.executeQuery(sql);		
			
			if(rs.next()){
				product.setBasePrice(Float.parseFloat(rs.getString("basePrice")));
				product.setAuthor(rs.getString("author"));
				product.setCategoryid(rs.getString("categoryid"));
				product.setDescription(rs.getString("description"));
				product.setImages(rs.getString("images"));
				product.setName(rs.getString("name"));
				product.setPages(Integer.parseInt(rs.getString("pages")));
				product.setPublish(rs.getString("publish"));
				product.setProductid(productid);
			}else{
				System.out.println("null");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("error when querying ProductDetail ",e);
		} finally{
			try {
				rs.close();
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException("error when querying ProductDetail ",e);
			}
		}
		
		return product;
		
	}

}
