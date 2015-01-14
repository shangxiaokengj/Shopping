package rj.service.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import rj.pojo.Product;
import rj.service.ProductService;

public class ProductServiceImpl implements ProductService {

	@Override
	public List getProductList() {
		List productList = new ArrayList();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");

			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/gwap", "root", "");

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
			e.printStackTrace();
			throw new RuntimeException("error when querying Product ", e);
		} finally {
			try {
				rs.close();
				stmt.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException("error when querying", e);
			}
		}

		return productList;

	}

}
