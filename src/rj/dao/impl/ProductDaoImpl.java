package rj.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import rj.dao.ProductDao;
import rj.pojo.Product;
import rj.util.ConnectionFactory;

public class ProductDaoImpl implements ProductDao {

	@Override
	public List getProductList() {
		List productList = new ArrayList();

		Connection conn = null;

		Statement stmt = null;

		ResultSet rs = null;
		try {
			conn = ConnectionFactory.getConnection();

			stmt = conn.createStatement();

			rs = stmt.executeQuery(" select * from product");

			while (rs.next()) {
				Product product = new Product();
				product.setProductid(rs.getString("productid"));
				product.setName(rs.getString("name"));
				product.setDescription(rs.getString("description"));
				product.setBasePrice(rs.getInt("basePrice"));
				product.setCategoryid(rs.getString("categoryid"));
				product.setAuthor(rs.getString("author"));
				product.setPublish(rs.getString("publish"));
				product.setPages(rs.getInt("pages"));
				product.setImages("images");
				productList.add(product);
			}
		} catch (Exception e) {
			throw new RuntimeException("error when querying Product ", e);
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
				throw new RuntimeException("error when querying", e);
			}
		}

		return productList;

	}

	public Product getProduct(Product paramProduct) {

		Product product = new Product();

		Connection conn = null;

		Statement stmt = null;

		ResultSet rs = null;
		try {
			conn = ConnectionFactory.getConnection();

			stmt = conn.createStatement();

			String sql = "select * from product where productid ='"
					+ paramProduct.getProductid() + "'";
			rs = stmt.executeQuery(sql);

			if (rs.next()) {
				product.setBasePrice(Float.parseFloat(rs.getString("basePrice")));
				product.setAuthor(rs.getString("author"));
				product.setCategoryid(rs.getString("categoryid"));
				product.setDescription(rs.getString("description"));
				product.setImages(rs.getString("images"));
				product.setName(rs.getString("name"));
				product.setPages(Integer.parseInt(rs.getString("pages")));
				product.setPublish(rs.getString("publish"));
				product.setProductid(paramProduct.getProductid());
			} else {
				System.out.println("null");
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("error when querying ProductDetail ", e);
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
				throw new RuntimeException(
						"error when querying ProductDetail ", e);
			}
		}

		return product;

	}

}
